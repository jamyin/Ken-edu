package com.ssic.education.common.dto;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class ProPackagesDto {
	
	@Getter
	@Setter
    private String id;

	@Getter
	@Setter
    private String packageName;

	@Getter
	@Setter
    private String supplierId;

	@Getter
	@Setter
    private Short customerType;

	@Getter
	@Setter
    private String customerId;

	@Getter
	@Setter
    private Short grade;

	@Getter
	@Setter
    private String supplyDate;

	@Getter
	@Setter
    private Short supplyPhase;

	@Getter
	@Setter
    private Date careteTime;

	@Getter
	@Setter
    private Date lastUpdateTime;

	@Getter
	@Setter
    private Short stat;

	@Setter
	@Getter
	private List<ProDishesDto> proDishesDtos;
	
	@Getter
	@Setter
	private List<ProPackagesDto> proPackagesDtos;
}