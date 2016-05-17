package com.ssic.education.government.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.government.dto.MenuAndRoleDto;
import com.ssic.education.government.dto.RoleMenuDto;
import com.ssic.education.government.dto.TImsMenuDto;
import com.ssic.education.government.dto.TImsRoleDto;
import com.ssic.education.government.dto.TImsRoleMenuDto;
import com.ssic.education.government.dto.TImsUsersRoleDto;
import com.ssic.education.government.mapper.TImsRoleExMapper;
import com.ssic.education.government.pojo.EduRole;
import com.ssic.education.government.pojo.MenuAndRoles;

//import com.ssic.education.provider.dto.MenuAndRoleDto;
//import com.ssic.education.provider.dto.RoleMenuDto;
//import com.ssic.education.provider.dto.TImsMenuDto;
//import com.ssic.education.provider.dto.TImsRoleDto;
//import com.ssic.education.provider.dto.TImsRoleMenuDto;
//import com.ssic.education.provider.dto.TImsUsersRoleDto;
//import com.ssic.education.provider.mapper.TImsRoleExMapper;
//import com.ssic.education.provider.pojo.MenuAndRoles;
//import com.ssic.education.provider.pojo.ProRole;



@Repository
public class ImsRoleDao {
	@Autowired
	private TImsRoleExMapper tImsRoleExMapper;

	public List<TImsRoleDto> findBy(TImsRoleDto tImsRoleDto) {

		List<EduRole> eduRole = tImsRoleExMapper.findBy(tImsRoleDto);

		List<TImsRoleDto> list_role = new ArrayList<TImsRoleDto>();

		if (eduRole != null && eduRole.size() > 0) {
			for (int i = 0; i < eduRole.size(); i++) {
				EduRole r1 = eduRole.get(i);
				TImsRoleDto rodto = new TImsRoleDto();
				BeanUtils.copyProperties(r1, rodto);
				list_role.add(rodto);
			}
			return list_role;
		}

		return null;
	}
	
	public List<RoleMenuDto> findRoleMenu(TImsRoleDto tImsRoleDto){
		List<RoleMenuDto> ProRole = tImsRoleExMapper.findRoleMenu(tImsRoleDto);
			return ProRole;
	}

	public List<TImsRoleDto> findByUserId(String user_id){
		
		List<EduRole> ProRole = tImsRoleExMapper.findByUserId(user_id);
		
		List<TImsRoleDto> list_role = new ArrayList<TImsRoleDto>();

		if (ProRole != null && ProRole.size() > 0) {
			for (int i = 0; i < ProRole.size(); i++) {
				EduRole r1 = ProRole.get(i);
				TImsRoleDto rodto = new TImsRoleDto();
				BeanUtils.copyProperties(r1, rodto);
				list_role.add(rodto);
			}
			return list_role;
		}

		return null;
		
	}
	
	
	public List<MenuAndRoleDto> findGreedTree(TImsRoleDto tImsRoleDto){
		
	//	List<ProRole> ProRole = tImsRoleExMapper.findGreedTree(tImsRoleDto);

		List<MenuAndRoles> menuroles =	tImsRoleExMapper.findGreedTree(tImsRoleDto);
		
		List<MenuAndRoleDto> menurodto = new ArrayList<MenuAndRoleDto>();
		
		if(menuroles!=null&&menuroles.size()>0){
			for(int i=0;i<menuroles.size();i++){
				MenuAndRoles mrol = menuroles.get(i);
				MenuAndRoleDto mroldto = new MenuAndRoleDto();
				BeanUtils.copyProperties(mrol, mroldto);
				menurodto.add(mroldto);
			}
			return menurodto;
		}
		return null;
		
	}
	
	public List<TImsMenuDto> finSubMenus(String pid){
		List<TImsMenuDto> subMenus = tImsRoleExMapper.finSubMenus(pid);
		
		return subMenus;
	}
	
	public TImsRoleDto findById(String id){
		EduRole ProRole =  tImsRoleExMapper.findById(id);
		if(ProRole!=null){
			TImsRoleDto result =new TImsRoleDto();
			BeanUtils.copyProperties(ProRole, result);
			return result;
		}
		return null;
	}
	
	public TImsRoleDto findByPid(String pid){
		EduRole ProRole =  tImsRoleExMapper.findByPid(pid);
		if(ProRole!=null){
			TImsRoleDto result =new TImsRoleDto();
			BeanUtils.copyProperties(ProRole, result);
			return result;
		}
		return null;
		
	}
	
	
	public void inUserRole(TImsUsersRoleDto tImsUsersRoleDto){
		 tImsRoleExMapper.inUserRole(tImsUsersRoleDto);
	}
	
	public void insertRole(TImsRoleDto tImsRoleDto){
		tImsRoleExMapper.insertRole(tImsRoleDto);
	}
	
	public void updateRole(TImsRoleDto tImsRoleDto){
		tImsRoleExMapper.updateRole(tImsRoleDto);
	}
	public void updateUserRole(TImsUsersRoleDto tImsUsersRoleDto){
		tImsRoleExMapper.updateUserRole(tImsUsersRoleDto);
	}
	
	public void updateRoleStat(TImsRoleDto tImsRoleDto){
		tImsRoleExMapper.updateRoleStat(tImsRoleDto);
	}
	
	public void updateRoleMenu(TImsRoleMenuDto tImsRoleMenuDto){
		tImsRoleExMapper.updateRoleMenu(tImsRoleMenuDto);
	}
	
	public void insertRoleMenu(TImsRoleMenuDto tImsRoleMenuDto){
		tImsRoleExMapper.insertRoleMenu(tImsRoleMenuDto);
	}
	
	
}
