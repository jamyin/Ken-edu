package com.ssic.educateion.common.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierReviewedDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String committeeId;
	private String schoolName;
	private String schoolThum;
	private String mobileNo;
	private String area;
	private String address;
	private String supplierName;
    private Integer supplierType;
    private Byte reviewed;//0:未审批，1：通过，2：不通过
    private Date createTime;
}
