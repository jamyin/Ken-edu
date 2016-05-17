package com.ssic.education.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.common.pojo.EduSchool;
import com.ssic.util.model.PageQuery;


public interface EduSchoolExMapper {

	List<EduSchool> findSchoolDetialList(@Param("id") String id,@Param("query")  PageQuery query);

	int findSchoolDetialListAccount(@Param("id") String id);


}
