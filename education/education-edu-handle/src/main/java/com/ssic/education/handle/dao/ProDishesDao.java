package com.ssic.education.handle.dao;

import java.util.List;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.educateion.common.dto.ProWaresDto;
import com.ssic.education.handle.mapper.ProDishesExMapper;
import com.ssic.education.handle.mapper.ProDishesMapper;
import com.ssic.education.handle.pojo.ProDishes;
import com.ssic.education.handle.pojo.ProWares;
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
	
	public int addWaresBatch(List<ProWares> waresList) {
		return exMapper.addWaresBatch(waresList);
	}

	public int addDishesBatch(List<ProDishes> dishesList) {
		return exMapper.addDishesBatch(dishesList);
	}
}
