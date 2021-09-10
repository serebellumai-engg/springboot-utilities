package com.service.tracing.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int responseStatus;

    private String apiPath;

    private long apiExecutionTime;

    private long apiExecutionMillis;

    private String apiMethod;

    private String clientIpAddress;

    public ActivityLog(int responseStatus, String apiPath, Long apiExecutionTime, Long apiExecutionMillis, String apiMethod,
                       String clientIpAddress) {
        this.responseStatus = responseStatus;
        this.apiPath = apiPath;
        this.apiExecutionTime = apiExecutionTime;
        this.apiExecutionMillis = apiExecutionMillis;
        this.apiMethod = apiMethod;
        this.clientIpAddress = clientIpAddress;
    }
}
