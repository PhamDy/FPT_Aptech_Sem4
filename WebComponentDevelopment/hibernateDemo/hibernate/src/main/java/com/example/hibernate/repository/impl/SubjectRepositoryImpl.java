package com.example.hibernate.repository.impl;

import com.example.hibernate.entity.Classroom;
import com.example.hibernate.entity.Subject;
import com.example.hibernate.repository.SubjectRepository;
import com.example.hibernate.util.HIbernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SubjectRepositoryImpl implements SubjectRepository {
    @Override
    public List<Subject> findAll() {
        try (Session session = HIbernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Subject", Subject.class).list();
        }
    }

    @Override
    public void save(Subject subject) {
        Transaction transaction = null;
        try(Session session = HIbernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(subject);
            transaction.commit();
        }catch (HibernateException e){
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public Subject findById(int id) {
        try (Session session = HIbernateUtil.getSessionFactory().openSession()){
            return session.get(Subject.class, id);
        }
    }

    @Override
    public void update(Subject subject) {
        Transaction transaction = null;
        try (Session session = HIbernateUtil.getSessionFactory().openSession()){
            transaction = session.getTransaction();
            session.update(subject);
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
            Subject subject = session.get(Subject.class, id);
            if (subject != null) {
                session.delete(subject);
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
    public List<Subject> findByName(String name) {
        try (Session session = HIbernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Subject where name like %:name%", Subject.class)
                    .setParameter("name", name)
                    .list();
        }
    }
}
