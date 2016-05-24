package com.ssic.education.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.app.dto.MaterialSupplierDto;
import com.ssic.education.app.dto.SupplierLicDto;

/**		
 * <p>Title: SupplierInfoExMapper </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月23日 下午4:08:06	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月23日 下午4:08:06</p>
 * <p>修改备注：</p>
 */
public interface SupplierInfoExMapper {

	SupplierLicDto getSupplierInfoById(@Param("supplier_id") String supplier_id);

	List<MaterialSupplierDto> getSupplierListById(@Param("supplier_id") String supplier_id);
}
