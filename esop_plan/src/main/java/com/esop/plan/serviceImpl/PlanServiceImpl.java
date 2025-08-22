package com.esop.plan.serviceImpl;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

import com.esop.plan.dto.AppResponseDTO;
import com.esop.plan.dto.PlanDTO;
import com.esop.plan.entity.PlanModel;
import com.esop.plan.repository.PlanRepository;
import com.esop.plan.service.PlanService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PlanServiceImpl implements PlanService {
    
    private final PlanRepository planRepository;

    @Override
    public AppResponseDTO createPlan(PlanDTO planDTO) {
        try {
            PlanModel planModel = new PlanModel();
            planModel.setIsCurrentPlans(planDTO.getIsCurrentPlans());
            planModel.setStartDate(planDTO.getStartDate());
            planModel.setPlanYear(planDTO.getPlanYear());
            
            planModel = planRepository.save(planModel);
            
            return new AppResponseDTO("SUCCESS", "200",planModel, null);
        } catch (Exception e) {
            return new AppResponseDTO("FAILURE", "500",null, e.getMessage());
        }
    }

    @Override
    public PlanModel getPlanByPlanId(BigInteger altkey) {
        return planRepository.findById(altkey).orElse(null);
    }

    @Override
    public PlanModel getCurrentPlan() {
        return planRepository.findAll().stream()
            .filter(plan -> plan.getIsCurrentPlans() != null && plan.getIsCurrentPlans().equals(1))
            .findFirst()
            .orElse(null);
    }

}
