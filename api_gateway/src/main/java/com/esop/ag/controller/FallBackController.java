package com.esop.ag.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class FallBackController {
	@GetMapping("/grantsFallBack")
      public List<String> grantsFallBack() {
    	  return Arrays.asList("service is not available");
      }
}
