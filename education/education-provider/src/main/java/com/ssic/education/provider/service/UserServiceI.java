package com.ssic.education.provider.service;

import java.util.List;

import com.ssic.education.provider.dto.ProUsersDto;
import com.ssic.education.provider.dto.TImsUsersDto;
import com.ssic.education.provider.model.Tuser;
import com.ssic.education.provider.pageModel.DataGrid;
import com.ssic.education.provider.pageModel.PageHelper;
import com.ssic.education.provider.pageModel.SessionInfo;
import com.ssic.education.provider.pageModel.Tree;
import com.ssic.education.provider.pageModel.User;


/**
 * 用户Service
 * 
 * @author 刘博
 * 
 */
public interface UserServiceI {

	List<TImsUsersDto> findAllDriver(String sourceId);

	/**
	 * 用户登录
	 * 
	 * @param user
	 *            里面包含登录名和密码
	 * @return 用户对象
	 */
	public TImsUsersDto login(TImsUsersDto usersDto);

	/**
	 * 用户注册
	 * 
	 * @param user
	 *            里面包含登录名和密码
	 * @throws Exception
	 */
	public void reg(TImsUsersDto usersDto) throws Exception;

	/**
	 * 获取用户数据表格
	 * 
	 * @param user
	 * @return
	 */
	public DataGrid dataGrid(TImsUsersDto user, PageHelper ph);

	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	public void add(TImsUsersDto user) throws Exception;
	
	//添加t_ims_users
	public void addImsUsers(TImsUsersDto user);

	/**
	 * 获得用户对象
	 * 
	 * @param id
	 * @return
	 */
	public User get(String id);

	/**
	 * 编辑用户
	 * 
	 * @param user
	 */
	public void edit(TImsUsersDto user) throws Exception;

	/**
	 * 删除用户
	 * 
	 * @param id
	 */
	public void delete(String id);


	/**
	 * 获得用户能访问的资源地址
	 * 
	 * @param id
	 *            用户ID
	 * @return
	 */
	public List<String> resourceList(String id);

	/**
	 * 编辑用户密码
	 * 
	 * @param user
	 */
	public void editPwd(TImsUsersDto user);

	/**
	 * 修改用户自己的密码
	 * 
	 * @param sessionInfo
	 * @param oldPwd
	 * @param pwd
	 * @return
	 */
	public boolean editCurrentUserPwd(SessionInfo sessionInfo, String oldPwd, String pwd);

	/**
	 * 用户登录时的autocomplete
	 * 
	 * @param q
	 *            参数
	 * @return
	 */
	public List<User> loginCombobox(String q);

	/**
	 * 用户登录时的combogrid
	 * 
	 * @param q
	 * @param ph
	 * @return
	 */
	public DataGrid loginCombogrid(String q, PageHelper ph);

	/**
	 * 用户创建时间图表
	 * 
	 * @return
	 */
	public List<Long> userCreateDatetimeChart();
	
	/**
	 * 获取当前用户
	 * 
	 * @return
	 */
	public Tuser getCurrentUser();

	public List<Tree> findUserTree(String userId);
	public int vailUserAccount(TImsUsersDto userDto);
	public TImsUsersDto getUser(String id);
	public String findUserRole(String userId);

	int findByNameCount(TImsUsersDto user);


	
	/**
	 * 根据session获取用户所属项目的信息<BR>	 
	 * @author 朱振	
	 * @date 2015年10月26日 下午5:34:11	
	 * @version 1.0
	 * @param session
	 * @return
	 * <p>修改人：朱振</p>
	 * <p>修改时间：2015年10月26日 下午5:34:11</p>
	 * <p>修改备注：</p>
	 */
//	public List<ProjectDto> getProjectBySession(HttpSession session);
	
	/**
	 * 
	 * getProjectsBySession:根据session获取用户所属项目id集合
	 * @param session
	 * @return
	 * @exception	
	 * @author zhuzhen
	 * @date 2015年11月25日 下午4:15:33
	 */
//	public String getProjectIdsBySession(HttpSession session);
}
