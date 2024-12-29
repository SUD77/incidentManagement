package com.incident.incidentManagement.entity.common;

import java.time.LocalDateTime;

public class IncidentIdGenerator {
    public static String generate() {
        int randomNum = (int) (Math.random() * 100000);
        return "RMG" + randomNum + LocalDateTime.now().getYear();
    }
}
