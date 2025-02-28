package com.exam.PhamDy.JavaEE.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateScoreStudent {
    @NotNull(message = "Student Id cannot be null")
    private Long studentId;

    @NotNull(message = "Subject Id cannot be null")
    private Long subjectId;

    @NotNull(message = "Score 1 cannot be null")
    @DecimalMin(value = "0.0", message = "Score 1 must be at least 1")
    @DecimalMax(value = "10.0", message = "Score 1 must be at most 10")
    private Double score1;

    @NotNull(message = "Score 2 cannot be null")
    @DecimalMin(value = "0.0", message = "Score 2 must be at least 1")
    @DecimalMax(value = "10.0", message = "Score 2 must be at most 10")
    private Double score2;
}
