/**
 * 
 */
package com.ssic.education.app.util;

import com.ssic.education.app.exception.AppException;

/**		
 * <p>Title: Assert </p>
 * <p>Description: 类描述</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author rkzhang	
 * @date 2016年4月7日 上午11:37:17	
 * @version 1.0
 * <p>修改人：rkzhang</p>
 * <p>修改时间：2016年4月7日 上午11:37:17</p>
 * <p>修改备注：</p>
 */
public abstract class Assert {

    public static void isTrue(boolean expression, String message, Integer errorCode) {
	if (!expression) {
	    throw new AppException(errorCode, message);
	}
    }
    
}

