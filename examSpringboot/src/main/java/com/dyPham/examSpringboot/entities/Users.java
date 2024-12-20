package com.dyPham.examSpringboot.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Age cannot be null")
    @Min(value = 18, message = "Age can not be less than 18")
    @Max(value = 50, message = "Age can not be greater than 50")
    private Integer age;

    @Column(nullable = false)
    @NotNull(message = "Salary cannot be null")
    @Min(value = 0, message = "Salary must be greater than or equal to 0")
    private Double salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Name is mandatory") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name is mandatory") String name) {
        this.name = name;
    }

    public @NotNull(message = "Age cannot be null") @Min(value = 18, message = "Age can not be less than 18") @Max(value = 50, message = "Age can not be greater than 50") Integer getAge() {
        return age;
    }

    public void setAge(@NotNull(message = "Age cannot be null") @Min(value = 18, message = "Age can not be less than 18") @Max(value = 50, message = "Age can not be greater than 50") Integer age) {
        this.age = age;
    }

    public @NotNull(message = "Salary cannot be null") @Min(value = 0, message = "Salary must be greater than or equal to 0") Double getSalary() {
        return salary;
    }

    public void setSalary(@NotNull(message = "Salary cannot be null") @Min(value = 0, message = "Salary must be greater than or equal to 0") Double salary) {
        this.salary = salary;
    }
}
