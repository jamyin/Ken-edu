package com.ssic.education.app.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**		
 * <p>Title: LedgerInfoDto </p>
 * <p>Description: 分类帐信息表</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月16日 下午3:00:43	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月16日 下午3:00:43</p>
 * <p>修改备注：</p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LedgerInfoDto {

	private String id;

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
}
