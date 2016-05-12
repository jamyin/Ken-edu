package com.ssic.education.common.dao;

import java.util.List;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.common.mapper.ProSupplierMapper;
import com.ssic.education.common.pojo.ProSupplier;
import com.ssic.education.common.pojo.ProSupplierExample;
import com.ssic.education.common.pojo.ProSupplierExample.Criteria;
import com.ssic.util.BeanUtils;
import com.ssic.util.StringUtils;
import com.ssic.util.base.MyBatisBaseDao;
import com.ssic.util.constants.DataStatus;
import com.ssic.util.model.PageQuery;

/**
* @ClassName: SupplierDao
* @Description: TODO(这里用一句话描述这个类的作用)
* @author Ken Yin
* @date 2016年5月12日 下午2:24:48
*
 */
@Repository
public class SupplierDao extends MyBatisBaseDao<ProSupplier> {

	@Getter
	@Autowired
	private ProSupplierMapper mapper;
    
	/**
	* @Title: findSupplierList
	* @Description: 分页查询供应商
	* @author Ken Yin  
	* @date 2016年5月12日 下午3:03:39
	* @return List<ProSupplierDto>    返回类型
	 */
	public List<ProSupplierDto> findSupplierList(ProSupplierDto proSupplierDto,PageQuery query) {
		ProSupplierExample example = new ProSupplierExample();
		ProSupplierExample.Criteria criteria = example.createCriteria();
        assemblyParams(proSupplierDto, criteria);
		//example.setOrderByClause("create_time DESC");
        if(null != query){
        	example.setOrderByClause("create_time DESC limit "+query.getStartNum() +"," + query.getPageSize());
		}
		List<ProSupplier> list = mapper.selectByExample(example);
		List<ProSupplierDto> eduAreaDtoList = BeanUtils.createBeanListByTarget(list, ProSupplierDto.class);
		return eduAreaDtoList;
	}

	private void assemblyParams(ProSupplierDto proSupplierDto, Criteria criteria) {
		if (null != proSupplierDto) {
        	if (StringUtils.isNotEmpty(proSupplierDto.getId())){
        		criteria.andIdEqualTo(proSupplierDto.getId().trim());
        	}		
        	if (StringUtils.isNotBlank(proSupplierDto.getSupplierName())){
        		criteria.andSupplierNameLike("%"+proSupplierDto.getSupplierName().trim()+"%");
        	}	
		}
		criteria.andStatEqualTo(DataStatus.ENABLED);
	}

	/**
	* @Title: selectSupplierAccount
	* @Description: 查询总条数
	* @author Ken Yin  
	* @date 2016年5月12日 下午3:02:50
	* @return int    返回类型
	 */
	public int selectSupplierAccount(ProSupplierDto proSupplierDto) {
		ProSupplierExample example = new ProSupplierExample();
		ProSupplierExample.Criteria criteria = example.createCriteria();
        assemblyParams(proSupplierDto, criteria);   //组装参数
        return mapper.countByExample(example);
	}
	
}

