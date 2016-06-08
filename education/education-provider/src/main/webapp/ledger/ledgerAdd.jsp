<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.panel-body {
	font-size: 13px !important;
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
		
		
	});
	$('#form').form(
			{
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

	$(function() {
		$("#addLedger")
				.click(
						function() {
							var lastTr = $("tr:last");
							var lastId = $(lastTr).attr("id");
							if(lastId==null){
								nextId=0;
							}else{
								var nextId=parseInt(lastId.substring(6))+1;
							}
							var a=ledgerTr().replace(/ledger\[[0-9]+]/g,"ledger["+nextId+"]");
							var b="<tr id='ledger"+nextId+"'>"+a+"</tr>";
							var c=b.replace(/title=""/g,"");
							$(c).insertAfter($(lastTr));
							$("<a onclick='subtractLedger(this);' data-id='ledger"+nextId+"' style='text-decoration:none;cursor:pointer;' ><font size='8' >-</font></a>").replaceAll("#ledger"+nextId+" a");
							$.parser.parse();
						});
	});
	
	function ledgerTr(){
		var ltr='<td style="width:95px;"><input name="ledger[0].name" style="width:95px;" type="text" placeholder="请输入采购品" class="easyui-validatebox span2" data-options="required:true"></td><td style="width:95px;"><input name="ledger[0].quantity" style="width:95px;" type="text" placeholder="请输入数量" class="easyui-validatebox span2" data-options="required:true"></td><td style="width:95px;"><input name="ledger[0].spce" style="width:95px;" type="text" placeholder="请输入规格" class="easyui-validatebox span2" data-options="required:true"></td><td style="width:95px;"><input name="ledger[0].supplierName" style="width:95px;" type="text" placeholder="请输入供应商" class="easyui-validatebox span2"></td><td style="width:95px;"><input name="ledger[0].productionName" style="width:95px;" type="text" placeholder="请输入生产单位" class="easyui-validatebox span2"></td><td style="width:95px;"><input name="ledger[0].productionDate" style="width:95px;cursor:pointer;" type="text" placeholder="点击选择日期" class="easyui-validatebox span2" onclick="WdatePicker({readOnly:true,dateFmt:\'yyyy-MM-dd\'})" readonly="readonly"></td><td><a></a></td><td><input type="hidden" name="ledger[0].mark" value="1" ></td>';
		return ltr;
	}
	
	function subtractLedger(_this){
		var id=$(_this).attr("data-id");
		$("#"+id).remove();
		$.parser.parse();
	}
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title=""
		style="overflow-x: hidden; overflow-y: auto;">
		<form id="form" method="post">
			<table class="table table-hover table-condensed">
				<tr >
					<th style='width:90px;'>*配货日期：</th>
					<td style='width:104px;'><input name="ledger[0].actionDate" style='width:104px;cursor:pointer;' type="text"
						class="span2" placeholder="点击选择日期" data-options="required:true"
						onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})"
						readonly="readonly"></td>
					<th style='width:70px;'>*配货点：</th>
					<td style='width:104px;'><input name="ledger[0].receiverName" style='width:104px;' type="text"
						placeholder="请输入回收人配货点" class="easyui-validatebox span2"
						data-options="required:true"></td>
				</tr>
				<tr>
					<th style='width:70px;'>驾驶员：</th>
					<td style='width:104px;'><select name="ledger[0].userId" style='width:118px;' type="text"
						placeholder="请选择驾驶员" class="easyui-validatebox span2">
						<option selected="selected" value =null>请选择驾驶员</option>
						<c:forEach items="${Driver}" var="user">
							<option value ="${user.id}">${user.name}</option>
						</c:forEach>
						</select></td>
					<th style='width:70px;'>*配送号：</th>
					<td><input name="ledger[0].wareBatchNo" style='width:104px;' type="text"
						placeholder="请输入回收人批次号" class="easyui-validatebox span2"
						data-options="required:true"></td>
				</tr>
				</table>
			<table id="ledgers" class="table table-hover table-condensed">
				<tr>
					<th style='width:109px;'>*采购品：</th>
					<th style='width:109px;'>*数量：</th>
					<th style='width:109px;'>*规格：</th>
					<th style='width:109px;'>采购品供应商：</th>
					<th style='width:109px;'>生产企业：</th>
					<th style='width:109px;'>生产日期：</th>
					<th ></th>
				</tr>
				<tr id="ledger0">
					<td style="width:95px;">
						<input name="ledger[0].name" style="width:95px;" type="text" placeholder="请输入采购品" class="easyui-validatebox span2" data-options="required:true">
					</td>
					<td style="width:95px;">
						<input name="ledger[0].quantity" style="width:95px;" type="text" placeholder="请输入数量" class="easyui-validatebox span2" data-options="required:true">
					</td>
					<td style="width:95px;">
						<input name="ledger[0].spce" style="width:95px;" type="text" placeholder="请输入规格" class="easyui-validatebox span2" data-options="required:true">
					</td>
					<td style="width:95px;">
						<input name="ledger[0].supplierName" style="width:95px;" type="text" placeholder="请输入供应商" class="easyui-validatebox span2">
					</td>
					<td style="width:95px;">
						<input name="ledger[0].productionName" style="width:95px;" type="text" placeholder="请输入生产单位" class="easyui-validatebox span2">
					</td>
					<td style="width:95px;">
						<input name="ledger[0].productionDate" style="width:95px;cursor:pointer;" type="text" placeholder="点击选择日期" class="easyui-validatebox span2" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" readonly="readonly">
					</td>
					<td>
						<a onclick='subtractLedger(this);' data-id='ledger0' style='text-decoration:none;cursor:pointer;' ><font size='8' >-</font></a>
					</td>
					<td>
						<input type="hidden" name="ledger[0].mark" value="1" >
					</td>
				</tr>
				</table>
				<div align="center"><a id="addLedger" style='text-decoration:none;cursor:pointer;' ><font size="8" >+</font></a></div>
				</form>
				</div>
				</div>
