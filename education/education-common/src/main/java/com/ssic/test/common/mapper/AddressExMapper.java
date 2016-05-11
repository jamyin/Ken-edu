/**
 * 
 */
package com.ssic.test.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.test.common.dto.AddressDto;
import com.ssic.test.common.dto.AddressStatistic;
import com.ssic.test.common.pojo.Address;

/**		
 * <p>Title: AddressExMapper </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2015 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author 刘博	
 * @date 2015年8月12日 下午1:22:13	
 * @version 1.0
 * <p>修改人：刘博</p>
 * <p>修改时间：2015年8月12日 下午1:22:13</p>
 * <p>修改备注：</p>
 */
public interface AddressExMapper
{

    
    /**
     * 
     * validAddressRootExists： 验证区域根节点是否存在
     * @param addressId
     * @return
     * @exception   
     * @author 刘博
     * @date 2015年8月11日 上午9:15:20
     */
    AddressDto validAddressRootExists(@Param("addressId")String addressId , @Param("projId")String projId);
    
    /**
     * 
     * validAddressRootExists： 验证区域根节点是否存在
     * @param addressId
     * @return
     * @exception   
     * @author 刘博
     * @date 2015年8月11日 上午9:15:20
     */
    List<AddressDto> findCodeByLastCreateTime();
    

    /**
     * 
     * queryAddressIdAndParentIds：更具addressId查询下面的子Id
     * @param parentId
     * @return
     * @exception   
     * @author Administrator
     * @date 2015年8月13日 下午12:23:24
     */
    List<AddressDto> queryAddressIdAndParentIds(@Param("parentId")String parentId);
    
    /**
     * 
     * queryCityId：查询城市Id
     * @param parentId
     * @return
     * @exception	
     * @author pengcheng.yang
     * @date 2015年8月13日 下午5:38:52
     */
    List<AddressDto> queryCityId(@Param("cityId")String cityId);
    
    /**
     * 
     * getAddressByParentCode：一句话描述方法功能
     * @param parentCode
     * @return
     * @exception	
     * @author rkzhang
     * @date 2016年4月1日 上午11:14:04
     */
    List<AddressStatistic> getAddressStatistic(@Param("parentCode")String parentCode, @Param("level")Integer level);
}
