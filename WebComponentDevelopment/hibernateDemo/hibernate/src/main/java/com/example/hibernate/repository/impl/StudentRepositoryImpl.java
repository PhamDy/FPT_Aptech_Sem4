package com.example.hibernate.repository.impl;

import com.example.hibernate.entity.Student;
import com.example.hibernate.repository.StudentRepository;
import com.example.hibernate.util.HIbernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    @Override
    public List<Student> findAll() {
        try (Session session = HIbernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Student ", Student.class).list();
        }
    }

    @Override
    public void save(Student student) {
        Transaction transaction = null;
        try(Session session = HIbernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        }catch (HibernateException e){
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public Student findById(int id) {
        try (Session session = HIbernateUtil.getSessionFactory().openSession()){
            return session.get(Student.class, id);
        }
    }

    @Override
    public void update(Student student) {
        Transaction transaction = null;
        try (Session session = HIbernateUtil.getSessionFactory().openSession()){
            transaction = session.getTransaction();
            session.update(student);
            transaction.commit();
        }catch (HibernateException e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        Transaction transaction = null;
        try (Session session = HIbernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.delete(student);
                transaction.commit();
            }
        }catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> findByName(String name) {
        try (Session session = HIbernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Student where name like %:name%", Student.class)
                    .setParameter("name", name)
                    .list();
        }
    }
}
