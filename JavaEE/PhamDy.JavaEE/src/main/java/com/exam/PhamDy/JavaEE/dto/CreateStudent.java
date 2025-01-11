package com.exam.PhamDy.JavaEE.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateStudent {
    @NotBlank(message = "Student code cannot be blank")
    private String studentCode;
    @NotBlank(message = "Full name cannot be blank")
    private String fullName;
    private String address;
}
