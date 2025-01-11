package com.exam.PhamDy.JavaEE.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectScore {
    private String subjectName;

    private Double score1;

    private Double score2;

    private int credit;

    private String grade;
}
