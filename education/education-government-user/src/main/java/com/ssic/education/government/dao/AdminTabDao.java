package com.ssic.education.government.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.ssic.education.government.dto.AdminTabDto;
import com.ssic.education.government.mapper.EduTabMapper;
import com.ssic.education.government.pojo.EduTab;
import com.ssic.education.government.pojo.EduTabExample;
import com.ssic.education.government.pojo.EduTabExample.Criteria;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.util.BeanUtils;

@Repository
public class AdminTabDao {
	@Autowired
	private EduTabMapper adminMapper;

	/**
	 * 
	 * countAdminBy：统计数量
	 * 
	 * @return
	 * @exception
	 * @author 刘博
	 * @date 2015年10月21日 上午10:50:40
	 */
	public int countAdminBy() {
		EduTabExample example = new EduTabExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatEqualTo(DataStatus.ENABLED);
		return adminMapper.countByExample(example);
	}

	/**
	 * 
	 * insertAdminInfo：添加tab页面信息
	 * 
	 * @param EduTab
	 * @return
	 * @exception
	 * @author 刘博
	 * @date 2015年10月21日 上午10:55:34
	 */
	public int insertAdminInfo(EduTab EduTab) {
		if (EduTab != null) {
			return adminMapper.insert(EduTab);
		}
		return 0;
	}

	/**
	 * 
	 * updateAdminTabInfo：修改信息
	 * 
	 * @param EduTab
	 * @return
	 * @exception
	 * @author 刘博
	 * @date 2015年10月21日 上午10:59:18
	 */
	public int updateAdminTabInfo(EduTab EduTab) {
		if (EduTab != null) {
			return adminMapper.updateByPrimaryKey(EduTab);
		}
		return 0;
	}

	/**
	 * 
	 * deleteAdminTabInfo：删除信息
	 * 
	 * @param EduTab
	 * @return
	 * @exception
	 * @author 刘博
	 * @date 2015年10月21日 上午11:02:45
	 */
	public int deleteAdminTabInfo(EduTab eduTab) {
		if (eduTab != null) {
			return adminMapper.updateByPrimaryKey(eduTab);
		}
		return 0;

	}

	/**
	 * findAll：查找所有
	 * 
	 * @return
	 * @exception
	 * @author 刘博
	 * @date 2016年3月1日 上午09:58:45
	 */
	public List<AdminTabDto> findAll() {
		List<AdminTabDto> result = new ArrayList<AdminTabDto>();
		EduTabExample example = new EduTabExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatEqualTo(DataStatus.ENABLED);
		example.setOrderByClause("create_time desc");

		criteria.andStatEqualTo(DataStatus.ENABLED);
		List<EduTab> list = adminMapper.selectByExample(example);
		if (!CollectionUtils.isEmpty(list)) {
			result = BeanUtils.createBeanListByTarget(list, AdminTabDto.class);
		}
		return result;
	}

	/**
	 * findById：查找tab对象;
	 * 
	 * @return
	 * @exception
	 * @author 刘博
	 * @date 2016年3月1日 上午09:58:45
	 */
	public AdminTabDto findById(String id) {
		AdminTabDto dto = new AdminTabDto();
		EduTab tab = adminMapper.selectByPrimaryKey(id);
		if (tab != null) {
			BeanUtils.copyProperties(tab, dto);
		}
		return dto;
	}

	public AdminTabDto findByTabName(String tabName) {
		AdminTabDto dto = new AdminTabDto();
		EduTabExample example = new EduTabExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatEqualTo(DataStatus.ENABLED);
		if (!StringUtils.isEmpty(tabName)) {
			criteria.andTabNameEqualTo(tabName);
		}
		List<EduTab> list = adminMapper.selectByExample(example);
		if (!CollectionUtils.isEmpty(list)) {
			BeanUtils.copyProperties(list.get(0), dto);
		}
		return dto;
	}
}
