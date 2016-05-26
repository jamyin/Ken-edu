<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	
	<table>
	<tr>
		<th>企业三证</th>
	</tr>
	<tr>
	<td>
	<c:forEach  var="list"  items="${ProLicenseList}">
	<c:if test="${list.licName=='工商营业执照' }"> 
	<img src="${list.licPic }" />	
	</c:if>
	</c:forEach>
	</td>
	<td>
	<c:forEach  var="list"  items="${ProLicenseList}">
	<c:if test="${list.licName=='组织机构代码' }">
	<img src="${list.licPic }" />	
	</c:if>
	</c:forEach>
	</td>
	<td>
	<c:forEach  var="list"  items="${ProLicenseList}">
	<c:if test="${list.licName=='税务登记证' }">
	<img src="${list.licPic }" />	
	</c:if>	
	</c:forEach>
	</td>
	</tr>
	<tr>
		<th>工商营业执照</th>
		<th>组织机构代码</th>
		<th>税务登记证</th>
	</tr>
	<tr>
		<th>许可证</th>
	</tr>
	
	<tr>
	<td>
	<c:forEach  var="list"  items="${ProLicenseList}">
	<c:if test="${list.licName=='食品流通许可证'}"> 
	<img src="${list.licPic }" />
	</c:if>	
	</c:forEach>
	</td>
	<td>
	<c:forEach  var="list"  items="${ProLicenseList}">
	<c:if test="${list.licName=='食品生产许可证' }">
	<img src="${list.licPic }" />
	</c:if>
	</c:forEach>
	</td>
	<td>
	<c:forEach  var="list"  items="${ProLicenseList}">
	<c:if test="${list.licName=='餐饮服务许可证' }">
	<img src="${list.licPic }" />
	</c:if>	
	</c:forEach>
	</td>
	<td>
	<c:forEach  var="list"  items="${ProLicenseList}">
	<c:if test="${list.licName=='食品经营许可证' }"> 
	<img src="${list.licPic }" />
	</c:if>
	</c:forEach>
	</td>
	</tr>
	<tr>
	<th>食品流通许可证</th>
	<th>食品生产许可证</th>
	<th>餐饮服务许可证</th>
	<th>食品经营许可证</th>
	</tr>
	<tr>
		<th>法定代表人/负责人/业主证件</th>
	</tr>
	<tr>
	<td>
	<c:forEach  var="list"  items="${ProLicenseList}">
	<c:if test="${list.licName=='身份证' }"> 
	<img src="${list.licPic }" />
	</c:if>
	</c:forEach>
	</td>	
	<td>
	<c:forEach  var="list"  items="${ProLicenseList}">
	<c:if test="${list.licName=='港澳居民来往内地通行证' }">
	<img src="${list.licPic }" />
	</c:if>
	</c:forEach>
	</td>	
	<td>
	<c:forEach  var="list"  items="${ProLicenseList}">
	<c:if test="${list.licName=='台湾居民往来内地通行证'}">
	<img src="${list.licPic }" />
	</c:if>	
	</c:forEach>
	</td>	
	</tr>
	<tr>
	<th>身份证</th>
	<th>港澳居民来往内地通行证</th>
	<th>台湾居民往来内地通行证</th>
	</tr>
	<tr>
		<th>其他</th>
	</tr>
	<tr>
	<td>
	<c:forEach  var="list"  items="${ProLicenseList}">
	<c:if test="${list.licName=='其他' }"> 
	<img src="${list.licPic }" />
	</c:if>
	</c:forEach>	
	</td>
	</tr>
	<tr>
	<th>其他</th>
	</tr>
	</table>		
</body>
</html>