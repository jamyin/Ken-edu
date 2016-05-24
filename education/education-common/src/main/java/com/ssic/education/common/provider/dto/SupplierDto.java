package com.ssic.education.common.provider.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import org.springframework.format.annotation.DateTimeFormat;

public class SupplierDto {

	@Setter
	@Getter
    private String id;

	@Setter
	@Getter
    private String supplierName;
	@Setter
	@Getter
    private String supplierId;
	@Setter
	@Getter
    private String waresName;//商品名称
	@Setter
	@Getter
    private String  receiverId;
	@Setter
	@Getter
    private String  supplierCode;
	@Setter
	@Getter
    private String spec;//商品规格

	@Setter
	@Getter
    private String address;

	@Setter
	@Getter
    private String provinces;

	@Setter
	@Getter
    private String city;

	@Setter
	@Getter
    private String area;

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
    private String foodServiceCode;

	@Setter
	@Getter
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date foodServiceCodeDate;

	@Setter
	@Getter
    private String foodBusinessCode;

	@Setter
	@Getter
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date foodBusinessCodeDate;

	@Setter
	@Getter
    private String foodCirculationCode;

	@Setter
	@Getter
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date foodCirculationCodeDate;

	@Setter
	@Getter
    private String foodProduceCode;

	@Setter
	@Getter
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date foodProduceCodeDate;

	@Setter
	@Getter
    private String code;

	@Setter
	@Getter
    private String abbr;

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
    private Date createTime;

	@Setter
	@Getter
    private Date lastUpdateTime;

	@Setter
	@Getter
    private Integer stat;
}