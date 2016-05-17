package com.ssic.education.government.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.government.dto.TImsMenuDto;
import com.ssic.education.government.pojo.EduMenu;

public interface TImsMenuExMapper {

	TImsMenuDto findBy(@Param("menuId") String menuId);

	EduMenu findById(@Param("menuId") String menuId);

	List<EduMenu> findChildMenuById(@Param("menuId") String id);

	void updateDeleteStat(@Param("menuId") String id);

	void insertBy(@Param("menu") EduMenu menu);

	void updateMenu(@Param("menu") EduMenu menu);

	
	List<EduMenu> findByUserId(@Param("userId") String userId);

	List<EduMenu> findByUserIdAndTabId(@Param("userId") String userId, @Param("tabId") String tabId);



}
