/**
 * 
 */
package com.ssic.education.app.dto;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**		
 * <p>Title: School </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author rkzhang	
 * @date 2016年4月7日 上午9:26:04	
 * @version 1.0
 * <p>修改人：rkzhang</p>
 * <p>修改时间：2016年4月7日 上午9:26:04</p>
 * <p>修改备注：</p>
 */
@ToString
public class School {

    @Getter
    @Setter
    private String id;
    
    @Getter
    @Setter
    private String schoolName;
    
    @Getter
    @Setter
    private String schoolDistrict;
    
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
    private List<Supplier> suppliers;
    
}

