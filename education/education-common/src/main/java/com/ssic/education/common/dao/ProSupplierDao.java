package com.ssic.education.common.dao;

import java.util.Date;
import java.util.List;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.common.mapper.ProSupplierExMapper;
import com.ssic.education.common.mapper.ProSupplierMapper;
import com.ssic.education.common.pojo.ProSupplier;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import com.ssic.education.utils.util.BeanUtils;

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

	public void updataProSupplier(ProSupplier ps) {
		ps.setCreateTime(null);
		ps.setLastUpdateTime(new Date());
		mapper.updateByPrimaryKeySelective(ps);
	}

	public int deleteSupplierById(String id) {
		return mapper.deleteByPrimaryKey(id);
	}

	public int saveSupplier(ProSupplier ps) {
		ps.setCreateTime(new Date());
		ps.setLastUpdateTime(ps.getCreateTime());
		return mapper.insert(ps);
	}

}
