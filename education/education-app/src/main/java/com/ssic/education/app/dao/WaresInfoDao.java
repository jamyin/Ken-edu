package com.ssic.education.app.dao;

import com.ssic.education.app.dto.WaresInfoDto;
import com.ssic.education.app.mapper.WaresInfoExMapper;
import com.ssic.education.common.mapper.ProWaresMapper;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
public class WaresInfoDao extends MyBatisBaseDao<WaresInfoDto> {

	@Getter
	@Autowired
	private ProWaresMapper mapper;

	@Getter
	@Autowired
	private WaresInfoExMapper WareInfoMapper;

	public List<WaresInfoDto> findWarseBySupplier(String supplierId) {
		return WareInfoMapper.findWarseBySupplier(supplierId);
	}
}
