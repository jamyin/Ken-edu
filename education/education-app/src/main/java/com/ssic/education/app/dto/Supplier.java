/**
 * 
 */
package com.ssic.education.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**		
 * <p>Title: Supplier </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author rkzhang	
 * @date 2016年4月7日 上午9:26:17	
 * @version 1.0
 * <p>修改人：rkzhang</p>
 * <p>修改时间：2016年4月7日 上午9:26:17</p>
 * <p>修改备注：</p>
 */
@ToString
public class Supplier {

    @Getter
    @Setter
    private String id;
    
    @Getter
    @Setter
    private String supplierName;
    
    @Getter
    @Setter
    private Boolean verified;
    
}

