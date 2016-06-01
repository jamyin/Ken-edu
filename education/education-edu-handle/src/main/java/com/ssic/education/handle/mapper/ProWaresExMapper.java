package com.ssic.education.handle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.educateion.common.dto.ProWaresDto;
import com.ssic.education.handle.dto.ProSchoolWareDto;
import com.ssic.education.utils.model.PageQuery;

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

	/**
	 * 
		 * 此方法描述的是：根据学校查询 对应的采购品信息
		 * @author: cwftalus@163.com
		 * @version: 2016年5月29日 上午11:20:10
	 */
	List<ProWaresDto> searchProWares(@Param("schoolId") String schoolId,@Param("waresName") String waresName);
	
	List<ProWaresDto> findWarseListByParam(@Param("proSchoolWareDto") ProSchoolWareDto proSchoolWareDto,@Param("query") PageQuery query);
	
	long countWarseListByParam(@Param("proSchoolWareDto") ProSchoolWareDto proSchoolWareDto);
}