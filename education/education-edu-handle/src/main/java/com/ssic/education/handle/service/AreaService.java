package com.ssic.education.handle.service;

import java.util.List;

import com.ssic.educateion.common.dto.EduAreaDto;

/**
 * <p>Description: 类描述:TODO </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 *
 * @author wangxiang
 * @version 1.0
 * @date 2016/5/13 13:03
 */
public interface AreaService {

    /**
     * <p>Description: 查询所有上海所有区 </p>
     * <p>Company: 上海天坊信息科技有限公司</p>
     * @return List<EduAreaDto>
     * @author wangxiang
     * @date 2016/5/13 13:04
     * @version 1.0
     */
    List<EduAreaDto> queryAll();
}
