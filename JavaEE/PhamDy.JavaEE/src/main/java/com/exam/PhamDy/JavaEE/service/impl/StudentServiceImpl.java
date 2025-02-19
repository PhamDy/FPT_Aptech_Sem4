package com.exam.PhamDy.JavaEE.service.impl;

import com.exam.PhamDy.JavaEE.dto.*;
import com.exam.PhamDy.JavaEE.entity.Student;
import com.exam.PhamDy.JavaEE.entity.StudentScore;
import com.exam.PhamDy.JavaEE.entity.Subject;
import com.exam.PhamDy.JavaEE.repository.StudentRepository;
import com.exam.PhamDy.JavaEE.repository.StudentScoreRepository;
import com.exam.PhamDy.JavaEE.repository.SubjectRepository;
import com.exam.PhamDy.JavaEE.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final StudentScoreRepository studentScoreRepository;

    @Override
    public List<StudentInfomation> getInfomationStudents() {
        List<Student> studentList = studentRepository.findAll();
        List<StudentInfomation> studentInfomationList = new ArrayList<>();
        for (Student student: studentList) {
            List<SubjectScore> subjectScoreList = student.getStudentScoreList().stream().map(this::toSubjectScore).collect(Collectors.toList());
            StudentInfomation studentInfomation = StudentInfomation.builder()
                    .id(student.getId())
                    .fullName(student.getFullName())
                    .studentCode(student.getStudentCode())
                    .subjectScoreList(subjectScoreList)
                    .build();
            studentInfomationList.add(studentInfomation);
        }
        return studentInfomationList;
    }

    @Override
    public StudentDTO createStudent(CreateStudent model) {
        Student studentExisting = studentRepository.findByStudentCode(model.getStudentCode());
        if (studentExisting != null) throw new RuntimeException("Students already exist");
        Student student = Student.builder()
                .studentCode(model.getStudentCode())
                .fullName(model.getFullName())
                .address(model.getAddress())
                .build();
        studentRepository.save(student);
        StudentDTO studentDTO = StudentDTO.builder()
                .id(student.getId())
                .studentCode(student.getStudentCode())
                .fullName(student.getFullName())
                .address(student.getAddress())
                .build();
        return studentDTO;
    }

    @Override
    public StudentScoreDTO insertScore(CreateScoreStudent model) {
        Student studentExisting = studentRepository.findById(model.getStudentId()).orElseThrow(() -> new RuntimeException("Student does not exist"));
        Subject subjectExisting = subjectRepository.findById(model.getSubjectId()).orElseThrow(() -> new RuntimeException("Subject does not exist"));

        StudentScore studentScoreExisting = studentScoreRepository.findByStudentAndSubject(studentExisting, subjectExisting);
        if (studentScoreExisting != null) {
            throw new RuntimeException("The student's subject has been graded");
        }

        StudentScore studentScore = StudentScore.builder()
                .student(studentExisting)
                .subject(subjectExisting)
                .score1(model.getScore1())
                .score2(model.getScore2())
                .build();
        studentScoreRepository.save(studentScore);

        StudentScoreDTO studentScoreDTO = StudentScoreDTO.builder()
                .id(studentScore.getId())
                .studentName(studentScore.getStudent().getFullName())
                .subjectName(studentScore.getSubject().getSubjectName())
                .score1(studentScore.getScore1())
                .score2(studentScore.getScore2())
                .build();
        return studentScoreDTO;
    }

    private SubjectScore toSubjectScore(StudentScore studentScore){
        if (studentScore == null) {
            throw new RuntimeException("Not found");
        }
        SubjectScore subjectScore = SubjectScore.builder()
                .subjectName(studentScore.getSubject().getSubjectName())
                .score1(studentScore.getScore1())
                .score2(studentScore.getScore2())
                .credit(studentScore.getSubject().getCredit())
                .grade(calculateGrade(studentScore.getScore1(), studentScore.getScore2()))
                .build();
        return subjectScore;
    }

    private String calculateGrade(Double score1, Double score2) {
        double grade = 0.3 * score1 + 0.7 * score2;
        if (grade >= 8.0) {
            return "A";
        } else if (grade >= 6.0) {
            return "B";
        } else if (grade >= 4.0) {
            return "D";
        } else {
            return "F";
        }
    }
}
