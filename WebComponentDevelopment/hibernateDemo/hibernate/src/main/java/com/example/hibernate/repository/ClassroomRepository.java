package com.example.hibernate.repository;

import com.example.hibernate.entity.Classroom;

import java.util.List;

public interface ClassroomRepository {

    List<Classroom> findAll();

    void save(Classroom classroom);

    Classroom findById(int id);

    void update(Classroom classroom);

    void delete(int id);

    List<Classroom> findByName(String name);

}
