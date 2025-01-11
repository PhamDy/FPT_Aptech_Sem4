package com.exam.PhamDy.JavaEE.controller;

import com.exam.PhamDy.JavaEE.dto.*;
import com.exam.PhamDy.JavaEE.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/infomation")
    ResponseEntity<?> getAllStudentInfomation() {
        try {
            List<StudentInfomation> list = studentService.getInfomationStudents();
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ApiResponse(true, "Success", list)
            );
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ApiResponse(false, e.getMessage(), "")
            );
        }
    }

    @PostMapping
    ResponseEntity<?> insertStudent(@Valid @RequestBody CreateStudent createStudent, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = new ArrayList<>();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errors.add(error.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ApiResponse(false, "Validation error", errors)
            );
        }
        try {
            StudentDTO studentDTO = studentService.createStudent(createStudent);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ApiResponse(true, "Success", studentDTO)
            );
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ApiResponse(false, e.getMessage(), "")
            );
        }
    }

    @PostMapping("/score")
    ResponseEntity<?> insertScoreStudent(@Valid @RequestBody CreateScoreStudent createScoreStudent, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = new ArrayList<>();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errors.add(error.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ApiResponse(false, "Validation error", errors)
            );
        }

        try {
            StudentScoreDTO studentScoreDTO = studentService.insertScore(createScoreStudent);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ApiResponse(true, "Success", studentScoreDTO)
            );
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ApiResponse(false, e.getMessage(), "")
            );
        }
    }

}
