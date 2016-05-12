package com.ssic.education.common.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class ProSupplierDto {
	
	@Setter
	@Getter
    private String id;

	@Setter
	@Getter
    private String supplierName;

	@Setter
	@Getter
    private String asddress;

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
}