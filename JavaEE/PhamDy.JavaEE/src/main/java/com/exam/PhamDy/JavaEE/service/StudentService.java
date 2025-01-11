package com.exam.PhamDy.JavaEE.service;

import com.exam.PhamDy.JavaEE.dto.*;

import java.util.List;

public interface StudentService {

    List<StudentInfomation> getInfomationStudents();

    StudentDTO createStudent(CreateStudent model);

    StudentScoreDTO insertScore(CreateScoreStudent model);

}
