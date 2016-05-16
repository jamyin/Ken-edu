package com.ssic.education.government.service;

import com.ssic.education.government.dto.EduUsersDto;


/**
 * 
	 * 此类描述的是：学校账号表 接口
	 * @author: cwftalus@163.com
	 * @version: 2016年5月12日 下午2:12:34
 */
public interface EduUsersService {
	
	public EduUsersDto checkUser(EduUsersDto usersDto);
	
	/**
	 * 
		 * 此方法描述的是：账号不能重复
		 * @author: cwftalus@163.com
		 * @version: 2016年5月16日 下午3:06:20
	 */
	public boolean validateAccount(EduUsersDto usersDto);

	public void save(EduUsersDto usersDto);
	
}
