package com.esop.grant.dto;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GrantDTO {
   private String employeeId;
   private String Band;
   private Long noOfGrants;
   private Double grantPrice;
   private String lockInStatus;
   private BigInteger planId;
   private Long frequency; 
   
}
