package com.pokemonsoap.spring.service;

import com.pokemonsoap.spring.entity.RequestLog;
import com.pokemonsoap.spring.repository.RequestLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RequestLogService {

    @Autowired
    private RequestLogRepository requestLogRepository;

    public void saveRequestLog(String className ,String eventType, String methodName, String requestValues, String responseValues, String exceptionMessage) {
        RequestLog log = new RequestLog();
        log.setRequestDate(LocalDateTime.now());
        log.setMethodName(methodName);
        log.setRequestValues(requestValues);
        log.setResponseValues(responseValues);
        log.setEventType(eventType);
        log.setExceptionMessage(exceptionMessage);
        log.setClassName(className);

        requestLogRepository.save(log);
    }
}
