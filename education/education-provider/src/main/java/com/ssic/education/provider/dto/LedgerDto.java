package com.ssic.education.provider.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

public class LedgerDto {

	@Setter
	@Getter
	private String id;

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
	private Integer actionType;

	@Setter
	@Getter
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date actionDate;

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
	private Integer quantity;

	@Setter
	@Getter
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date productionDate;

	@Setter
	@Getter
	private String batchNo;

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
	private String wareBatchNo;
	
	@Setter
	@Getter
	private Date createTime;

	@Setter
	@Getter
	private Date lastUpdateTime;

	@Setter
	@Getter
	private Integer stat;
	
	@Setter
	@Getter
	private String userName;

	@Override
	public String toString() {
		return "LedgerDto [id=" + id + ", waresId=" + waresId + ", name="
				+ name + ", spce=" + spce + ", actionType=" + actionType
				+ ", actionDate=" + actionDate + ", supplierId=" + supplierId
				+ ", supplierCode=" + supplierCode + ", supplierName="
				+ supplierName + ", quantity=" + quantity + ", productionDate="
				+ productionDate + ", batchNo=" + batchNo + ", receiverId="
				+ receiverId + ", receiverCode=" + receiverCode
				+ ", receiverName=" + receiverName + ", traceCode=" + traceCode
				+ ", userId=" + userId + ", sourceId=" + sourceId
				+ ", wareBatchNo=" + wareBatchNo + ", createTime=" + createTime
				+ ", lastUpdateTime=" + lastUpdateTime + ", stat=" + stat
				+ ", userName=" + userName + "]";
	}
	
	

}