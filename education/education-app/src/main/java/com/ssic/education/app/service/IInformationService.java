package com.ssic.education.app.service;

import com.ssic.education.common.dto.EduInformationDto;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;

/**
 * @ClassName: IInformationService
 * @Description: App资讯接口(1:公告 2:卫生检查 3:健康宣教)  
 * @author Ken Yin
 * @date 2016年5月20日 上午10:42:48
 *
 */
public interface IInformationService {

	//查询所有资讯列表-带分页
	PageResult<EduInformationDto> findInformationList(EduInformationDto eduInformationDto,
			PageQuery query);
	//根据学校id查资讯信息
	EduInformationDto findInformationDetial(String id);


}

