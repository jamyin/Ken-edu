<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
							var nextId=parseInt(lastId.substring(6))+1;
							var a=$(lastTr).html().replace(/ledger\[[0-9]+]/g,"ledger["+nextId+"]");
							var b="<tr id='ledger"+nextId+"'>"+a.replace('<td><a id="addLedger" ><font size="15" >+</font></a></td>',"")+"</tr>";
							var c=b.replace(/title=""/g,"");
							$(c).insertAfter($(lastTr));
							$("#ledger"+nextId+" a").remove();
							$.parser.parse();
						});
	});
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title=""
		style="overflow: hidden;">
		<form id="form" method="post">
			<table id="ledgers" class="table table-hover table-condensed">
				<tr >
					<th style='width:70px;'>进货日期：</th>
					<td style='width:100px;'><input name="ledger[0].actionDate" style='width:100px;' type="text"
						class="span2" placeholder="点击选择日期" data-options="required:true"
						onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})"
						readonly="readonly"></td>
					<th style='width:70px;'>配货点：</th>
					<td style='width:100px;'><input name="ledger[0].receiverName" style='width:100px;' type="text"
						placeholder="请输入回收人配货点" class="easyui-validatebox span2"
						data-options="required:true"></td>
					<th style='width:70px;'>驾驶员：</th>
					<td style='width:100px;'><select name="ledger[0].userId" style='width:100px;' type="text"
						placeholder="请选择驾驶员" class="easyui-validatebox span2"
						data-options="required:true">
						<c:forEach items="${Driver}" var="user">
							<option value ="${user.id}">${user.name}</option>
						</c:forEach>
						</select></td>
					<th>批次号：</th>
					<td><input name="ledger[0].wareBatchNo" style='width:100px;' type="text"
						placeholder="请输入回收人批次号" class="easyui-validatebox span2"
						data-options="required:true"></td>
				</tr>
				<tr id="ledger0">
					<th style='width:70px;'>采购品：</th>
					<td style='width:100px;'><input name="ledger[0].name" style='width:100px;' type="text"
						placeholder="请输入采购品" class="easyui-validatebox span2"
						data-options="required:true"></td>
					<th style='width:70px;'>数量：</th>
					<td style='width:100px;'><input name="ledger[0].quantity" style='width:100px;' type="text"
						placeholder="请输入数量" class="easyui-validatebox span2"
						data-options="required:true"></td>
					<th style='width:70px;'>规格：</th>
					<td style='width:100px;'><input name="ledger[0].spce" style='width:100px;' type="text"
						placeholder="请输入规格" class="easyui-validatebox span2"
						data-options="required:true"></td>
					<th style='width:70px;'>供应商名称：</th>
					<td style='width:100px;'><input name="ledger[0].supplierName" style='width:100px;' type="text"
						placeholder="请输入供应商" class="easyui-validatebox span2"
						data-options="required:true"></td>
					<th style='width:70px;'>生产单位：</th>
					<td style='width:100px;'><input name="ledger[0].productionName" style='width:100px;' type="text"
						placeholder="请输入生产单位" class="easyui-validatebox span2"
						data-options="required:true"></td>
					<th style='width:70px;'>生产日期：</th>
					<td style='width:100px;'><input name="ledger[0].productionDate" style='width:100px;' type="text"
						placeholder="点击选择日期" class="easyui-validatebox span2"
						data-options="required:true"
						onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})"
						readonly="readonly"></td>
					<td><a id="addLedger" ><font size="15" >+</font></a></td>
				</tr>
				</table>
				</form>
				</div>
				</div>