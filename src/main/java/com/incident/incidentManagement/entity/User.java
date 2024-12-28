package com.incident.incidentManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.incident.incidentManagement.entity.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User extends BaseEntity {

    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phone;
    @OneToOne(cascade = CascadeType.ALL , orphanRemoval = true, fetch = FetchType.LAZY)
//    @JsonIgnore  // Ignoring the location during serialization
    private Address address;

}
