<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>注册</title>
<link href="reg/css/bootstrap.min.css" rel="stylesheet">
<link href="reg/css/gloab.css" rel="stylesheet">
<link href="reg/css/index.css" rel="stylesheet">
<script src="reg/js/jquery-1.11.1.min.js"></script>
<script src="reg/js/register.js"></script>

<link href="reg/uploadify/uploadify.css" rel="stylesheet" type="text/css" />
<!-- <script type="text/javascript" src="${base}/plugins/uploadify/jquery-1.3.2.min.js"></script> -->
	<script type="text/javascript" src="reg/uploadify/swfobject.js"></script>
<script type="text/javascript" src="reg/uploadify/jquery.uploadify.v2.1.4.min.js"></script>	

</head>
<body class="bgf4">
<div class="login-box f-mt10 f-pb50">
	<div class="main bgf">    
    		<div style="text-align: center;">
    			<h2>上海市中小学校学生午餐综合管理平台</h2>
    		</div>

    	<div class="reg-box-pan display-inline">  
<!--         	<div class="step">        	
                <ul>
                    <li class="col-xs-4 on">
                        <span class="num"><em class="f-r5"></em><i>1</i></span>                	
                        <span class="line_bg lbg-r"></span>
                        <p class="lbg-txt">填写基础信息</p>
                    </li>
                    <li class="col-xs-4">
                        <span class="num"><em class="f-r5"></em><i>2</i></span>
                        <span class="line_bg lbg-l"></span>
                        <p class="lbg-txt">注册成功</p>
                    </li>
                </ul>
            </div> -->
            <form id="submit_form">
	        	<div class="reg-box" id="verifyCheck" style="margin-top:20px;">
	            	<div class="part1">                	
	                    <div class="item col-xs-12">
	                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>单位名称：</span>    
	                        <div class="f-fl item-ifo">
	                            <input name="supplierName" type="text" maxlength="20" class="txt03 f-r3 required" tabindex="1" data-valid="isNonEmpty||between:3-20||isUname" data-error="单位名称不能为空||用户名长度3-20位||只能输入中文、字母、数字、下划线，且以中文或字母开头" id="adminNo" />                            <span class="ie8 icon-close close hide"></span>
	                            <label class="icon-sucessfill blank hide"></label>
	                            <label class="focus"><span>中文、字母、数字、下划线的组合，以中文或字母开头</span></label>
	                            <label class="focus valid"></label>
	                        </div>
	                    </div>
	                    <div class="item col-xs-12">
	                        <span class="intelligent-label f-fl"><b class="ftx04"></b>地址：</span>    
	                        <div class="f-fl item-ifo">
	                            <input name="address" type="text" maxlength="20" class="txt03 f-r3" tabindex="1" data-valid="isUname" data-error="只能输入中文、字母、数字、下划线，且以中文或字母开头" id="adminNo" />                            <span class="ie8 icon-close close hide"></span>
	                            <label class="icon-sucessfill blank hide"></label>
	                            <label class="focus"><span>中文、字母、数字、下划线的组合，以中文或字母开头</span></label>
	                            <label class="focus valid"></label>
	                        </div>
	                    </div>
	                    <div class="item col-xs-12">
	                        <span class="intelligent-label f-fl"><b class="ftx04"></b>联系人：</span>    
	                        <div class="f-fl item-ifo">
	                            <input name="corporation" type="text" maxlength="20" class="txt03 f-r3" tabindex="2" data-valid="isUname" data-error="只能输入中文、字母、数字、下划线，且以中文或字母开头" id="adminNo" />                            <span class="ie8 icon-close close hide"></span>
	                            <label class="icon-sucessfill blank hide"></label>
	                            <label class="focus"><span>中文、字母、数字、下划线的组合，以中文或字母开头</span></label>
	                            <label class="focus valid"></label>
	                        </div>
	                    </div>                                        
	                    <div class="item col-xs-12">
	                        <span class="intelligent-label f-fl"><b class="ftx04"></b>手机：</span>    
	                        <div class="f-fl item-ifo">
	                            <input name="contactWay" type="text" class="txt03 f-r3" keycodes="tel" tabindex="3" data-valid="isPhone" data-error="手机号码不能为空||手机号码格式不正确" maxlength="11" id="phone" /> 
	                            <span class="ie8 icon-close close hide"></span>                           
	                            <label class="icon-sucessfill blank hide"></label>
	                            <label class="focus">请填写11位有效的手机号码</label>
	                            <label class="focus valid"></label>
	                        </div>
	                    </div>
	                    <div class="item col-xs-12">
	                        <span class="intelligent-label f-fl"><b class="ftx04"></b>区教委：</span>    
	                        <div class="" id="committeeList" style="float: right;margin-left:90px;"></div>
	                    </div>	                    
						<div class="item col-xs-12" style="margin-top:60px;">
	                        <span class="intelligent-label f-fl"><b class="ftx04"></b>工商执照：</span>    
	                       <div class="f-fl item-ifo">
	      						<input multiple type="file" id="id-input-file-3"/>
	                        </div>
	                    </div>	
	                    <div class="item col-xs-12" >
	                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>用户名：</span>    
	                        <div class="f-fl item-ifo">
	                            <input name="userAccount" type="text" maxlength="20" class="txt03 f-r3 required" tabindex="4" data-valid="isNonEmpty||between:3-20||isUname" data-error="用户名不能为空||用户名长度3-20位||只能输入中文、字母、数字、下划线，且以中文或字母开头" id="adminNo" />                            <span class="ie8 icon-close close hide"></span>
	                            <label class="icon-sucessfill blank hide"></label>
	                            <label class="focus"><span>3-20位，中文、字母、数字、下划线的组合，以中文或字母开头</span></label>
	                            <label class="focus valid"></label>
	                        </div>
	                    </div>
	                    <div class="item col-xs-12">
	                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>密码：</span>    
	                        <div class="f-fl item-ifo">
	                            <input name="password" type="password" id="password" maxlength="20" class="txt03 f-r3 required" tabindex="5" style="ime-mode:disabled;" onpaste="return  false" autocomplete="off" data-valid="isNonEmpty||between:6-20||level:2" data-error="密码不能为空||密码长度6-20位||该密码太简单，有被盗风险，建议字母+数字的组合" /> 
	                            <span class="ie8 icon-close close hide" style="right:55px"></span>
	                            <span class="showpwd" data-eye="password"></span>                        
	                            <label class="icon-sucessfill blank hide"></label>
	                            <label class="focus">6-20位英文（区分大小写）、数字、字符的组合</label>
	                            <label class="focus valid"></label>
	                            <span class="clearfix"></span>
	                            <label class="strength">
	                            	<span class="f-fl f-size12">安全程度：</span>
	                            	<b><i>弱</i><i>中</i><i>强</i></b>
	                            </label>    
	                        </div>
	                    </div>
	                    <div class="item col-xs-12">
	                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>确认密码：</span>    
	                        <div class="f-fl item-ifo">
	                            <input type="password" maxlength="20" class="txt03 f-r3 required" tabindex="6" style="ime-mode:disabled;" onpaste="return  false" autocomplete="off" data-valid="isNonEmpty||between:6-16||isRepeat:password" data-error="密码不能为空||密码长度6-16位||两次密码输入不一致" id="rePassword" />
	                            <span class="ie8 icon-close close hide" style="right:55px"></span>
	                            <span class="showpwd" data-eye="rePassword"></span>
	                            <label class="icon-sucessfill blank hide"></label>
	                            <label class="focus">请再输入一遍上面的密码</label> 
	                            <label class="focus valid"></label>                          
	                        </div>
	                    </div>
		
	                    <div class="item col-xs-12">
	                        <span class="intelligent-label f-fl">&nbsp;</span>    
	                        <div class="f-fl item-ifo">
	                           <a href="javascript:;" class="btn btn-blue f-r3" id="btn_part1">完成</a>                         
	                        </div>
	                    </div> 
	                    
		        	</div>
		     	</div>
             </form>
                <div class="part4 text-center" style="display:none">
                	<h3>恭喜，您已注册成功，审核通过之后即可登录使用！</h3>
                    <p class="c-666 f-mt30 f-mb50">页面将在 <strong id="times" class="f-size18">10</strong> 秒钟后，跳转到 <a href="index.jsp" class="c-blue">用户中心</a></p>
                </div>          
         </div>
    </div>
