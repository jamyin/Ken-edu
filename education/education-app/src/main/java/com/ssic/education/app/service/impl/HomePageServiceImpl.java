/**
 * 
 */
package com.ssic.education.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Objects;
import com.ssic.education.app.constants.SchoolLevel;
import com.ssic.education.app.dto.Coordinate;
import com.ssic.education.app.dto.District;
import com.ssic.education.app.exception.AppException;
import com.ssic.education.app.service.IHomePageService;
import com.ssic.education.common.dao.AddressDao;
import com.ssic.education.common.dto.AddressStatistic;
import com.ssic.education.common.pojo.Address;
import com.ssic.util.StringUtils;
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
public class HomePageServiceImpl implements IHomePageService {
    
    @Autowired
    private AddressDao addressDao;

     /** 
     * (non-Javadoc)   
     * @see com.ssic.education.app.service.IHomePageService#getSubDistricetByParentCode(java.lang.String)   
     */
    @Override
    public Response<List<District>> getSubDistricetByParentCode(String parentDistrictCode) {
	Response<List<District>> response = new Response<>();
	List<District> districts = new ArrayList<>();
	response.setData(districts);
	
	if(StringUtils.isEmpty(parentDistrictCode)) {
	    throw new AppException(1, "parent district code can not be null or empty");
	}
	
	List<Address> addresses = addressDao.getAddressByParentCode(parentDistrictCode);
	if(CollectionUtils.isEmpty(addresses)) { 
	    return response;
	}
	
	for(Address address : addresses) {
	    districts.add(changeToDistrict(address));
	}
	
	return response;
    }
    
    /** 
     * (non-Javadoc)   
     * @see com.ssic.education.app.service.IHomePageService#getSubDistricetSchoolStatistic(java.lang.String, java.lang.Integer)   
     */
    @Override
    public Response<List<AddressStatistic>> getSubDistricetSchoolStatistic(String parentDistrictCode, Integer schoolLevel) {
	Response<List<AddressStatistic>> response = new Response<>();
	List<AddressStatistic> districts = new ArrayList<>();
	response.setData(districts);
	
	if(StringUtils.isEmpty(parentDistrictCode)) {
	    throw new AppException(1, "parent district code can not be null or empty");
	}
	
	if(!SchoolLevel.validateSchoolLevelValue(schoolLevel)){
	    throw new AppException(2, "invalid school level number");
	}
	
	List<AddressStatistic> statistics = addressDao.getAddressStatistic(parentDistrictCode, schoolLevel);
	
	if(CollectionUtils.isEmpty(statistics)) { 
	    return response;
	}
	response.setData(statistics);
	return response;
    }

    /** 
    * (non-Javadoc)   
    * @see com.ssic.education.app.service.IHomePageService#getSchoolLevel()   
    */
   @Override
   public Response<Map<Integer, String>> getSchoolLevel() {
       Response<Map<Integer, String>> response = new Response<>();
       response.setData(SchoolLevel.getAll());
       return response;
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
	
	return distict;
    }

}

