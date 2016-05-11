package com.ssic.education.provider.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.provider.dto.RoleMenuDto;
import com.ssic.education.provider.dto.TImsMenuDto;
import com.ssic.education.provider.dto.TImsRoleDto;
import com.ssic.education.provider.dto.TImsRoleMenuDto;
import com.ssic.education.provider.dto.TImsUsersRoleDto;
import com.ssic.education.provider.pojo.MenuAndRoles;
import com.ssic.education.provider.pojo.ProRole;


public interface TImsRoleExMapper {
	
	List<ProRole> findBy(@Param("role")TImsRoleDto role);
	
	List<MenuAndRoles> findGreedTree(@Param("role")TImsRoleDto role);
	
	ProRole findById(@Param("roleId")String roleId);
	
	ProRole findByPid(@Param("pid")String pid);
	
	void inUserRole(@Param("userRole")TImsUsersRoleDto tImsUsersRoleDto);
	
	void insertRole(@Param("role")TImsRoleDto role);
	
	void updateRole(@Param("role")TImsRoleDto role);
	
	List<ProRole> findByUserId(@Param("user_id")String  user_id);
	
	void updateUserRole(@Param("userRole")TImsUsersRoleDto tImsUsersRoleDto);
	
	void updateRoleStat(@Param("role")TImsRoleDto role);
	
	List<RoleMenuDto> findRoleMenu(@Param("role")TImsRoleDto role);
	
	void updateRoleMenu(@Param("roleMenu")TImsRoleMenuDto roleMenu);
	
	void insertRoleMenu(@Param("roleMenu")TImsRoleMenuDto roleMenu);
	
	List<TImsMenuDto> finSubMenus(@Param("pid")String pid );

}
