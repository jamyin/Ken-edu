package com.ssic.educateion.common.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class ProLedgerDto implements Serializable {
	private String schoolId;
	
	private String sourceId;
	
	private Integer source;

	private String id;

	private String masterId;
	
	private String waresId;

	private String name;

	private String spce;

	private Integer actionType;

	private Date actionDate;

	private String supplierId;

	private String supplierCode;

	private String supplierName;

	private Integer quantity;

	private Date productionDate;

	private String batchNo;

	private String receiverId;

	private String receiverCode;

	private String receiverName;

	private String traceCode;

	private Date createTime;

	private Date lastUpdateTime;

	private Integer stat;
	
	private String driverName;
	
    private String productionName;

}