package com.ssic.education.handle.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.ProWaresDto;
import com.ssic.education.handle.dao.ProWaresDao;
import com.ssic.education.handle.dto.ProSchoolWareDto;
import com.ssic.education.handle.pojo.ProWares;
import com.ssic.education.handle.service.ProWaresService;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.util.BeanUtils;

@Service
public class ProWaresServiceImpl implements ProWaresService {

    @Autowired
    private ProWaresDao proWaresDao;
    
    public ProWaresDto findById(String id) {
    	if (StringUtils.isNotBlank(id)) {
    		ProWares proWares = proWaresDao.selectByPrimaryKey(id);
            if (null != proWares) {
                return BeanUtils.createBeanByTarget(proWares, ProWaresDto.class);
            }
    	}
        
        return null;
    }

 
    public List<ProWaresDto> queryWaresByParams(ProWaresDto params) {
        List<ProWares> proWares = proWaresDao.queryWaresByParams(params, null);
        if (null != proWares && proWares.size() > 0) {
            return BeanUtils.createBeanListByTarget(proWares, ProWaresDto.class);
        }
        return null;
    }

   
    public PageResult<ProWaresDto> queryWaresByParams(ProWaresDto params, PageQuery query) {
        int total = proWaresDao.countWaresByParams(params);
        if (total > 0) {
            query.setTotal(total);
            List<ProWares> proWares = proWaresDao.queryWaresByParams(params, query);
            if (null != proWares && proWares.size() > 0) {
                List<ProWaresDto> result  = BeanUtils.createBeanListByTarget(proWares, ProWaresDto.class);
                return new PageResult<ProWaresDto>(query, result);
            }
        }
        return null;
    }

    public PageResult<ProWaresDto> findWarsePageByParam(ProSchoolWareDto proSchoolWareDto,PageQuery query) {
    	List<ProWaresDto> results = proWaresDao.findWarseListByParam(proSchoolWareDto, query);
    	query.setTotal(proWaresDao.countWarseListByParam(proSchoolWareDto));
    	return new PageResult<ProWaresDto>(query, results);
    }

	@Override
	public List<ProWaresDto> searchProWares(String schoolId,String waresName) {
		// TODO Auto-generated method stub
		return proWaresDao.searchProWares(schoolId,waresName);
	}

}
