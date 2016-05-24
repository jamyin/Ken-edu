package com.ssic.education.common.provider.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

public class LedgerAddressDto {

	@Setter
	@Getter
	private String id;
	
	@Setter
	@Getter
	private String schoolName;
	
	@Setter
	@Getter
	private String supplierId;
	
	@Setter
	@Getter
	private String schoolId;
	
	@Setter
	@Getter
	private String mobileNo;
	
	@Setter
	@Getter
	private String address;
	
	@Setter
	@Getter
	private String contacts;
}