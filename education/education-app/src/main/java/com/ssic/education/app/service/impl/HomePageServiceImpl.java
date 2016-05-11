/**
 * 
 */
package com.ssic.education.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Objects;
import com.ssic.education.app.constants.SchoolLevel;
import com.ssic.education.app.dto.Coordinate;
import com.ssic.education.app.dto.District;
import com.ssic.education.app.dto.School;
import com.ssic.education.app.dto.Supplier;
import com.ssic.education.app.service.IHomePageService;
import com.ssic.education.app.util.Assert;
import com.ssic.test.common.dao.AddressDao;
import com.ssic.test.common.dao.SchoolSupplierDao;
import com.ssic.test.common.dto.AddressStatistic;
import com.ssic.test.common.dto.SchoolSupplierRel;
import com.ssic.test.common.pojo.Address;
import com.ssic.util.BeanUtils;
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
    
    @Autowired
    private SchoolSupplierDao schoolSupplierDao;

     /** 
     * (non-Javadoc)   
     * @see com.ssic.education.app.service.IHomePageService#getSubDistricetByParentCode(java.lang.String)   
     */
    @Override
    public Response<List<District>> getSubDistricetByParentCode(String parentDistrictCode) {
	Assert.isTrue(StringUtils.isNotEmpty(parentDistrictCode), "parent district code can not be null or empty", 1);
	
	Response<List<District>> response = new Response<>();
	List<District> districts = new ArrayList<>();
	response.setData(districts);
	
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
	Assert.isTrue(StringUtils.isNotEmpty(parentDistrictCode), "parent district code can not be null or empty", 1);
	Assert.isTrue(SchoolLevel.validateSchoolLevelValue(schoolLevel), "invalid school level number", 2);
	
	Response<List<AddressStatistic>> response = new Response<>();
	List<AddressStatistic> districts = new ArrayList<>();
	response.setData(districts);

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
    * (non-Javadoc)   
    * @see com.ssic.education.app.service.IHomePageService#getSchoolList(java.util.Date)   
    */
   @Override
   public Response<List<School>> getSchoolList(Date lastUpdateTime) {
       Response<List<School>> response = new Response<>();
      
       List<SchoolSupplierRel> results = schoolSupplierDao.findSchoolSupplierRel(lastUpdateTime);
       List<School> schools = changeToSchool(results);
       response.setData(schools);
       return response;
   }
    
    
    /**     
     * changeToSchool：一句话描述方法功能
     * @param results
     * @return
     * @exception	
     * @author rkzhang
     * @date 2016年4月7日 下午1:39:35	 
     */
    private List<School> changeToSchool(List<SchoolSupplierRel> results) {
	 List<School> schools = new ArrayList<>();
	 if(CollectionUtils.isEmpty(results)) {
	     return schools;
	 }
	 Map<String, List<Supplier>> supplierMap = new HashMap<String, List<Supplier>>();
	 
	 //--- 构建supplier对象
	 for(SchoolSupplierRel rel : results) {
	     Supplier supplier = createSupplier(rel);
	     List<Supplier> suppliers = supplierMap.get(rel.getSchoolId());
	     if(suppliers == null) {
		 suppliers = new ArrayList<Supplier>();
		 suppliers.add(supplier);
		 supplierMap.put(rel.getSchoolId(), suppliers);
	     } else {
		 suppliers.add(supplier);
	     }
	 }
	 
	 //--- 构建school对象
	 Set<String> schoolIds = new HashSet<>();
	 for(SchoolSupplierRel rel : results) {
	     if(!schoolIds.contains(rel.getSchoolId())) {
        	     School school = createSchool(rel);
        	     List<Supplier> suppliers = supplierMap.get(school.getId());
        	     school.setSuppliers(suppliers);
        	     schools.add(school);
        	     schoolIds.add(rel.getSchoolId());
	     }
	 }
	      
        return schools;
    }

    
    
    /**     
     * createSchool：构建学校信息
     * @param rel
     * @return
     * @exception	
     * @author rkzhang
     * @date 2016年4月7日 下午3:04:21	 
     */
    private School createSchool(SchoolSupplierRel rel) {
	School school = BeanUtils.createBeanByTarget(rel, School.class);
	school.setId(rel.getSchoolId());
	return school;
    }

    /**     
     * createSupplier：构建供应商信息
     * @param rel
     * @return
     * @exception	
     * @author rkzhang
     * @date 2016年4月7日 下午1:54:29	 
     */
    private Supplier createSupplier(SchoolSupplierRel rel) {
	if(rel == null) {
	    return null;
	}
	Supplier supplier = new Supplier();
	supplier.setId(rel.getSupplierId());
	supplier.setSupplierName(rel.getSupplierName());
	supplier.setVerified(rel.getVerified());
	return supplier;
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

