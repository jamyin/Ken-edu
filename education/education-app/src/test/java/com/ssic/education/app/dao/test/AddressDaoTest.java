/**
 * 
 */
package com.ssic.education.app.dao.test;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.ssic.education.app.test.BaseTestCase;
import com.ssic.education.common.dao.AddressDao;
import com.ssic.education.common.dto.AddressStatistic;
import com.ssic.education.common.pojo.Address;
import com.ssic.util.UUIDGenerator;
import com.ssic.util.constants.DataStatus;

/**		
 * <p>Title: AddressDaoTest </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author rkzhang	
 * @date 2016年3月16日 上午11:46:38	
 * @version 1.0
 * <p>修改人：rkzhang</p>
 * <p>修改时间：2016年3月16日 上午11:46:38</p>
 * <p>修改备注：</p>
 */
public class AddressDaoTest extends BaseTestCase {

    protected static final Log logger = LogFactory.getLog(AddressDaoTest.class);
    
    @Autowired
    private AddressDao addressDao;
    
    @Test
    public void getAddressStatisticTest() {
	List<AddressStatistic> statisitics = addressDao.getAddressStatistic("310000", 1);
	Assert.isTrue(CollectionUtils.isNotEmpty(statisitics));
	for(AddressStatistic statistic : statisitics) {
	    logger.info(statistic);
	}
    }
    
    @Test
    public void getAddressByParentCodeTest() {
	List<Address> addressList = addressDao.getAddressByParentCode("310000");
	for(Address address : addressList) {
	    logger.info(address);  
	}
    }

    public void prepareData() {
	Address address = new Address();
	String shId = UUIDGenerator.getUUID();
	String shCode = "310000";
	
	address.setId(shId);
	address.setAddressCode(shCode);
	address.setAddressName("上海市");
	address.setParentId(null);
	address.setParentCode(null);
	address.setProjId("");
	address.setStat(DataStatus.ENABLED);
	address.setLatitude(23.7f);
	address.setLongitude(11.1f);
	addressDao.insertSelective(address);
	
	address.setId(UUIDGenerator.getUUID());
	address.setAddressCode("310101");
	address.setAddressName("黄浦区");
	address.setParentId(shId);
	address.setParentCode(shCode);
	addressDao.insertSelective(address);
	
	address.setId(UUIDGenerator.getUUID());
	address.setAddressCode("310103");
	address.setAddressName("南市区");
	addressDao.insertSelective(address);

	address.setId(UUIDGenerator.getUUID());
	address.setAddressCode("310104");
	address.setAddressName("卢湾区");
	addressDao.insertSelective(address);
	
	address.setId(UUIDGenerator.getUUID());
	address.setAddressCode("310105");
	address.setAddressName("徐汇区");
	addressDao.insertSelective(address);

	address.setId(UUIDGenerator.getUUID());
	address.setAddressCode("310106");
	address.setAddressName("长宁区");
	addressDao.insertSelective(address);

	address.setId(UUIDGenerator.getUUID());
	address.setAddressCode("310107");
	address.setAddressName("静安区");
	addressDao.insertSelective(address);
	
	address.setId(UUIDGenerator.getUUID());
	address.setAddressCode("310108");
	address.setAddressName("普陀区");
	addressDao.insertSelective(address);

	address.setId(UUIDGenerator.getUUID());
	address.setAddressCode("310109");
	address.setAddressName("闸北区");
	addressDao.insertSelective(address);
	
	address.setId(UUIDGenerator.getUUID());
	address.setAddressCode("310110");
	address.setAddressName("虹口区");
	addressDao.insertSelective(address);

	address.setId(UUIDGenerator.getUUID());
	address.setAddressCode("310111");
	address.setAddressName("杨浦区");
	addressDao.insertSelective(address);

	address.setId(UUIDGenerator.getUUID());
	address.setAddressCode("310112");
	address.setAddressName("吴淞区");
	addressDao.insertSelective(address);
	
	address.setId(UUIDGenerator.getUUID());
	address.setAddressCode("310113");
	address.setAddressName("闵行区");
	addressDao.insertSelective(address);
	
	address.setId(UUIDGenerator.getUUID());
	address.setAddressCode("310114");
	address.setAddressName("宝山区");
	addressDao.insertSelective(address);
	
	address.setId(UUIDGenerator.getUUID());
	address.setAddressCode("310115");
	address.setAddressName("嘉定区");
	addressDao.insertSelective(address);
	
	address.setId(UUIDGenerator.getUUID());
	address.setAddressCode("310116");
	address.setAddressName("浦东新区");
	addressDao.insertSelective(address);

	address.setId(UUIDGenerator.getUUID());
	address.setAddressCode("310117");
	address.setAddressName("金山区");
	addressDao.insertSelective(address);
	
	address.setId(UUIDGenerator.getUUID());
	address.setAddressCode("310118");
	address.setAddressName("松江区");
	addressDao.insertSelective(address);
	
	address.setId(UUIDGenerator.getUUID());
	address.setAddressCode("310119");
	address.setAddressName("青浦区");
	addressDao.insertSelective(address);
	
	address.setId(UUIDGenerator.getUUID());
	address.setAddressCode("310225");
	address.setAddressName("南汇区");
	addressDao.insertSelective(address);
	
	address.setId(UUIDGenerator.getUUID());
	address.setAddressCode("310226");
	address.setAddressName("奉贤区");
	addressDao.insertSelective(address);

	address.setId(UUIDGenerator.getUUID());
	address.setAddressCode("310230");
	address.setAddressName("崇明县");
	addressDao.insertSelective(address);

    }

}

