<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.panel-body {
	font-size: 13px !important;
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
							var nextId=parseInt(lastId.substring(6))+1;
							var a=$(lastTr).html().replace(/ledger\[[0-9]+]/g,"ledger["+nextId+"]");
							var b="<tr id='ledger"+nextId+"'>"+a.replace('<td><a id="addLedger" ><font size="8" >+</font></a></td>',"")+"</tr>";
							var c=b.replace(/title=""/g,"");
							$(c).insertAfter($(lastTr));
							$("tr:last").find("input").each(function(){
								if($(this).attr("name")!="ledger["+nextId+"].mark"){
									$(this).removeAttr("value");
								}
							});
							$("<a id='subtract' onclick='subtractLedger(this);' data-id='ledger"+nextId+"' style='text-decoration:none;' ><font size='8' >-</font></a>").replaceAll("#ledger"+nextId+" a");
							$.parser.parse();
						});
	});
	
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
			<table id="ledgers" class="table table-hover table-condensed">
				<tr>
					<th style='width:70px;'>配货日期：</th>
					<td style='width:100px;'><input name="ledger[0].actionDate" type="text"
						style='width:100px;' class="span2" placeholder="点击选择日期" data-options="required:true"
						onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})"
						readonly="readonly"
						value="<fmt:formatDate value="${LedgerList[0].actionDate}" pattern="yyyy-MM-dd"/>"></td>
					<th style='width:70px;'>配货点：</th>
					<td style='width:100px;'><input name="ledger[0].receiverName" type="text"
						style='width:100px;' placeholder="请输入回收人配货点" class="easyui-validatebox span2"
						data-options="required:true" value="${LedgerList[0].receiverName}"></td>
					<th style='width:70px;'>配送号：</th>
					<td style='width:100px;'><input name="ledger[0].wareBatchNo" type="text"
						style='width:100px;' class="easyui-validatebox span2" readonly="readonly"
						value="${LedgerList[0].wareBatchNo}"></td>
					</tr>
					<tr>
					<th style='width:70px;'>驾驶员：</th>
					<td style='width:100px;'><select name="ledger[0].userId" type="text"
						style='width:100px;' placeholder="请选择驾驶员" class="easyui-validatebox span2">
						<c:if test="${LedgerList[0].userName} == null">
							<option selected="selected" value =null>请选择驾驶员</option>
						</c:if>
						<c:if test="${LedgerList[0].userName} != null">
							<option value =null>请选择驾驶员</option>
						</c:if>
						<option selected="selected" value =null>请选择驾驶员</option>
						<c:forEach items="${Driver}" var="user">
							<c:if test="${LedgerList[0].userName eq user.name}">
								<option selected="selected" value ="${user.id}">${user.name}</option>
							</c:if>
							<c:if test="${LedgerList[0].userName ne user.name}">
								<option  value ="${user.id}">${user.name}</option>
							</c:if>
						</c:forEach>
					</select></td>
					<th style='width:70px;'>配送状态：</th>
					<td style='width:100px;'><select name="ledger[0].haulStatus" type="text"
						style='width:100px;' placeholder="请选择驾驶员" class="easyui-validatebox span2">
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
				<c:forEach var="ledger" items="${LedgerList}" varStatus="status">
					<tr id="ledger${status.index}">
						<th style='width:70px;'>采购品：</th>
						<td style='width:100px;'><input name="ledger[${status.index }].name" type="text"
							style='width:100px;' placeholder="请输入采购品" class="easyui-validatebox span2"
							data-options="required:true" value="${ledger.name}"></td>
						<th style='width:70px;'>数量：</th>
						<td style='width:100px;'><input name="ledger[${status.index }].quantity"
							style='width:100px;' type="text" placeholder="请输入数量" class="easyui-validatebox span2"
							data-options="required:true" value="${ledger.quantity}"></td>
						<th style='width:70px;'>规格：</th>
						<td style='width:100px;'><input name="ledger[${status.index }].spce" type="text"
							style='width:100px;' placeholder="请输入规格" class="easyui-validatebox span2"
							data-options="required:true" value="${ledger.spce}"></td>
						<th style='width:70px;'>采购品供应商：</th>
						<td style='width:100px;'><input name="ledger[${status.index }].supplierName"
							style='width:100px;' type="text" placeholder="请输入供应商" class="easyui-validatebox span2"
							value="${ledger.supplierName}"></td>
						<th style='width:70px;'>生产企业：</th>
						<td style='width:100px;'><input name="ledger[${status.index }].productionName"
							type="text" placeholder="请输入生产单位"
							style='width:100px;' class="easyui-validatebox span2" 
							value="${ledger.productionName}"></td>
						<th style='width:70px;'>生产日期：</th>
						<td style='width:100px;'><input name="ledger[${status.index }].productionDate"
							style='width:100px;' type="text" placeholder="点击选择日期" class="easyui-validatebox span2"
							onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})"
							readonly="readonly"
							value="<fmt:formatDate value="${ledger.productionDate }" pattern="yyyy-MM-dd"/>"></td>
						<td style='width:100px;'><input name="ledger[${status.index }].id" type="hidden"
							class="easyui-validatebox span2" data-options="required:true" value="${ledger.id}"></td>
						<td>
							<c:if test="${status.index != 0}">
								<a id='subtract' onclick='subtractLedger(this);' data-id='ledger${status.index }' style='text-decoration:none;' ><font size='8' >-</font></a>
							</c:if>
							<c:if test="${status.index == 0}">
								<a id="addLedger" style='text-decoration:none;' ><font size="8" >+</font></a>
							</c:if>
						</td>
						<td><input type="hidden" name="ledger[${status.index }].mark" value="1" ></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
</div>