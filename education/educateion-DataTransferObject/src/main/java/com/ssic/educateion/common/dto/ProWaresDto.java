package com.ssic.educateion.common.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProWaresDto implements Serializable {

	private String id;

	private String waresName;

	private String supplierName;// 供应商名称

	private String image;// 图片路径

	private String remark;// 备注

	private String spec;

	private Integer shelfLife;

	private String unit;

	private String supplierId;

	private Integer way;

	private Integer waresType;

	private String customCode;

	private String barCode;

	private String enName;

	private String place;

	private Boolean dishes;

	private Date createTime;

	private Date lastUpdateTime;

	private Integer stat;

	private String manufacturer;

	private String waresTypeName;

}
