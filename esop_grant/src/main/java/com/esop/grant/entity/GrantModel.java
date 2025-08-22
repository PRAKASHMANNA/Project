package com.esop.grant.entity;

import java.math.BigInteger;
import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="esop_grant")
public class GrantModel {
	@Id
	@Column(name="altkey")
	@GenericGenerator(name="auto", strategy="increment")
	@GeneratedValue(generator="auto")
     private BigInteger altkey;
	@Column(name="employee_id")
     private String employeeId;
	@Column(name="band")
     private String band;
	@Column(name="no_of_grants")
     private Long noOfGrants;
	@Column(name="grant_price")
     private double grantPrice;
	@Column(name="grant_status")
     private String grantStatus;
	@Column(name="lock_in_status")
     private String lockInStatus;
	@Column(name="is_accepted")
     private boolean IsAccepted;
	@Column(name="plan_id")
     private BigInteger planId;
	@Column(name="accepted_date")
     private Date acceptedDate;
	@Column(name="frequency")
     private Long frequency;
	@Column(name="allocation_state")
     private String allocationState;
}
