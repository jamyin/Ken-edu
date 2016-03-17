package com.ssic.education.common.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class SchoolSupplierDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2274919128120845789L;

	    @Getter
	    @Setter
	    private String id;
	    @Getter
	    @Setter
	    private String projId;
	    @Getter
	    @Setter
	    private String supplierName;
	    @Getter
	    @Setter
	    private String supplierAddress;
	    @Getter
	    @Setter
	    private String foodLicense;
	    @Getter
	    @Setter
	    private String businessLicense;
	    @Getter
	    @Setter
	    private String corporation;
	    @Getter
	    @Setter
	    private String contactWay;
	    @Getter
	    @Setter
	    private String certificateIcon;
	    @Getter
	    @Setter
	    private String longitude;
	    @Getter
	    @Setter
	    private String latitude;
	    @Getter
	    @Setter
	    private Date createTime;
	    @Getter
	    @Setter
	    private Date lastUpdateTime;
	    @Getter
	    @Setter
	    private Integer stat;
	    @Getter
	    @Setter
	    private String projName;
	
}
