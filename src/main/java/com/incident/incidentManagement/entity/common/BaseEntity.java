package com.incident.incidentManagement.entity.common;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Data //Lombok generates getters for all non-static fields, setters for all non-final fields in the class.
@NoArgsConstructor
@MappedSuperclass
//to have no Direct Table Mapping, child classed inheriting this entity will have below fields in their tables.
@Access(AccessType.FIELD) //JPA directly accesses the fields of this entity, bypassing any getter/setter methods that may exist
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", updatable = false)
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    @PrePersist
    public void onPrePersist() {
        createdAt = Instant.now();
        updatedAt = Instant.now();
    }

    @PreUpdate
    public void onPreUpdate(){
        updatedAt = Instant.now();
    }

}
