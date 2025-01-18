package com.pokemonsoap.spring.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "request_logs")
public class RequestLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "request_date", nullable = false)
    private LocalDateTime requestDate;

    @Column(name = "method_name", nullable = false)
    private String methodName;

    @Column(name = "request_values", columnDefinition = "TEXT")
    private String requestValues;

    @Column(name = "response_values", columnDefinition = "TEXT")
    private String responseValues;
    
    @Column(name = "event_type", length = 50, nullable = false)
    private String eventType;
    
    @Column(name = "exception_message", columnDefinition = "TEXT")
    private String exceptionMessage;
    
    @Column(name = "class_name", length = 50, nullable = false)
    private String className;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getRequestValues() {
        return requestValues;
    }

    public void setRequestValues(String requestValues) {
        this.requestValues = requestValues;
    }

    public String getResponseValues() {
        return responseValues;
    }

    public void setResponseValues(String responseValues) {
        this.responseValues = responseValues;
    }

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}