</div>
<div class="m-sPopBg" style="z-index:998;"></div>
<div class="m-sPopCon regcon">
	<div class="m-sPopTitle"><strong>服务协议条款</strong><b id="sPopClose" class="m-sPopClose" onClick="closeClause()">×</b></div>
    <div class="apply_up_content">
    	<pre class="f-r0">
		<strong>同意以下服务条款，提交注册信息</strong>
        </pre>
    </div>
    <center><a class="btn btn-blue btn-lg f-size12 b-b0 b-l0 b-t0 b-r0 f-pl50 f-pr50 f-r3" href="javascript:closeClause();">已阅读并同意此条款</a></center>
</div>
<script>
$(function(){
	
	//图片上传
	$("#id-input-file-3").uploadify({
        'uploader': 'reg/uploadify/uploadify.swf',
        'script':"file/upload.htm",
        'cancelImg': 'reg/uploadify/cancel.png',
        'queueID': 'fileQueue',
        'auto': true,
        //'multi':true,
        'buttonText': 'select',
        'simUploadLimit' : 1,
        'sizeLimit':1024*1024*10,
        'queueSizeLimit' : 1,
        'fileDesc' : 'pictures',
        'fileExt': '*.gif;*.png;*.jpg;*.jpge',
        onComplete: function(event, queueID, fileObj, response, data) {
            var dataObj = eval("("+response+")");
            if(dataObj.status == 200){
            	parent.layer.msg('图片上传成功', {
					shade: [0.9, '#000'],
				    icon: 6,
				    time: 800 //2秒关闭（如果不配置，默认是3秒）
				}, function(){
					$("#img_show").attr("src",'${imgurl}'+dataObj.filePath);
					$("#pic").val(dataObj.filePath);
				});                
           		//console.log(dataObj.filePath);
				//$("[name=logo]").val(dataObj.filePath);
            }else{
            	layer.alert("对不起," + fileObj.name + "上传失败!<br/>请选择小于10M的图片", {
    				shade: [0.9, '#000'],
    			    icon: 3,
    			    time: 3000 //2秒关闭（如果不配置，默认是3秒）
    			}); 
            }
        },
        onSelect:function(){
        },
        onError: function(event, queueID, fileObj) {
        	layer.alert("对不起," + fileObj.name + "上传失败!<br/>请选择小于10M的图片", {
				shade: [0.9, '#000'],
			    icon: 3,
			    time: 3000 //2秒关闭（如果不配置，默认是3秒）
			}); 
        }
    });	
	
	//第一页的确定按钮
	$("#btn_part1").click(function(){
		if(!verifyCheck._click()) return;
/* 		$(".part1").hide();
		$(".part4").show();
		$(".step li").eq(0).removeClass("on");
		$(".step li").eq(2).addClass("on");
 */			
		//加载
		var dataParam = $("#submit_form").serialize();
		$.ajax({
			url:'${pageContext.request.contextPath}/proUserRegController/pureg',
			type:"POST",
			data : dataParam,
			dataType:'json',
			success:function(data){
				$("#submit_form").hide();
				/* $(".part4").show(); */
			}
		});
	});
	
	laodcommittee();
	
});
function showoutc(){$(".m-sPopBg,.m-sPopCon").show();}
function closeClause(){
	$(".m-sPopBg,.m-sPopCon").hide();		
}
</script>
<script src="reg/js/reg.js"></script>
</body>
</html>