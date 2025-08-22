package com.esop.plan.entity;

import java.math.BigInteger;
import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="esop_plan")
public class PlanModel {
	@Id
	@Column(name="altkey")
	@GenericGenerator(name="auto", strategy="increment")
	@GeneratedValue(generator="auto")
    private BigInteger altKey;
	@Column(name="plan_year")
    private String planYear;
	@Column(name="start_date")
    private Date startDate;
	@Column(name="iscurrent_plans")
    private Long isCurrentPlans;
	@Column(name="vestiny_factor")
    private Double vestinyFactor;
	@Column(name="monitization_date")
    private Date monitizationDate;
}
