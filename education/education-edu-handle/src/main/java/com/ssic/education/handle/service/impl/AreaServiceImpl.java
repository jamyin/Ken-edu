package com.ssic.education.handle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.EduAreaDto;
import com.ssic.education.handle.dao.AreaDao;
import com.ssic.education.handle.pojo.EduArea;
import com.ssic.education.handle.service.AreaService;
import com.ssic.education.utils.util.BeanUtils;

/**
 * <p>Description: 类描述:区域接口 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 *
 * @author wangxiang
 * @version 1.0
 * @date 2016/5/13 13:04
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    
    public List<EduAreaDto> queryAll() {
        List<EduArea> areaList = areaDao.findAreaList();
        if (null != areaList && areaList.size() > 0){
            return BeanUtils.createBeanListByTarget(areaList, EduAreaDto.class);
        }

        return null;
    }
}
