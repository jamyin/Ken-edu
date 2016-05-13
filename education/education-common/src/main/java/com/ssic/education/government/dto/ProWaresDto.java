package com.ssic.education.government.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

public class ProWaresDto implements Serializable{
	
	@Getter
	@Setter
    private String id;

	@Getter
	@Setter
    private String waresName;

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
    private Date createTime;;

	@Getter
	@Setter
    private Date lastUpdateTime;

	@Getter
	@Setter
    private Integer stat;

}