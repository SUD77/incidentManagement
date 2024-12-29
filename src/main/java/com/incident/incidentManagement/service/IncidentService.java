package com.incident.incidentManagement.service;

import com.incident.incidentManagement.dtos.IncidentsDto;
import com.incident.incidentManagement.entity.Incidents;
import com.incident.incidentManagement.entity.common.IncidentIdGenerator;
import com.incident.incidentManagement.repository.IncidentRepository;
import com.incident.incidentManagement.service.mapper.IncidentManagementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    public IncidentsDto createIncident(IncidentsDto incidentDto) {

        Incidents incident= IncidentManagementMapper.INSTANCE.toIncidents(incidentDto);
        incident.setIncidentId(IncidentIdGenerator.generate());
        incident.setReportedAt(LocalDateTime.now());
        return IncidentManagementMapper.INSTANCE.toIncdientsDto(incidentRepository.save(incident));
    }
}
