<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<style>
.panel-body {
	font-size: 18px !important;
	
}
.table th, .table td {
    border-top: none!important;
}
.panel-body.panel-body-noheader.panel-body-noborder.layout-body {
	padding:20px!important;
}
</style>
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
		  <input id="id" name="id" type="hidden" value="${ProSupplie.id}" />
			<table class="table table-hover table-condensed">
				<tr>					
					<th>*供应商名称</th>
					<td><input name="supplierName" type="text" placeholder="请输入供应商名称" class="easyui-validatebox span2" data-options="required:true" value="${ProSupplie.supplierName}" ></td>
				
						<th>供应商编码</th>
						<td><input name="supplierCode" type="text" class="easyui-validatebox span2"  value="${ProSupplie.supplierCode}" ></td>
			
				<tr>
					<th>*供应商地址</th>
					<td><input name="address" type="text" placeholder="请输入供应商地址" class="easyui-validatebox span2" data-options="required:true"  value="${ProSupplie.address}" ></td>
					<th>联系人</th>
						<td><input name="corporation" type="text" placeholder="请输入联系人" class="easyui-validatebox span2"  value="${ProSupplie.corporation}" ></td>					
				</tr>
				<tr>
					<th>联系方式</th>
						<td><input name="contactWay" type="text" placeholder="请输入联系方式" class="easyui-validatebox span2"  value="${ProSupplie.contactWay}" ></td>
				<th>工商执照号</th>
					<td><input name="businessLicense" type="text" placeholder="请输入工商执照号" class="easyui-validatebox span2"  value="${ProSupplie.businessLicense}"></td>
						
				</tr>
			
				
		
				<tr>
				<th>餐饮服务证号</th>
						<td><input name="foodServiceCode" type="text" class="easyui-validatebox span2"  value="${ProSupplie.foodServiceCode}" ></td>
				
					<th>食品经营许可证号</th>
						<td><input name="foodBusinessCode" type="text" class="easyui-validatebox span2"  value="${ProSupplie.foodBusinessCode}" ></td>
					</tr>
				<tr>
					<th>食品流通证号</th>
						<td><input name="foodCirculationCode" type="text" class="easyui-validatebox span2"  value="${ProSupplie.foodCirculationCode}" ></td>
					<th>食品生产证号</th>
						<td><input name="foodProduceCode" type="text" class="easyui-validatebox span2" value="${ProSupplie.foodProduceCode}" ></td>
						
						</tr>
									
			
			</table>
		</form>
	</div>
</div>
<script type="text/javascript">
$(function(){
	$("td,th").css("vertical-align","middle");
	$('td input').css("margin-top","8px");
	$('table tr:first:child td').css("border-top","none");
});
</script>