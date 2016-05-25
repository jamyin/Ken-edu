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
	private Integer type;
	
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
    private Date supplyDate;

	@Getter
	@Setter
    private Short supplyPhase;

	@Getter
	@Setter
    private Date createTime;

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
	
	
	@Getter
	@Setter
	private List<ProNutritionalDto> proNutritionalDtos;
	
	
	@Getter
	@Setter
    private String waresNames;    //拼接菜品
	
	@Getter
	@Setter
    private String nutritionalNames;//拼接营养名称
	
	@Getter
	@Setter
    private String nutritionalWeights;//拼接营养含量

	@Getter
	@Setter
    private String nutritionalUnits; //拼接营养单位
}