package com.ssic.education.provider.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssic.education.provider.dao.ImsRoleDao;
import com.ssic.education.provider.dao.ResourceDao;
import com.ssic.education.provider.dao.TImsMenuDao;
import com.ssic.education.provider.dao.TImsUsersRolesDao;
import com.ssic.education.provider.dao.UserDao;
import com.ssic.education.provider.dto.ProUsersDto;
import com.ssic.education.provider.dto.TImsMenuDto;
import com.ssic.education.provider.dto.TImsUsersDto;
import com.ssic.education.provider.model.Tuser;
import com.ssic.education.provider.pageModel.DataGrid;
import com.ssic.education.provider.pageModel.PageHelper;
import com.ssic.education.provider.pageModel.SessionInfo;
import com.ssic.education.provider.pageModel.Tree;
import com.ssic.education.provider.pageModel.User;
import com.ssic.education.provider.service.UserServiceI;
import com.ssic.education.provider.util.MD5Util;

@Service
public class UserServiceImpl implements UserServiceI {

	@Autowired
	private UserDao userDao;

	@Autowired
	private ImsRoleDao roleDao;

	@Autowired
	private ResourceDao resourceDao;

	@Autowired
	private TImsMenuDao tImsMenuDao;

	@Autowired
	private TImsUsersRolesDao userRoleDao;

	private static Logger log = Logger.getLogger(UserServiceImpl.class);
	
	
	public List<TImsUsersDto> findAllDriver(String sourceId) {
		return userDao.findAllDriver(sourceId);
	}

	public TImsUsersDto login(TImsUsersDto user) {
		user.setPassword(MD5Util.md5(user.getPassword()));
		TImsUsersDto result = userDao.login(user);
		return result;
	}

	synchronized public void reg(TImsUsersDto user) throws Exception {
	

		userDao.insertBy(user);

	}

	public DataGrid dataGrid(TImsUsersDto user, PageHelper ph) {
		
		return userDao.findAll(user, ph);
	}

	private String whereHql(User user, Map<String, Object> params) {
		String hql = "";
		if (user != null) {
			hql += " where 1=1 ";
			if (user.getName() != null) {
				hql += " and t.name like :name";
				params.put("name", "%%" + user.getName() + "%%");
			}
			if (user.getCreatedatetimeStart() != null) {
				hql += " and t.createdatetime >= :createdatetimeStart";
				params.put("createdatetimeStart", user.getCreatedatetimeStart());
			}
			if (user.getCreatedatetimeEnd() != null) {
				hql += " and t.createdatetime <= :createdatetimeEnd";
				params.put("createdatetimeEnd", user.getCreatedatetimeEnd());
			}
			if (user.getModifydatetimeStart() != null) {
				hql += " and t.modifydatetime >= :modifydatetimeStart";
				params.put("modifydatetimeStart", user.getModifydatetimeStart());
			}
			if (user.getModifydatetimeEnd() != null) {
				hql += " and t.modifydatetime <= :modifydatetimeEnd";
				params.put("modifydatetimeEnd", user.getModifydatetimeEnd());
			}
		}
		hql += " and t.isDelete=0";
		return hql;
	}

	private String orderHql(PageHelper ph) {
		String orderString = "";
		if (ph.getSort() != null && ph.getOrder() != null) {
			orderString = " order by t." + ph.getSort() + " " + ph.getOrder();
		}
		return orderString;
	}

	synchronized public void add(TImsUsersDto user) throws Exception {
		userDao.insertBy(user);
	}


	synchronized public void edit(TImsUsersDto user) throws Exception {
		userDao.updateBy(user);
	
	}

	public void delete(String id) {
		if (id != null) {
			userDao.deleteBy(id);
		}

	}

	
	public List<String> resourceList(String id) {


		List<String> resourceList = new ArrayList<String>();
		List<String> tempList = userRoleDao.findBy(id);
		if (tempList != null && tempList.size() > 0) {
			List<TImsMenuDto> list = tImsMenuDao.getTree(id);
			if (list != null && list.size() > 0) {
				for (TImsMenuDto tImsMenuDto : list) {
					resourceList.add(tImsMenuDto.getUrl());
				}
			}
		}

		return resourceList;
	}

	public void editPwd(TImsUsersDto user) {
		if (user != null && user.getPassword() != null
				&& !user.getPassword().trim().equalsIgnoreCase("")) {
			//
			// Tuser u = userDao.get(Tuser.class, user.getId());
			// u.setPwd(MD5Util.md5(user.getPwd()));
			// u.setModifydatetime(new Date());
			user.setPassword(MD5Util.md5(user.getPassword()));
		
			userDao.updatePwd(user);

		}
	}

	public boolean editCurrentUserPwd(SessionInfo sessionInfo, String oldPwd,
			String pwd) {
		TImsUsersDto userDto = new TImsUsersDto();
		userDto.setId(sessionInfo.getId());
		TImsUsersDto resultUser = userDao.login(userDto);
		if (resultUser == null) {
			return false;
		}

		if (resultUser.getPassword().equalsIgnoreCase(MD5Util.md5(oldPwd))) {// 说明原密码输入正确
			resultUser.setPassword(MD5Util.md5(pwd));
		
			userDao.updatePwd(resultUser);
			return true;
		}
		return false;
	}

	

	public int vailUserAccount(TImsUsersDto userDto) {
		return userDao.findCountByAccount(userDto);
	}

	public TImsUsersDto getUser(String id) {
		TImsUsersDto temp = new TImsUsersDto();
		temp.setId(id);
		return userDao.login(temp);
	}

	public String findUserRole(String userId) {
		List<String> list = userRoleDao.findBy(userId);
		if (list != null && list.size() > 0) {
			String result = "";
			for (int i = 0; i < list.size(); i++) {
				if (i == list.size() - 1) {
					result += list.get(i);
				} else {
					result += list.get(i) + ",";
				}
			}
			return result;
		}
		return null;
	}


	public void addImsUsers(TImsUsersDto user) {

		userDao.addImsUsers(user);

	}

	public User get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> loginCombobox(String q) {
		// TODO Auto-generated method stub
		return null;
	}

	public DataGrid loginCombogrid(String q, PageHelper ph) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Long> userCreateDatetimeChart() {
		// TODO Auto-generated method stub
		return null;
	}

	public Tuser getCurrentUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Tree> findUserTree(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findByNameCount(TImsUsersDto user) {
		// TODO Auto-generated method stub
		return userDao.findByNameCount(user);
	}

	
	


}
