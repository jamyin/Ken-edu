package com.ssic.education.common.dao;

import java.util.List;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.common.dto.ProDishesDto;
import com.ssic.education.common.mapper.ProDishesExMapper;
import com.ssic.education.common.mapper.ProDishesMapper;
import com.ssic.education.common.pojo.ProDishes;
import com.ssic.education.government.dto.ProWaresDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;

/**
 * 
 * @author pengpeng
 * @Date: 2016年5月12日 下午4:28:22
 */
@Repository
public class ProDishesDao extends MyBatisBaseDao<ProDishes>{

	@Getter
	@Autowired
	private ProDishesMapper mapper;
	
	@Autowired
	private ProDishesExMapper exMapper;
	
	public List<ProWaresDto> findPage(ProWaresDto proWaresDto,PageQuery page) {
		return exMapper.selectWaresByContact(proWaresDto, page);
	}
	
	public long count(ProWaresDto proWaresDto) {
		return exMapper.countWares(proWaresDto);
	}
}
