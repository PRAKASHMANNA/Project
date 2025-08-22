package com.esop.grant.dto;
import lombok.Data;
import lombok.AllArgsConstructor;
@Data
@AllArgsConstructor
public class AppResponseDTO {
	private String status;
	private String statusFlag;
	private Object Data;
    private String errorMessage;
}
