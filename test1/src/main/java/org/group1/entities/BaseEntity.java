package org.group1.entities;

import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@MappedSuperclass
public class BaseEntity {

    @CreationTimestamp
    protected LocalDate createdDate;
    @UpdateTimestamp
    protected LocalDate updatedDate;
    protected LocalDate deletedDate;
}
