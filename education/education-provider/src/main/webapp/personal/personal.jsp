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
<%   
String basePath = "/carte/umedit/";  
String path = request.getContextPath();
String baseIp = null;
if(request.getContextPath() == null || request.getContextPath() == "")
{
    baseIp = "..";
}
else
{
    baseIp = "..";
}
%> 
<title>用户管理</title>
<jsp:include page="../inc.jsp"></jsp:include>

<script type="text/javascript">
		$.canEdit = true;
	</script>

	<script type="text/javascript">
		$.canEditPassword = true;
	</script>
	
<script type="text/javascript">
	var dataGrid;
	$(function() {
		dataGrid = $('#dataGrid').propertygrid({
			url : '${pageContext.request.contextPath}/personalController/dataGrid',
			fit : true,
			fitColumns : true,
			border : false,
			pagination : true,
			idField : 'id',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'id',
			sortOrder : 'asc',
			checkOnSelect : false,
			selectOnCheck : false,
			nowrap : false,
			frozenColumns : [[{
				field : 'id',
				title : '编号',
				width : 150,
				hidden:true,
			
			}]],
			columns : [[  
			            {
				field : 'userAccount',
				title : '用户名',
				width : 120,
				
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font style="font-style: normal;font-weight: bolder;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			}
			,  {
				field : 'name',
				title : '姓名',
				width : 120,
				
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font style="font-style: normal;font-weight: bolder;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			},  {
				field : 'userNo',
				title : '手机',
				width : 120,
				
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font style="font-style: normal;font-weight: bolder;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			},  {
				field : 'email',
				title : '邮箱',
				width : 120,
				
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font style="font-style: normal;font-weight: bolder;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			},
			{
				field : 'action',
				title : '操作',
				width : 140,
				formatter : function(value, row, index) {
					var str = '';
					if ($.canEdit) {
						str += $.formatString('<img onclick="editFun(\'{0}\');" src="{1}" title="编辑"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/pencil.png');
					}
					
					if ($.canEditPassword) {
						str += $.formatString('<img onclick="editFunPassword(\'{0}\');" src="{1}" title="修改密码"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/key.png');
					}
					return str;
					
				}
			} ]] ,
			toolbar : '#toolbar',
			onLoadSuccess : function() {
				$('#searchForm table').show();
				parent.$.messager.progress('close');

				$(this).datagrid('tooltip');
			},
			groupFormatter:function(group,rows){
				return  '- <span style="color:green">'+group+' </span>'
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

	function editFun(id) {
		if (id == undefined) {
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].id;
		} else {
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.modalDialog({
			title : '编辑用户',
			width :768,
			height : 480,
			href : '${pageContext.request.contextPath}/personalController/personalEdit?id='+ id,
			buttons : [ {
				text : '保存',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#formEdit');
					f.submit();
					var f2 = parent.$.modalDialog.handler.find('#projectFormEdit');
					f2.submit();
				}
			} ]
		});
	}
	
	
	function editFunPassword(id) {
		if (id == undefined) {
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].id;
		} else {
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.modalDialog({
			title : '修改密码',
			width :768,
			height : 480,
			href : '${pageContext.request.contextPath}/personalController/editCurrentUserPwdPage?id='+ id,
			buttons : [ {
				text : '保存',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#editCurrentUserPwdForm');
					f.submit();
					var f2 = parent.$.modalDialog.handler.find('#editCurrentUserPwdForm');
					f2.submit();
				}
			} ]
		});
	}

	
	
	
	
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		
		<div data-options="region:'center',border:false"  id="g">
			<table id="dataGrid" title="个人中心" data-options="collapsible:true" >
				<style>
						#g .datagrid-btable tr{height: 57px;}
				</style>
			</table>
		</div>
	</div>
	
</body>
</html>