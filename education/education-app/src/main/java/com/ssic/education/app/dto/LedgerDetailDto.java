package com.ssic.education.app.dto;

import java.util.Date;

import lombok.Data;

/**		
 * <p>Title: ledgerDetailDto </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月26日 下午6:21:04	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月26日 下午6:21:04</p>
 * <p>修改备注：</p>
 */

public @Data class LedgerDetailDto {
	private String id;
	private String masterId;
	private String waresId;
	private String name;
	private String supplierId;
	private String supplierName;
	private String quantity;
	private Date productionDate;
	private String productionName;
}
