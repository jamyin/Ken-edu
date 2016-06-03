package com.ssic.education.handle.service;

import com.ssic.educateion.common.dto.EduUsersDto;
import com.ssic.educateion.common.dto.EduUsersRegDto;



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
	public boolean validateAccount(EduUsersRegDto usersDto);

	public EduUsersDto save(EduUsersRegDto usersDto);
	
	public EduUsersDto getUserInfo(EduUsersDto usersDto);
	
	public Integer update(EduUsersDto usersDto);
	
	public EduUsersRegDto edit(EduUsersRegDto usersDto);
	
}
