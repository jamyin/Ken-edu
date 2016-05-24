$(function(){
	//表单切换
	var b = $('.tabbar')
	var f = $('.forms')
	var a = $('.agreement')
	var s = $('.submit')

	b.on('click', 'span', function(){
		if(!$(this).hasClass('cur')){
			$(this).addClass('cur').siblings().removeClass('cur')
			var t = $(this).attr('tag')
			f.find('#'+ t +'_box').addClass('show').siblings('ul').removeClass('show')
		}
	})
	//协议
	a.on('click', 'i', function(){
		$(this).toggleClass('cur')
		if(s.attr('disabled') == 'disabled'){
			s.removeAttr('disabled').removeClass('off')
		}else{
			s.attr('disabled', 'disabled').addClass('off')
		}
	})
//	//提交
//	s.on('click', function(){
//		if(!check_form()){
//			return false;
//		}
//		//utype隐藏域赋值
//		var mail_utype =  $("#mail_user_type").val(); 
//		var phone_utype =  $("#phone_user_type").val(); 
//		var mail_pic =  $("#hfThumbnail").val(); 
//		var phone_pic =  $("#phoneHfThumbnail").val(); 
//		//alert("mail_utype="+mail_utype+";phone_utype="+phone_utype);
//		if($("#mail_box").hasClass('show')){
//			 $("#utype").val(mail_utype); 
//			 $("#mobile").val("");
//			 $("#papers_pic").val(mail_pic);
//		}else{
//			 $("#utype").val(phone_utype); 
//			 $("#email").val("");
//			 $("#papers_pic").val(phone_pic);
//		}
//		
//		var mail_password =  $("#mail_password").val(); 
//		var phone_password =  $("#phone_password").val(); 
//		if($("#mail_box").hasClass('show')){
//			$("#password").val(mail_password); 
//		}else{
//			$("#password").val(phone_password); 
//		}
//		
//		var jsonData = $("#reg").serialize();
//		$.ajax({
//			url:"/userMan/register.htm",//提交的网址
//			type: 'POST',  
//			dataType: 'json', 
//			async: false,
//			data:jsonData,//提交的数据
//			success: function(data){
//				//console.log(data.data);
//				var status = data.status;
//				var message = data.message;
//				if(status==500){
//					layer.msg(message);
//				}else{
//					layer.msg('注册成功,正在跳转至用户中心', {
//						shade: [0.9, '#000'],
//					    icon: 6,
//					    time: 2000 //2秒关闭（如果不配置，默认是3秒）
//					}, function(){
//						window.location.href = "/userMan/userInfo.htm";
////						window.location.href = "/index.htm";
//					});
//				}
//				
///*				if(message=='用户名已存在！'){
//					//alert_redtext('reg_username',message);
//					layer.msg("邮箱/手机已被注册！");
//				}else if(message=='未输入验证码或验证码错误！'){
//					//alert_redtext('reg_captcha',message);
//					layer.msg("未输入验证码或验证码错误！");
//				}else if(message=='恭喜您注册成功！'){
//					//layer.msg("恭喜您注册成功！");
//					//window.location.href = '/userMan/userInfo.htm';
//					layer.msg('注册成功,正在跳转至首页', {
//						shade: [0.9, '#000'],
//					    icon: 6,
//					    time: 2000 //2秒关闭（如果不配置，默认是3秒）
//					}, function(){
//						window.location.href = "/userMan/userInfo.htm";
//					});
//				}else{
//					layer.msg(message);
//				}*/
//			},error :function(){
//				layer.msg("系统错误！", 1, 1);
//			}
//		});
//
//	})

	//取消错误提示
	$('input[type=text], input[type=phone_password]').keyup(function(){
		$(this).siblings('span').html('').removeClass('warning')
	})
	
	//注册发送验证码到手机
	$("#getCaptcha").click(function(){
		var mobile = $.trim($("#mobile").val());
		if (mobile.length == 0) {
			alert_redtext('mobile','请输入手机号')
			return false;
		}
		var phone_reg  = /(^13\d{9}$)|(^14)[5,7]\d{8}$|(^15[0,1,2,3,5,6,7,8,9]\d{8}$)|(^17)[6,7,8]\d{8}$|(^18\d{9}$)/g ;  
    	if (!phone_reg.test($.trim($('#mobile').val()))) {
        	alert_redtext('mobile','手机号码格式不正确');
            return false;
     	}
    	var captcha = $("#phone_picCaptcha").val();
		if(captcha == null || captcha ==""){
			alert_redtext('phone_picCaptcha','请先输入验证码');
			return false;
		}
		var a = this;
		$.ajax({
			url:"/userMan/checkRandom.htm",//提交的网址
			type: 'POST', 
			async:false,
			dataType: 'json',  
			data:{"picCaptcha":captcha},//提交的数据
			success: function(data){
				//console.log(data.status);
				var status = data.status;
				if(status == 200){
					//校验手机验证码
					$.ajax({
						url:"/SMS/regMobileVal.htm",//提交的网址
						type: 'POST',  
						dataType: 'json',  
						data:{"mobilePhone":mobile,"picCaptcha":captcha},//提交的数据
						success: function(data){
							if(data.status==500){
								layer.msg(data.message);
							}else{
								layer.msg("发送短信成功，如90秒内未收到短信，请点击获取验证码");
								time(a);
							}
							//console.log(data.data);
							//alert('发送信息成功！');
						},error :function(){
							layer.msg("系统错误！", 1, 1);
						}
					});
				}else{
					alert_redtext('phone_picCaptcha','请输入正确的图片验证码');
					flag =  false;
					phonerefreshImage();
				}
			},error :function(){
				layer.msg("系统错误！", 1, 1);
			}
		});		
	    });
/*    $(document).ready(function () {
        $(".upload").upload({
            uploadData: { id: "12233" },
            successFn: "success",
            deleteData: { id: function () { return "asdfasdf" } }
        });
    });
*/
	  //上传
//	$('#file').on("change",function(){
//		$("#query").click();
//	});
//	
//	$("#query").upload({
//        uploadData: { id: "12233" },
//        successFn: "success",
//        deleteData: { id: function () { 
//        	return "asdfasdf" } }
//	});
	
//	$('#phoneFile').on("change",function(){
//		
//		
//	});
	
//	$("#phoneQuery").phoneupload({		
//        uploadData: { id: '112235' },
//        successFn: "success",
//        deleteData: { id: function () { return "asdfasdf" } }
//	});
	//上传成功后执行该函数
	function success(response, statusText, xhr, $this) {
	    //比如插入编辑器
	    //alert(response.Data.RelativePath + $this.attr("value"))
		//console.log("response="+response+"statusText="+statusText+"xhr="+xhr+"$this="+$this);
	}
	 
});

