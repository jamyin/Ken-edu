package com.ssic.education.government.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.government.dto.RoleMenuDto;
import com.ssic.education.government.dto.TImsMenuDto;
import com.ssic.education.government.dto.TImsRoleDto;
import com.ssic.education.government.dto.TImsRoleMenuDto;
import com.ssic.education.government.dto.TImsUsersRoleDto;
import com.ssic.education.government.pojo.EduRole;
import com.ssic.education.government.pojo.MenuAndRoles;

/*import com.ssic.education.provider.dto.RoleMenuDto;
import com.ssic.education.provider.dto.TImsMenuDto;
import com.ssic.education.provider.dto.TImsRoleDto;
import com.ssic.education.provider.dto.TImsRoleMenuDto;
import com.ssic.education.provider.dto.TImsUsersRoleDto;
import com.ssic.education.provider.pojo.MenuAndRoles;
import com.ssic.education.provider.pojo.ProRole;*/


public interface TImsRoleExMapper {
	
	List<EduRole> findBy(@Param("role")TImsRoleDto role);
	
	List<MenuAndRoles> findGreedTree(@Param("role")TImsRoleDto role);
	
	EduRole findById(@Param("roleId")String roleId);
	
	EduRole findByPid(@Param("pid")String pid);
	
	void inUserRole(@Param("userRole")TImsUsersRoleDto tImsUsersRoleDto);
	
	void insertRole(@Param("role")TImsRoleDto role);
	
	void updateRole(@Param("role")TImsRoleDto role);
	
	List<EduRole> findByUserId(@Param("user_id")String  user_id);
	
	void updateUserRole(@Param("userRole")TImsUsersRoleDto tImsUsersRoleDto);
	
	void updateRoleStat(@Param("role")TImsRoleDto role);
	
	List<RoleMenuDto> findRoleMenu(@Param("role")TImsRoleDto role);
	
	void updateRoleMenu(@Param("roleMenu")TImsRoleMenuDto roleMenu);
	
	void insertRoleMenu(@Param("roleMenu")TImsRoleMenuDto roleMenu);
	
	List<TImsMenuDto> finSubMenus(@Param("pid")String pid );

}
