<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<style>
.panel-body {
	font-size: 18px !important;
}
</style>
<!DOCTYPE html>
<html>
<head>
<title>配货点</title>
<jsp:include page="../inc.jsp"></jsp:include>


<script type="text/javascript">
	var dataGrid;
	$(function() {
		dataGrid = $('#dataGrid').datagrid({
			url : '${pageContext.request.contextPath}/ledgerAddressController/dataGrid',
			fit : true,
			fitColumns : true,
			border : false,
			pagination : true,
			idField : 'id',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'name',
			sortOrder : 'asc',
			checkOnSelect : false,
			selectOnCheck : false,
			nowrap : false,
			frozenColumns : [ [ /* {
				field : 'id',
				title : '编号',
				width : 150,
				checkbox : true
			}, */ {
				field : 'schoolName',
				title : '<font  style="font-style: normal; font-size:18px;">名称</font>',
				width : 150,
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font  style="font-style: normal;font-size:15px;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			} ] ],
			columns : [ [ {
				field : 'address',
				title : '<font  style="font-style: normal; font-size:18px;">地址</font>',
				width : 180,
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font  style="font-style: normal;font-size:15px;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			}, 
			{
				field : 'contacts',
				title : '<font  style="font-style: normal; font-size:18px;">联系人</font>',
				width : 50,
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font  style="font-style: normal;font-size:15px;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			},
			{
				field : 'mobileNo',
				title : '<font  style="font-style: normal;font-size:18px;">联系电话</font>',
				width : 50,
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font  style="font-style: normal;font-size:15px;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			}] ],
			toolbar : '#toolbar',
			onLoadSuccess : function() {
				$('#searchForm table').show();
				parent.$.messager.progress('close');

				$(this).datagrid('tooltip');
			},
			onRowContextMenu : function(e, rowIndex, rowData) {
				e.preventDefault();
				$(this).datagrid('unselectAll').datagrid('uncheckAll');
				$(this).datagrid('selectRow', rowIndex);
				$('#menu').menu('show', {
					left : e.pageX,
					top : e.pageY
				});
			}
		});
	});

	function cleanFun() {
		$('#searchForm input').val('');
		dataGrid.datagrid('load', {});
	}

	function searchFun() {
		dataGrid.datagrid('load', $.serializeObject($('#searchForm')));
	}
	
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'north',border:false"    title="<font  style='font-style: normal;font-weight: bolder;font-size:18px;'>查询条件</font>"  style="height: 80px; overflow: hidden;">
			<form id="searchForm">
				<table class="table table-hover table-condensed" style="display: none;">
			
					<tr>
						<td>名称:
						<input class="span2" name="schoolName" />&nbsp;&nbsp;&nbsp;<a href="javascript:void(0);"  onclick="searchFun();" class="easyui-linkbutton" iconCls="icon-search" ><font  style='font-style: normal;font-weight: bolder;font-size:18px;'>查询</font></a></td>
				
					</tr>							
				</table>
			</form>
		</div>
		<div data-options="region:'center',border:false"  id="g">
			<table id="dataGrid"  data-options="collapsible:true"  title="配货点管理表单" ></table>
			<style>
						#g .datagrid-btable tr{height: 57px;}
				</style>
		</div>
	</div>
	<div id="toolbar" style="display: none;">
	
		
	</div>

</body>
</html>