package com.incident.incidentManagement.controller;

import com.incident.incidentManagement.dtos.IncidentsDto;
import com.incident.incidentManagement.entity.Incidents;
import com.incident.incidentManagement.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/incidents")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    @PostMapping
    public ResponseEntity<IncidentsDto> createIncident(@RequestBody IncidentsDto incidentDto) {
        IncidentsDto createdIncident = incidentService.createIncident(incidentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdIncident);
    }
}
