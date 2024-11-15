package com.example.hibernate.repository;

import com.example.hibernate.entity.Student;

import java.util.List;

public interface StudentRepository {

    List<Student> findAll();

    void save(Student student);

    Student findById(int id);

    void update(Student student);

    void delete(int id);

    List<Student> findByName(String name);

}
