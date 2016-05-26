package com.ssic.educateion.common.dto;

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
