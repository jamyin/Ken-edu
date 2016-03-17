<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>学校加工商管理</title>
<jsp:include page="../../inc.jsp"></jsp:include>
	<c:if 
	    test="${fn:contains(sessionInfo.resourceList, '/schoolSupplierController/addPage')}">
			<script type="text/javascript">
		$.canAddDept= true;
	</script>
		</c:if>

<script type="text/javascript">
	var dataGrid;
	var treeGrid;
	$(function() {
		dataGrid = $('#dataGrid').datagrid({
			url : '${pageContext.request.contextPath}/schoolSupplierController/dataGrid',
			fit : true,
			fitColumns : true,
			border : false,
			pagination : true,
			rownumbers : true,
			idField : 'id',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			checkOnSelect : false,
			selectOnCheck : false,
			nowrap : false,
			frozenColumns : [ [ {
				field : 'id',
				title : '编号',
				width : 144,
				checkbox : true,
				hidden : true
			}, {
				field : 'projName',
				title : '项目名称',
				width : 110
			} ] ],
			columns : [ [ {
				field : 'supplierName',
				title : '供应商名称',
				width : 300
			},{
				field : 'supplierAddress',
				title : '供应商地址',
				width : 700
			},{
				field : 'foodLicense',
				title : '餐饮许可证',
				width : 300
			},{
				field : 'businessLicense',
				title : '工商执照',
				width : 300
			},{
				field : 'corporation',
				title : '法人代表',
				width : 300
			},{
				field : 'contactWay',
				title : '联系方式',
				width : 300
			},{
				field : 'certificateIcon',
				title : '资格证书图片',
				width : 300
			},{
				field : 'longitude',
				title : '经度',
				width : 300
			},{
				field : 'latitude',
				title : '纬度',
				width : 300
			},
			{
				field : 'action',
				title : '操作',
				width : 350,
				formatter : function(value, row, index) {
					var str = '';
					
						str += $.formatString('<img onclick="editFun(\'{0}\');" src="{1}" title="编辑"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/pencil.png');
					
						str += '&nbsp;';
						str += $.formatString('<img onclick="grantFun(\'{0}\');" src="{1}" title="添加流程"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/pencil_add.png');
				
				     	str += '&nbsp;';
				
						str += $.formatString('<img onclick="adduserFun(\'{0}\');" src="{1}" title="用户授权"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/key.png');
						
						str += '&nbsp;&nbsp;';
						
						if($.canAddDept){
						str += $.formatString('<img onclick="addDeptFun(\'{0}\');" src="{1}" title="添加部门"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/book_add.png');
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


	function addFun() {
		parent.$.modalDialog({
			title : '添加供应商',
			width :768,
			height : 480,
			href : '${pageContext.request.contextPath}/schoolSupplierController/addPage',
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
	

	function deleteFun(id) {
		if (id == undefined) {//点击右键菜单才会触发这个
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].id;
		} else {//点击操作里面的删除图标会触发这个
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.messager.confirm('询问', '您是否要删除当前任务节点？', function(b) {
			if (b) {
				var currentUserId = '${sessionInfo.id}';/*当前登录用户的ID*/
				if (currentUserId != id) {
					parent.$.messager.progress({
						title : '提示',
						text : '数据处理中，请稍后....'
					});
					$.post('${pageContext.request.contextPath}/ProjectController/delete', {
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
			title : '编辑项目',
			width : 400,
			height : 200,
			href : '${pageContext.request.contextPath}/ProjectController/editProject?id=' + id,
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
	<div  class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'north',title:'查询条件',border:false" style="height: 100px; overflow: hidden;">
			<form id="searchForm">
				<table class="table table-hover table-condensed" style="display: none;">
					<tr>
					    
						<th>项目名称</th>
						<td><input name="projName" placeholder="可以查询项目名称" class="span2" style="width:279px;"/></td>
						<th>供应商名称</th>
						<td><input name="supplierName" placeholder="可以查询供应商名称" class="span2" style="width:279px;"/></td>
					</tr>
				</table>
			</form>
		</div>
		<div data-options="region:'center',border:false">
			<table id="dataGrid"></table>
		</div>
	</div>
	<div id="toolbar" style="display: none;">
		
			<a onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'pencil_add'">添加</a>
		
		<!--<c:if test="${fn:contains(sessionInfo.resourceList, '/deptLevelController/grantPage')}">
			<a onclick="batchGrantFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'tux'">批量授权</a>
		</c:if>-->
	
		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'brick_add',plain:true" onclick="searchFun();">过滤条件</a><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'brick_delete',plain:true" onclick="cleanFun();">清空条件</a>
	</div>

	
</body>
</html>