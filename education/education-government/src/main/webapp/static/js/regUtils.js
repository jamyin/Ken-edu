$(function() {	
	//失去焦点事件
	$("#picCaptcha").on("blur",function(){
		var picCaptcha = $("#picCaptcha").val();
		var dataParam = {picCaptcha:picCaptcha};
		$.ajax({
			url : '/ajax/checkRandom.htm',
			type : "POST",
			data : dataParam,
			dataType : 'json',
			success : function(data) {
				if(data.status == 500){
					$("#sendMessage").attr("disabled","disabled");
					$("#sendMessage").css("background","#c6c6c6");
					layer.alert(data.message, {icon: 2});
				}else{
					$("#sendMessage").css("background","#60ac62");
					$("#sendMessage").removeAttr("disabled");
				}
			}
		});
	});
//	$("#picCaptcha").on("blur",function(){
//		var picCaptcha = $("#picCaptcha").val();
//		if(picCaptcha=="" || picCaptcha==null){
//			return false;
//		}		
//		var dataParam = {picCaptcha:picCaptcha};
//		$.ajax({
//			url : '/ajax/checkRandom.htm',
//			type : "POST",
//			data : dataParam,
//			dataType : 'json',
//			success : function(data) {
//				if(data.status == 500){
//					//$("#sendMessage").attr("disabled","disabled");
//					//$("#sendMessage").css("background","#c6c6c6");
//					layer.alert(data.message, {icon: 2});
//				}else{
//					//$("#sendMessage").css("background","#60ac62");
//					//$("#sendMessage").removeAttr("disabled");
//				}
//			}
//		});
//	});
	$("#sendMessage").click(function(){
		var mobilePhone = $("#mobileNo").val();
		var phone_reg  = /(^13\d{9}$)|(^14)[5,7]\d{8}$|(^15[0,1,2,3,5,6,7,8,9]\d{8}$)|(^17)[6,7,8]\d{8}$|(^18\d{9}$)/g ;  
		if (!phone_reg.test(mobilePhone)) {
			layer.msg("手机格式不正确", {icon: 2,time: 800});//alert_redtext('mobile','手机格式不正确')
			return;
		}			
		var picCaptcha = $("#picCaptcha").val();
		if (picCaptcha.length<=0 || picCaptcha == 'undefined') {
//			layer.alert("请输入图片验证码~", {icon: 2});
			layer.msg("请输入图片验证码", {icon: 2,time: 800});//alert_redtext('mobile','手机格式不正确')
			return;
		}		
		var mobilePhone = $("#mobileNo").val();
		
		var dataParam = {picCaptcha:picCaptcha,mobilePhone:mobilePhone};
		$.ajax({
			url : '/ajax/SMS/send.htm',
			type : "POST",
			data : dataParam,
			dataType : 'json',
			success : function(data) {
				if(data.status == 500){
					layer.alert(data.message, {icon: 2,time: 800});
				}else{
					
				}
			}
		});
	});
	$("#messageValid").on("blur",function(){
		var validateCode = $("#messageValid").val();
		var mobilePhone = $("#mobileNo").val();
		var dataParam = {validateCode:validateCode,mobilePhone:mobilePhone};
		$.ajax({
			url : '/ajax/checkMobile.htm',
			type : "POST",
			data : dataParam,
			dataType : 'json',
			success : function(data) {
				if(data.status == 500){
					$("#messageValid").val("")
					$("#sursSubmit").attr("disabled","disabled");
					$("#sursSubmit").css("background","#c6c6c6");
//					layer.alert(data.message, {icon: 2});
					layer.msg(data.message, {icon: 2,time: 800});
				}else{
					$("#sursSubmit").css("background","#60ac62");
					$("#sursSubmit").removeAttr("disabled");
				}
			}
		});
	});
	
	$("#refreshValid").click(function(){
		$(this).attr("src","/ajax/drawRandom.htm?"+Math.random());
	});
});

var countM = 90;
function setMessagetime(obj) {
	if (countM == 0) {
		$(obj).removeAttr("disabled");
		$(obj).val("获取短信验证码");
		return false;
	} else {
		$(obj).val("获取短信验证码" + countM + "");
		countM--;
	}
	setTimeout(function() {
		setMessagetime(obj)
	}, 1000)
}
