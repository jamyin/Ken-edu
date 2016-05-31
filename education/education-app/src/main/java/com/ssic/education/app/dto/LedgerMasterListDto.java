package com.ssic.education.app.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**		
 * <p>Title: LedgerMasterListDto </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月25日 下午5:44:02	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月25日 下午5:44:02</p>
 * <p>修改备注：</p>
 */
public @Data class LedgerMasterListDto {
	private String id; //ID
	private Date actionDate; //配送日期
	private String receiverId;//收获商ID
	private String receiverName;//收货商名称
	private String userId;//驾驶员ID 
	private String sourceId;//企业ID
	private String outset;//出发点
	private String stock;//
	private String wareBatchNo; //商品运送批次
	private Integer haulStatus;//运送状态	
}
