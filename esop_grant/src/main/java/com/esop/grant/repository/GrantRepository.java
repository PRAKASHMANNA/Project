package com.esop.grant.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esop.grant.entity.GrantModel;

public interface GrantRepository extends JpaRepository<GrantModel, BigInteger> {

}
