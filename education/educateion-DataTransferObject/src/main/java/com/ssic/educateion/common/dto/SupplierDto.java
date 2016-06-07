package com.ssic.educateion.common.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.springframework.format.annotation.DateTimeFormat;

@Data
public class SupplierDto implements Serializable {

	private String id;

	private String supplierName;

	private String supplierId;

	private String waresName;// 商品名称

	private String receiverId;

	private String supplierCode;

	private String spec;// 商品规格

	private String address;

	private String provinces;

	private String city;

	private String area;

	private Integer supplierType;

	private String businessLicense;

	private String organizationCode;

	private String foodServiceCode;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date foodServiceCodeDate;

	private String foodBusinessCode;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date foodBusinessCodeDate;

	private String foodCirculationCode;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date foodCirculationCodeDate;

	private String foodProduceCode;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date foodProduceCodeDate;

	private String code;

	private String abbr;

	private String corporation;

	private String contactWay;

	private String longitude;

	private String latitude;
	private String creator;
	private String Updater;

	private Date createTime;

	private Date lastUpdateTime;

	private Integer stat;

	private Byte reviewed;
}