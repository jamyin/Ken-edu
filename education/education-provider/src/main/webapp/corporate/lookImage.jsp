<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript">
		$(function() {
			parent.$.messager.progress('close');
		});
</script>
</head>
<body>
	<c:forEach  var="list"  items="${ProLicenseList}">
	
	<c:if test="${list.licName=='工商营业执照' }"> 
	<tr>
	<th>工商营业执照</th>
	<td><img src="${list.licPic }" /></td>	</tr>
	</c:if>
	
	<c:if test="${list.licName=='组织机构代码' }">
	<tr>
	<th>组织机构代码</th>
	<td><img src="${list.licPic }" /></td>	</tr>
	</c:if>
	<c:if test="${list.licName=='税务登记证' }">
	<tr>
	<th>税务登记证</th>
	<td><img src="${list.licPic }" /></td>	</tr>
	</c:if>	
	<c:if test="${list.licName=='身份证' }"> 
	<tr>
	<th>身份证</th>
	<td><img src="${list.licPic }" /></td>	</tr>
	</c:if>
	
	<c:if test="${list.licName=='港澳居民来往内地通行证' }">
	<tr>
	<th>港澳居民来往内地通行证</th>
	<td><img src="${list.licPic }" /></td>	</tr>
	</c:if>
	<c:if test="${list.licName=='台湾居民往来内地通行证'}">
	<tr>
	<th>台湾居民往来内地通行证</th>
	<td><img src="${list.licPic }" /></td>	</tr>
	</c:if>	
	<c:if test="${list.licName=='食品流通许可证'}"> 
	<tr>
	<th>食品流通许可证</th>
	<td><img src="${list.licPic }" /></td>	</tr>
	</c:if>	
	<c:if test="${list.licName=='食品生产许可证' }">
	<tr>
	<th>食品生产许可证</th>
	<td><img src="${list.licPic }" /></td>	</tr>
	</c:if>
<c:if test="${list.licName=='餐饮服务许可证' }">
	<tr>
	<th>餐饮服务许可证</th>
	<td><img src="${list.licPic }" /></td>	</tr>
	</c:if>	
	
	<c:if test="${list.licName=='食品经营许可证' }"> 
	<tr>
	<th>食品经营许可证</th>
	<td><img src="${list.licPic }" /></td>	</tr>
	</c:if>
	<c:if test="${list.licName=='其他' }"> 
	<tr>
	<th>其他</th>
	<td><img src="${list.licPic }" /></td>	</tr>
	</c:if>
	
	</c:forEach>	
				
</body>
</html>