package com.example.hibernate.service;

import com.example.hibernate.entity.Student;
import com.example.hibernate.repository.StudentRepository;
import com.example.hibernate.repository.impl.StudentRepositoryImpl;

import java.util.List;

public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService() {
        this.studentRepository = new StudentRepositoryImpl();
    }

    public List<Student> getAllClasses(){
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) throws Exception {
        Student student = studentRepository.findById(id);
        if(student == null){
            throw new Exception("Classroom not found!");
        }
        return student;
    }

    public void saveStudent(Student student){
        if(student.getName().isEmpty() || student.getName().length()<2){
            throw new IllegalArgumentException("Please input name");
        }
        if (studentRepository.findByName(student.getName()) != null) {
            throw new IllegalArgumentException("Class name is existed.");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(int id){
        studentRepository.delete(id);
    }

    public List<Student> searchStudent(String search){
        return studentRepository.findByName(search);
    }

}
