<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.panel-body {
	font-size: 18px !important;
}
</style>
<style>

</style>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title=""
		style="overflow: hidden;">
			配送号：${LedgerList[0].wareBatchNo}  进货日期：<fmt:formatDate value="${LedgerList[0].actionDate}" pattern="yyyy-MM-dd"/> 配货点：${LedgerList[0].receiverName} 状态：
						<c:if test="${LedgerList[0].haulStatus ==0}">
							未配送
						</c:if>
						<c:if test="${LedgerList[0].haulStatus ==1}">
							配送中
						</c:if>
						<c:if test="${LedgerList[0].haulStatus ==2}">
							已配送
						</c:if>
			<table id="ledgers" class="table table-hover table-condensed">
					<tr>
						<th>采购品</th>
						<th>数量</th>	
						<th>规格</th>	
						<th>生产日期</th>
						<th>生产企业</th>
						<th>采购品供应商</th>
					</tr>
				<c:forEach var="ledger" items="${LedgerList}" varStatus="status">
					<tr>
						<td style='width:100px;'>${ledger.name}</td>
						<td style='width:100px;'>${ledger.quantity}</td>
						<td style='width:100px;'>${ledger.spce}</td>
						<td style='width:100px;'><fmt:formatDate value="${ledger.productionDate }" pattern="yyyy-MM-dd"/></td>
						<td style='width:100px;'>${ledger.productionName}</td>
						<td style='width:100px;'>${ledger.supplierName}</td>
					</tr>
				</c:forEach>
			</table>
			<table>
				<tr>
					<th>驾驶员：</th><td>${LedgerList[0].userName}</td>
				</tr>
				<tr>
					<th>出发点：</th><td>${LedgerList[0].sourceName}</td>
				</tr>
				<tr>
					<th>开始时间：</th><td></td>
				</tr>
				<tr>
					<th>目的地：</th><td>${LedgerList[0].receiverName}</td>
				</tr>
				<tr>
					<th>到达时间：</th><td></td>
				</tr>
			</table>
	</div>
</div>