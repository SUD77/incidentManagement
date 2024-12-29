package com.incident.incidentManagement.entity;

import com.incident.incidentManagement.entity.common.BaseEntity;
import com.incident.incidentManagement.entity.common.IncidentIdGenerator;
import com.incident.incidentManagement.enums.Priority;
import com.incident.incidentManagement.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;


@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "incidents")
public class Incidents extends BaseEntity {

    @Column(name = "incident_id", unique = true, nullable = false)
    private String incidentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reporter_id", nullable = false)
    private User reporter;

    @Column(name = "incident_type", nullable = false)
    private String incidentType; // Enterprise or Government

    private String details;

    @Column(name = "reported_at")
    private LocalDateTime reportedAt;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Status status;

    @PrePersist
    public void generateIncidentId() {
        this.incidentId = IncidentIdGenerator.generate();
        this.reportedAt = LocalDateTime.now();
    }
}
