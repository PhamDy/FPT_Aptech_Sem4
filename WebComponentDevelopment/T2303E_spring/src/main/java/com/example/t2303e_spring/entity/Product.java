package com.example.t2303e_spring.entity;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Double price;
    @Column(name = "qty")
    private Integer qty;
    @Column(name = "desc")
    private String description;

}
