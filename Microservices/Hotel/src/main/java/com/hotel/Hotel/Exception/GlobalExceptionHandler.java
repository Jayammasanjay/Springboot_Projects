package com.hotel.Hotel.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> GlobalException(Exception ex){
        String message="An unexpected error occurred: "+ex.getMessage();
        Response response=Response.builder()
                .message(message).status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
