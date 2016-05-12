package com.ssic.education.government.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class ProLedgerDto {
	
	@Getter
	@Setter
    private String id;

	@Getter
	@Setter
    private String waresId;

	@Getter
	@Setter
    private String spce;

	@Getter
	@Setter
    private Integer actionType;

	@Getter
	@Setter
    private Date actionDate;

	@Getter
	@Setter
    private String supplierId;

	@Getter
	@Setter
    private String supplierCode;

	@Getter
	@Setter
    private String supplierName;

	@Getter
	@Setter
    private Integer quantity;

	@Getter
	@Setter
    private Date productionDate;

	@Getter
	@Setter
    private String batchNo;

	@Getter
	@Setter
    private String receiverId;

	@Getter
	@Setter
    private String receiverCode;

	@Getter
	@Setter
    private String receiverName;

	@Getter
	@Setter
    private String traceCode;

	@Getter
	@Setter
    private Date createTime;

	@Getter
	@Setter
    private Date lastUpdateTime;

	@Getter
	@Setter
    private Integer stat;

}