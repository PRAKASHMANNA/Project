package com.esop.allocation.serviceimpl;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esop.allocation.entity.AllocationEntity;
import com.esop.allocation.repository.AllocationRepository;
import com.esop.allocation.service.AllocationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AllocationServiceImpl implements AllocationService {

    private final AllocationRepository repository;

    @Override
    @Transactional
    public void saveAllocations(List<Map<String, Object>> input) {
        for (Map<String, Object> row : input) {
        	BigInteger altkey = new BigInteger(String.valueOf(row.get("employeeId")));
        	int grantNumber = Integer.parseInt(String.valueOf(row.get("planId")));
        	int frequency = Integer.parseInt(String.valueOf(row.get("frequency")));
        	int startYear = Year.now().getValue();
            for (int i = 0; i < frequency; i++) {
                AllocationEntity entity = new AllocationEntity();
                BigInteger uniqueAltkey = new BigInteger(altkey.toString() + (startYear + i));
                entity.setAltkey(uniqueAltkey);
                String allocationNumber = String.valueOf(grantNumber / frequency);
                entity.setAllocationNumber(allocationNumber);
                entity.setAllocationYear(String.valueOf(startYear + i));
                entity.setAllocationStatus("PENDING");
                entity.setAllocationDate(LocalDate.now());
                entity.setCreatedDate(LocalDateTime.now());
                repository.save(entity);
            }
        }
    }
}
