package com.rsjava.converter.service;

import com.rsjava.converter.model.Log;
import com.rsjava.converter.model.Transaction;
import com.rsjava.converter.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
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
                ""));
    }

    public void createGetAllCurrenciesCodesLog() {
        logRepository.save(buildBasicLog(
                GET_ALL_CURRENCIES_CODES_ENDPOINT_URL,
                HttpMethod.GET,
                ""));
    }

    public void createConvertLog(Transaction transaction) {
        logRepository.save(buildBasicLog(
                CONVERT_CURRENCIES_ENDPOINT_URL,
                HttpMethod.POST,
                transaction.getAmount() + ", " + transaction.getFrom() + ", " + transaction.getTo()));
    }

    private Log buildBasicLog(String path, HttpMethod httpMethod, String body) {
        Log log = new Log();
        log.setUrl(path);
        log.setHttpMethod(httpMethod.toString());
        log.setDate(localDateNow());
        log.setBody(body);
        return log;
    }

    private String localDateNow() {
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Europe/Berlin"));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dateTimeFormatter.format(localDateTime);
    }
}
