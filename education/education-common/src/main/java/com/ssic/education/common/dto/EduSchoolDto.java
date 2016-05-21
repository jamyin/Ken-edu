package com.ssic.education.common.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: EduSchoolDto
* @Description: TODO(这里用一句话描述这个类的作用)
* @author Ken Yin
* @date 2016年5月17日 上午10:05:56
*
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EduSchoolDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String committeeId;
	private String schoolName;
	private String schoolThum;
	private String mobileNo;
	private String address;
	private String longitude;
	private String latitude;
	private Byte level;
	private String province;
	private String city;
	private String area;
	private Byte reviewed;
	private Date createTime;
	private Date lastUpdateTime;
	private Integer stat;
	private List<ProPackagesDto> packagesDtoList;
	private Integer source;
	private String waresName;
	private Integer waresType;
	private String spec;
	private String image;
	private String remark;
	
	private String supplyDate;       
	private String grade; 		   //年级
	private String supplyPhase;    //供应阶段:早中晚餐
	
}
