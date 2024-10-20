package com.sharipov.movie_reservation_system.domain.exception;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationErrorResponse {
    private String field;
    private String message;
}
