<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(function() {
		parent.$.messager.progress('close');
		$('#form').form({
			url : '${pageContext.request.contextPath}/proSupplierController/proSupplierEdit',
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
					parent.$.modalDialog.openner_dataGrid.datagrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_dataGrid这个对象，是因为user.jsp页面预定义好了
					parent.$.modalDialog.handler.dialog('close');
				} else {
					parent.$.messager.alert('错误', result.msg, 'error');
				}
			}
		});
	});
	
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title="" style="overflow: hidden;">
		<form id="form" method="post">
			<table class="table table-hover table-condensed">
				<tr>
					<th>编号</th>
					<td><input name="id" type="text" class="span2" value="${ProSupplie.id}" readonly="readonly"></td>
					<th>供应商名称</th>
					<td><input name="supplierName" type="text" placeholder="请输入供应商名称" class="easyui-validatebox span2" data-options="required:true" value="${ProSupplie.supplierName}" ></td>
				</tr>
				<tr>
					<th>供应商地址</th>
					<td><input name="address" type="text" placeholder="请输入供应商地址" class="easyui-validatebox span2" data-options="required:true" value="${ProSupplie.address}" ></td>
					
					<th>供应商类型</th>
					<td><input name="supplierType" type="text" placeholder="请输入供应商类型" class="easyui-validatebox span2"  value="${ProSupplie.supplierType}" ></td>
				</tr>
				<tr>
					<th>工商执照号</th>
					<td><input name="businessLicense" type="text" placeholder="请输入工商执照号" class="easyui-validatebox span2" data-options="required:true" value="${ProSupplie.businessLicense}"></td>
					<th>组织机构代码</th>
					<td><input name="organizationCode" type="text" placeholder="请输入组织机构代码" class="easyui-validatebox span2" data-options="required:true"  value="${ProSupplie.organizationCode}" ></td>
				</tr>
				<tr>
					<th>法人代表</th>
						<td><input name="corporation" type="text" placeholder="请输入法人代表" class="easyui-validatebox span2" data-options="required:true" value="${ProSupplie.corporation}" ></td>
					<th>联系方式</th>
						<td><input name="contactWay" type="text" placeholder="请输入联系方式" class="easyui-validatebox span2" data-options="required:true" value="${ProSupplie.contactWay}" ></td>
				</tr>
				<tr>
					<th>精度</th>
						<td><input name="longitude" type="text" placeholder="请输入精度" class="easyui-validatebox span2" data-options="required:true" value="${ProSupplie.longitude}" ></td>
					<th>维度</th>
						<td><input name="latitude" type="text" placeholder="请输入维度" class="easyui-validatebox span2" data-options="required:true" value="${ProSupplie.latitude}" ></td>
				</tr>
				<tr>
					<th>省</th>
						<td><input name="provinces" type="text" placeholder="请输入省" class="easyui-validatebox span2" data-options="required:true" value="${ProSupplie.provinces}" ></td>
					<th>市</th>
						<td><input name="city" type="text" placeholder="请输入市" class="easyui-validatebox span2" data-options="required:true" value="${ProSupplie.city}" ></td>
				</tr>
				<tr>
					<th>区</th>
						<td><input name="area" type="text" placeholder="请输入区" class="easyui-validatebox span2" data-options="required:true" value="${ProSupplie.area}" ></td>
				</tr>
			</table>
		</form>
	</div>
</div>