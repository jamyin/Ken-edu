package com.ssic.education.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.admin.dto.TImsMenuDto;
import com.ssic.education.admin.pojo.Menu;

public interface TImsMenuExMapper {

	TImsMenuDto findBy(@Param("menuId") String menuId);

	Menu findById(@Param("menuId") String menuId);

	List<Menu> findChildMenuById(@Param("menuId") String id);

	void updateDeleteStat(@Param("menuId") String id);

	void insertBy(@Param("menu") Menu menu);

	void updateMenu(@Param("menu") Menu menu);

	
	List<Menu> findByUserId(@Param("userId") String userId);

	List<Menu> findByUserIdAndTabId(@Param("userId") String userId, @Param("tabId") String tabId);



}
