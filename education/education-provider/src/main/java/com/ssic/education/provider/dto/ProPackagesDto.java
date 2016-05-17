package com.ssic.education.provider.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProPackagesDto {

	private String id;

	private String packageName;

	private String supplierId;

	private Short customerType;

	private String customerId;

	private Short grade;

	private Date supplyDate;

	private Short supplyPhase;

	private Date careteTime;

	private Date lastUpdateTime;

	private Integer stat;

}