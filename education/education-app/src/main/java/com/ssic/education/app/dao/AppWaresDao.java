package com.ssic.education.app.dao;

import java.util.List;

import lombok.Getter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.app.dto.WaresInfoDto;
import com.ssic.education.app.dto.WaresListDto;
import com.ssic.education.app.dto.WaresRelatedDto;
import com.ssic.education.app.mapper.WaresInfoExMapper;
import com.ssic.education.handle.mapper.ProWaresMapper;
import com.ssic.education.handle.pojo.ProWares;
import com.ssic.education.handle.pojo.ProWaresExample;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;

/**
 * 		
 * <p>Title: WaresInfoDao </p>
 * <p>Description: 商品信息数据库访问层</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月16日 下午2:02:02	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月16日 下午2:02:02</p>
 * <p>修改备注：</p>
 */
@Repository
public class AppWaresDao extends MyBatisBaseDao<WaresInfoDto> {

	@Getter
	@Autowired
	private ProWaresMapper mapper;

	@Getter
	@Autowired
	private WaresInfoExMapper WareInfoMapper;

	public List<WaresInfoDto> findWarseBySupplier(String supplierId) {
		return WareInfoMapper.findWarseBySupplier(supplierId);
	}

	public WaresRelatedDto findWarseById(String id) {
		return WareInfoMapper.findWarseById(id);
	}

	public List<WaresListDto> findWarseBySchoolId(String schoolId) {
		return WareInfoMapper.findWarseBySchoolId(schoolId);
	}

	/**
	 * 
	 * findWarseInLedger：根据配送记录商品查询商品信息
	 * @param ledgerWares
	 * @param proWares
	 * @param page
	 * @return
	 * @exception	
	 * @author SeanYoung
	 * @date 2016年5月29日 下午3:45:55
	 */
	public List<ProWares> findWarseInSchool(List<String> schoolWares, ProWares proWares, PageQuery page) {
		ProWaresExample example = new ProWaresExample();
		ProWaresExample.Criteria criteria = example.createCriteria();
		if (null != proWares) {
			if (StringUtils.isNotBlank(proWares.getWaresName())) {
				criteria.andWaresNameLike("%" + proWares.getWaresName() + "%");
			}
			if (proWares.getWaresType() != null) {
				criteria.andWaresTypeEqualTo(proWares.getWaresType());
			}
		}
		if (schoolWares != null && !schoolWares.isEmpty()) {
			criteria.andIdIn(schoolWares);
		}
		criteria.andStatEqualTo(DataStatus.ENABLED);
		if (null != page) {
			example.setOrderByClause("stat desc,create_time desc limit " + page.getStartNum() + "," + page.getPageSize());
		}
		List<ProWares> WarseInLedger = mapper.selectByExample(example);

		return WarseInLedger;
	}

	public int findWarseInSchoolCount(List<String> schoolWares, ProWares proWares) {
		ProWaresExample example = new ProWaresExample();
		ProWaresExample.Criteria criteria = example.createCriteria();
		if (null != proWares) {
			if (StringUtils.isNotBlank(proWares.getWaresName())) {
				criteria.andWaresNameLike("%" + proWares.getWaresName() + "%");
			}
			if (proWares.getWaresType() != null) {
				criteria.andWaresTypeEqualTo(proWares.getWaresType());
			}
		}
		if (schoolWares != null && !schoolWares.isEmpty()) {
			criteria.andIdIn(schoolWares);
		}
		criteria.andStatEqualTo(DataStatus.ENABLED);

		return mapper.countByExample(example);
	}
}
