package com.rsjava.converter.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
public class ApiError {

    private HttpStatus status;
    private String localDateTime;
    private String message;

    public ApiError(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
        localDateTime = getCurrentlyDateTime();
    }

    private String getCurrentlyDateTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return formatter.format(localDateTime);
    }
}
