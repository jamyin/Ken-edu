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
				title : '名称',
				width : 150,
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font  style="font-style: normal;font-weight: bolder;font-size:18px;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			} ] ],
			columns : [ [ {
				field : 'address',
				title : '地址',
				width : 180,
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font  style="font-style: normal;font-weight: bolder;font-size:18px;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			}, 
			{
				field : 'contacts',
				title : '联系人',
				width : 50,
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font  style="font-style: normal;font-weight: bolder;font-size:18px;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			},
			{
				field : 'mobileNo',
				title : '联系电话',
				width : 50,
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font  style="font-style: normal;font-weight: bolder;font-size:18px;">'
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
		<div data-options="region:'north',title:'查询条件',border:false" style="height: 80px; overflow: hidden;">
			<form id="searchForm">
				<table class="table table-hover table-condensed" style="display: none;">
			
					<tr>
						<th>名称</th>
						<td><input class="span2" name="schoolName" /></td>
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
		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'brick_add',plain:true" onclick="searchFun();">过滤条件</a><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'brick_delete',plain:true" onclick="cleanFun();">清空条件</a>
	</div>

</body>
</html>