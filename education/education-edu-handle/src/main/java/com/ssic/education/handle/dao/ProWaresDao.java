package com.ssic.education.handle.dao;

import java.util.List;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.educateion.common.dto.ProWaresDto;
import com.ssic.education.handle.dto.ProSchoolWareDto;
import com.ssic.education.handle.mapper.ProWaresExMapper;
import com.ssic.education.handle.mapper.ProWaresMapper;
import com.ssic.education.handle.pojo.ProWares;
import com.ssic.education.handle.pojo.ProWaresExample;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import com.ssic.education.utils.util.StringUtils;

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
	
	@Getter
	@Autowired
	private ProWaresExMapper mapperEx;

	public List<ProWaresDto> findWarseListByParam(ProSchoolWareDto proSchoolWareDto,PageQuery query) {
		return mapperEx.findWarseListByParam(proSchoolWareDto, query);
	}
	
	public long countWarseListByParam(ProSchoolWareDto proSchoolWareDto) {
		return mapperEx.countWarseListByParam(proSchoolWareDto);
	}
	
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

	public List<ProWaresDto> searchProWares(String schoolId,String waresName) {
		// TODO Auto-generated method stub
		return mapperEx.searchProWares(schoolId,waresName);
	}

	public List<ProWares> searchWarseList(List<String> wareIds) {
		ProWaresExample example = new ProWaresExample();
		ProWaresExample.Criteria criteria = example.createCriteria();
		
		criteria.andIdIn(wareIds);
		
		return mapper.selectByExample(example);
	}
}
