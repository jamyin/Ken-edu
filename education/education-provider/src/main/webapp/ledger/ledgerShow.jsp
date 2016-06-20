<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.panel-body {
	font-size: 18px !important;
}
.table th, .table td {
    border-top: none!important;
}
</style>

<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title=""
		style="overflow-x: hidden; overflow-y: auto;">
		<table id="ledgers" class="table table-hover table-condensed">
			<tr>
				<th>配送号：</th><td>${LedgerList[0].wareBatchNo}</td>
				<th>配送日期：</th><td><fmt:formatDate value="${LedgerList[0].actionDate}" pattern="yyyy-MM-dd"/></td>
				<th>配货点：</th><td>${LedgerList[0].receiverName}</td>
				<th>状态：</th><td><c:if test="${LedgerList[0].haulStatus ==0}">
							未配送
						</c:if>
						<c:if test="${LedgerList[0].haulStatus ==1}">
							配送中
						</c:if>
						<c:if test="${LedgerList[0].haulStatus ==2}">
							已配送
						</c:if></td>
			</tr>
		</table>
			<table id="ledgers" class="table table-hover table-condensed">
					<tr>
						<th>原料</th>
						<th>数量</th>	
						<th>数量单位</th>	
						<th>生产日期</th>
						<th>生产企业</th>
						<th>原料供货者</th>
					</tr>
				<c:forEach var="ledger" items="${LedgerList}" varStatus="status">
					<tr>
						<td style='width:100px;'>${ledger.name}</td>
						<td style='width:100px;'>${ledger.quantity}</td>
						<td style='width:100px;'>${ledger.amountUnit}</td>
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
					<th>开始时间：</th><td><fmt:formatDate value="${LedgerList[0].startTime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
				</tr>
				<tr>
					<th>目的地：</th><td>${LedgerList[0].receiverName}</td>
				</tr>
				<tr>
					<th>到达时间：</th><td><fmt:formatDate value="${LedgerList[0].endTime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
				</tr>
			</table>
	</div>
</div>