package com.exam.PhamDy.JavaEE.repository;

import com.exam.PhamDy.JavaEE.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
