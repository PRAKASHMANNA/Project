package com.esop.plan.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class PlanDTO {
   private String planYear;
   private Date startDate;
   private Long isCurrentPlans;
}
