package com.example.t2303e_spring.repository;

import com.example.t2303e_spring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
