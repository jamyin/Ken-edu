package com.ssic.education.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ProSupplierDto implements Serializable {
	
	@Setter
	@Getter
    private String id;

	@Setter
	@Getter
    private String supplierName;

	@Setter
	@Getter
    private String address;

	@Setter
	@Getter
    private Integer supplierType;

	@Setter
	@Getter
    private String businessLicense;

	@Setter
	@Getter
    private String organizationCode;

	@Setter
	@Getter
    private String corporation;

	@Setter
	@Getter
    private String contactWay;

	@Setter
	@Getter
    private String longitude;

	@Setter
	@Getter
    private String latitude;

	@Setter
	@Getter
    private String province;     //省

	@Setter
	@Getter
    private String city;		 //市

	@Setter
	@Getter
    private String area;         //区
	
	@Setter
	@Getter
    private Date createTime;

	@Setter
	@Getter
    private Date lastUpdateTime;

	@Setter
	@Getter
    private Integer stat;

	@Setter
	@Getter
    private List<ProLicenseDto> proLicenseDtoList;

	@Setter
	@Getter
	private List<EduSchoolDto> schools;	// 供应学校

	private String schoolIds;	// 供应学校id(用,分割)

	private String schoolNames; // 供应学校名称(用,分割)
}