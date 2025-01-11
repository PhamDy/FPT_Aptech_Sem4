package com.exam.PhamDy.JavaEE.repository;

import com.exam.PhamDy.JavaEE.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByStudentCode(String code);
}
