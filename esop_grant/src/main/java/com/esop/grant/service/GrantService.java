package com.esop.grant.service;

import java.math.BigInteger;
import java.util.List;

import com.esop.grant.dto.AppResponseDTO;
import com.esop.grant.dto.GrantDTO;
import com.esop.grant.entity.GrantModel;

public interface GrantService {
    public AppResponseDTO processCreate(List<GrantDTO> list);
    public GrantModel  processGetGrantById(BigInteger altkey);
    public AppResponseDTO processApprove(List<BigInteger> altkey);
    public AppResponseDTO processAccept(BigInteger altkey);
}
