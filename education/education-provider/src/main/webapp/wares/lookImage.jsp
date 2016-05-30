<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<style>
.panel-body {
	font-size: 18px !important;
}
</style>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<c:forEach  var="list"  items="${ProLicenseList}">
	
	<c:if test="${list.licName=='商品图片' }"> 
	<tr>
	<th>商品图片</th>
	<td><img src="${list.licPic }" /></td>	</tr>
	</c:if>
	
	<c:if test="${list.licName=='检测检验报告' }">
	<tr>
	<th>检测检验报告</th>
	<td><img src="${list.licPic }" /></td>	</tr>
	</c:if>
	<c:if test="${list.licName=='生产许可证' }">
	<tr>
	<th>生产许可证</th>
	<td><img src="${list.licPic }" /></td>	</tr>
	</c:if>	
	</c:forEach>	
				
</body>
</html>