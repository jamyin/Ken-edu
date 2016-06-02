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
 		$("#aa").dialog({    
		    title: '编辑',    
		    width: 500,    
		    height: 550,    
		    closed: false,    
		    cache: false,    
		    href: '${pageContext.request.contextPath}/corporateController/editPage',    
		    modal: true,
		    buttons : [ {
				text : '编辑',
				handler : function() {
					var f = $('#form');
					f.submit();
				}
			} ]
		});
	} 
	
	function editPic(){
		$("#aa").dialog({
			title : '编辑图片',
			width : 700,
			height : 600,
			href : '${pageContext.request.contextPath}/corporateController/editPic',
			buttons : [ {
				text : '编辑',
				handler : function() {
					var f = $('#updateImage');
					f.submit();
				}
			} ]
		});
	}
</script>
</head>
<body>
<div>
	<div id="aa"></div>
	<h2>${Corporate.supplierName }</h2>
	<div class="">
	<a id="btn"  class="easyui-linkbutton" data-options="iconCls:'icon-edit'"  onclick="edit()">编辑</a>
	<a id="btn"  class="easyui-linkbutton" data-options="iconCls:'icon-picture'"  onclick="showPic()">查看图片</a>
	<a id="btn"  class="easyui-linkbutton" data-options="iconCls:'icon-edit'"  onclick="editPic()">编辑图片</a>  
	</div>
	
	<ul class="easyui-datalist my_info">
		<li>
			<span class="name">单位地址：</span><span class="value">${Corporate.address }</span>
		</li>
		<li>
			<span class="name">联系人姓名:	</span><span class="value">${Corporate.corporation }</span>
		</li>
		<li>
			<span class="name">电话:	</span><span class="value">${Corporate.contactWay }</span>
		</li>
		<li>
			<span class="name">证件类型:	</span><span class="value"></span>
		</li>
		<li>
			<span class="cert">食品经营许可证:	</span><span class="value">${Corporate.foodBusinessCode }</span>
		</li>
		<li>
			<span class="cert">食品流通证号:	</span><span class="value">${Corporate.foodCirculationCode }</span>
		</li>
		<li>
			<span class="cert">食品生产证号:	</span><span class="value">${Corporate.foodProduceCode }</span>
		</li>
		<li>
			<span class="cert">工商执照号:	</span><span class="value">${Corporate.businessLicense }</span>
		</li>
	</ul>
		
</div>
</body>
</html>