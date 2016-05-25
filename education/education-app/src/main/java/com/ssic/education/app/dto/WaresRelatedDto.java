package com.ssic.education.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 		
 * <p>Title: WaresInfoDto </p>
 * <p>Description: 商品关联证书以及交易信息</p>
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
	/**主键*/
	private String id;
	/**商品名称*/
	private String waresName;
	/**规格*/
	private String spec;
	/**保质期*/
	private Integer shelfLife;
	/**保质期单位*/
	private String unit;
	/**供应商ID*/
	private String supplierId;
	/**生成企业*/
	private String manufacturer;
	/**商品方向 0采购品1为产出品*/
	private Integer way;
	/**商品类别*/
	private Integer waresType;
	/**企业自定义编码*/
	private String customCode;
	/**产地*/
	private String place;
	/**商品英文名*/
	private String enName;
	/**商品图片*/
	private String image;
	/**检测检验报告*/
	private String insReport;
	/**生产许可证*/
	private String proLic;

}
