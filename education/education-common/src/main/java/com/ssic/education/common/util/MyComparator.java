/**
 * 
 */
package com.ssic.education.common.util;

import java.util.Comparator;

import com.ssic.education.common.dto.AddressDto;

/**		
 * <p>Title: MyComparator </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2015 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author 刘博
 * @date 2015年7月19日 上午11:51:28	
 * @version 1.0
 * <p>修改人：刘博</p>
 * <p>修改时间：2015年7月19日 上午11:51:28</p>
 * <p>修改备注：</p>
 */
public class MyComparator implements Comparator
{

    /** 
     * 这里的o1和o2就是list里任意的两个对象，然后按需求把这个方法填完整就行了
     */
    @Override
    public int compare(Object o1, Object o2)
    {
       
        //判断2个比较对象是否是菜单栏目对象；
        boolean isAddress = o1 instanceof AddressDto && o2 instanceof AddressDto;
        if (isAddress)
        {//如果是，强转2个菜单栏目对象，比较sort字段：按从小到大顺序比较;
            AddressDto addressDto1 = (AddressDto) o1;
            AddressDto addressDto2 = (AddressDto) o2;
            if (addressDto1.getAddressCode().compareTo(addressDto2.getAddressCode())<0)
            {
                return 1;
            }
            if (addressDto1.getAddressCode().equals(addressDto2.getAddressCode()))
            {
                return 0;
            }
        }
     
        return -1;
    }

}
