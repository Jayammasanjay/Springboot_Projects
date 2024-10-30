package com.hotel.Hotel.Exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Response {

    private String message;
    private HttpStatus status;
}
