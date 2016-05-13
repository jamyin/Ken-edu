package com.ssic.education.common.dao;

import java.util.List;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.common.mapper.ProSupplierExMapper;
import com.ssic.education.common.mapper.ProSupplierMapper;
import com.ssic.education.common.pojo.ProSupplier;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;

/**
 * 
 * @author pengpeng
 * @Date: 2016年5月12日 下午5:36:33
 */
@Repository
public class ProSupplierDao extends MyBatisBaseDao<ProSupplier> {

	@Getter
	@Autowired
	private ProSupplierMapper mapper;
	
	@Autowired
	private ProSupplierExMapper exMapper;

	public List<ProSupplierDto> findAllProSupplier() {
		return exMapper.findAllProSupplier();
	}

	public ProSupplierDto findProSupplierById(String id) {
		return exMapper.findProSupplierById(id);
	}

}
