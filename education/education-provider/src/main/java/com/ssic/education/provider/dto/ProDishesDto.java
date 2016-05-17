package com.ssic.education.provider.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 		
 * <p>Title: ProDishes </p>
 * <p>Description: 套餐子表菜品信息</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月17日 下午2:35:45	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月17日 下午2:35:45</p>
 * <p>修改备注：</p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProDishesDto {

	private String id;

	private String packageId;

	private String waresId;

	private String waresName;

	private String supplierId;

	private String supplierName;

	private Date createTime;

	private Date lastUpdateTime;

	private Short stat;
}
