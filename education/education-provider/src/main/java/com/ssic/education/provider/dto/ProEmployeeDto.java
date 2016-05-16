package com.ssic.education.provider.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class ProEmployeeDto {
		@Getter
		@Setter
		private String id;

		@Getter
		@Setter
	    private String supplierId;
		@Getter
		@Setter
	    private String supplierName;//供应商名称
		@Getter
		@Setter
	    private String name;

		@Getter
		@Setter
	    private Byte gender;

		@Getter
		@Setter
	    private Short idType;

		@Getter
		@Setter
	    private String idCode;

		@Getter
		@Setter
	    private String mobile;
		@Getter
		@Setter
	   
	    private Short position;

		@Getter
		@Setter
	    private String workNum;

		@Getter
		@Setter
	    private String healthCode;
		@Getter
		@Setter
	    
	    private Date healthCodeDate;
		@Getter
		@Setter
	    
	    private String healthCodeDateString;

		@Getter
		@Setter
	    private String trainCode;

		@Getter
		@Setter
	    private Short trainLevel;
		@Getter
		@Setter
	    private Date trainCodeDate;
		@Getter
		@Setter
	    private String  trainCodeDateString;
		@Getter
		@Setter
	 
	    private Date createTime;
		@Getter
		@Setter
	    private Date lastUpdateTime;
		@Getter
		@Setter
	 
	    private Short stat;
}
