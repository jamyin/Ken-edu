<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(function() {
		parent.$.messager.progress('close');
		$('#form').form({
			url : '${pageContext.request.contextPath}/ledgerController/saveLedger',
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
		<form id="form" method="post" >
			<table class="table table-hover table-condensed">
				<tr>
					<th>进货日期：</th>
					<td><input name="ledger[0].actionDate" type="text" class="span2" placeholder="点击选择日期" data-options="required:true" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" readonly="readonly"></td>
					<th>配货点：</th>
					<td><input name="ledger[0].receiverName" type="text" placeholder="请输入回收人配货点" class="easyui-validatebox span2" data-options="required:true" ></td>
				</tr>
				<tr>
					<th>批次号：</th>
					<td><input name="ledger[0].wareBatchNo" type="text" class="easyui-validatebox span2" ></td>
					<th>驾驶员：</th>
					<td><input name="ledger[0].userName" type="text" placeholder="请输入驾驶员" class="easyui-validatebox span2" data-options="required:true" value="${Driver[0].name}" ></td>
				</tr>
				<tr>
					<th>采购品：</th>
					<td><input name="ledger[0].name" type="text" placeholder="请输入采购品" class="easyui-validatebox span2" data-options="required:true" ></td>
					<th>数量：</th>
						<td><input name="ledger[0].quantity" type="text" placeholder="请输入数量" class="easyui-validatebox span2" data-options="required:true" ></td>
					<th>规格：</th>
						<td><input name="ledger[0].spce" type="text" placeholder="请输入规格" class="easyui-validatebox span2" data-options="required:true" ></td>
					<th>供应商名称：</th>
						<td><input name="ledger[0].supplierName" type="text" placeholder="请输入供应商" class="easyui-validatebox span2" data-options="required:true" ></td>
					<th>生产单位：</th>
						<td><input name="ledger[0].productionName" type="text" placeholder="请输入生产单位" class="easyui-validatebox span2" data-options="required:true" ></td>
					<th>生产日期：</th>
						<td><input name="ledger[0].productionDate" type="text" placeholder="点击选择日期" class="easyui-validatebox span2" data-options="required:true" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" readonly="readonly"></td>
				</tr>
				<tr>
		</form>
	</div>
</div>