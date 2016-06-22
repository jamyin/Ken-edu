<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<style>
ul.my_info {
	text-align:center;
}
.name {
	display:inline-block;
	width:120px;
	text-align:right;
	margin-right:10px;
}
.cert {
	display:inline-block;
	width:120px;
	text-align:right;
	margin-right:10px;
}
.fl {
	text-align:center;
	margin-left:10px;
	width:25px;
	float:left;
}
.fl-a {
	padding-top:25px!important;
}
</style>
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript">

	function showPic(){
		parent.$.modalDialog({
			title : '查看图片',
			width :768,
			height : 480,
			href : '${pageContext.request.contextPath}/corporateController/showPic',
			onOpen: function(){}
		});
	}

	function edit(){
		parent.$.modalDialog({
			title: '编辑',    
		    width: 500,    
		    height: 600,  
		    href: '${pageContext.request.contextPath}/corporateController/editPage', 
		    buttons : [ {
				text : '保存',
				handler : function() {
					var f = parent.$.modalDialog.handler.find('#form');
					f.submit();
				}
			} ]
		});
	} 
	
	function editPic(){
		parent.$.modalDialog({
			title : '编辑图片',
			width : 800,
			height : 600,
			href : '${pageContext.request.contextPath}/corporateController/editPic',
			buttons : [ {
				text : '上传',
				handler : function() {
					var f = parent.$.modalDialog.handler.find('#updateImage');
					f.submit();
				}
			} ]
		});
	}
</script>
</head>
<body>
<div>
	<div class="fl" style="width:auto;"><h2>${Corporate.supplierName }</h2></div>
	<div class="fl fl-a" ><a id="btn" onclick="edit()"><img title="编辑" src="${pageContext.request.contextPath}/icon/编辑.png"></img></a></div>
	<div class="fl fl-a" ><a id="btn" onclick="editPic()"><img title="编辑图片" src="${pageContext.request.contextPath}/icon/编辑图片.png"></img></a> </div>
	<%-- <a id="btn" onclick="showPic()"><img title="查看图片" src="${pageContext.request.contextPath}/icon/查看图片.png"></img></a> --%>
	</div>
	<div>
		&nbsp;</p>
		&nbsp;</p>
	</div>
	<div>	
	<ul class="easyui-datalist my_info">
		<li>
			<span class="name" style="text-align:left;">单位地址：</span><span class="value">${Corporate.address }</span>
		</li>
		<li>
			<span class="name" style="text-align:left;">联系人姓名：</span><span class="value">${Corporate.corporation }</span>
		</li>
		<li>
			<span class="name" style="text-align:left;">电话：	</span><span class="value">${Corporate.contactWay }</span>
		</li>
		<li>
			<span class="cert" style="text-align:left;">餐饮服务许可证：	</span><span class="value">${Corporate.foodServiceCode }</span>
		</li>
<%-- 		<li>
			<span class="cert" style="text-align:left;">食品经营许可证：	</span><span class="value">${Corporate.foodBusinessCode }</span>
		</li>
		<li>
			<span class="cert" style="text-align:left;">食品流通证号：	</span><span class="value">${Corporate.foodCirculationCode }</span>
		</li>
		<li>
			<span class="cert" style="text-align:left;">食品生产证号：	</span><span class="value">${Corporate.foodProduceCode }</span>
		</li> --%>
		<li>
			<span class="cert" style="text-align:left;">工商执照号：	</span><span class="value">${Corporate.businessLicense }</span>
		</li>
	</ul>
		
</div>
</body>
</html>