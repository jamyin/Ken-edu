package com.ssic.education.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

public class EduSchoolDto implements Serializable {

	@Getter
	@Setter
	private String id;

	@Getter
	@Setter
	private String committeeId;

	@Getter
	@Setter
	private String schoolName;

	@Getter
	@Setter
	private String schoolThum;
	
	@Getter
	@Setter
	private String mobileNo;

	@Getter
	@Setter
	private String address;

	@Getter
	@Setter
	private String longitude;

	@Getter
	@Setter
	private String latitude;

	@Getter
	@Setter
	private Byte level;

	@Getter
	@Setter
	private String province;

	@Getter
	@Setter
	private String city;

	@Getter
	@Setter
	private String area;

	@Getter
	@Setter
	private Date createTime;

	@Getter
	@Setter
	private Date lastUpdateTime;

	@Getter
	@Setter
	private Integer stat;
}