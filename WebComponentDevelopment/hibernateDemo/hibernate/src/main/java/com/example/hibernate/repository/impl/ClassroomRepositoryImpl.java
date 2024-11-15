package com.example.hibernate.repository.impl;

import com.example.hibernate.entity.Classroom;
import com.example.hibernate.repository.ClassroomRepository;
import com.example.hibernate.util.HIbernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClassroomRepositoryImpl implements ClassroomRepository {


    @Override
    public List<Classroom> findAll() {
        try (Session session = HIbernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Classroom", Classroom.class).list();
        }
    }

    @Override
    public void save(Classroom classroom) {
        Transaction transaction = null;
        try(Session session = HIbernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(classroom);
            transaction.commit();
        }catch (HibernateException e){
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public Classroom findById(int id) {
        try (Session session = HIbernateUtil.getSessionFactory().openSession()){
            return session.get(Classroom.class, id);
        }
    }

    @Override
    public void update(Classroom classroom) {
        Transaction transaction = null;
        try (Session session = HIbernateUtil.getSessionFactory().openSession()){
            transaction = session.getTransaction();
            session.update(classroom);
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
            Classroom classroom = session.get(Classroom.class, id);
            if (classroom != null) {
                session.delete(classroom);
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
    public List<Classroom> findByName(String name) {
        try (Session session = HIbernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Classroom where name like %:name%", Classroom.class)
                    .setParameter("name", name)
                    .list();
        }
    }

}
