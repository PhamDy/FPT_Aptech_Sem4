package com.exam.PhamDy.JavaEE.repository;

import com.exam.PhamDy.JavaEE.entity.Student;
import com.exam.PhamDy.JavaEE.entity.StudentScore;
import com.exam.PhamDy.JavaEE.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentScoreRepository extends JpaRepository<StudentScore, Long> {
    StudentScore findByStudentAndSubject(Student student, Subject subject);
}
