package com.ssic.education.common.dao;

import com.ssic.education.government.dto.ProWaresDto;
import com.ssic.education.common.mapper.ProWaresMapper;
import com.ssic.education.common.pojo.ProWares;
import com.ssic.education.common.pojo.ProWaresExample;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import com.ssic.util.StringUtils;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 * @author pengpeng
 * @Date: 2016年5月12日 下午5:36:28
 */
@Repository
public class ProWaresDao extends MyBatisBaseDao<ProWares>{

	@Getter
	@Autowired
	private ProWaresMapper mapper;

	public List<ProWares> queryWaresByParams(ProWaresDto dto, PageQuery query) {
		ProWaresExample example = new ProWaresExample();
		ProWaresExample.Criteria criteria = example.createCriteria();
		assemblyParams(dto, criteria);
		if(null != query){
			example.setOrderByClause("create_time DESC limit "+query.getStartNum() +"," + query.getPageSize());
		}else{
			example.setOrderByClause("create_time DESC");
		}
		List<ProWares> list = mapper.selectByExample(example);
		return list;
	}

	public int countWaresByParams(ProWaresDto dto) {
		ProWaresExample example = new ProWaresExample();
		ProWaresExample.Criteria criteria = example.createCriteria();
		assemblyParams(dto, criteria);   //组装参数
		return mapper.countByExample(example);
	}

	private void assemblyParams(ProWaresDto dto, ProWaresExample.Criteria criteria) {
		if (null != dto) {
			if (StringUtils.isNotEmpty(dto.getId())){
				criteria.andIdEqualTo(dto.getId().trim());
			}
			if (StringUtils.isNotEmpty(dto.getWaresName())){
				criteria.andWaresNameLike("%"+dto.getWaresName().trim()+"%");
			}
			if (StringUtils.isNotBlank(dto.getSpec())){
				criteria.andSpecLike("%"+dto.getSpec().trim()+"%");
			}
			if (StringUtils.isNotBlank(dto.getSupplierId())){
				criteria.andSupplierIdEqualTo(dto.getSupplierId().trim());
			}
			if (null != dto.getWay()){
				criteria.andWayEqualTo(dto.getWay());
			}
			if (null != dto.getWaresType()){
				criteria.andWaresTypeEqualTo(dto.getWaresType());
			}
			if (null != dto.getDishes()){
				criteria.andDishesEqualTo(dto.getDishes());
			}
		}
		criteria.andStatEqualTo(DataStatus.ENABLED);
	}
}
