package com.dyPham.examSpringboot.dto;

import lombok.Data;

@Data
public class EditUser {
    private Long id;
    private String name;

    private Integer age;

    private Double salary;
}
