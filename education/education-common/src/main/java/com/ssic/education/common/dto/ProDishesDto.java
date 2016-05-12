package com.ssic.education.common.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class ProDishesDto {
	
	@Setter
	@Getter
    private String id;
	
	@Setter
	@Getter
    private String packageId;

	@Setter
	@Getter
    private String waresId;

	@Setter
	@Getter
    private String waresName;

	@Setter
	@Getter
    private String supplierId;

	@Setter
	@Getter
    private String supplierName;

	@Setter
	@Getter
    private Date createTime;

	@Setter
	@Getter
    private Date lastUpdateTime;

	@Setter
	@Getter
    private Short stat;

}