function selectfun(obj){
	var fileId =  obj.id.charAt(obj.id.length - 1);
	$("#phoneQuery"+fileId+"").phoneupload({		
        uploadData: { id: obj.id },
        successFn: "success",
        deleteData: { id: function () { return "asdfasdf" } }
	});
	$("#phoneQuery"+fileId+"").click();
} 

//发送验证码按钮 倒数90秒方法
var wait=90; 
function time(sendObj) {
	if (wait == 0) {
		//sendObj.attr("disabled",false);
		//sendObj.val("获取验证码");
		sendObj.removeAttribute("disabled");         
		sendObj.value="获取验证码"; 
		wait = 90; 
	} else {
		//sendObj.attr("disabled",true);
		//sendObj.val("请等待"+wait+"秒");			
		sendObj.setAttribute("disabled", true); 
		sendObj.value="请等待"+wait+"秒"; 
		wait--; 
		setTimeout(function() { 
			time(sendObj) 
		}, 1000) 
	} 
} 
		
/*function updateImg(){
	//$('.preview > img').attr('src','/static/img/simple4.jpg')
	  $("#userImageS").attr("src",$("#file").val());
	
}*/

//验证表单
function check_form(){
	var flag = true;
	if($("#mail_box").hasClass('show')){
		//用户类型
		var mailUserType = $.trim($("#mail_user_type").val());
		if (mailUserType.length == 0) {
			alert_redtext('mail_user_type','请选择您的身份')
			flag =  false;
		}else{
			alert_redtext('mail_user_type','')
		}
		//邮箱
		var mail = $.trim($("#email").val());
		
		var mail_reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/; 
		if (!mail_reg.test(mail)) {
			alert_redtext('email','邮箱地址不正确')
			flag =  false;
		}else{
			alert_redtext('email','')
		}
		//密码
		var MailPassWord = $.trim($("#mail_password").val());
		if (MailPassWord.length == 0) {
			alert_redtext('mail_password','请输入您的邮箱')
			flag =  false;
		}
		if (MailPassWord.length < 6 || MailPassWord.length > 16) {
			alert_redtext('mail_password','密码应为6-16位，英文、数字或常用符号')
			flag =  false;
		}else{
			alert_redtext('mail_password','')
		}
		//身份证
//		var img = $.trim($("#file").val());
//        if (img == null || img == "") {
//           layer.msg("请上传您的证件！");
//            flag =  false;
//        }
		//图片验证码
		var picCaptcha = $.trim($("#mail_picCaptcha").val());
		if (picCaptcha.length <= 0) {
			alert_redtext('mail_picCaptcha','图片验证码为空')
			flag =  false;
		}else{
			alert_redtext('mail_picCaptcha','')
		}
		//检验图片验证码
		$.ajax({
			url:"/userMan/checkRandom.htm",//提交的网址
			type: 'POST', 
			async:false,
			dataType: 'json',  
			data:{"picCaptcha":picCaptcha},//提交的数据
			success: function(data){
				//console.log(data.status);
				var status = data.status;
	        	if(status == 500){
					alert_redtext('mail_picCaptcha','请输入正确的图片验证码');
					flag =  false;
					phonerefreshImage();
				}else{
					alert_redtext('mail_picCaptcha','');
				}
			},error :function(){
				//alert('系统错误！');
				layer.msg("系统错误！", 1, 1);
			}
		});
	}
	//console.log($("#iphone_box").hasClass('show'));
	if($("#iphone_box").hasClass('show')){
		//用户类型
		var phoneUserType = $.trim($("#phone_user_type").val());
		if (phoneUserType.length == 0) {
			alert_redtext('phone_user_type','请选择您的身份')
			flag =  false;
		}else{
			alert_redtext('phone_user_type','')
		}
		//手机
		var tel = $.trim($("#mobile").val());
		if (tel.length == 0) {
			alert_redtext('mobile','请输入手机号')
			flag =  false;
		}
		var phone_reg  = /(^13\d{9}$)|(^14)[5,7]\d{8}$|(^15[0,1,2,3,5,6,7,8,9]\d{8}$)|(^17)[6,7,8]\d{8}$|(^18\d{9}$)/g ;  
		if (!phone_reg.test(tel)) {
			alert_redtext('mobile','手机格式不正确')
			flag =  false;
		}else{
			alert_redtext('mobile','')
		}
		//密码
		var phonePassword = $.trim($("#phone_password").val());
		if (phonePassword.length < 6 || phonePassword.length > 16) {
			alert_redtext('phone_password','密码应为6-16位，英文、数字或常用符号')
			flag =  false;
		}else{
			alert_redtext('phone_password','')
		}
		//身份证
//		var img = $.trim($("#file").val());
//        if (img == null || img == "") {
//           layer.msg("请上传您的证件！");
//            flag =  false;
//        }
		//手机验证码
		var TelCaptcha = $.trim($("#randomPic").val());
		if (TelCaptcha.length <= 0) {
			alert_redtext('randomPic','手机验证码为空')
			flag =  false;
		}else{
			alert_redtext('randomPic','')
		}
		//图片验证码
		var picCaptcha = $.trim($("#phone_picCaptcha").val());
		if (picCaptcha.length <= 0) {
			alert_redtext('phone_picCaptcha','图片验证码为空')
			flag =  false;
		}else{
			alert_redtext('phone_picCaptcha','')
		}
		//检验图片验证码
		$.ajax({
			url:"/userMan/checkRandom.htm",//提交的网址
			type: 'POST', 
			async:false,
			dataType: 'json',  
			data:{"picCaptcha":picCaptcha},//提交的数据
			success: function(data){
				//console.log(data.status);
				var status = data.status;
	        	if(status == 500){
					alert_redtext('phone_picCaptcha','请输入正确的图片验证码');
					flag =  false;
					phonerefreshImage();
				}else{
					alert_redtext('phone_picCaptcha','');
				}
			},error :function(){
				layer.msg("系统错误！", 1, 1);
			}
		});
	}
	return flag;
}

//验证表单错误提示
function alert_redtext(d,t){
	$('#' +d).focus().siblings('span').html(t).addClass('warning')
}
//邮箱注册刷新验证码
function mailrefreshImage(){
	var imageUrl = '/userMan/drawRandom.htm'; //你的生成图片的页面
	$("#mail_check_Code").attr("src",imageUrl + '?' + Math.random());
};
//手机注册刷新验证码
function phonerefreshImage(){
	var imageUrl = '/userMan/drawRandom.htm'; //你的生成图片的页面
	$("#phone_check_Code").attr("src",imageUrl + '?' + Math.random());
};
