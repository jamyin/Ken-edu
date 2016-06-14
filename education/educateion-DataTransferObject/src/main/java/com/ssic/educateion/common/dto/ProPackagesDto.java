package com.ssic.educateion.common.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProPackagesDto {

	private String id;

	private String packageName;

	private String supplierId;

	private String sourceId;

	private Integer type;

	private Short customerType;

	private String customerId;

	private Short grade;

	private Date supplyDate;

	private String supplyDateStr;

	private Short supplyPhase;

	private Date createTime;

	private Date lastUpdateTime;

	private Short stat;

	private List<ProDishesDto> proDishesDtos;

	private List<ProPackagesDto> proPackagesDtos;

	private List<ProNutritionalDto> proNutritionalDtos;

	private String waresNames; // 拼接菜品

	private String nutritionalNames;// 拼接营养名称

	private String nutritionalWeights;// 拼接营养含量

	private String nutritionalUnits; // 拼接营养单位

	private Integer source;// 来源0：市教委，1：区教委，2：学校

	private float comment;

	private String creator; // 更新人

	private Integer packageStar;//package 的 评级 数量
	
	private Boolean evaluated = false; //true 点评 false 未点评

}
