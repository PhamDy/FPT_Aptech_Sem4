package com.exam.PhamDy.JavaEE.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentInfomation {
    private Long id;

    private String studentCode;

    private String fullName;

    private List<SubjectScore> subjectScoreList;
}
