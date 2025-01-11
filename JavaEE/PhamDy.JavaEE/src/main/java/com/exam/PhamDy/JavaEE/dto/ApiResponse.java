package com.exam.PhamDy.JavaEE.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse {
    private boolean status;
    private String message;
    private Object data;
}
