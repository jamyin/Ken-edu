package com.ssic.education.common.dao;

import java.util.List;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.common.dto.ProSupplierDto;
import com.ssic.education.common.mapper.ProSupplierExMapper;
import com.ssic.education.common.mapper.ProSupplierMapper;
import com.ssic.education.common.pojo.ProSupplier;
import com.ssic.education.common.pojo.ProSupplierExample;
import com.ssic.education.common.pojo.ProSupplierExample.Criteria;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import com.ssic.education.utils.util.StringUtils;


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

	@Getter
	@Autowired
	private ProSupplierExMapper mappers;
    
	/**
	* @Title: findSupplierList
	* @Description: 分页查询供应商
	* @author Ken Yin  
	* @date 2016年5月12日 下午3:03:39
	* @return List<ProSupplierDto>    返回类型
	 */
	public List<ProSupplier> findSupplierList(ProSupplierDto proSupplierDto,PageQuery query) {
		ProSupplierExample example = new ProSupplierExample();
		ProSupplierExample.Criteria criteria = example.createCriteria();
        assemblyParams(proSupplierDto, criteria);
		//example.setOrderByClause("create_time DESC");
        if(null != query){
        	example.setOrderByClause("create_time DESC limit "+query.getStartNum() +"," + query.getPageSize());
		}
		List<ProSupplier> list = mapper.selectByExample(example);
		return list;
	}

	private void assemblyParams(ProSupplierDto proSupplierDto, Criteria criteria) {
		if (null != proSupplierDto) {
        	if (StringUtils.isNotEmpty(proSupplierDto.getId())){
        		criteria.andIdEqualTo(proSupplierDto.getId().trim());
        	}
        	if (StringUtils.isNotEmpty(proSupplierDto.getArea())){
        		criteria.andAreaEqualTo(proSupplierDto.getArea().trim());
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

	/**
	* @Title: findSupplierDetail
	* @Description: 根据Id查询供应商详细信息
	* @author Ken Yin  
	* @date 2016年5月12日 下午5:23:02
	* @return ProSupplierDto    返回类型
	 */
	public ProSupplierDto findSupplierDetail(String id) {
		return mappers.findSupplierDetail(id);
	}
	
}

