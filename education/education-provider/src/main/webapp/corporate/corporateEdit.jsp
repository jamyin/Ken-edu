<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>

.table th{    
width: 100px;
text-align: right;
}

</style>
<script type="text/javascript">
	$(function() {
		parent.$.messager.progress('close');
		$('#form')
				.form(
						{
							url : '${pageContext.request.contextPath}/corporateController/corporateEdit',
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
									window.parent.document.getElementById('indexContext').src="${pageContext.request.contextPath}/corporateController/manager";
									parent.$.modalDialog.handler.dialog('close'); 
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
		<form id="form" method="post">
			<table class="table" style="width:400px;">
				<tr>
					<th>单位名称:</th>
					<td><input name="supplierName" type="text"
						class="span2" placeholder="请输入单位名称" data-options="required:true"
						value="${Corporate.supplierName }" ></td>
				</tr>
				<tr>
					<th>单位地址:</th>
					<td><input name="address" type="text"
						placeholder="请输入单位地址" class="easyui-validatebox span2"
						data-options="required:true" value="${Corporate.address }"></td>
				</tr>
				<tr>
					<th>联系人姓名:</th>
					<td><input name="corporation" type="text"
						class="easyui-validatebox span2"
						value="${Corporate.corporation }"></td>
				</tr>
				<tr>
					<th>联系方式:</th>
					<td><input name="contactWay" type="text"
						class="easyui-validatebox span2"
						value="${Corporate.contactWay }"></td>
				</tr>
				<tr>
					<th>证件类型:</th>
					<th>餐饮服务证号:</th>
					<td><input name="foodServiceCode"
						type="text" placeholder="请输入餐饮服务证号" class="easyui-validatebox span2"
						value="${Corporate.foodServiceCode }"></td>
				</tr>
				<tr>
					<th></th>
					<th>食品经营许可证:</th>
					<td><input name="foodBusinessCode" type="text"
						placeholder="请输入食品经营许可证号" class="easyui-validatebox span2"
						value="${Corporate.foodBusinessCode }"></td>
				</tr>
				<tr>
					<th></th>
					<th>食品流通证号:</th>
					<td><input name="foodCirculationCode"
						type="text" placeholder="请输入食品流通证号" class="easyui-validatebox span2"
						value="${Corporate.foodCirculationCode }"></td>
				</tr>
				<tr>
					<th></th>
					<th>食品生产证号:</th>
					<td><input name="foodProduceCode" type="text"
						placeholder="请输入食品生产证号" class="easyui-validatebox span2"
						value="${Corporate.foodProduceCode }"></td>
				</tr>
				<tr>	
					<th></th>
					<th>工商执照号:</th>
					<td><input name="businessLicense"
						type="text" placeholder="请输入工商执照号" class="easyui-validatebox span2"
						value="${Corporate.businessLicense }"></td>
				</tr>
			</table>
		</form>
	</div>
</div>