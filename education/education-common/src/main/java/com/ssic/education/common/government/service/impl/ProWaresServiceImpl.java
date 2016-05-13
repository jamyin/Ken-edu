package com.ssic.education.common.government.service.impl;

import com.ssic.education.common.dao.ProWaresDao;
import com.ssic.education.government.dto.ProWaresDto;
import com.ssic.education.common.government.service.ProWaresService;
import com.ssic.education.common.pojo.ProWares;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProWaresServiceImpl implements ProWaresService {

    @Autowired
    private ProWaresDao proWaresDao;

    public ProWaresDto findById(String id) {
        ProWares proWares = proWaresDao.selectByPrimaryKey(id);
        if (null != proWares) {
            return BeanUtils.createBeanByTarget(proWares, ProWaresDto.class);
        }
        return null;
    }

    @Override
    public List<ProWaresDto> queryWaresByParams(ProWaresDto params) {
        List<ProWares> proWares = proWaresDao.queryWaresByParams(params, null);
        if (null != proWares && proWares.size() > 0) {
            return BeanUtils.createBeanListByTarget(proWares, ProWaresDto.class);
        }
        return null;
    }

    @Override
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

}