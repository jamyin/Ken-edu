package com.ssic.education.government.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class ProWaresDto {
		@Getter
		@Setter
	   private String id;
		@Getter
		@Setter
	    private String waresName;
		@Getter
		@Setter
	    private String supplierName;//供应商名称
		
		@Getter
		@Setter
	     private String image;//图片路径
		@Getter
		@Setter
		private String 	remark;//备注
		@Getter
		@Setter
	    private String spec;

		@Getter
		@Setter
	    private Integer shelfLife;

		@Getter
		@Setter
	    private String unit;

		@Getter
		@Setter
	    private String supplierId;

		@Getter
		@Setter
	    private Integer way;
		@Getter
		@Setter
	    private Integer waresType;

		@Getter
		@Setter
	    private String customCode;
		@Getter
		@Setter
	    private String barCode;

		@Getter
		@Setter
	    private String enName;

		@Getter
		@Setter
	    private String place;
		@Getter
		@Setter
	    
	    private Boolean dishes;

		@Getter
		@Setter
	    private Date crateTime;

		@Getter
		@Setter
	    private Date lastUpdateTime;

		@Getter
		@Setter
	    private Integer stat;

	    
}
