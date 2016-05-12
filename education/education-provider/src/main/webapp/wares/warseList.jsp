<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
			url : '${pageContext.request.contextPath}/waresController/dataGrid',
			fit : true,
			fitColumns : true,
			//rownumbers : true ,
			border : false,
			pagination : true,
			idField : 'id',
			pageSize : 200,
			groupField:"way", 
			 showGroup:false, 
			pageList : [100,200,300,400 ],
			//sortName : 'deptName',
			//sortOrder : 'asc',
			checkOnSelect : false,
			selectOnCheck : false,
			//singleSelect:true,
			nowrap : false,
			frozenColumns : [ [{
				field : 'id',
				title : '编号',
				width : 150,
				hidden:true
			
			}  ] ],
			columns : [ [ /*  {
				field : 'userNo',
				title : '员工编号',
				width : 150,
				hidden: true
			}, */  {
				field : 'waresImage',
				title : '商品图片',
				width : 150,
				formatter : function(value, row, index) {
					  if(row.waresImage==null||row.waresImage==""){
			        	   return "";
			           }else{
			        	 
			        	   return "<img src="+row.waresImage+" />";
			           }
				}
			}, {
				field : 'waresName',
				title : '商品名称',
				width : 120,
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font style="font-style: normal;font-weight: bolder;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			},{
				field : 'supplierName',
				title : '供应商名称',
				width : 150,
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font style="font-style: normal;font-weight: bolder;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			}, {
				field : 'spec',
				title : '规格',
				width : 150,
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font style="font-style: normal;font-weight: bolder;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			},{
				field : 'shelfLife',
				title : '保质期',
				width : 150,
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font style="font-style: normal;font-weight: bolder;word-wrap:break-word;white-space:normal;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			},{
				field : 'unit',
				title : '保质期单位',
				width : 150,
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font style="font-style: normal;font-weight: bolder;word-wrap:break-word;white-space:normal;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			}, {
				field : 'way',
				title : '商品方向',
				width : 100,
				formatter : function(value, row, index) {
					 if(value==0){
							return '<font style="font-style: normal;font-weight: bolder;">采购品</font>';
					 }else if(value==1){
							return '<font style="font-style: normal;font-weight: bolder;">产出品</font>';
					 }
				}
			},{
				field : 'customCode',
				title : '企业自定义代码',
				width : 150,
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font style="font-style: normal;font-weight: bolder;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			},{
				field : 'barCode',
				title : '商品条形码',
				width : 150,
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font style="font-style: normal;font-weight: bolder;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			},{
				field : 'enName',
				title : '英文名',
				width : 110,
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font style="font-style: normal;font-weight: bolder;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			},{
				field : 'place',
				title : '产地',
				width : 110,
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font style="font-style: normal;font-weight: bolder;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			}
			,{
				field : 'action',
				title : '操作',
				width : 140,
				formatter : function(value, row, index) {
					var str = '';
					if ($.canEdit) {
						str += $.formatString('<img onclick="editFun(\'{0}\');" src="{1}" title="编辑"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/pencil.png');
					}
					str += '&nbsp;';
					
					if ($.canDelete) {
						str += $.formatString('<img onclick="deleteFun(\'{0}\');" src="{1}" title="删除"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/cancel.png');
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
				if (currentUserId != id) {
					parent.$.messager.progress({
						title : '提示',
						text : '数据处理中，请稍后....'
					});
					$.post('${pageContext.request.contextPath}/imsUserController/deleteUser', {
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
			height : 480,
			href : '${pageContext.request.contextPath}/imsUserController/edit?id=' + id,
			buttons : [ {
				text : '编辑',
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
			height : 480,
			href : '${pageContext.request.contextPath}/waresController/addWares',
			buttons : [ {
				text : '添加',
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



	function grantFun(id) {
		dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		parent.$.modalDialog({
			title : '用户授权',
			width : 500,
			height : 300,
			href : '${pageContext.request.contextPath}/imsUserController/grantPage?ids=' + id,
			buttons : [ {
				text : '授权',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为授权成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#form');
					f.submit();
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
	
	
	function editPwdFun(id) {
		dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		parent.$.modalDialog({
			title : '编辑用户密码',
			width : 500,
			height : 200,
			href : '${pageContext.request.contextPath}/imsUserController/editPwdPage?id=' + id,
			buttons : [ {
				text : '编辑',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#form');
					f.submit();
				}
			} ]
		});
	}
	
	function upLoadFun(id) {
		if (id == undefined) {
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].id;
		} else {
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.modalDialog({
			title : '上传图片',
			width : 700,
			height : 300,
			href : '${pageContext.request.contextPath}/waresController/upLoadImage?id=' + id,
			buttons : [ {
				text : '上传',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#form');
					f.submit ();
				}
			} ]
		});
	}
	
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'north',title:'查询条件',border:false" style="height: 160px; overflow: hidden;">
			<form id="searchForm">
				<table class="table table-hover table-condensed" style="display: none;">
					<tr>
						<th>商品名称</th>
						<td><input name="waresName" placeholder="可以商品名称" class="easyui-validatebox"  style="width: 215px;"/></td>
						 <th>供应商名称</th>
					    <td><input name="supplierName" placeholder="可以查询供应商名称" class="easyui-validatebox"  style="width: 215px;"/></td>
					</tr>
					<tr>
					     <th>产地</th>
					     <td><input name="place" placeholder="可以查询产地" class="easyui-validatebox"  style="width: 215px;"/></td>
					     <th>商品条形码</th>
					     <td><input name="barCode" placeholder="可以查询条形码" class="easyui-validatebox"  style="width: 215px;"/></td>
					</tr>
					<tr>
					    <th>商品方向</th>
					    <td>
					       <select id="way" name="way"  class="easyui-combobox" style="height: 27px;">
					          <option value="">请选择</option>
					          <option value="0">采购品</option>
					          <option value="1">产出品</option>
					       </select>
					    </td>
					    <th>企业自定义代码</th>
					    <td><input name="customCode" placeholder="可以查询企业自定义代码" class="easyui-validatebox"  style="width: 215px;"/></td>
					</tr>
				</table>
			</form>
		</div>
		<div data-options="region:'center',border:false">
			<table id="dataGrid" title="聚运动用户表单" data-options="collapsible:true"></table>
		</div>
	</div>
	<div id="toolbar" style="display: none;">
			<a onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'pencil_add'">添加</a>
		<!--<c:if test="${fn:contains(sessionInfo.resourceList, '/userController/grantPage')}">
			<a onclick="batchGrantFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'tux'">批量授权</a>
		</c:if>-->
	
		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'brick_add',plain:true" onclick="searchFun();">过滤条件</a><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'brick_delete',plain:true" onclick="cleanFun();">清空条件</a>
	</div>

</body>
</html>