<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>供应商管理</title>
<jsp:include page="../inc.jsp"></jsp:include>

	<script type="text/javascript">
		$.canEdit = true;
	</script>


	<script type="text/javascript">
		$.canDelete = true;
	</script>


	<script type="text/javascript">
		$.inputImage = true;
	</script>
		<script type="text/javascript">
		$.lookImage = true;
	</script>
		<script type="text/javascript">
		$.editImage = true;
	</script>
<script type="text/javascript">
	var dataGrid;
	$(function() {
		dataGrid = $('#dataGrid').datagrid({
			url : '${pageContext.request.contextPath}/proSupplierController/dataGrid',
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
			frozenColumns : [ [] ],
			columns : [ [ 
			             {
			 				field : 'supplierName',
			 				title : '供应商名称',
			 				width : 120,
			 				
			 				formatter : function(value, row, index) {
			 					if(value!=null){
			 					return '<font style="font-style: normal;font-weight: bolder;">'
			 							+ value + '</font>';
			 					}else{
			 					return "";
			 							}
			 				}
			 			}, {
			 				field : 'supplierCode',
			 				title : '供应商编码',
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
			 				field : 'address',
			 				title : '供应商地址',
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
			 				field : 'corporation',
			 				title : '法人代表',
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
			 				field : 'contactWay',
			 				title : '联系方式',
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
			 				field : 'businessLicense',
			 				title : '工商执照号',
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
			 				field : 'foodServiceCode',
			 				title : '餐饮服务证号',
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
			 				field : 'foodBusinessCode',
			 				title : '食品经营许可证号',
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
			 				field : 'foodCirculationCode',
			 				title : '食品流通证号',
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
			 				field : 'foodProduceCode',
			 				title : '食品生产证号',
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
				width : 100,
				formatter : function(value, row, index) {
					var str = '';
					if ($.canEdit) {
						str += $.formatString('<img onclick="editFun(\'{0}\');" src="{1}" title="编辑"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/pencil.png');
					}
					str += '&nbsp;';
					if ($.inputImage) {
						str += $.formatString('<img onclick="inputImage(\'{0}\');" src="{1}" title="上传图片"/>',  row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/photoAndPic/photo_add.png');
					}
				
					str += '&nbsp;';
				
					if ($.lookImage) {
						str += $.formatString('<img onclick="lookImage(\'{0}\');" src="{1}" title="查看图片"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/photoAndPic/photo.png');
					}
					
					str += '&nbsp;';

					if ($.editImage) {
						str += $.formatString('<img onclick="editImage(\'{0}\');" src="{1}" title="修改图片"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/photoAndPic/picture_edit.png');
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
		parent.$.messager.confirm('询问', '您是否要删除当前供应商？', function(b) {
			if (b) {
				var currentUserId = '${sessionInfo.id}';/*当前登录用户的ID*/
				if (currentUserId != id) {
					parent.$.messager.progress({
						title : '提示',
						text : '数据处理中，请稍后....'
					});
					$.post('${pageContext.request.contextPath}/proSupplierController/deleteSupplier', {
						id : id
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
			title : '编辑供应商',
			width : 700,
			height : 550,
			href : '${pageContext.request.contextPath}/proSupplierController/editPage?id=' + id,
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

	function addFun() {
		parent.$.modalDialog({
			title : '添加供应商',
			width : 700,
			height : 550,
			href : '${pageContext.request.contextPath}/proSupplierController/addSupplier',
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

	function searchFun() {
		dataGrid.datagrid('load', $.serializeObject($('#searchForm')));
	}
	
	function inputImage() {
		dataGrid.datagrid('load', $.serializeObject($('#searchForm')));
	}
	function cleanFun() {
		$('#searchForm input').val('');
		dataGrid.datagrid('load', {});
	}
	
	
	function inputImage(id) {
		if (id == undefined) {
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].id;
		} else {
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.modalDialog({
			title : '上传图片',
			width :768,
			height : 480,
			href : '${pageContext.request.contextPath}/proSupplierController/inputImage?id='+ id,
			buttons : [ {
				text : '上传',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#formEditImage');
					f.submit();
					var f2 = parent.$.modalDialog.handler.find('#projectFormEdit');
					f2.submit();
				}
			} ]
		});
	}
	
	function lookImage(id) {
		if (id == undefined) {
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].id;
		} else {
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.modalDialog({
			title : '查看图片',
			width :768,
			height : 480,
			href : '${pageContext.request.contextPath}/proSupplierController/lookImage?id='+ id,
			onOpen: function(){}
		});
	}
	
	function editImage(id) {
		if (id == undefined) {
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].id;
		} else {
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.modalDialog({
			title : '修改图片信息',
			width :768,
			height : 480,
			href : '${pageContext.request.contextPath}/proSupplierController/editImage?id='+ id,
			buttons : [ {
				text : '上传',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#updateImage');
					f.submit();
					var f2 = parent.$.modalDialog.handler.find('#projectFormEdit');
					f2.submit();
				}
			} ]
		});
	}
	
	function importSupplier() {
		parent.$.modalDialog({
			title : '导入供应商',
			width :300,
			height : 150,
			href : '${pageContext.request.contextPath}/proSupplierController/importPage',
			buttons : [ {
				text : '上传',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#importSupplier');
					f.submit();
				}
			} ]
		});
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
						<td><input class="span2" name="supplierName" /></td>
						<th>地址</th>
						<td><input class="span2" name="address" /></td>
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
		

		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'brick_add',plain:true" onclick="searchFun();">搜索</a><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'brick_delete',plain:true" onclick="cleanFun();">清空搜索条件</a>
		<a onclick="importSupplier();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'pencil_add'">导入</a>
		<a href="${pageContext.request.contextPath}/proSupplierController/download" class="easyui-linkbutton" data-options="plain:true,iconCls:'pencil_add'">下载模板</a>
	</div>

	
	
</body>
</html>
