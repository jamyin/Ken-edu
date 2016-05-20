/**
 * 
 */
package com.ssic.education.wechat.exception;

import lombok.Getter;
import lombok.Setter;

/**		
 * <p>Title: AppException </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author rkzhang	
 * @date 2016年4月5日 上午10:29:26	
 * @version 1.0
 * <p>修改人：rkzhang</p>
 * <p>修改时间：2016年4月5日 上午10:29:26</p>
 * <p>修改备注：</p>
 */
public class EduException extends RuntimeException {

    
    private static final long serialVersionUID = -1673187824595767978L;
    
    @Getter
    @Setter
    private Integer errorCode;

    /**   
     * 创建一个新的实例 AppException.      
     */
    public EduException() {
	
    }

    /**   
     * 创建一个新的实例 AppException.   
     * @param message   
     */
    public EduException(String message) {
	super(message);
	
    }

    /**   
     * 创建一个新的实例 AppException.   
     * @param message   
     */
    public EduException(Integer errorCode, String message) {
	super(message);
	this.errorCode = errorCode;
    }

}

