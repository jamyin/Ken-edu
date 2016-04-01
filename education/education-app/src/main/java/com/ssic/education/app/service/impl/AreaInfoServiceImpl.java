/**
 * 
 */
package com.ssic.education.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Objects;
import com.ssic.education.app.dto.Coordinate;
import com.ssic.education.app.dto.District;
import com.ssic.education.app.service.IAreaInfoService;
import com.ssic.education.common.dao.AddressDao;
import com.ssic.education.common.pojo.Address;
import com.ssic.util.StringUtils;
import com.ssic.util.constants.DataStatus;
import com.ssic.util.model.Response;

/**		
 * <p>Title: AreaInfoServiceImpl </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author rkzhang	
 * @date 2016年3月15日 下午4:26:28	
 * @version 1.0
 * <p>修改人：rkzhang</p>
 * <p>修改时间：2016年3月15日 下午4:26:28</p>
 * <p>修改备注：</p>
 */
@Service
public class AreaInfoServiceImpl implements IAreaInfoService {
    
    @Autowired
    private AddressDao addressDao;

     /** 
     * (non-Javadoc)   
     * @see com.ssic.education.app.service.IAreaInfoService#getSubDistricetByParentCode(java.lang.String)   
     */
    @Override
    public Response<List<District>> getSubDistricetByParentCode(String parentDistrictCode) {
	Response<List<District>> response = new Response<>();
	List<District> districts = new ArrayList<>();
	response.setData(districts);
	
	if(StringUtils.isEmpty(parentDistrictCode)) {
	    response.setStatus(DataStatus.HTTP_FAILE);
	    response.setMessage("parent district code can not be null or empty");
	    return response;
	}
	
	List<Address> addresses = addressDao.getAddressByParentCode(parentDistrictCode);
	if(CollectionUtils.isEmpty(addresses)) { 
	    response.setStatus(DataStatus.HTTP_SUCCESS);
	    return response;
	}
	
	for(Address address : addresses) {
	    districts.add(changeToDistrict(address));
	}
	
	return null;
    }
    
    /** 
     * (non-Javadoc)   
     * @see com.ssic.education.app.service.IAreaInfoService#getSubDistricetSchoolStatistic(java.lang.String, java.lang.Integer)   
     */
    @Override
    public Response<List<District>> getSubDistricetSchoolStatistic(String parentDistrictCode, Integer schoolLevel) {


	return null;
    }


    
    /**     
     * changeToDistrict：change Address Object to District Object
     * 
     * @param address
     * @return
     * @exception	
     * @author rkzhang
     * @date 2016年3月31日 下午1:51:39	 
     */
    private District changeToDistrict(Address address) {
	if(Objects.equal(address, null)){
	    return null;
	}
	District distict = new District();
	distict.setDistrictCode(address.getAddressCode());
	distict.setDistrictName(address.getAddressName());
	distict.setCoordinate(new Coordinate(address.getLongitude(), address.getLatitude()));
	
	return null;
    }


    
}

