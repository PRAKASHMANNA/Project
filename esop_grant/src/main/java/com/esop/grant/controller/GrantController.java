package com.esop.grant.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esop.grant.constants.MappingConstants;
import com.esop.grant.dto.AppResponseDTO;
import com.esop.grant.dto.GrantDTO;
import com.esop.grant.entity.GrantModel;
import com.esop.grant.service.GrantService;

import lombok.AllArgsConstructor;
@RestController
@AllArgsConstructor
public class GrantController {
	private GrantService grantService;
	 @PostMapping(value=MappingConstants.UPLOAD)
   public @ResponseBody AppResponseDTO uploadGrants(@RequestBody List<GrantDTO>list) {
	   return grantService.processCreate(list);
   }
	 @GetMapping(value=MappingConstants.GETID)
	    public GrantModel getGrantById(@PathVariable("id") BigInteger id) {
	        return grantService.processGetGrantById(id); 
	    }
	 @PostMapping(value=MappingConstants.APPROVE)
	    public AppResponseDTO approveGrants(@RequestBody List<BigInteger> altkeys) {
	        return grantService.processApprove(altkeys);
	    }
	 @PostMapping(value=MappingConstants.ACCEPT)
	    public AppResponseDTO acceptGrant(@PathVariable("id") BigInteger id) {
	        return grantService.processAccept(id);
	    }
}
