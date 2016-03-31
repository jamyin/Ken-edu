package com.ssic.education.common.dao;

import java.util.List;







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.common.dto.PageHelperDto;
import com.ssic.education.common.dto.SchoolSupplierDto;
import com.ssic.education.common.mapper.SchoolSupplierExMapper;
import com.ssic.education.common.mapper.SchoolSupplierMapper;
import com.ssic.education.common.pojo.SchoolSupplier;
import com.ssic.education.common.pojo.SchoolSupplierExample;
import com.ssic.education.common.pojo.SchoolSupplierExample.Criteria;
import com.ssic.util.StringUtils;
import com.ssic.util.constants.DataStatus;

@Repository
public class SchoolSupplierDao {

	@Autowired
	private SchoolSupplierMapper schoolSupplierMapper;
	@Autowired
    private SchoolSupplierExMapper schoolSupplierExMapper ;
	
	
	//学校加工商统一查询
	public  List<SchoolSupplier>  findBy(SchoolSupplier param){
	    SchoolSupplierExample example = new SchoolSupplierExample();
		 Criteria criteria = example.createCriteria();
		 if(!StringUtils.isEmpty(param.getId())){
			 criteria.andIdEqualTo(param.getId());
		 }
		 if(!StringUtils.isEmpty(param.getProjId())){
			 criteria.andProjIdEqualTo(param.getProjId());
		 }
		 if(!StringUtils.isEmpty(param.getSupplierName())){
			 criteria.andSupplierNameEqualTo(param.getSupplierName());
		 }
		 criteria.andStatEqualTo(DataStatus.ENABLED);
		 example.setOrderByClause("  id desc  ");
		 return schoolSupplierMapper.selectByExample(example);
	}
	
	//分页查询
	public List<SchoolSupplier> findByPage(SchoolSupplier param,PageHelperDto phdto){
		SchoolSupplierExample example = new SchoolSupplierExample();
		 Criteria criteria = example.createCriteria();
		 if(!StringUtils.isEmpty(param.getId())){
			 criteria.andIdEqualTo(param.getId());
		 }
		 if(!StringUtils.isEmpty(param.getProjId())){
			 criteria.andProjIdEqualTo(param.getProjId());
		 }
		 if(!StringUtils.isEmpty(param.getSupplierName())){
			 criteria.andSupplierNameEqualTo(param.getSupplierName());
		 }
		 criteria.andStatEqualTo(DataStatus.ENABLED);
		 example.setOrderByClause("  id desc  limit "+phdto.getBeginRow()+","+phdto.getRows());
		 return schoolSupplierMapper.selectByExample(example);
	}
	
	//分页查询返回条数
	public int findCountByPage(SchoolSupplier param,PageHelperDto phdto){
		SchoolSupplierExample example = new SchoolSupplierExample();
		 Criteria criteria = example.createCriteria();
		 if(!StringUtils.isEmpty(param.getId())){
			 criteria.andIdEqualTo(param.getId());
		 }
		 if(!StringUtils.isEmpty(param.getProjId())){
			 criteria.andProjIdEqualTo(param.getProjId());
		 }
		 if(!StringUtils.isEmpty(param.getSupplierName())){
			 criteria.andSupplierNameEqualTo(param.getSupplierName());
		 }
		 criteria.andStatEqualTo(DataStatus.ENABLED);
		 example.setOrderByClause("  id desc  limit "+phdto.getBeginRow()+","+phdto.getRows());
		return schoolSupplierMapper.countByExample(example);
	}
	
	//学校加工商统一插入
	public int insertSchoolSupplier(SchoolSupplier param){
		param.setStat(DataStatus.ENABLED);
		return  schoolSupplierMapper.insert(param);
	}
	
	//学校加工商同意更新
	public int updateSchoolSupplier(SchoolSupplier param){
		return schoolSupplierMapper.updateByPrimaryKeySelective(param);
	}
	
	//学校加工商同意删除
	public int deleteSchoolSupplier(SchoolSupplier param){
		param.setStat(DataStatus.DISABLED);
		return schoolSupplierMapper.updateByPrimaryKeySelective(param);
	}
	
	//级联项目表查询,当phdto.beginRow!=0 and phdto.rows!=0 开始分页
	public List<SchoolSupplierDto> findExByPage(SchoolSupplierDto schoolSupplier,PageHelperDto phdto){
		return schoolSupplierExMapper.findExByPage(schoolSupplier, phdto);
	}
	//级联项目表查询条数,当phdto.beginRow!=0 and phdto.rows!=0 开始分页
	public Integer findExCountByPage(SchoolSupplierDto schoolSupplier,PageHelperDto phdto){
		return schoolSupplierExMapper.findExCountByPage(schoolSupplier, phdto);
	}
	
	//删除加工商学校关系
	public void deleteSchoolSupplierRel(String supplierId){
		schoolSupplierExMapper.deleteSchoolSupplierRel(supplierId);
	}
	
}
