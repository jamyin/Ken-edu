package com.ssic.education.government.controller;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssic.education.handle.service.ISmsSendService;
import com.ssic.education.utils.constants.DataStatus;
import com.ssic.education.utils.model.Response;
import com.ssic.education.utils.tools.RandomPicTools;
import com.ssic.education.utils.util.DateUtils;
import com.ssic.education.utils.util.PropertiesUtils;

@Controller
@RequestMapping(value = "/ajax")
public class DrawRandomController {
	
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    
    @Autowired
	private ISmsSendService iSmsSendService;

	@RequestMapping(value = "/drawRandom")
	@ResponseBody
	public void drawRandom(HttpServletResponse reponse,
			HttpServletRequest request, HttpSession session) {
		RandomPicTools randomPicTools = new RandomPicTools();
		int width = 100;// 图片宽
		int height = 26;// 图片高
		int lineSize = 80;// 干扰线数量
		int stringNum = 6;// 随机产生字符数量
		session = request.getSession();
		// BufferedImage类是具有缓冲区的Image类,Image类是用于描述图像信息的类
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_BGR);
		Graphics g = image.getGraphics();// 产生Image对象的Graphics对象,改对象可以在图像上进行各种绘制操作
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));
		g.setColor(randomPicTools.getRandColor(110, 133));
		// 绘制干扰线
		for (int i = 0; i <= lineSize; i++) {
			randomPicTools.drowLine(g, width, height);
		}
		// 绘制随机字符
		String randomString = "";
		for (int i = 1; i <= stringNum; i++) {
			randomString = randomPicTools.drowString(g, randomString, i);
		}
		session.removeAttribute("RandomCode");
		session.setAttribute("RandomCode", randomString);
		g.dispose();
		try {
			// 将内存中的图片通过流动形式输出到客户端
			ImageIO.write(image, "JPEG", reponse.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value = "/checkRandom")
	@ResponseBody
	public Response<String> checkRandom(HttpServletResponse reponse,
			HttpServletRequest request, HttpSession session,@RequestParam(value = "picCaptcha", required = false) String picCaptcha) {
		Response<String> result = new Response<String>();
		if(StringUtils.isEmpty(picCaptcha)){
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("图片验证码不存在！");
			return result;
		}
		if (session.getAttribute("RandomCode") != null) {
			String randomPicSession = session.getAttribute("RandomCode")
					.toString().toLowerCase();
			if (!picCaptcha.toLowerCase().equals(randomPicSession)) {
				result.setStatus(DataStatus.HTTP_FAILE);
				result.setMessage("图片验证码输入错误！");
				return result;
			}else{
				result.setStatus(DataStatus.HTTP_SUCCESS);
				result.setMessage("图片验证码输入正确！");
				return result;
			}
		 }else {
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("图片验证码不存在！");
			return result;
		}
	}
	
    @RequestMapping(value = "/SMS/send")
	@ResponseBody
	public Response<String> sendSMS(String mobilePhone,String picCaptcha,HttpSession session,HttpServletRequest request) {
		Response<String> result = new Response<String>();

		if (StringUtils.isEmpty(mobilePhone)) {
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("手机为空！");
			return result;
		}
		
		if(StringUtils.isEmpty(picCaptcha)){
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("图片验证码为空！");
			return result;
		}
		String randomPicSession = session.getAttribute("RandomCode").toString().toLowerCase();
		if (!picCaptcha.toLowerCase().equals(randomPicSession)) {
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("图片验证码输入错误！");
			return result;
		}		
		
		if(!CheckSendMsg(redisTemplate, mobilePhone, request)){
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("发送短信过于频繁,请您稍后再试");
			return result;			
		}

		if(!CheckSendMsg(redisTemplate, mobilePhone)){
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("超过当天最多的发送次数");
			return result;
		}
		
		int randomNumber = (int) (Math.random() * 9000 + 1000);
		String content = "温馨提示，为了保护您的隐私，请您在90秒内输入" + randomNumber + "验证码。";// 短信内容
		System.out.println("iSmsSendService"+iSmsSendService);
		String returnString = iSmsSendService.sendSms(randomNumber, mobilePhone, content);
//		String keyCode = SessionConstants.PHONE_NUMBER+loginUserDto.getId();
		String keyCode = mobilePhone + "provider";
		redisTemplate.opsForValue().set(keyCode, randomNumber, 90, TimeUnit.SECONDS);
		
		result.setStatus(DataStatus.HTTP_SUCCESS);
		return result;
	}
    
	@RequestMapping(value = "/checkMobile")
	@ResponseBody
	public Response<String> checkRandom(String mobilePhone,String validateCode,HttpSession session,HttpServletRequest request) {
		Response<String> result = new Response<String>();
		
		if(validateCode == null || validateCode.equals("")){
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("短信验证码为空！");
			return result;
		}
		if (StringUtils.isEmpty(mobilePhone)) {
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("手机为空！");
			return result;
		}
		
		String keyCode = mobilePhone + "provider";
		if(redisTemplate.opsForValue().get(keyCode)==null || redisTemplate.opsForValue().get(keyCode).equals("")){
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("短信验证码失效！");
			return result;
		}
		
		String checkCode = redisTemplate.opsForValue().get(keyCode).toString();
		if (validateCode.equals(checkCode)) {
				result.setStatus(DataStatus.HTTP_SUCCESS);
				result.setMessage("手机验证成功！");
			return result;
		} else {
			result.setStatus(DataStatus.HTTP_FAILE);
			result.setMessage("短信验证码错误！");
			return result;
		}

	}
    
    public static Boolean CheckSendMsg(final RedisTemplate<String, Object> redisTemplate,final String mobilePhone,HttpServletRequest request){
    	String keySessionId = mobilePhone + DateUtils.format(new Date(), DateUtils.YMD_DASH)+"diff";
    	if(redisTemplate.opsForValue().get(keySessionId)!=null){
    		String nowDate = (String)redisTemplate.opsForValue().get(keySessionId);
    		long  diffmin = DateUtils.diffNowMin(DateUtils.parse(nowDate, DateUtils.YMD_DASH_WITH_TIME));
    		if(diffmin < 10){
    			return false;
    		}
    	}else{
    		String nowDate = DateUtils.format(new Date(), DateUtils.YMD_DASH_WITH_TIME);
    		redisTemplate.opsForValue().set(keySessionId, nowDate, 10, TimeUnit.MINUTES);
    	}
    	return true;
    }
    
	public static Boolean CheckSendMsg(final RedisTemplate<String, Object> redisTemplate,final String mobilePhone){
		String phoneKey = mobilePhone + DateUtils.format(new Date(), DateUtils.YMD_DASH);
		if(redisTemplate.opsForValue().get(phoneKey)!=null){
			Integer tempRounds = (Integer)redisTemplate.opsForValue().get(phoneKey);
			if(tempRounds > Integer.valueOf(PropertiesUtils.getProperty("maxSendNumber"))){
				return false;
			}
			redisTemplate.delete(phoneKey);
			redisTemplate.opsForValue().set(phoneKey, (tempRounds+1), 24, TimeUnit.HOURS);	
		}else{
			redisTemplate.opsForValue().set(phoneKey, 1, 24, TimeUnit.HOURS);
		}
		return true;
	}

}
