/**
 * 
 */
package com.ssic.education.app.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**		
 * <p>Title: Coordinate </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author rkzhang	
 * @date 2016年3月15日 下午3:47:42	
 * @version 1.0
 * <p>修改人：rkzhang</p>
 * <p>修改时间：2016年3月15日 下午3:47:42</p>
 * <p>修改备注：</p>
 */
@ToString
public class Coordinate implements Serializable{
    
    private static final long serialVersionUID = 8709850974063196910L;

    @Getter
    @Setter
    private Float x;
    
    @Getter
    @Setter
    private Float y;

   
    public Coordinate(Float x, Float y) {
	this.x = x;
	this.y = y;
    }

}

