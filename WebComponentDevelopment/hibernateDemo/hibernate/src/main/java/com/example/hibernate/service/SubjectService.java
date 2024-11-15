package com.example.hibernate.service;

import com.example.hibernate.entity.Subject;
import com.example.hibernate.repository.SubjectRepository;
import com.example.hibernate.repository.impl.SubjectRepositoryImpl;

import java.util.List;

public class SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectService() {
        this.subjectRepository = new SubjectRepositoryImpl();
    }

    public List<Subject> getAllSubject(){
        return subjectRepository.findAll();
    }

    public Subject getStudentById(int id) throws Exception {
        Subject subject = subjectRepository.findById(id);
        if(subject == null){
            throw new Exception("Classroom not found!");
        }
        return subject;
    }

    public void saveSubject(Subject subject){
        if(subject.getName().isEmpty() || subject.getName().length()<2){
            throw new IllegalArgumentException("Please input name");
        }
        if (subjectRepository.findByName(subject.getName()) != null) {
            throw new IllegalArgumentException("Class name is existed.");
        }
        subjectRepository.save(subject);
    }

    public void deleteSubject(int id){
        subjectRepository.delete(id);
    }

    public List<Subject> searchSubject(String search){
        return subjectRepository.findByName(search);
    }

}
