package com.ssic.education.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.handle.mapper.ProSchoolWareMapper;
import com.ssic.education.handle.pojo.ProSchoolWare;
import com.ssic.education.handle.pojo.ProSchoolWareExample;
import com.ssic.education.utils.constants.DataStatus;

import lombok.Getter;

/**
 * 		
 * <p>Title: AppSchoolWaresDao </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月29日 下午4:22:11	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月29日 下午4:22:11</p>
 * <p>修改备注：</p>
 */
@Repository
public class AppSchoolWaresDao {

	@Autowired
	@Getter
	private ProSchoolWareMapper mapper;

	/**
	 * findSchoolWaresBySchoolId：根据SchoolId查询出WaresId列表
	 * @param schoolId
	 * @return List<String>
	 * @author SeanYoung
	 * @date 2016年5月29日 下午4:21:26
	 */
	public List<String> findSchoolWaresBySchoolId(String schoolId) {
		ProSchoolWareExample example = new ProSchoolWareExample();
		ProSchoolWareExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(schoolId)) {
			criteria.andSchoolIdEqualTo(schoolId);
		}
		criteria.andStatEqualTo(DataStatus.ENABLED);
		List<String> list = new ArrayList<String>();
		List<ProSchoolWare> schoolWareList = this.mapper.selectByExample(example);
		if (schoolWareList != null && !schoolWareList.isEmpty()) {
			for (ProSchoolWare psw : schoolWareList) {
				list.add(psw.getWareId());
			}
			return list;
		} else {
			return null;
		}
	}
}
