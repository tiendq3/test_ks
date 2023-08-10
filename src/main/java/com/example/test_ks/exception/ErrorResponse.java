package com.example.test_ks.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
@Builder
public class ErrorResponse {
    private HttpStatus httpStatus;

    private String reason;

    private String path;
}
