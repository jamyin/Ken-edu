package com.ssic.educateion.common.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ProLedgerMasterDto implements Serializable {

	private String id;

	private Date actionDate;

	private String receiverId;

	private String receiverName;

	private String driverName;

	private String userId;

	private String sourceId;

	private String wareBatchNo;

	private Integer haulStatus;

	private Date startTime;

	private Date endTime;

	private Date createTime;

	private Date lastUpdateTime;

	private Integer stat;
	
	private List<ProLedgerDto> resltList;
	
	private List<ProWaresDto> wareList;
	
	private ProSupplierDto supplierDto;

}