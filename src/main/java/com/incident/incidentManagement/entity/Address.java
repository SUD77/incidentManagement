package com.incident.incidentManagement.entity;

import com.incident.incidentManagement.entity.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "address")
public class Address extends BaseEntity {

    private String streetAddress;
    private String city;
    private String state;
    private String pinCode;
    private String country;
}
