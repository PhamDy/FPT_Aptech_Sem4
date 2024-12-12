package com.dyPham.examSpringboot.repository;

import com.dyPham.examSpringboot.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {
    List<Users> findAllByNameContaining(String search);
}
