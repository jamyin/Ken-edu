package com.ssic.education.app.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.ssic.education.utils.model.PageResult;

/**		
 * <p>Title: LedgerMasterInfoDto </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月26日 下午6:09:44	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月26日 下午6:09:44</p>
 * <p>修改备注：</p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LedgerMasterInfoDto {
	private String id;
	private Date actionDate; //配送日期
	private String wareBatchNo; //商品运送批次
	private String userId;//驾驶员ID 
	private String driverName;//驾驶员名称
	private String receiverId;//收获商ID
	private String receiverName;//收货商名称
	private String sourceId;//企业ID
	private String outset;//出发点
	private String stock;//菜品
	private Integer haulStatus;//运送状态	
	private Date lastUpdateTime;//
	private PageResult<ledgerDetailDto> resultLedger;
}
