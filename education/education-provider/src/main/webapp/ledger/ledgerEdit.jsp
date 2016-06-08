<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		$('#form')
				.form(
						{
							url : '${pageContext.request.contextPath}/ledgerController/ledgerEdit',
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
		var ltr='<td style="width:100px;"><input name="ledger[0].name" style="width:100px;" type="text" placeholder="请输入采购品" class="easyui-validatebox span2" data-options="required:true"></td><td style="width:100px;"><input name="ledger[0].quantity" style="width:100px;" type="text" placeholder="请输入数量" class="easyui-validatebox span2" data-options="required:true"></td><td style="width:100px;"><input name="ledger[0].spce" style="width:100px;" type="text" placeholder="请输入规格" class="easyui-validatebox span2" data-options="required:true"></td><td style="width:100px;"><input name="ledger[0].supplierName" style="width:100px;" type="text" placeholder="请输入供应商" class="easyui-validatebox span2"></td><td style="width:100px;"><input name="ledger[0].productionName" style="width:100px;" type="text" placeholder="请输入生产单位" class="easyui-validatebox span2"></td><td style="width:100px;"><input name="ledger[0].productionDate" style="width:100px;cursor:pointer;" type="text" placeholder="点击选择日期" class="easyui-validatebox span2" onclick="WdatePicker({readOnly:true,dateFmt:\'yyyy-MM-dd\'})" readonly="readonly"></td><td><a></a></td><td><input type="hidden" name="ledger[0].mark" value="1" ></td>';
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
		<form id="form" method="post" >
			<table class="table table-hover table-condensed">
				<tr>
					<th style='width:65px;'>配货日期：</th>
					<td style='width:104px;'><input name="ledger[0].actionDate" type="text"
						style='width:104px;cursor:pointer;' class="span2" placeholder="点击选择日期" data-options="required:true"
						onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})"
						readonly="readonly"
						value="<fmt:formatDate value="${LedgerList[0].actionDate}" pattern="yyyy-MM-dd"/>"></td>
					<th style='width:65px;'>配货点：</th>
					<td style='width:104px;'><input name="ledger[0].receiverName" type="text"
						style='width:104px;' placeholder="请输入配货点" class="easyui-validatebox span2"
						data-options="required:true" value="${LedgerList[0].receiverName}"></td>
					<th style='width:65px;'>配送号：</th>
					<td style='width:104px;'><input name="ledger[0].wareBatchNo" type="text"
						style='width:104px;' class="easyui-validatebox span2" readonly="readonly"
						value="${LedgerList[0].wareBatchNo}"></td>
					</tr>
					<tr>
					<th style='width:65px;'>驾驶员：</th>
					<td style='width:104px;'><select name="ledger[0].userId" type="text"
						style='width:118px;' placeholder="请选择驾驶员" class="easyui-validatebox span2">
						<c:if test="${LedgerList[0].userName} == null">
							<option selected="selected" value ="">请选择驾驶员</option>
						</c:if>
						<c:if test="${LedgerList[0].userName} != null">
							<option value ="">请选择驾驶员</option>
						</c:if>
						<option selected="selected" value ="">请选择驾驶员</option>
						<c:forEach items="${Driver}" var="user">
							<c:if test="${LedgerList[0].userName eq user.name}">
								<option selected="selected" value ="${user.id}">${user.name}</option>
							</c:if>
							<c:if test="${LedgerList[0].userName ne user.name}">
								<option  value ="${user.id}">${user.name}</option>
							</c:if>
						</c:forEach>
					</select></td>
					<th style='width:65px;'>配送状态：</th>
					<td style='width:104px;'><select name="ledger[0].haulStatus" type="text"
						style='width:118px;' placeholder="请选择驾驶员" class="easyui-validatebox span2">
						<c:if test="${LedgerList[0].haulStatus ==0}">
							<option selected="selected" value ="0">未配送</option>
						</c:if>
						<c:if test="${LedgerList[0].haulStatus !=0}">
							<option value ="0">未配送</option>
						</c:if>
						<c:if test="${LedgerList[0].haulStatus ==1}">
							<option selected="selected" value ="1">配送中</option>
						</c:if>
						<c:if test="${LedgerList[0].haulStatus !=1}">
							<option value ="1">配送中</option>
						</c:if>
						<c:if test="${LedgerList[0].haulStatus ==2}">
							<option selected="selected" value ="2">已配送</option>
						</c:if>
						<c:if test="${LedgerList[0].haulStatus !=2}">
							<option value ="2">已配送</option>
						</c:if>
					</select></td>
					<td style='width:70px;'><input name="ledger[0].masterId" type="hidden"
						style='width:100px;' class="easyui-validatebox span2"
						value="${LedgerList[0].masterId}"></td>
				</tr>
			</table>
			<table id="ledgers" class="table table-hover table-condensed">
					<tr>
						<th style='width:114px;'>采购品：</th>
						<th style='width:114px;'>数量：</th>
						<th style='width:114px;'>规格：</th>
						<th style='width:114px;'>采购品供应商：</th>
						<th style='width:114px;'>生产企业：</th>
						<th style='width:114px;'>生产日期：</th>
						<th ></th>
					</tr>
				<c:forEach var="ledger" items="${LedgerList}" varStatus="status">
					<tr id="ledger${status.index}">
						<td><input name="ledger[${status.index }].name" type="text"
							style='width:100px;' placeholder="请输入采购品" class="easyui-validatebox span2"
							data-options="required:true" value="${ledger.name}"></td>
						<td><input name="ledger[${status.index }].quantity"
							style='width:100px;' type="text" placeholder="请输入数量" class="easyui-validatebox span2"
							data-options="required:true" value="${ledger.quantity}"></td>
						<td><input name="ledger[${status.index }].spce" type="text"
							style='width:100px;' placeholder="请输入规格" class="easyui-validatebox span2"
							data-options="required:true" value="${ledger.spce}"></td>
						<td><input name="ledger[${status.index }].supplierName"
							style='width:100px;' type="text" placeholder="请输入供应商" class="easyui-validatebox span2"
							value="${ledger.supplierName}"></td>
						<td><input name="ledger[${status.index }].productionName"
							type="text" placeholder="请输入生产单位"
							style='width:100px;' class="easyui-validatebox span2" 
							value="${ledger.productionName}"></td>
						<td><input name="ledger[${status.index }].productionDate"
							style='width:100px;cursor:pointer;' type="text" placeholder="点击选择日期" class="easyui-validatebox span2"
							onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})"
							readonly="readonly"
							value="<fmt:formatDate value="${ledger.productionDate }" pattern="yyyy-MM-dd"/>"></td>
						<td>
								<a id='subtract' onclick='subtractLedger(this);' data-id='ledger${status.index }' style='text-decoration:none;cursor:pointer;' ><font size='8' >-</font></a>
						</td>
						<td ><input name="ledger[${status.index }].id" type="hidden"
							class="easyui-validatebox span2" data-options="required:true" value="${ledger.id}"></td>
						<td><input type="hidden" name="ledger[${status.index }].mark" value="1" ></td>
					</tr>
				</c:forEach>
			</table>
							<div align="center"><a id="addLedger" style='text-decoration:none;cursor:pointer;' ><font size="8" >+</font></a></div>
		</form>
	</div>
</div>
