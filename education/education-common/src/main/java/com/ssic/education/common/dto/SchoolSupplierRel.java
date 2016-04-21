/**
 * 
 */
package com.ssic.education.common.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**		
 * <p>Title: School </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author rkzhang	
 * @date 2016年4月6日 下午5:28:51	
 * @version 1.0
 * <p>修改人：rkzhang</p>
 * <p>修改时间：2016年4月6日 下午5:28:51</p>
 * <p>修改备注：</p>
 */
@ToString
public class SchoolSupplierRel {
    
    @Getter
    @Setter
    private String schoolId;
    
    @Getter
    @Setter
    private String schoolName;
    
    @Getter
    @Setter
    private String schoolDistrict;
    
    @Getter
    @Setter
    private String districtCode;
    
    @Getter
    @Setter
    private Float x;
    
    @Getter
    @Setter
    private Float y;
    
    @Getter
    @Setter
    private String indexKey;
    
    @Getter
    @Setter
    private Date lastUpdateTime;
    
    @Getter
    @Setter
    private String supplierId;
    
    @Getter
    @Setter
    private String supplierName;
    
    @Getter
    @Setter
    private Boolean verified;
    
}

