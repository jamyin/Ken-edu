<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<style>
.panel-body {
	font-size: 18px !important;
}
.act {
	padding-top: 7px!important;
	padding-bottom: 7px!important;
}
.stable{
	width:414px!important;;
  	table-layout:fixed;
}
</style>
<!DOCTYPE html>
<html>
<head>
<title>供货者管理</title>
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
			 				title : '<font  style="font-style: normal; font-size:18px;">供货者名称</font>',
			 				width : 180,
			 				
			 				formatter : function(value, row, index) {
			 					if(value!=null){
			 					return '<font style="font-style: normal; font-size:15px;">'
								+ value + '</font>';
			 					}else{
			 					return "";
			 							}
			 				}
			 			},{
			 				field : 'address',
			 				title : '<font  style="font-style: normal; font-size:18px;">供货者地址</font>',
			 				width : 180,
			 				
			 				formatter : function(value, row, index) {
			 					if(value!=null){
			 					return '<font style="font-style: normal; font-size:15px;">'
								+ value + '</font>';
			 					}else{
			 					return "";
			 							}
			 				}
			 			},
			 			
			 			{
			 				field : 'corporation',
			 				title : '<font  style="font-style: normal; font-size:18px;"> 联系人</font>',
			 				width : 80,
			 				
			 				formatter : function(value, row, index) {
			 					if(value!=null){
			 					return '<font style="font-style: normal; font-size:15px;">'
								+ value + '</font>';
			 					}else{
			 					return "";
			 							}
			 				}
			 			},{
			 				field : 'contactWay',
			 				title : '<font  style="font-style: normal; font-size:18px;">联系方式</font>',
			 				width : 110,
			 				
			 				formatter : function(value, row, index) {
			 					if(value!=null){
			 					return '<font style="font-style: normal; font-size:15px;">'
								+ value + '</font>';
			 					}else{
			 					return "";
			 							}
			 				}
			 			},{
			 				field : 'foodCirculationCode',
			 				title : '<font  style="font-style: normal; font-size:18px;">食品流通证号</font>',
			 				width : 120,
			 				
			 				formatter : function(value, row, index) {
			 					if(value!=null){
			 					return'<font style="font-style: normal; font-size:15px;">'
								+ value + '</font>';
			 					}else{
			 					return "";
			 							}
			 				}
			 			},{
			 				field : 'foodProduceCode',
			 				title : '<font  style="font-style: normal; font-size:18px;">食品生产证号</font>',
			 				width : 120,
			 				
			 				formatter : function(value, row, index) {
			 					if(value!=null){
			 					return '<font style="font-style: normal; font-size:15px;">'
								+ value + '</font>';
			 					}else{
			 					return "";
			 							}
			 				}
			 			},			 						
			{
				field : 'action',
				title : '<font  style="font-style: normal; font-size:18px;">操作</font>',
				width : 100,
				formatter : function(value, row, index) {
					var str = '';
					if ($.canEdit) {
						str += $.formatString('<img onclick="editFun(\'{0}\');" src="{1}" title="编辑"/>', row.id, '${pageContext.request.contextPath}/icon/编辑.png');
					}
					str += '&nbsp;';
			/* 		if ($.inputImage) {
						str += $.formatString('<img onclick="inputImage(\'{0}\');" src="{1}" title="上传图片"/>',  row.id, '${pageContext.request.contextPath}/icon/上传图片.png');
					}
				
					str += '&nbsp;';
				
					if ($.lookImage) {
						str += $.formatString('<img onclick="lookImage(\'{0}\');" src="{1}" title="查看图片"/>', row.id, '${pageContext.request.contextPath}/icon/查看图片.png');
					}
					
					str += '&nbsp;'; */

					if ($.editImage) {
						str += $.formatString('<img onclick="editImage(\'{0}\');" src="{1}" title="编辑图片"/>', row.id, '${pageContext.request.contextPath}/icon/编辑图片.png');
					}	
					str += '&nbsp;';
					if ($.canDelete) {
						str += $.formatString('<img onclick="deleteFun(\'{0}\');" src="{1}" title="删除"/>', row.id, '${pageContext.request.contextPath}/icon/删除.png');
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
		parent.$.messager.confirm('询问', '您是否要删除当前供货者？', function(b) {
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
			title : '编辑供货者',
			width : 700,
			height : 420,
			href : '${pageContext.request.contextPath}/proSupplierController/editPage?id=' + id,
			onOpen: function(){},
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
			title : '添加供货者',
			width : 700,
			height : 420,
			href : '${pageContext.request.contextPath}/proSupplierController/addSupplier',
			onOpen: function(){},
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
			width :800,
			height : 480,
			href : '${pageContext.request.contextPath}/proSupplierController/inputImage?id='+ id,
			onOpen: function(){},
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
			width :800,
			height : 480,
			href : '${pageContext.request.contextPath}/proSupplierController/editImage?id='+ id,
			onOpen: function(){},
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
			title : '导入供货者',
			width :340,
			height : 130,
			href : '${pageContext.request.contextPath}/proSupplierController/importPage',
			onOpen: function(){},
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
	
	function toExcel(){
		var supplierName = $("#supplierName").val();
		var address = $("#address").val();
		window.location.href='${pageContext.request.contextPath}/proSupplierController/excel.do?supplierName='+supplierName+'&address='+address+'';
	}
	
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'north',border:false"  title="<font  style='font-style: normal;font-weight: bolder;font-size:18px;'>查询条件</font>"   style="height: 80px; overflow: hidden;">
			<form id="searchForm">
				<table class="table table-hover table-condensed stable" style="display: none;">
			
					<tr>
						<td style="width:414px;padding-top: 10px;">
						供货者名称:&nbsp;<input id="supplierName" class="span3" name="supplierName" placeholder="查询供货者名称" style="width: 215px;" /></td>
						<td style="width:414px;padding-top: 10px;">
						供货者地址:&nbsp;<input id="address" class="span2" name="address" placeholder="查询供货者地址" style="width: 215px;" />&nbsp;&nbsp;&nbsp;
						<a href="javascript:void(0);"  onclick="searchFun();" ><img src="${pageContext.request.contextPath}/icon/查询.png" ></img></a>
						</td>
						
					</tr>		
										
				</table>
			</form>
		</div>
		
			<div data-options="region:'center',border:false"  id="g">
				<table id="dataGrid" title="<font  style='font-style: normal;font-weight: bolder;font-size:16px;'>供货者表单</font>" data-options="collapsible:true" ></table>
						<style>
						#g .datagrid-btable tr{height: 45px;}
				</style>
			</div>
	</div>
		<div id="toolbar" class="act" style="display: none;"  >		
		<a onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true"><img src="${pageContext.request.contextPath}/icon/添加.png" ></img></a>
		&nbsp;
		<a onclick="importSupplier();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true"><img src="${pageContext.request.contextPath}/icon/导入.png"></img></a>
		&nbsp;
		<a onclick="toExcel();" title="导出到EXCEL"><img src="${pageContext.request.contextPath}/icon/导出.png"></img></a>
		&nbsp;
		<a href="${pageContext.request.contextPath}/templates/供货者.xlsx" class="easyui-linkbutton" data-options="plain:true"><img src="${pageContext.request.contextPath}/icon/下载模板.png"></img></a>
	</div>

	
	
</body>
</html>