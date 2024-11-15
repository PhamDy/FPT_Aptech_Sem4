package com.example.hibernate.repository;

import com.example.hibernate.entity.Subject;

import java.util.List;

public interface SubjectRepository {

    List<Subject> findAll();

    void save(Subject subject);

    Subject findById(int id);

    void update(Subject subject);

    void delete(int id);

    List<Subject> findByName(String name);

}
