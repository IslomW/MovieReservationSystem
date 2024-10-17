package com.sharipov.movie_reservation_system.domain.exception;

public class BadAppRequestException extends RuntimeException{
    public BadAppRequestException(String message) {
        super(message);
    }
}
