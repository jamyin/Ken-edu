package com.ssic.education.government.controller.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ssic.education.government.controller.admin.service.ResourceTypeServiceI;
import com.ssic.education.government.dao.ResourceTypeDao;
import com.ssic.education.government.dao.TImsMenuTypeDao;
import com.ssic.education.government.dto.TImsMenuTypeDto;
import com.ssic.education.government.pageModel.ResourceType;


@Service
public class ResourceTypeServiceImpl implements ResourceTypeServiceI {

	@Autowired
	private ResourceTypeDao resourceType;

	@Autowired
	private TImsMenuTypeDao menuTypeDao;

	
	public List<ResourceType> getResourceTypeList() {
//		List<Tresourcetype> l = resourceType.find("from Tresourcetype t");
//		List<ResourceType> rl = new ArrayList<ResourceType>();
//		if (l != null && l.size() > 0) {
//			for (Tresourcetype t : l) {
//				ResourceType rt = new ResourceType();
//				BeanUtils.copyProperties(t, rt);
//				rl.add(rt);
//			}
//		}
//		return rl;
		return null;
	}

	
	//@Cacheable(value = "menuTypeServiceCache", key = "'menuTypeList'")
    @Cacheable(value = "default", key = "'game.admin.dto.TImsMenuTypeDto'")
	public List<TImsMenuTypeDto> getMenuTypeList() {
		 List<TImsMenuTypeDto> rl = menuTypeDao.finAll();
	     return rl;
  }
	
}
