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
<title>配货管理</title>
<jsp:include page="../inc.jsp"></jsp:include>
	<script type="text/javascript">
		$.canShow = true;
	</script>
	<script type="text/javascript">
		$.canEdit = true;
	</script>
	<script type="text/javascript">
		$.canDelete = true;
	</script>
<script type="text/javascript">
	var dataGrid;
	$(function() {
		dataGrid = $('#dataGrid').datagrid({
			url : '${pageContext.request.contextPath}/ledgerController/dataGrid',
			fit : true,
			fitColumns : true,
			border : false,
			pagination : true,
			idField : 'masterId',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'name',
			sortOrder : 'asc',
			checkOnSelect : false,
			selectOnCheck : false,
			nowrap : false,
			frozenColumns : [ [ /* {
				field : 'masterId',
				title : '编号',
				width : 150,
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font  style="font-style: normal;font-weight: bolder;font-size:18px;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			}, */ {
				field : 'wareBatchNo',
				title : '配送号',
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
			columns : [ [  
			{
				field : 'sendDate',
				title : '配送日期',
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
				field : 'name',
				title : '采购品',
				width : 150,
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
				field : 'receiverName',
				title : '配货点',
				width : 150,
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
				field : 'haulStatus',
				title : '状态',
				width : 30,
			
				formatter: function(value,row,index){
					if (value==0){
						return  '<font  style="font-style: normal;font-weight: bolder;font-size:18px;">未配送</font>';
					} 
					if (value==1){
					
						return  '<font  style="font-style: normal;font-weight: bolder;font-size:18px;">配送中</font>';
					} 
					if (value==2){
					
						return  '<font  style="font-style: normal;font-weight: bolder;font-size:18px;">已配送</font>';
					} 
				}

			},
			{
				field : 'action',
				title : '操作',
				width : 100,
				formatter : function(value, row, index) {
					var str = '';
					if ($.canShow) {
						str += $.formatString('<img onclick="showFun(\''+row.masterId+'\');" src="{1}" title="查看"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/pencil.png');
					}
					str += '&nbsp;';
					if ($.canEdit) {
						str += $.formatString('<img onclick="editFun(\''+row.masterId+'\');" src="{1}" title="编辑"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/pencil.png');
					}
					str += '&nbsp;';
					if ($.canDelete) {
						str += $.formatString('<img onclick="deleteFun(\''+row.masterId+'\');" src="{1}" title="删除"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/cancel.png');
					}
					return str;
				}
			} ] ],
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

	function deleteFun(id) {
		if (id == undefined) {//点击右键菜单才会触发这个
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].id;
		} else {//点击操作里面的删除图标会触发这个
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.messager.confirm('询问', '您是否要删除当前配送？', function(b) {
			if (b) {
				var currentUserId = '${sessionInfo.id}';/*当前登录用户的ID*/
				if (currentUserId != id) {
					parent.$.messager.progress({
						title : '提示',
						text : '数据处理中，请稍后....'
					});
					$.post('${pageContext.request.contextPath}/ledgerController/deleteLedger', {
						masterId : id
					}, function(result) {
						if (result.success) {
							parent.$.messager.alert('提示', result.msg, 'info');
							dataGrid.datagrid('reload');
						}
						parent.$.messager.progress('close');
					}, 'JSON');
				} else {
					parent.$.messager.show({
						title : '提示',
						msg : '不可以删除自己！'
					});
				}
			}
		});
	}

	function editFun(id) {
		if (id == undefined) {
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].id;
		} else {
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.modalDialog({
			title : '编辑配送',
			width : 1000,
			height : 500,
			href : '${pageContext.request.contextPath}/ledgerController/editPage?masterId=' +id ,
			buttons : [ {
				text : '保存',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#form');
					f.submit();
				}
			} ]
		});
	}

	function showFun(id) {
		if (id == undefined) {
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].id;
		} else {
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.modalDialog({
			title : '查看配送',
			width : 1000,
			height : 500,
			href : '${pageContext.request.contextPath}/ledgerController/showPage?masterId=' +id,
			onOpen: function(){}
		});
	}
	
	function addFun() {
		parent.$.modalDialog({
			title : '添加配货',
			width : 1030,
			height : 500,
			href : '${pageContext.request.contextPath}/ledgerController/addLedger',
			style : 'overflow-y:scroll;',
			buttons : [ {
				text : '添加',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#form');
					f.submit();
				}
			} ]
		});
	}

	function importSupplier() {
		parent.$.modalDialog({
			title : '导入配货',
			width :300,
			height : 150,
			href : '${pageContext.request.contextPath}/ledgerController/importPage',
			buttons : [ {
				text : '上传',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#importLedger');
					f.submit();
				}
			} ]
		});
	}
	
	function toExcel(){
		var actionDate = $("#actionDate").val();
		var nextDate = $("#nextDate").val();
		var receiverName = $("#receiverName").val();
		window.location.href='${pageContext.request.contextPath}/ledgerController/excel.do?actionDate='+actionDate+'&nextDate='+nextDate+'&receiverName='+receiverName+'';
	}
	
	function searchFun() {
		dataGrid.datagrid('load', $.serializeObject($('#searchForm')));
	}
	function cleanFun() {
		$('#searchForm input').val('');
		dataGrid.datagrid('load', {});
	}
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'north',title:'查询条件',border:false" style="height: 80px; overflow: hidden;">
			
			<form id="searchForm">
				<table class="table table-hover table-condensed" style="display: none;">
					<tr>
						<th style="width: 500;">配货日期
						<input id="actionDate" class="span2" name="actionDate" placeholder="点击选择日期" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" readonly="readonly"/>
						至
						<input id="nextDate" class="span2" name="nextDate" placeholder="点击选择日期" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" readonly="readonly"/></th>
						<th>配货点
						<input id="receiverName" class="span2" name="receiverName" /></th>
					</tr>
				</table>
			</form>
		</div>
		<div data-options="region:'center',border:false" id="g">
			<table id="dataGrid"  data-options="collapsible:true"  title="配货管理表单" ></table>
			<style>
						#g .datagrid-btable tr{height: 57px;}
				</style>
		</div>
	</div>
	<div id="toolbar" style="display: none;">
			<a onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'pencil_add'">添加</a>
		<!--<c:if test="${fn:contains(sessionInfo.resourceList, '/userController/grantPage')}">
			<a onclick="batchGrantFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'tux'">批量授权</a>
		</c:if>-->
			<!-- <a onclick="batchDeleteFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'delete'">批量删除</a> -->
		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'brick_add',plain:true" onclick="searchFun();">搜索</a><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'brick_delete',plain:true" onclick="cleanFun();">清空搜索条件</a>
		<a onclick="importSupplier();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'pencil_add'">导入</a>
		<a class="btn btn-mini btn-light" onclick="toExcel();" title="导出到EXCEL"><i id="nav-search-icon" class="icon-download-alt"></i>导出</a>
		<a href="${pageContext.request.contextPath}/templates/配货管理.xlsx" class="easyui-linkbutton" data-options="plain:true,iconCls:'pencil_add'">下载模板</a>
	</div>

</body>
</html>
