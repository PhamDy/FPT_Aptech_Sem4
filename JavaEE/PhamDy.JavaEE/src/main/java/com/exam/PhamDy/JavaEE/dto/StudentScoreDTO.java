package com.exam.PhamDy.JavaEE.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentScoreDTO {
    private Long id;
    private String studentName;
    private String subjectName;
    private Double score1;
    private Double score2;
}
