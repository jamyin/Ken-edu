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
	$("#sendMessage").on("click",function(){
		var picCaptcha = $("#picCaptcha").val();
		if (picCaptcha.length<=0 || picCaptcha == 'undefined') {
			layer.alert("请输入图片验证码~", {icon: 2});
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
		var mobilePhone = $("#mobileNo").val();
		var dataParam = {validateCode:validateCode,mobilePhone:mobilePhone};
		$.ajax({
			url : '/ajax/checkMobile.htm',
			type : "POST",
			data : dataParam,
			dataType : 'json',
			success : function(data) {
				if(data.status == 500){
					$("#sursSubmit").attr("disabled","disabled");
					$("#sursSubmit").css("background","#c6c6c6");
					layer.alert(data.message, {icon: 2});
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