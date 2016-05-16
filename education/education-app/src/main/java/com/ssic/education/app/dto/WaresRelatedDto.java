package com.ssic.education.app.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 		
 * <p>Title: WaresInfoDto </p>
 * <p>Description: 商品关联供应商以及交易信息</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月16日 下午2:39:32	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月16日 下午2:39:32</p>
 * <p>修改备注：</p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WaresRelatedDto {
	private String id;

	private String waresName;

	private String spec;

	private Integer shelfLife;

	private String unit;

	private String supplierId;

	private Integer way;

	private Integer waresType;

	private String customCode;

	private String barCode;

	private String enName;

	private String place;

	private Boolean dishes;

	private String image;

	private String remark;

	private Date crateTime;

	private Date lastUpdateTime;

	private Integer stat;

	private ProSupplierDto supplier;

	private List<LedgerInfoDto> ledgerList;

}
