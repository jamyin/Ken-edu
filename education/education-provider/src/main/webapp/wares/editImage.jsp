<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<style>
.panel-body {
	font-size: 18px !important;
}
</style>
<script type="text/javascript">

	$(function() {
		parent.$.messager.progress('close');


		$('#updateImage').form(
						{			
							url : '${pageContext.request.contextPath}/waresController/alterImage',
							onSubmit : function() {
								
								parent.$.messager.progress({
									title : '提示',
									text : '数据处理中，请稍后....'
								});
								var isValid = $(this).form('validate');
								if (!isValid) {
									parent.$.messager.progress('close');
								}
							
								return isValid;
							},
							success : function(result) {
								parent.$.messager.progress('close');
								result = $.parseJSON(result);
								
								if (result.success) {
									
									//$("#projectForm").submit();
									
									parent.$.modalDialog.openner_dataGrid
											.datagrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_dataGrid这个对象，是因为user.jsp页面预定义好了
									parent.$.modalDialog.handler
											.dialog('close');
								} else {
									parent.$.messager.alert('错误', result.msg,
											'error');
								}
							}
						});
	
	});

</script>
		<div class="easyui-layout" data-options="fit:true,border:false">
			<div data-options="region:'center',border:false" title=""
				style="overflow: hidden;">
				<form id="updateImage" method="post"  enctype="multipart/form-data">
				   <input id="id" name="id" type="hidden" value="${id}" />
				   <c:forEach  var="list"  items="${ProLicenseList}">
					<table>
							<tr>			
							<td>商品图片</td>
								<td><input type="file" name="spImgUrl"  id="spImgUrl"  accept="image/*" />	</td>	
							<c:if test="${list.licName=='商品图片' }"> 
									<td><img  src="${list.licPic }"></td>
									</c:if>
									</tr>
					
					<tr>		<td>检测检验报告</td>
							<td><input type="file" name="jcImgUrl"  id="jcImgUrl"  accept="image/*" /></td>
								<c:if test="${list.licName=='检测检验报告' }"> 
									<td><img  src="${list.licPic }"></td>
									</c:if>
							
								</tr>
							<tr><td>	生产许可证</td>
							<td>	<input type="file" name="scImgUrl"  id="jcImgUrl"  accept="image/*" /></td>	
								<c:if test="${list.licName=='生产许可证' }"> 
									<td><img  src="${list.licPic }"></td>
									</c:if>
							
							</tr>
						
		
			</table>
			</c:forEach>
				</form>
			</div>

		</div>

