package com.esop.plan.service;

import java.math.BigInteger;

import com.esop.plan.dto.AppResponseDTO;
import com.esop.plan.dto.PlanDTO;
import com.esop.plan.entity.PlanModel;

public interface PlanService {
    public AppResponseDTO createPlan(PlanDTO planDTO);
    public PlanModel getPlanByPlanId(BigInteger altkey);
    public PlanModel getCurrentPlan();
}
