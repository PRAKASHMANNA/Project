package com.esop.allocation.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esop.allocation.entity.AllocationEntity;

public interface AllocationRepository extends JpaRepository<AllocationEntity, BigInteger> {
}
