/**
 * 
 */
package com.ssic.education.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**		
 * <p>Title: SupplierInfo </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author rkzhang	
 * @date 2016年4月20日 下午2:46:15	
 * @version 1.0
 * <p>修改人：rkzhang</p>
 * <p>修改时间：2016年4月20日 下午2:46:15</p>
 * <p>修改备注：</p>
 */
@ToString
public class SupplierInfo {

    @Getter
    @Setter
    private String supplierName;
    
    @Getter
    @Setter
    private String supplierAddress;

    @Getter
    @Setter
    private String foodLicense;
    
    @Getter
    @Setter
    private String businessLicense;
    
    @Getter
    @Setter
    private String corporation;
    
    @Getter
    @Setter
    private String contactWay;
    
    @Getter
    @Setter
    private String certificateIcon;
}

