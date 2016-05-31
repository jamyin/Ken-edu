package com.ssic.education.app.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**		
 * <p>Title: LedgerInfoDto </p>
 * <p>Description: 分类帐信息列表DTO</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月16日 下午3:00:43	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月16日 下午3:00:43</p>
 * <p>修改备注：</p>
 */
public @Data class LedgerListDto {

	private String id; //主键

	private Date actionDate; //配送日期

	private String supplierId; //供应商ID

	private String supplierCode; //供应商Code

	private String supplierName; //供应商名称

	private Integer quantity; //数量

	private Date productionDate;//生成日期

	private String productionName;//生产单位

	private String batchNo;//生产批号

	private String receiverId;//收货商ID

	private String receiverCode;//收货商code

	private String receiverName;//收获商名称

	private String traceCode;//追溯码

}
