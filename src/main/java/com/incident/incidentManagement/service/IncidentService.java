package com.incident.incidentManagement.service;

import com.incident.incidentManagement.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;
}
