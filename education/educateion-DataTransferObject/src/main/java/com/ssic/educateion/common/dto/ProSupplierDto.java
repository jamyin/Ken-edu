package com.ssic.educateion.common.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ProSupplierDto implements Serializable {

	private String id;

	private String supplierName;

	private String committeeId;
	
	private String address;

	private Integer supplierType;

	private String businessLicense;

	private String organizationCode;

	private String corporation;

	private String contactWay;

	private String longitude;

	private String latitude;

	private String provinces; // 省

	private String city; // 市

	private String area; // 区

	private String areaName;

	private Date createTime;

	private Date lastUpdateTime;

	private Integer stat;

	private List<ProLicenseDto> proLicenseDtoList;

	private List<EduSchoolDto> schools; // 供应学校

	private String schoolIds; // 供应学校id(用,分割)

	private String schoolNames; // 供应学校名称(用,分割)

	/* 以下为供应商资质信息 */

	private String licName;

	private String licNo;

	private Integer licType;

	private Date licEndDate;

	private String licPic;

	private Integer source;

	private Byte reviewed;

	private String foodServiceCode;

	private Date foodServiceCodeDate;

	private String foodBusinessCode;

	private Date foodBusinessCodeDate;

	private String foodCirculationCode;

	private Date foodCirculationCodeDate;

	private String foodProduceCode;

	private Date foodProduceCodeDate;

	private String idCard;

	private String idType;

	private String schoolId;
	
	private String updater;
	
	private String sourceId;
}