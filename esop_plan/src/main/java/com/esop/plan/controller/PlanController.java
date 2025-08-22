package com.esop.plan.controller;

import java.math.BigInteger;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esop.plan.constants.MappingConstants;
import com.esop.plan.dto.AppResponseDTO;
import com.esop.plan.dto.PlanDTO;
import com.esop.plan.entity.PlanModel;
import com.esop.plan.service.PlanService;

import lombok.AllArgsConstructor;
@RestController
@AllArgsConstructor
public class PlanController {
	private PlanService planService; 
	@PostMapping(value=MappingConstants.CREATE)
	public @ResponseBody AppResponseDTO processCreatePlan(@RequestBody PlanDTO planDTO) {
		return planService.createPlan(planDTO);
	}
	@GetMapping(value = MappingConstants.GETID)
	public @ResponseBody PlanModel getPlanById(@PathVariable("id") BigInteger altkey) {
		return planService.getPlanByPlanId(altkey);
	}
	@GetMapping(value = MappingConstants.CURRENTPLAN)
	public @ResponseBody PlanModel getCurrentPlan() {
		return planService.getCurrentPlan();
	}
}
