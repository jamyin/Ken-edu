/**
 * 
 */
package com.ssic.education.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**		
 * <p>Title: District </p>
 * <p>Description: 地区信息对象</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author rkzhang	
 * @date 2016年3月15日 下午3:46:30	
 * @version 1.0
 * <p>修改人：rkzhang</p>
 * <p>修改时间：2016年3月15日 下午3:46:30</p>
 * <p>修改备注：</p>
 */
@ToString
public class District {
 
     /**   
     * districtCode: 地区编码
     */   
   @Getter
   @Setter
   private String districtCode;
   
   
   
     /**   
     * districtName:  地区名称
     */   
   @Getter
   @Setter
   private String districtName;
   
   
     /**   
     * coordinate: 地区坐标
     */   
   @Getter
   @Setter
   private Coordinate coordinate;
   
   
     /**   
     * number: 学校数量
     */   
   @Getter
   @Setter
   private Integer number;
   
}

