package com.incident.incidentManagement.repository;

import com.incident.incidentManagement.entity.Incidents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentRepository extends JpaRepository<Incidents,Long> {
}
