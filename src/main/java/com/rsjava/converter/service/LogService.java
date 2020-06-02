package com.rsjava.converter.service;

import com.rsjava.converter.model.Log;
import com.rsjava.converter.model.Transaction;
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

    public void createGetAllCurrenciesLog() {
        logRepository.save(buildBasicLog(
                GET_ALL_CURRENCIES_ENDPOINT_URL,
                HttpMethod.GET,
                HttpStatus.OK,
                ""));
    }

    public void createGetAllCurrenciesCodesLog() {
        logRepository.save(buildBasicLog(
                GET_ALL_CURRENCIES_CODES_ENDPOINT_URL,
                HttpMethod.GET,
                HttpStatus.OK,
                ""));
    }

    public void createConvertLog(Transaction transaction) {
        HttpStatus httpStatus = null;
        if (isAnyOfInputDataIsNull(transaction)){
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        } else if (isAmountLessThanZero(transaction)){
            httpStatus = HttpStatus.BAD_REQUEST;
        } else {
            httpStatus = HttpStatus.OK;
        }
        logRepository.save(buildBasicLog(
                CONVERT_CURRENCIES_ENDPOINT_URL,
                HttpMethod.POST,
                httpStatus,
                transaction.getAmount() + ", " + transaction.getFrom() + ", " + transaction.getTo()));
    }

    private Log buildBasicLog(String path, HttpMethod httpMethod, HttpStatus httpStatus, String body) {
        Log log = new Log();
        log.setUrl(path);
        log.setHttpStatus(httpStatus.toString());
        log.setHttpMethod(httpMethod.toString());
        log.setDate(localDateNow());
        log.setBody(body);
        return log;
    }

    private String localDateNow() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dateTimeFormatter.format(localDateTime);
    }

    boolean isAnyOfInputDataIsNull(Transaction transaction) {
        return (transaction.getAmount() == null
                || transaction.getFrom() == null
                || transaction.getTo() == null);
    }
    boolean isAmountLessThanZero(Transaction transaction){
        return transaction.getAmount() <= 0;
    }

}
