package com.rsjava.converter.service;

import com.rsjava.converter.model.Log;
import com.rsjava.converter.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service

public class LogService {

    private LogRepository logRepository;

    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    private static final String GET_ALL_CURRENCIES_ENDPOINT_URL = "api/currencies";
    private static final String GET_ALL_CURRENCIES_CODES_ENDPOINT_URL = "api/currencies/codes";
    private static final String CONVERT_CURRENCIES_ENDPOINT_URL = "api/currencies/codes";

    private String localDateNow(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dateTimeFormatter.format(localDateTime);
    }

    public void createGetAllCurrenciesLog(){
        Log log = new Log();
        log.setUrl(GET_ALL_CURRENCIES_ENDPOINT_URL);
        log.setHttpMethod(HttpMethod.GET.toString());
        log.setDate(localDateNow());
        log.setRequestBody("");
        log.setHttpStatus(HttpStatus.OK.toString());
        logRepository.save(log);
    }
}
