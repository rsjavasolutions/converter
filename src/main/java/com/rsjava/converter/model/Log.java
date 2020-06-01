package com.rsjava.converter.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "logs")
@NoArgsConstructor
public class Log {

    // to url, metoda HTTP, body, parametrs, data wykonania zapytania.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String url;
    private String httpMethod;
    private String requestBody;
    private String date;
    private String httpStatus;

    public Log(String url, String httpMethod, String requestBody, String date, String httpStatus) {
        this.url = url;
        this.httpMethod = httpMethod;
        this.requestBody = requestBody;
        this.date = date;
        this.httpStatus = httpStatus;
    }
}
