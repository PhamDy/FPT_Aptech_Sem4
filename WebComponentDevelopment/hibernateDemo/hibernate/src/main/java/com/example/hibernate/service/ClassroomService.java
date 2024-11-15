package com.example.hibernate.service;

import com.example.hibernate.entity.Classroom;
import com.example.hibernate.repository.ClassroomRepository;
import com.example.hibernate.repository.impl.ClassroomRepositoryImpl;

import java.util.List;

public class ClassroomService {

    private final ClassroomRepository classroomRepository;

    public ClassroomService() {
        this.classroomRepository = new ClassroomRepositoryImpl();
    }

    public List<Classroom> getAllClasses(){
        return classroomRepository.findAll();
    }

    public Classroom getClassroomById(int id) throws Exception {
        Classroom classroom = classroomRepository.findById(id);
        if(classroom == null){
            throw new Exception("Classroom not found!");
        }
        return classroom;
    }

    public void saveClassroom(Classroom classroom){
        if(classroom.getName().isEmpty() || classroom.getName().length()<2){
            throw new IllegalArgumentException("Please input name");
        }
        if (classroomRepository.findByName(classroom.getName()) != null) {
            throw new IllegalArgumentException("Class name is existed.");
        }
        classroomRepository.save(classroom);
    }

    public void deleteClassroom(int id){
        classroomRepository.delete(id);
    }

    public List<Classroom> searchClassroom(String search){
        return classroomRepository.findByName(search);
    }

}
