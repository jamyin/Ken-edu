package com.ssic.educateion.common.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: ChooseSchoolDto
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Ken Yin
 * @date 2016年5月29日 下午12:48:20
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String committeeId;
	private String schoolName;
	private String schoolThum;
	private String mobileNo;
	private String contacts;
	private String address;
	private String longitude;
	private String latitude;
	private String level;
	private String province;
	private String city;
	private String area;
	private String supplierId;
	private Byte reviewed;   //0:未审批，1：通过，2：不通过
	private Date createTime;
	private Date lastUpdateTime;
	private Integer stat;
	
}
