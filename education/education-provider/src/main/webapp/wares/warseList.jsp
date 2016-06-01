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
		$.canImage = true;
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
		dataGrid = $('#dataGrid').propertygrid({
			url : '${pageContext.request.contextPath}/waresController/dataGrid',
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
				height : 40,
				hidden:true,
			
			}]],
			columns : [[  {
				field : 'waresName',
				title : '<font  style="font-style: normal;font-weight: bolder;font-size:18px;">商品名称</font>',
				width : 120,
				
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font  style="font-style: normal;font-size:16px;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			}, {
				field : 'spec',
				title : '<font  style="font-style: normal;font-weight: bolder;font-size:18px;">规格</font>',
				width : 50,
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font style="font-style: normal;  font-size:16px;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			},{
				field : 'manufacturer',
				title : '<font  style="font-style: normal;font-weight: bolder;font-size:18px;">生产企业</font>',
				width : 150,
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font style="font-style: normal; font-size:16px;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			},{
				field : 'shelfLife',
				title : '<font  style="font-style: normal;font-weight: bolder;font-size:18px;">保质期</font>',
				width : 50,
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font style="font-style: normal; word-wrap:break-word;white-space:normal;font-size:16px;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			},{
				field : 'unit',
				title : '<font  style="font-style: normal;font-weight: bolder;font-size:18px;">单位</font>',
				width : 50,
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font style="font-style: normal; word-wrap:break-word;white-space:normal;font-size:16px;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			}, {
				field : 'waresTypeName',
				title : '<font  style="font-style: normal;font-weight: bolder;font-size:18px;">商品分类</font>',
				width : 120,
				formatter : function(value, row, index) {
					return	'<font style="font-style: normal; word-wrap:break-word;white-space:normal;font-size:16px;">'
					+ value + '</font>'
				}
			},{
				field : 'customCode',
				title : '<font  style="font-style: normal;font-weight: bolder;font-size:18px;">企业自定义代码</font>',
				width : 150,
				formatter : function(value, row, index) {
					if(value!=null){
					return'<font style="font-style: normal;font-size:16px; ">'
					+ value + '</font>';
					}else{
					return "";
							}
				}
			} ,{
				field : 'barCode',
				title : '<font  style="font-style: normal;font-weight: bolder;font-size:18px;">商品条形码</font>',
				width : 150,
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font style="font-style: normal;font-size:16px; ">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			},{
				field : 'enName',
				title : '<font  style="font-style: normal;font-weight: bolder;font-size:18px;">英文名</font>',
				width : 110,
				formatter : function(value, row, index) {
					if(value!=null){
					return'<font style="font-size:16px; ">'
					+ value + '</font>';
					}else{
					return "";
							}
				}
			},{
				field : 'place',
				title : '<font  style="font-style: normal;font-weight: bolder;font-size:18px;">产地</font>',
				width : 50,
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font style="font-style: normal; font-size:16px;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			}
			,{
				field : 'action',
				title : '<font  style="font-style: normal;font-weight: bolder;font-size:18px;">操作</font>',
				width : 100,
				formatter : function(value, row, index) {
					var str = '';
					if ($.canEdit) {
						str += $.formatString('<img onclick="editFun(\'{0}\');" src="{1}" title="编辑"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/pencil.png');
					}
					str += '&nbsp;';
					
					
					if ($.canImage) {
						str += $.formatString('<img onclick="imageFun(\'{0}\');" src="{1}" title="上传图片"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/photoAndPic/photo_add.png');
					}
					
					str += '&nbsp;';
				
					if ($.lookImage) {
						str += $.formatString('<img onclick="lookImage(\'{0}\');" src="{1}" title="查看图片"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/photoAndPic/photo.png');
					}
					
					str += '&nbsp;';
/* 
					if ($.lookSupplier) {
						str += $.formatString('<img onclick="lookSupplier(\'{0}\');" src="{1}" title="查看供应商"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/pencil.png');
					}	
					str += '&nbsp;';
 */
					if ($.editImage) {
						str += $.formatString('<img onclick="editImage(\'{0}\');" src="{1}" title="修改图片"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/photoAndPic/picture_edit.png');
					}	
					str += '&nbsp;';
					if ($.canDelete) {
						str += $.formatString('<img onclick="deleteFun(\'{0}\');" src="{1}" title="删除"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/cancel.png');
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
		parent.$.messager.confirm('询问', '您是否要删除该原料？', function(b) {
			if (b) {
				var currentUserId = '${sessionInfo.id}';/*当前登录用户的ID*/
				if (currentUserId != id) {
					parent.$.messager.progress({
						title : '提示',
						text : '数据处理中，请稍后....'
					});
					$.post('${pageContext.request.contextPath}/waresController/deleteWares', {
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
			title : '编辑原料',
			width :768,
			height : 480,
			href : '${pageContext.request.contextPath}/waresController/editWares?id='+ id,
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
			href : '${pageContext.request.contextPath}/waresController/editImage?id='+ id,
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
			href : '${pageContext.request.contextPath}/waresController/lookImage?id='+ id,
			onOpen: function(){}
		});
	}
	
	function imageFun(id) {
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
			href : '${pageContext.request.contextPath}/waresController/updateImage?id='+ id,
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
	
	function addFun() {
		parent.$.modalDialog({
			title : '添加原料',
			width :768,
			height : 480,
			href : '${pageContext.request.contextPath}/waresController/addWares',
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
	
	function importSupplier() {
		parent.$.modalDialog({
			title : '导入采购品',
			width :300,
			height : 150,
			href : '${pageContext.request.contextPath}/waresController/importPage',
			buttons : [ {
				text : '上传',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#importWare');
					f.submit();
				}
			} ]
		});
	}
	
	//导出excel
	function toExcel(){
	
		var waresName = $("#waresName").val();
		var customCode = $("#customCode").val();
		var waresType = $("#waresType").combo('getValue');
		window.location.href='${pageContext.request.contextPath}/waresController/excel.do?waresName='+waresName+'&waresType='+waresType+'&customCode='+customCode+''
	}
	
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'north',border:false" title="<font  style='font-style: normal;font-weight: bolder;font-size:18px;'>查询条件</font>"  style="height: 80px; overflow: hidden;">
			<form id="searchForm">
				<table class="table table-hover table-condensed" style="display: none;">
					<tr>
						<th>商品名称</th>
						<td><input id="waresName" name="waresName" placeholder="可以商品名称" class="easyui-validatebox"  style="width: 215px;"/></td>
						 <th>企业编码</th>
					     <td><input id="customCode" name="customCode" placeholder="可以查询企业编码" class="easyui-validatebox"  style="width: 215px;"/></td>
						 
						 
						  <th>商品类别</th>
					    <td>
					       <select id="waresType" class="easyui-combobox"  name="waresType"  data-options="width:210,height:24,editable:false,panelHeight:'auto'"
								data-options="required:true"  >	
								<option value="">请选择商品分类</option>							
							    <option value="1">畜产品及其制品</option>   
							    <option value="2">禽及其产品、制品</option>   
							    <option value="3">蔬菜</option>   
							    <option value="4">乳及乳制品</option>   
							    <option value="5">油脂及其制品</option>   
							    <option value="6">水产及其制品</option>   
							    <option value="7">冷冻饮品</option>   
							    <option value="8">水果</option>   
							    <option value="9">粮食和粮食制品</option>   
							    <option value="10">豆类及其制品</option>   
							    <option value="11">食用菌和藻类</option>   
							    <option value="12">可可和巧克力制品及糖果</option>   
							    <option value="13">焙烤食品</option>   
							    <option value="14">甜味料</option>   
							    <option value="15">调味品</option>   
							    <option value="16">特殊膳食用食品</option>   
							    <option value="17">饮料类</option>   
							    <option value="18">酒类</option>   
							    <option value="19">添加剂类</option>   
							    <option value="20">其他类</option>   
							</select>
					    </td>
					    <td>
					    	<a href="javascript:void(0);"  onclick="searchFun();" class="easyui-linkbutton" iconCls="icon-search" ><font  style='font-style: normal;font-weight: bolder;font-size:18px;'>查询</font></a>
					</td></tr>
				
				</table>
			</form>
				
		</div>
		<div id="toolbar" style="display: none;">
				<a class="btn btn-mini btn-light" onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'pencil_add'" iconCls="icon-search" ><font  style='font-style: normal;font-weight: bolder;font-size:16px;'>添加</font> </a>
		
			<a  class="btn btn-mini btn-light" onclick="importSupplier();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'pencil_add'"><font  style='font-style: normal;font-weight: bolder;font-size:18px;'>导入</font></a>
			<a class="btn btn-mini btn-light" onclick="toExcel();" title="导出到EXCEL"><font  style='font-style: normal;font-weight: bolder;font-size:16px;'>导出</font></a>
			<a class="btn btn-mini btn-light"  href="${pageContext.request.contextPath}/templates/采购品.xlsx" class="easyui-linkbutton" data-options="plain:true,iconCls:'pencil_add'"><font  style='font-style: normal;font-weight: bolder;font-size:16px;'>下载模板</font></a>
		</div>		
		<div data-options="region:'center',border:false" id="g">
							<table id="dataGrid" title="<font  style='font-style: normal;font-weight: bolder;font-size:16px;'>采购品表单</font>" data-options="collapsible:true" >
						
							</table>
							<style>
						#g .datagrid-btable tr{height: 45px;}
				</style>
		</div>
	</div>
	

</body>
</html>