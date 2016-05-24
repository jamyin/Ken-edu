package com.ssic.education.common.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProLicenseDto {
	
    private String id;

    private String licName;

    private String licNo;

    private Integer licType;

    private Date licEndDate;

    private String licPic;

    private Date createTime;

    private Date lastUpdateTime;

    private Integer stat;

    private String relationId;

    private Short cerSource;
    
    private String schoolName;
    
    private String supplierName;
    
    private Byte reviewed;//0:未审批，1：通过，2：不通过

}