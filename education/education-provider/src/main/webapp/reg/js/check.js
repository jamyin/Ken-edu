$(function() {
	//失去焦点事件
	$("#picCaptcha").on("blur",function(){
		var picCaptcha = $("#picCaptcha").val();
		if(picCaptcha=="" || picCaptcha==null){
			return false;
		}
		var dataParam = {picCaptcha:picCaptcha};
		$.ajax({
			url : 'checkRandom',
			type : "POST",
			data : dataParam,
			dataType : 'json',
			success : function(data) {
				if(data.status == 500){
					$("#sendMessage").attr("disabled","disabled");
					layer.alert(data.message, {icon: 2});
				}else{
					$("#sendMessage").removeAttr("disabled");
				}
			}
		});
	});
	$("#sendMessage").click(function(){
		var picCaptcha = $("#picCaptcha").val();
		var mobilePhone = $("#phone").val();
		var dataParam = {picCaptcha:picCaptcha,mobilePhone:mobilePhone};
		$.ajax({
			url : 'SMS/send',
			type : "POST",
			data : dataParam,
			dataType : 'json',
			success : function(data) {
				if(data.status == 500){
					layer.alert(data.message, {icon: 2});
				}else{
					var obj =  $("#sendMessage");
					$(obj).attr("disabled","disabled");
					setMessagetime(obj);
				}
			}
		});
	});
	$("#messageValid").on("blur",function(){
		var validateCode = $("#messageValid").val();
		var mobilePhone = $("#phone").val();

		if(validateCode=="" || validateCode==null){
			return false;
		}
		
		var dataParam = {validateCode:validateCode,mobilePhone:mobilePhone};
		$.ajax({
			url : 'checkMobile',
			type : "POST",
			data : dataParam,
			dataType : 'json',
			success : function(data) {
				if(data.status == 500){
					$("#btn_part1").attr("disabled","disabled");
					layer.alert(data.message, {icon: 2});
				}else{
					$("#btn_part1").removeAttr("disabled");
				}
			}
		});
	});
	
	$("#refreshValid").click(function(){
		$(this).attr("src","drawRandom?"+Math.random());
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