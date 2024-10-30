package com.user.service.Exceptions;

import lombok.*;
import lombok.Builder;
import org.aspectj.internal.lang.annotation.ajcDeclareEoW;
import org.springframework.http.HttpStatus;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ApiResponse {

    private String message;
    private boolean succes;
    private HttpStatus status;
}
