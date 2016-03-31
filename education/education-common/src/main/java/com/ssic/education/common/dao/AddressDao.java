/**
 * 
 */
package com.ssic.education.common.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssic.education.common.mapper.AddressMapper;
import com.ssic.education.common.pojo.Address;
import com.ssic.education.common.pojo.AddressExample;
import com.ssic.education.common.pojo.AddressExample.Criteria;
import com.ssic.util.base.MyBatisBaseDao;
import com.ssic.util.constants.DataStatus;

/**		
 * <p>Title: AddressDao </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author rkzhang	
 * @date 2016年3月16日 上午11:42:01	
 * @version 1.0
 * <p>修改人：rkzhang</p>
 * <p>修改时间：2016年3月16日 上午11:42:01</p>
 * <p>修改备注：</p>
 */
 @Repository
public class AddressDao extends MyBatisBaseDao<Address> {

    @Autowired
    private AddressMapper addressMapper;
     
    @Override
    public Object getMapper() {
	return addressMapper;
    }

    public List<Address> getAddressByParentCode(String parentCode){
	AddressExample example = new AddressExample();
	Criteria criteria = example.createCriteria();
	criteria.andParentCodeEqualTo(parentCode);
	criteria.andStatEqualTo(DataStatus.ENABLED);
	return addressMapper.selectByExample(example);
    }
}

