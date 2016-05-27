package com.ssic.educateion.common.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class EduSchoolSupplierDto implements Serializable {

	private String id;

	private String schoolId;

	private String supplierId;

	private Date createTime;

	private Date lastUpdateTime;

	private Integer stat;

}
