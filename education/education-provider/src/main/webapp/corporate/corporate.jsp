<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript">

	function showPic(){
		parent.$.modalDialog({
			title : '查看图片',
			width :768,
			height : 480,
			href : '${pageContext.request.contextPath}/corporateController/showPic',
		});
	}

	function edit(){
 		$("#aa").dialog({    
		    title: '编辑',    
		    width: 500,    
		    height: 500,    
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
			width : 900,
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
	<div >
		<table class="table table-hover table-condensed">
			<tr style='height:100px;'>
				<th style="text-align:right; vertical-align:middle;"><a onclick="edit()">编辑</a></th>
				<th style='text-align:center; vertical-align:middle;'><a onclick="showPic()">查看图片</a></th>
				<th style='text-align:left; vertical-align:middle;'><a onclick="editPic()">编辑图片</a></th>
			</tr>
			<tr>
				<th style="text-align:right;">单位名称:</th>
				<td style='text-align:center;'>${Corporate.supplierName }</td>
				<td></td>
			</tr>
			<tr>
				<th style="text-align:right;">地址:</th>
				<td style='text-align:center;'>${Corporate.address }</td>
				<td></td>
			</tr>
			<tr>
				<th style="text-align:right;">联系人姓名:</th>
				<td style='text-align:center;'>${Corporate.corporation }</td>
				<td></td>
			</tr>
			<tr>
				<th style="text-align:right;">电话:</th>
				<td style='text-align:center;'>${Corporate.contactWay }</td>
				<td></td>
			</tr>
			<tr>
				<th style="text-align:right;">证件类型:</th>
				<th style='text-align:center;'>食品经营许可证:</th>
				<td >${Corporate.foodBusinessCode }</td>
			</tr>
			<tr>
				<th></th>
				<th style='text-align:center;'>食品流通证号:</th>
				<td>${Corporate.foodCirculationCode }</td>
			</tr>
			<tr>
				<th></th>
				<th style='text-align:center;'>食品生产证号:</th>
				<td>${Corporate.foodProduceCode }</td>
			</tr>
			<tr>
				<th ></th>
				<th style='text-align:center;'>工商执照号:</th>
				<td>${Corporate.businessLicense }</td>
			</tr>
			<tr ></tr>
		</table>
		<div id="aa"></div>
	</div>
</body>
</html>