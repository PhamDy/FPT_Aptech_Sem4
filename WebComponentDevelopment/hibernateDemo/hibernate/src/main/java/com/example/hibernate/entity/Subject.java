package com.example.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int hours;
    @ManyToMany(mappedBy = "subjects")
    private List<Student> students;
}
