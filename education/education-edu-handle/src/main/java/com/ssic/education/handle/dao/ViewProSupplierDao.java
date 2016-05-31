package com.ssic.education.handle.dao;

import java.util.List;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.educateion.common.dto.ProSupplierDto;
import com.ssic.education.handle.mapper.ViewProSupplierMapper;
import com.ssic.education.handle.pojo.ViewProSupplier;
import com.ssic.education.handle.pojo.ViewProSupplierExample;
import com.ssic.education.handle.pojo.ViewProSupplierWithBLOBs;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import com.ssic.education.utils.util.StringUtils;

/**
 * <p>Description: 类描述:视图 v_sup_sch_area_group dao层实现 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author wangxiang
 * @date 2016/5/13 11:17
 * @version 1.0
 */
@Repository
public class ViewProSupplierDao extends MyBatisBaseDao<ViewProSupplier> {

	@Getter
	@Autowired
	private ViewProSupplierMapper mapper;

//	/**
//	 * <p>Description: 根据参数查询视图v_sup_sch_area_group </p>
//	 * <p>Company: 上海天坊信息科技有限公司</p>
//	 * @param
//	 * @return
//	 * @author wangxiang
//	 * @date 2016/5/13 12:02
//	 * @version 1.0
//	 */
//	public List<ViewProSupplierWithBLOBs> queryViewSupplier(ProSupplierDto proSupplierDto, PageQuery query) {
//		ViewProSupplierExample example = new ViewProSupplierExample();
//		ViewProSupplierExample.Criteria criteria = example.createCriteria();
//        assemblyParams(proSupplierDto, criteria);
//        if(null != query){
//        	example.setOrderByClause("create_time DESC limit "+query.getStartNum() +"," + query.getPageSize());
//		}else{
//			example.setOrderByClause("create_time DESC");
//		}
//		List<ViewProSupplierWithBLOBs> list = mapper.selectByExampleWithBLOBs(example);
//		return list;
//	}

	/**
	 * <p>Description:  根据参数统计视图v_sup_sch_area_group </p>
	 * <p>Company: 上海天坊信息科技有限公司</p>
	 * @param
	 * @return
	 * @author wangxiang
	 * @date 2016/5/13 12:01
	 * @version 1.0
	 */
//	public int countViewSupplier(ProSupplierDto proSupplierDto) {
//		ViewProSupplierExample example = new ViewProSupplierExample();
//		ViewProSupplierExample.Criteria criteria = example.createCriteria();
//        assemblyParams(proSupplierDto, criteria);   //组装参数
//        return mapper.countByExample(example);
//	}

//	private void assemblyParams(ProSupplierDto proSupplierDto, ViewProSupplierExample.Criteria criteria) {
//		if (null != proSupplierDto) {
//			if (StringUtils.isNotEmpty(proSupplierDto.getId())){
//				criteria.andIdEqualTo(proSupplierDto.getId().trim());
//			}
//			if (StringUtils.isNotEmpty(proSupplierDto.getArea())){
//				criteria.andAreaEqualTo(proSupplierDto.getArea().trim());
//			}
//			if (StringUtils.isNotBlank(proSupplierDto.getSupplierName())){
//				criteria.andSupplierNameLike("%"+proSupplierDto.getSupplierName().trim()+"%");
//			}
//			if (StringUtils.isNotBlank(proSupplierDto.getAddress())){
//				criteria.andAddressLike("%"+proSupplierDto.getAddress().trim()+"%");
//			}
//			if (StringUtils.isNotBlank(proSupplierDto.getSchoolIds())){
//				criteria.andSchoolIdsLike("%"+proSupplierDto.getSchoolIds().trim()+"%");
//			}
//		}
//	}
}

