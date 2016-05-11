package com.ssic.education.provider.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.provider.dto.TImsMenuDto;
import com.ssic.education.provider.pojo.ProMenu;

public interface TImsMenuExMapper {

	TImsMenuDto findBy(@Param("menuId") String menuId);

	ProMenu findById(@Param("menuId") String menuId);

	List<ProMenu> findChildMenuById(@Param("menuId") String id);

	void updateDeleteStat(@Param("menuId") String id);

	void insertBy(@Param("menu") ProMenu menu);

	void updateMenu(@Param("menu") ProMenu menu);

	
	List<ProMenu> findByUserId(@Param("userId") String userId);

	List<ProMenu> findByUserIdAndTabId(@Param("userId") String userId, @Param("tabId") String tabId);



}
