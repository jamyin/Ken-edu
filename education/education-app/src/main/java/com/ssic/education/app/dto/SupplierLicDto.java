package com.ssic.education.app.dto;

import java.util.List;

import com.ssic.education.utils.model.PageResult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**		
 * <p>Title: SupplierLicDto </p>
 * <p>Description: 供应商资质信息DTO</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月23日 上午10:24:40	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月23日 上午10:24:40</p>
 * <p>修改备注：</p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierLicDto {
	private String id; //主键
	private String supplierName; //单位名称
	private String address; //单位地址
	private Integer supplierType; //供应商类型
	private String corporation;//法人代表
	private String contactWay;//联系方式
	private List<AppLicenseDto> appLicense;
	private PageResult<MaterialSupplierDto> materialSupplierList;
}
