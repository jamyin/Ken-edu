package com.ssic.educateion.common.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

public class LedgerDto {

	@Setter
	@Getter
	private String id;
	
	@Setter
	@Getter
	private String masterId;

	@Setter
	@Getter
	private String waresId;

	@Setter
	@Getter
	private String name;

	@Setter
	@Getter
	private String spce;
	
	@Setter
	@Getter
	private String spec;

	@Setter
	@Getter
	private Integer actionType;

	@Setter
	@Getter
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date actionDate;
	
	@Setter
	@Getter
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date nextDate;

	@Setter
	@Getter
	private String supplierId;

	@Setter
	@Getter
	private String supplierCode;

	@Setter
	@Getter
	private String supplierName;

	@Setter
	@Getter
	private String quantity;

	@Setter
	@Getter
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date productionDate;
	
	@Setter
	@Getter
	private Date startTime;
	
	@Setter
	@Getter
	private Date endTime;
	
	@Setter
	@Getter
	private String productionName;

	@Setter
	@Getter
	private String batchNo;
	
	@Setter
	@Getter
	private Integer shelfLife;
	
	
	@Setter
	@Getter
	private String unit;
	
	@Setter
	@Getter
	private String amountUnit;

	@Setter
	@Getter
	private String receiverId;

	@Setter
	@Getter
	private String receiverCode;

	@Setter
	@Getter
	private String receiverName;

	@Setter
	@Getter
	private String traceCode;

	@Setter
	@Getter
	private String userId;
	
	@Setter
	@Getter
	private String sourceId;
	
	@Setter
	@Getter
	private String customerId;
	
	@Setter
	@Getter
	private String sourceName;
	
	@Setter
	@Getter
	private String wareBatchNo;
	
	@Setter
	@Getter
	private String creator;
	
	@Setter
	@Getter
	private Date createTime;

	@Setter
	@Getter
	private String updater;
	
	@Setter
	@Getter
	private Date lastUpdateTime;

	@Setter
	@Getter
	private Integer stat;
	
	@Setter
	@Getter
	private String userName;
	
	@Setter
	@Getter
	private String sendDate;
	
	@Setter
	@Getter
	private int haulStatus;
	
	@Setter
	@Getter
	private Integer source;//来源0：市教委，1：区教委，2：学校
	
	@Setter
	@Getter
	private List<LedgerDto> ledgerDtos;
	
	@Setter
	@Getter
	private int mark;
	
	@Override
	public String toString() {
		return "LedgerDto [id=" + id + ", masterId=" + masterId + ", waresId="
				+ waresId + ", name=" + name + ", spce=" + spce
				+ ", actionType=" + actionType + ", actionDate=" + actionDate
				+ ", nextDate=" + nextDate + ", supplierId=" + supplierId
				+ ", supplierCode=" + supplierCode + ", supplierName="
				+ supplierName + ", quantity=" + quantity + ", productionDate="
				+ productionDate + ", productionName=" + productionName +", endTime=" + endTime +", startTime=" + startTime
				+ ", batchNo=" + batchNo + ", receiverId=" + receiverId
				+ ", receiverCode=" + receiverCode + ", receiverName="
				+ receiverName + ", traceCode=" + traceCode + ", userId="
				+ userId + ", sourceId=" + sourceId + ", wareBatchNo="
				+ wareBatchNo + ", createTime=" + createTime
				+ ", lastUpdateTime=" + lastUpdateTime + ", stat=" + stat
				+ ", userName=" + userName + ", sendDate=" + sendDate
				+ ", haulStatus=" + haulStatus + "]";
	}

}
