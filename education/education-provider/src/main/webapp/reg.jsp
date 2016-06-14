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

<script type="text/javascript" src="reg/layer-v2.0/layer/layer.js"></script>

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
				<form id="submit_form" enctype="multipart/form-data" method="POST">
					<div class="reg-box" id="verifyCheck" style="margin-top: 20px;">
						<div class="part1">
							<div class="item col-xs-12">
								<span class="intelligent-label f-fl"><b class="ftx04">*</b>单位名称：</span>
								<div class="f-fl item-ifo">
									<input name="supplierName" type="text" maxlength="20" class="txt03 f-r3 required" tabindex="1" data-valid="isNonEmpty||between:3-20||isUname"
										data-error="单位名称不能为空||用户名长度3-20位||只能输入中文、字母、数字、下划线，且以中文或字母开头" id="adminNo" /> <span class="ie8 icon-close close hide"></span> <label class="icon-sucessfill blank hide"></label>
									<label class="focus"><span>中文、字母、数字、下划线的组合，以中文或字母开头</span></label> <label class="focus valid"></label>
								</div>
							</div>
							<div class="item col-xs-12">
								<span class="intelligent-label f-fl"><b class="ftx04"></b>地址：</span>
								<div class="f-fl item-ifo">
									<input name="address" type="text" maxlength="20" class="txt03 f-r3" tabindex="1" data-valid="isUname" data-error="只能输入中文、字母、数字、下划线，且以中文或字母开头" id="adminNo" /> <span
										class="ie8 icon-close close hide"></span> <label class="icon-sucessfill blank hide"></label> <label class="focus"><span>中文、字母、数字、下划线的组合，以中文或字母开头</span></label> <label
										class="focus valid"></label>
								</div>
							</div>
							<div class="item col-xs-12">
								<span class="intelligent-label f-fl"><b class="ftx04"></b>联系人：</span>
								<div class="f-fl item-ifo">
									<input name="corporation" type="text" maxlength="20" class="txt03 f-r3" tabindex="2" data-valid="isUname" data-error="只能输入中文、字母、数字、下划线，且以中文或字母开头" id="adminNo" /> <span
										class="ie8 icon-close close hide"></span> <label class="icon-sucessfill blank hide"></label> <label class="focus"><span>中文、字母、数字、下划线的组合，以中文或字母开头</span></label> <label
										class="focus valid"></label>
								</div>
							</div>
							<div class="item col-xs-12">
								<span class="intelligent-label f-fl"><b class="ftx04">*</b>手机：</span>
								<div class="f-fl item-ifo">
									<input name="contactWay" type="text" class="txt03 f-r3 required" keycodes="tel" tabindex="3" data-valid="isNonEmpty||isPhone" data-error="手机号码不能为空||手机号码格式不正确" maxlength="11" id="phone" /> <span
										class="ie8 icon-close close hide"></span> <label class="icon-sucessfill blank hide"></label> <label class="focus">请填写11位有效的手机号码</label> <label class="focus valid"></label>
								</div>
							</div>
							<div class="item col-xs-12">
								<span class="intelligent-label f-fl"><b class="ftx04">*</b>图片验证码：</span>
								<div class="f-fl item-ifo">
									<input name="picCaptcha" type="text" class="txt03 f-r3 required" keycodes="tel" tabindex="3" data-valid="isNonEmpty" data-error="手机号码不能为空||手机号码格式不正确" maxlength="11" id="picCaptcha" /> <span
										class="ie8 icon-close close hide"></span> <label class="icon-sucessfill blank hide"></label> 
								</div>
								<div class="f-fl item-ifo">
									<label class=""><img id="refreshValid" title="点击图片刷新验证码" src="${pageContext.request.contextPath}/drawRandom"/></label>
								</div>
							</div>
							<div class="item col-xs-12">
								<span class="intelligent-label f-fl"><b class="ftx04">*</b>短信验证码：</span>
								<div class="f-fl item-ifo">
									<input name="messageValid" type="text" class="txt03 f-r3 required" keycodes="tel" data-valid="isNonEmpty" maxlength="11" id="messageValid" /> <span
										class="ie8 icon-close close hide"></span> <label class="icon-sucessfill blank hide"></label>
								</div>
								<div class="f-fl item-ifo">
									<input id="sendMessage" type="button" href="javascript:;" disabled="disabled" class="btn btn-blue" style="width:150px;" value="获取短信验证码"></input>
								</div>
							</div>
							<div class="item col-xs-12">
								<span class="intelligent-label f-fl"><b class="ftx04"></b>区教委：</span>
								<div class="" id="committeeList" style="float: right; margin-left: 90px;"></div>
							</div>
						<div class="item col-xs-12" style="margin-top:80px;">
	                        <span class="intelligent-label f-fl"><b class="ftx04"></b>工商营业执照：</span>
     						<div class="f-fl item-ifo">
		     						<input type="text" placeholder="输入工商营业执照号" data-valid="between:6-20" class="txt03 f-r3" id="licenseNo1" onkeyup="enterLicenNO(this,1,4,'工商营业执照');"/>
     						</div>	                        
	                      <div class="f-fl item-ifo" style="margin-left:5px;">
	                       		<input id="file-1" name="licenseList" type="checkbox" style="display:none;"/>
	      						<input multiple type="file" id="id-input-file-1"/>
		     					<wf id="license1"></wf>
     						</div>
	                    </div>
						<div class="item col-xs-12">
	                        <span class="intelligent-label f-fl"><b class="ftx04"></b>餐饮服务许可证：</span>
     						<div class="f-fl item-ifo">
		     						<input type="text" placeholder="输入餐饮服务许可证号" data-valid="between:6-20" class="txt03 f-r3" id="licenseNo2" onkeyup="enterLicenNO(this,2,0,'餐饮服务许可证');"/>
     						</div>
	                       <div class="f-fl item-ifo" style="margin-left:5px;">
	                       		<input id="file-2" name="licenseList" type="checkbox" style="display:none;"/>
	      						<input multiple type="file" id="id-input-file-2"/>
		     					<wf id="license2"></wf>
     						</div>	                        
	                    </div>
						<div class="item col-xs-12">
	                        <span class="intelligent-label f-fl"><b class="ftx04"></b>食品流通许可证：</span>
     						<div class="f-fl item-ifo">
		     						<input type="text" placeholder="输入食品流通许可证号" data-valid="between:6-20" class="txt03 f-r3" id="licenseNo3" onkeyup="enterLicenNO(this,3,2,'食品流通许可证');"/>
     						</div>
	                      <div class="f-fl item-ifo" style="margin-left:5px;">
	                       		<input id="file-3" name="licenseList" type="checkbox" style="display:none;"/>
	      						<input multiple type="file" id="id-input-file-3"/>
		     					<wf id="license3"></wf>
     						</div>	                        
	                    </div>
						<div class="item col-xs-12">
	                        <span class="intelligent-label f-fl"><b class="ftx04"></b>食品生产许可证：</span>
     						<div class="f-fl item-ifo">
		     						<input type="text" placeholder="输入食品生产许可证号" data-valid="between:6-20" class="txt03 f-r3" id="licenseNo4" onkeyup="enterLicenNO(this,4,3,'食品生产许可证');"/>
     						</div>
	                       <div class="f-fl item-ifo" style="margin-left:5px;">
	                       		<input id="file-4" name="licenseList" type="checkbox" style="display:none;"/>
	      						<input multiple type="file" id="id-input-file-4"/>
		     					<wf id="license4"></wf>
     						</div>	                        
	                    </div>	
							<div class="item col-xs-12">
								<span class="intelligent-label f-fl"><b class="ftx04">*</b>用户名：</span>
								<div class="f-fl item-ifo">
									<input name="userAccount" type="text" maxlength="20" class="txt03 f-r3 required" tabindex="4" data-valid="isNonEmpty||between:3-20||isUname"
										data-error="用户名不能为空||用户名长度3-20位||只能输入中文、字母、数字、下划线，且以中文或字母开头" id="adminNo" /> <span class="ie8 icon-close close hide"></span> <label class="icon-sucessfill blank hide"></label>
									<label class="focus"><span>3-20位，中文、字母、数字、下划线的组合，以中文或字母开头</span></label> <label class="focus valid"></label>
								</div>
							</div>
							<div class="item col-xs-12">
								<span class="intelligent-label f-fl"><b class="ftx04">*</b>密码：</span>
								<div class="f-fl item-ifo">
									<input name="password" type="password" id="password" maxlength="20" class="txt03 f-r3 required" tabindex="5" style="ime-mode: disabled;" onpaste="return  false"
										autocomplete="off" data-valid="isNonEmpty||between:6-20" data-error="密码不能为空||密码长度6-20位" /> <span class="ie8 icon-close close hide"
										style="right: 55px"></span> <span class="showpwd" data-eye="password"></span> <label class="icon-sucessfill blank hide"></label> <label class="focus">6-20位英文（区分大小写）、数字、字符的组合</label>
									<label class="focus valid"></label> <span class="clearfix"></span> <label class="strength"> <span class="f-fl f-size12">安全程度：</span> <b><i>弱</i><i>中</i><i>强</i></b>
									</label>
								</div>
							</div>
							<div class="item col-xs-12">
								<span class="intelligent-label f-fl"><b class="ftx04">*</b>确认密码：</span>
								<div class="f-fl item-ifo">
									<input type="password" maxlength="20" class="txt03 f-r3 required" tabindex="6" style="ime-mode: disabled;" onpaste="return  false" autocomplete="off"
										data-valid="isNonEmpty||between:6-20||isRepeat:password" data-error="密码不能为空||密码长度6-20位||两次密码输入不一致" id="rePassword" /> <span class="ie8 icon-close close hide"
										style="right: 55px"></span> <span class="showpwd" data-eye="rePassword"></span> <label class="icon-sucessfill blank hide"></label> <label class="focus">请再输入一遍上面的密码</label>
									<label class="focus valid"></label>
								</div>
							</div>

							<div class="item col-xs-12">
								<span class="intelligent-label f-fl">&nbsp;</span>
								<div class="f-fl item-ifo">
									<input id="btn_part1" type="button" href="javascript:;" disabled="disabled" class="btn btn-blue f-r3" style="width:150px;" value="完成"></input>
									<!-- <a href="javascript:;" class="btn btn-blue f-r3" disabled="disabled" id="btn_part1">完成</a> -->
								</div>
							</div>

						</div>
					</div>
					<!-- <a href="javascript:;" class="btn btn-blue f-r3" id="btn_part2">完成11</a> -->
				</form>
				<div class="part4 text-center" style="display: none">
					<h3>恭喜，您已注册成功，审核通过之后即可登录使用！</h3>
					<p class="c-666 f-mt30 f-mb50">
						页面将在 <strong id="times" class="f-size18">10</strong> 秒钟后，跳转到 <a href="index.jsp" class="c-blue">登陆页面</a>
					</p>
				</div>
			</div>
		</div>
	</div>
	<div class="m-sPopBg" style="z-index: 998;"></div>
	<div class="m-sPopCon regcon">
		<div class="m-sPopTitle">
			<strong>服务协议条款</strong><b id="sPopClose" class="m-sPopClose" onClick="closeClause()">×</b>
		</div>
		<div class="apply_up_content">
			<pre class="f-r0">
		<strong>同意以下服务条款，提交注册信息</strong>
        </pre>
		</div>
		<center>
			<a class="btn btn-blue btn-lg f-size12 b-b0 b-l0 b-t0 b-r0 f-pl50 f-pr50 f-r3" href="javascript:closeClause();">已阅读并同意此条款</a>
		</center>
	</div>
	<script>
		$(function() {
			//第一页的确定按钮
			$("#btn_part1").click(function() {
 								if (!verifyCheck._click()){
									return;
								}
								
 								//必须选中一个区域
 								//var committees = document.getElementsByName("committees");
 								var checkLength = 0;
 			            		$("input[name='committees']").each(function(index,item){
 			            		    if (true == $(item).prop("checked")) {
 			            		    	checkLength ++;
 			            		    }
 			            		});
 			            		if(checkLength<1){
 			            			alert("必须选择一个区教委");
 			            			return false;
 			            		}
 								
								//图片判断 必须上传一个图片
								var isFiles = 0;
								for(var i=1;i<5;i++){
									var liceHtml = $("#license"+i).html();
									if(liceHtml=="" || liceHtml ==null){
										isFiles++;
									}
									
									var licenseNo = $("#licenseNo"+i).val();
									if(licenseNo!="" && licenseNo!=null){
										//进行正则判断
										var strExp=/^[A-Za-z0-9]+$/;
								        if(!strExp.test(licenseNo)){
								        	alert("证件号为数字或字母");
								        	return false;
								        }
									}
								}
								if(isFiles==4){
									alert("必须上传一份证件");
									return false;
								}
								//加载
 								var dataParam = $("#submit_form").serialize();
								//console.log("dataParam"+dataParam);
 								$.ajax({
									url : '${pageContext.request.contextPath}/proUserRegController/pureg',
									type : "POST",
									data : dataParam,
									dataType : 'json',
									success : function(data) {
										$("#submit_form").hide();
										$(".part4").show();
										var obj =  $("#times");
										//console.log(obj);
										settime(obj);
									}
								});
								
							});

			$("#btn_part2").click(function() {
				$("#submit_form").hide();
				$(".part4").show();
				var obj =  $("#times");
				console.log(obj);
				settime(obj);
			});

			laodcommittee();

		});

		var countdown = 10;
		function settime(obj) {
			if (countdown == 0) {
				window.location.href = "index.jsp";
				return;
			} else {
				$(obj).html("" + countdown + "");
				countdown--;
			}
			setTimeout(function() {
				settime(obj)
			}, 1000)
		}

		function showoutc() {
			$(".m-sPopBg,.m-sPopCon").show();
		}
		function closeClause() {
			$(".m-sPopBg,.m-sPopCon").hide();
		}
	</script>
	<script src="reg/js/reg.js"></script>
	<script src="reg/js/regImages.js"></script>
	<script src="reg/js/check.js"></script>
</body>
</html>
