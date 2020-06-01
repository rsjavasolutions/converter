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
    private static final String CONVERT_CURRENCIES_ENDPOINT_URL = "api/currencies/convert";

    public void createGetAllCurrenciesLog(){
        Log log = getBasicLog(
                GET_ALL_CURRENCIES_ENDPOINT_URL,
                HttpStatus.OK,
                HttpMethod.GET,
                " "
        );
        logRepository.save(log);
    }

    public void createGetAllCurrenciesCodesLog(){
       Log log = getBasicLog(
               GET_ALL_CURRENCIES_CODES_ENDPOINT_URL,
               HttpStatus.OK,
               HttpMethod.GET,
               " ");
       logRepository.save(log);
    }

    public void createConvertLog(Double amount, String from, String to){
        Log log = getBasicLog(
                CONVERT_CURRENCIES_ENDPOINT_URL,
                HttpStatus.OK,
                HttpMethod.POST,
                amount.toString() + ", " + from + ", " + to);
        logRepository.save(log);
    }

    private Log getBasicLog(String path, HttpStatus httpStatus, HttpMethod httpMethod, String body){
        Log log = new Log();
        log.setUrl(path);
        log.setHttpStatus(httpStatus.toString());
        log.setHttpMethod(httpMethod.toString());
        log.setDate(localDateNow());
        log.setBody(body);
        return log;
    }

    private String localDateNow(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dateTimeFormatter.format(localDateTime);
    }

}
