package com.ssic.education.handle.dao;

import java.util.List;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.educateion.common.dto.EduInformationDto;
import com.ssic.education.handle.mapper.EduInformationMapper;
import com.ssic.education.handle.pojo.EduInformation;
import com.ssic.education.handle.pojo.EduInformationExample;
import com.ssic.education.handle.pojo.EduInformationExample.Criteria;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.PageQuery;
import com.ssic.education.utils.mybatis.MyBatisBaseDao;
import com.ssic.education.utils.util.StringUtils;

/**
* @ClassName: InformationDao
* @Description: TODO(这里用一句话描述这个类的作用)
* @author Ken Yin
* @date 2016年5月13日 上午9:24:21
*
 */
@Repository
public class InformationDao extends MyBatisBaseDao<EduInformation> {

	@Getter
	@Autowired
	private EduInformationMapper mapper;
	
	/**
	* @Title: findInformationList
	* @Description: 查询学校列表-分页
	* @author Ken Yin  
	* @date 2016年5月13日 上午9:25:55
	* @return List<EduInformation>    返回类型
	 */
	public List<EduInformation> findInformationList(EduInformationDto eduInformationDto,PageQuery query) {
		EduInformationExample example = new EduInformationExample();
		EduInformationExample.Criteria criteria = example.createCriteria();
        assemblyParams(eduInformationDto, criteria);
        if(query != null && query.getPageSize() > 0){
        	example.setOrderByClause("create_time DESC limit "+query.getStartNum() +"," + query.getPageSize());
		}
		List<EduInformation> list = mapper.selectByExample(example);
		return list;
	}

	private void assemblyParams(EduInformationDto eduInformationDto, Criteria criteria) {
        	if (StringUtils.isNotEmpty(eduInformationDto.getId())){
        		criteria.andIdEqualTo(eduInformationDto.getId().trim());
        	}
        	if (eduInformationDto.getType() != null){
        		criteria.andTypeEqualTo(eduInformationDto.getType());   //(1:公告 2:卫生检查 3:健康宣教 )
        	}
        	if (StringUtils.isNotBlank(eduInformationDto.getTitle())){
        		criteria.andTitleLike("%"+eduInformationDto.getTitle().trim()+"%");
        	}	
		criteria.andStatEqualTo(DataStatus.ENABLED);
	}

	/**
	* @Title: selectInformationAccount
	* @Description: 分页总条数
	* @author Ken Yin  
	* @date 2016年5月13日 上午9:27:48
	* @return int    返回类型
	 */
	public int selectInformationAccount(EduInformationDto eduInformationDto) {
		EduInformationExample example = new EduInformationExample();
		EduInformationExample.Criteria criteria = example.createCriteria();
        assemblyParams(eduInformationDto, criteria);  
        return mapper.countByExample(example);
	}

	public EduInformation findInformationDetial(String id) {
		return mapper.selectByPrimaryKey(id);
	}

}

