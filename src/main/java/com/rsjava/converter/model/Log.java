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
    private String body;
    private String date;

    public Log(String url, String httpMethod, String body, String date) {
        this.url = url;
        this.httpMethod = httpMethod;
        this.body = body;
        this.date = date;
    }
}
