package com.ssic.education.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.common.dto.ProWaresDto;

/**
 * 		
 * <p>Title: ProWaresExMapper </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月12日 下午4:43:17	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月12日 下午4:43:17</p>
 * <p>修改备注：</p>
 */
public interface ProWaresExMapper {
	/**
	 * 
	 * findWarseBySupplier根据供应商ID查询菜品信息
	 * @return
	 * @exception	
	 * @author SeanYoung
	 * @date 2016年5月12日 下午4:46:27
	 */
	List<ProWaresDto> findWarseBySupplier(@Param("supplierId") String supplierId);
	
	
}