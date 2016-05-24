package com.ssic.education.app.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**		
 * <p>Title: MaterialSupplier </p>
 * <p>Description: 原料供应商</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月23日 下午2:18:26	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月23日 下午2:18:26</p>
 * <p>修改备注：</p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterialSupplierDto {
	private String id; //主键
	private String supplierName; //单位名称
	private String address; //单位地址
}
