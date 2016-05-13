package com.ssic.education.common.government.service.impl;

import com.ssic.education.common.dao.AreaDao;
import com.ssic.education.common.dto.EduAreaDto;
import com.ssic.education.common.government.service.AreaService;
import com.ssic.education.common.pojo.EduArea;
import com.ssic.education.utils.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<EduAreaDto> queryAll() {
        List<EduArea> areaList = areaDao.findAreaList();
        if (null != areaList && areaList.size() > 0){
            return BeanUtils.createBeanListByTarget(areaList, EduAreaDto.class);
        }

        return null;
    }
}
