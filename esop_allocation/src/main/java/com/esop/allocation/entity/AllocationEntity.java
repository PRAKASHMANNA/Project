package com.esop.allocation.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "allocation_entity")
public class AllocationEntity {

    @Id
    @Column(name="altkey")
    private BigInteger altkey;

    @Column(name = "allocation_number")
    private String allocationNumber;

    @Column(name = "allocation_year")
    private String allocationYear;

    @Column(name = "allocation_status")
    private String allocationStatus;

    @Column(name = "allocation_date")
    private LocalDate allocationDate;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;
}
