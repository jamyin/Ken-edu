package com.ssic.educateion.common.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

public class RecycleOilDto {

	@Setter
	@Getter
    private String id;

	@Setter
	@Getter
    private String recyclerId;
	
	@Setter
	@Getter
	private String recycler;

	@Setter
	@Getter
    private String supplierId;

	@Setter
	@Getter
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private String recycleDate;

	@Setter
	@Getter
    private Short type;

	@Setter
	@Getter
    private Integer amount;

	@Setter
	@Getter
    private String recyclerName;

	@Setter
	@Getter
    private String documentUrl;

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