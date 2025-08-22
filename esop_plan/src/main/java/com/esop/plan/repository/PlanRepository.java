package com.esop.plan.repository;

import com.esop.plan.entity.PlanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface PlanRepository extends JpaRepository<PlanModel, BigInteger> {
	
}
