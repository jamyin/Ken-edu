package com.ssic.education.utils.constants;

import com.ssic.education.utils.util.PropertiesUtils;
import com.ssic.education.utils.util.RandomCode;

/**
 * 数据状态常量， 标识数据是否有效
 * 1，有效， 0， 无效
 * @author rkzhang
 *
 */
public interface DataStatus {
	final static String IMAGE_HOST = PropertiesUtils.getProperty("upload.look.url");

	final static String _UPLOAD_ = "/upload/";

	final static int EVA_TWO = 2;

	final static int ENABLED = 1;

	final static int DISABLED = 0;

	final static short SHORT_ENABLED = 1;

	final static short SHORT_DISABLED = 0;
	/**   
	* DISABLED: 交易完成
	*/
	final static int DEALS_ORDER = 2;

	//	final static int ENABLED = 1; //1 可用 0 不可用 2已经使用
	//	
	//	final static int DISABLED = 0;//1 可用 0 不可用 2已经使用

	final static int ISUSER = 2;//1 可用 0 不可用 2已经使用

	final static int HTTP_SUCCESS = 200; //OK

	final static int HTTP_FAILE = 500; //OK

	final static int HTTP_INFO = 501; // 用户参赛信息为空
	//200 OK
	//500 faile

	final static int USERTYPE = 1;//普通用户

	final static int SITETYPE = 2;//场地用户

	final static int MANAGERTYPE = 3;//教练用户

	final static String DECODECHARSET = "utf-8";

	final static String _RANDOMPIC_ = "0";

	final static String _ORDERCODE_ = "orderCode";

	final static long _FILESIZE_ = 1024 * 1024;

	final static long _TEMPFILESIZE = 1024 * 500;

	final static String _ORDER_ = "O";

	final static String _ITEMS_ = "I";

	final static int _MAX_MINUTES = 30 * 60;

	final static int _MAX_SECONDS = 60;

	final static int CARD_USR = 1;//刷卡消费

	final static int CODE_USR = 2;//二维码消费

	final static int PHONE_USR = 3;//手机验证码消费

	final static String _JUJU_ = "juju_" + RandomCode.getEnRandomCode(1) + RandomCode.getRandomCodeByNumber(4);

	final static String _SITE_ = "site_" + RandomCode.getEnRandomCode(1) + RandomCode.getRandomCodeByNumber(4);

	public String _SST_ = "sst_" + RandomCode.getEnRandomCode(1) + RandomCode.getRandomCodeByNumber(4); //赛事通用户昵称

	public static final String SST_USER = "SSTUSER";

	public final static long HOUR_24 = 24 * 60 * 60 * 1000L;// 24小时

	public final static String TIGASEACCOUNT = "tigaseAccount-";
}
