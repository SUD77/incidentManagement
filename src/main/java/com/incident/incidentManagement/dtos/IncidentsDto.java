package com.incident.incidentManagement.dtos;

import com.incident.incidentManagement.entity.User;
import com.incident.incidentManagement.enums.Priority;
import com.incident.incidentManagement.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncidentsDto {

    private Long id;
    private String incidentId;
    private User reporter;
    private String incidentType;
    private String details;
    private LocalDateTime reportedAt;
    private Priority priority;
    private Status status;
}
