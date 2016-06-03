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
		$.canDelete = true;
	</script>
	
<script type="text/javascript">
	var dataGrid;
	$(function() {
		dataGrid = $('#dataGrid').propertygrid({
			url : '${pageContext.request.contextPath}/userController/dataGrid',
			fit : true,
			fitColumns : true,
			border : false,
			pagination : true,
			idField : 'id',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			
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
				title : '<font  style="font-style: normal; font-size:18px;">用户名</font>',
				width : 120,
				
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font style="font-style: normal; font-size:15px;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			}
			,  {
				field : 'name',
				title : '<font  style="font-style: normal; font-size:18px;">姓名</font>',
				width : 120,
				
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font style="font-style: normal; font-size:15px;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			},  {
				field : 'userNo',
				title : '<font  style="font-style: normal; font-size:18px;">手机</font>',
				width : 120,
				
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font style="font-style: normal; font-size:15px;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			},  {
				field : 'email',
				title : '<font  style="font-style: normal; font-size:18px;">邮箱</font>',
				width : 120,
				
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font style="font-style: normal; font-size:15px;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			},  {
				field : 'userTypeName',
				title : '<font  style="font-style: normal; font-size:18px;">账号权限</font>',
				width : 120,
				
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font style="font-style: normal; font-size:15px;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			}
			,
			{
				field : 'action',
				title : '<font  style="font-style: normal;font-size:18px;">操作</font>',
				width : 140,
				formatter : function(value, row, index) {
					var str = '';
					if ($.canEdit) {
						str += $.formatString('<img onclick="editFun(\'{0}\');" src="{1}" title="编辑"/>', row.id, '${pageContext.request.contextPath}/icon/编辑.png');
					}
					str += '&nbsp;';
					
			
					str += '&nbsp;';
					if ($.canDelete) {
						str += $.formatString('<img onclick="deleteFun(\'{0}\');" src="{1}" title="删除"/>', row.id, '${pageContext.request.contextPath}/icon/删除.png');
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

	function deleteFun(id) {
		if (id == undefined) {//点击右键菜单才会触发这个
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].id;
		} else {//点击操作里面的删除图标会触发这个
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.messager.confirm('询问', '您是否要删除当前用户？', function(b) {
			if (b) {
				var currentUserId = '${sessionInfo.id}';/*当前登录用户的ID*/
				
					parent.$.messager.progress({
						title : '提示',
						text : '数据处理中，请稍后....'
					});
					$.post('${pageContext.request.contextPath}/userController/delete', {
						id : id
					}, function(result) {
						if (result.success) {
							parent.$.messager.alert('提示', result.msg, 'info');
							dataGrid.datagrid('reload');
						}else {
							parent.$.messager.alert('错误', result.msg, 'error');
						}
						parent.$.messager.progress('close');
					}, 'JSON');
				
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
			title : '编辑用户',
			width :768,
			height : 420,
			href : '${pageContext.request.contextPath}/userController/editPage?id='+ id,
			onOpen: function(){},
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
	
	
	
	function addFun() {
		parent.$.modalDialog({
			title : '添加用户',
			width :768,
			height : 420,
			href : '${pageContext.request.contextPath}/userController/addPage',
			onOpen: function(){},
			buttons : [ {
				text : '保存',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					 var f2 = parent.$.modalDialog.handler.find('#projectForm');
					 f2.submit();
					var f = parent.$.modalDialog.handler.find('#form');
					f.submit();
				//	if(f.submit().success){
				//		alert("11111111111111");
				//		var f2 = parent.$.modalDialog.handler.find('#projectForm');
				//		f2.submit();
				//	}
					
				}
			} ]
		});
	}





	function searchFun() {
		dataGrid.datagrid('load', $.serializeObject($('#searchForm')));
	}
	function cleanFun() {
		$('#searchForm input').val('');
		
		$("#gender").val("");
		dataGrid.datagrid('load', {});
	}
	
	
	
	
	
	
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'north',border:false"  title="<font  style='font-style: normal;font-weight: bolder;font-size:18px;'>查询条件</font>"    style="height: 80px; overflow: hidden;">
			<form id="searchForm">
				<table class="table table-hover table-condensed" style="display: none;">
					<tr>
						<td>姓名:
						<input name="name" placeholder="可以搜索名称" class="easyui-validatebox"  style="width: 215px;"/>&nbsp;&nbsp;&nbsp;<a href="javascript:void(0);"  onclick="searchFun();" class="easyui-linkbutton" iconCls="icon-search" ><font  style='font-style: normal;font-size:18px;'>查询</font></a>
							</td>
	
						 </tr>	
								</table>
			</form>
		</div>
		<div data-options="region:'center',border:false"  id="g">
			<table id="dataGrid" title="<font  style='font-style: normal;font-weight: bolder;font-size:16px;'>用户管理</font>" data-options="collapsible:true" ></table>
				<style>
						#g .datagrid-btable tr{height: 45px;}
				</style>
		</div>
	</div>
	<div id="toolbar" style="display: none;">
			<a onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true"><img src="${pageContext.request.contextPath}/icon/添加.png" ></img></a>

	</div>

</body>
</html>
