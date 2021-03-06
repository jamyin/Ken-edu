package com.ssic.education.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.educateion.common.dto.EduInformationDto;
import com.ssic.education.app.service.IInformationService;
import com.ssic.education.handle.dao.InformationDao;
import com.ssic.education.handle.pojo.EduInformation;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.model.PageResult;
import com.ssic.education.utils.util.BeanUtils;
import com.ssic.education.utils.util.PropertiesUtils;
import com.ssic.education.utils.util.StringUtils;

/**
 * @ClassName: InformationServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Ken Yin
 * @date 2016年5月20日 上午11:02:07
 *
 */
@Service
public class InformationServiceImpl implements IInformationService{

	@Autowired
	private InformationDao informationDao;

	@Override
	public PageResult<EduInformationDto> findInformationList(EduInformationDto eduInformationDto,
			PageQuery query) {
		List<EduInformation> list = informationDao.findInformationList(eduInformationDto, query);
		if(list == null || list.size() <= 0){
			return null;
		}
		List<EduInformationDto> informationDtoList = BeanUtils.createBeanListByTarget(list, EduInformationDto.class);
		String realPath = PropertiesUtils.getProperty("upload.look.url"); 
		//String realPath = "127.0.0.1:8091";                    //拼接图片显示路径
		for (EduInformationDto dto : informationDtoList) {
			if(StringUtils.isNotEmpty(dto.getPic())){
				String pics[] = dto.getPic().split(";");      //pics用于存放多张图片的路径
				if(pics.length >0){
					for(int i =0 ;i <pics.length ;i++){
						pics[i] = realPath + pics[i];
					}
					dto.setPics(pics);                       
				}
				dto.setPic(realPath +dto.getPic()) ;
			}
		}
		int total = informationDao.selectInformationAccount(eduInformationDto);
		query.setTotal(total);
		return new PageResult<EduInformationDto>(query, informationDtoList);
	}

	@Override
	public EduInformationDto findInformationDetial(String id) {
		EduInformation eduInformation = informationDao.findInformationDetial(id);
		if(eduInformation ==null){
			return null;
		}
		EduInformationDto dto = BeanUtils.createBeanByTarget(eduInformation, EduInformationDto.class);
		String realPath = PropertiesUtils.getProperty("upload.look.url"); 
		if(StringUtils.isNotEmpty(dto.getPic())){
			dto.setPic(realPath +dto.getPic()) ;
		}
		return dto;
	}


}

