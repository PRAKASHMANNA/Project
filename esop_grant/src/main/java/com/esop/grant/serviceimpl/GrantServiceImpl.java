package com.esop.grant.serviceimpl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.esop.grant.dto.AppResponseDTO;
import com.esop.grant.dto.GrantDTO;
import com.esop.grant.entity.GrantModel;
import com.esop.grant.repository.GrantRepository;
import com.esop.grant.service.GrantService;
import com.esop.grant.service.KafkaProducerService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class GrantServiceImpl implements GrantService {
    private GrantRepository grantRepository;
    private KafkaProducerService kafkaProducerService;
    @Override
    public AppResponseDTO processCreate(List<GrantDTO> list) {
        List<GrantModel> savedGrants = new ArrayList<>();

        for (GrantDTO grantDTO : list) {
            GrantModel model = new GrantModel();
            model.setEmployeeId(grantDTO.getEmployeeId());
            model.setBand(grantDTO.getBand());
            model.setNoOfGrants(grantDTO.getNoOfGrants());
            model.setGrantPrice(grantDTO.getGrantPrice());
            model.setGrantStatus("PENDING");
            model.setLockInStatus(grantDTO.getLockInStatus());
            model.setIsAccepted(false);
            model.setPlanId(grantDTO.getPlanId());
            model.setAcceptedDate(new Date());
            model.setFrequency(grantDTO.getFrequency());
            model.setAllocationState("PENDING");

            GrantModel saved = grantRepository.save(model);
            savedGrants.add(saved);
        }

        return new AppResponseDTO("SUCCESS", "200", savedGrants, null);
    }
    @Override
    public GrantModel processGetGrantById(BigInteger altkey) {
        return grantRepository.findById(altkey).orElse(null);
    }

    @Override
    public AppResponseDTO processApprove(List<BigInteger> altkeys) {
        List<Map<String, Object>> grantDataList = new ArrayList<>();
        List<GrantModel> approvedList = new ArrayList<>();

        for (BigInteger altkey : altkeys) {
            GrantModel grantModel = grantRepository.findById(altkey).orElse(null);

            if (grantModel != null && "PENDING".equalsIgnoreCase(grantModel.getGrantStatus())) {
                grantModel.setGrantStatus("APPROVED");
                grantModel.setAllocationState("APPROVED");
                GrantModel saved = grantRepository.save(grantModel);
                approvedList.add(saved);

                // Extract only required fields to send to allocation service
                Map<String, Object> grantMap = new HashMap<>();
                grantMap.put("altkey", saved.getAltkey());
                grantMap.put("planId", saved.getPlanId());
                grantMap.put("frequency", saved.getFrequency());
                grantMap.put("employeeId", saved.getEmployeeId()); // optional

                grantDataList.add(grantMap);
            }
        }

        // Send to Kafka
        kafkaProducerService.sendGrantToKafka(grantDataList);

        return new AppResponseDTO("SUCCESS", "200", approvedList, null);
    }


	@Override
    public AppResponseDTO processAccept(BigInteger altkey) {
		GrantModel grantModel = grantRepository.findById(altkey).orElse(null);

        if (grantModel != null) {
            grantModel.setIsAccepted(true);
            grantRepository.save(grantModel);
            return new AppResponseDTO("SUCCESS", "200", grantModel, null);
        } else {
            return new AppResponseDTO("FAILURE", "404", null, "Grant not found to accept");
        }
    }

}


