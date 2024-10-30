package com.example.student.Exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IdNotFoundException extends RuntimeException{
    public IdNotFoundException(String message) {
        super(message);
    }
}