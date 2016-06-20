<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<style>
.panel-body {
	font-size: 18px !important;
}
.act {
	padding-top: 7px!important;;
	padding-bottom: 7px!important;;
}
.textbox .textbox-text {
	 cursor:pointer;
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
				title : '<font  style="font-style: normal; font-size:18px;">原料名称</font>',
				width : 120,
				
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font  style="font-style: normal;font-size:15px;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			},{
				field : 'amountUnit',
				title : '<font  style="font-style: normal; font-size:18px;">数量单位</font>',
				width : 50,
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font style="font-style: normal;  font-size:15px;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			}, {
				field : 'spec',
				title : '<font  style="font-style: normal; font-size:18px;">规格</font>',
				width : 50,
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font style="font-style: normal;  font-size:15px;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			},{
				field : 'manufacturer',
				title : '<font  style="font-style: normal; font-size:18px;">生产企业</font>',
				width : 150,
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font style="font-style: normal; font-size:15px;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			},{
				field : 'shelfLife',
				title : '<font  style="font-style: normal; font-size:18px;">保质期</font>',
				width : 50,
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font style="font-style: normal; word-wrap:break-word;white-space:normal;font-size:15px;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			},{
				field : 'unit',
				title : '<font  style="font-style: normal; font-size:18px;">保质期单位</font>',
				width : 50,
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font style="font-style: normal; word-wrap:break-word;white-space:normal;font-size:15px;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			}, {
				field : 'waresTypeName',
				title : '<font  style="font-style: normal; font-size:18px;">原料分类</font>',
				width : 120,
				formatter : function(value, row, index) {
					return	'<font style="font-style: normal; word-wrap:break-word;white-space:normal;font-size:15px;">'
					+ value + '</font>'
				}
			},{
				field : 'place',
				title : '<font  style="font-style: normal; font-size:18px;">产地</font>',
				width : 50,
				formatter : function(value, row, index) {
					if(value!=null){
					return '<font style="font-style: normal; font-size:15px;">'
							+ value + '</font>';
					}else{
					return "";
							}
				}
			}
			,{
				field : 'action',
				title : '<font  style="font-style: normal; font-size:18px;">操作</font>',
				width : 100,
				formatter : function(value, row, index) {
					var str = '';
					if ($.canEdit) {
						str += $.formatString('<img onclick="editFun(\'{0}\');" src="{1}" title="编辑"/>', row.id, '${pageContext.request.contextPath}/icon/编辑.png');
					}
		/* 			str += '&nbsp;';
					
					
					if ($.canImage) {
						str += $.formatString('<img onclick="imageFun(\'{0}\');" src="{1}" title="上传图片"/>', row.id, '${pageContext.request.contextPath}/icon/上传图片.png');
					}
					
					str += '&nbsp;';
				
					if ($.lookImage) {
						str += $.formatString('<img onclick="lookImage(\'{0}\');" src="{1}" title="查看图片"/>', row.id, '${pageContext.request.contextPath}/icon/查看图片.png');
					}
					 */
					str += '&nbsp;';
/* 
					if ($.lookSupplier) {
						str += $.formatString('<img onclick="lookSupplier(\'{0}\');" src="{1}" title="查看供应商"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/pencil.png');
					}	
					str += '&nbsp;';
 */
					if ($.editImage) {
						str += $.formatString('<img onclick="editImage(\'{0}\');" src="{1}" title="编辑图片"/>', row.id, '${pageContext.request.contextPath}/icon/编辑图片.png');
					}	
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
		parent.$.messager.confirm('询问', '您是否要删除该采购品？', function(b) {
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
			height : 420,
			href : '${pageContext.request.contextPath}/waresController/editWares?id='+ id,
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
	
	function addFun() {
		parent.$.modalDialog({
			title : '添加原料',
			width :768,
			height : 420,
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
			} ],
		onOpen: function(){},
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
			onOpen: function(){},
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
			width :340,
			height : 130,
			href : '${pageContext.request.contextPath}/waresController/importPage',
			onOpen: function(){},
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

/* 	window.onload=function(){
		alert($("#datagrid-header-over"));
		$("#datagrid-header-over").each(function(){
			alert($(this).html());
		});
	} */
	
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'north',border:false" title="<font  style='font-style: normal;font-size:18px;'>查询条件</font>"  style="height: 80px; overflow: hidden;">
			<form id="searchForm">
				<table class="table table-hover table-condensed" style="display: none;">
					<tr>
						<td style='padding-top: 10px;'>原料名称:
						<input id="waresName" name="waresName" placeholder="查询原料名称" class="easyui-validatebox"  style="width: 215px;"/></td>
						
						  <td style='padding-top: 10px;'>原料类别:
					    
					       <select id="waresType" class="easyui-combobox"  name="waresType" data-options="width:210,height:24,editable:false,panelHeight:'auto'"
								data-options="required:true"  >	
								<option value="0">请选择商品类别</option>										
							    <option value="1">粮食及其制品</option>   
							    <option value="2">畜产品及其制品</option>   
							    <option value="3">禽及其产品、制品</option>   
							    <option value="4">蔬菜</option>   
							    <option value="5"> 水果</option>   
							    <option value="6">水产品</option>   
							    <option value="7">豆制品</option>   
							    <option value="8">乳品</option>   
							    <option value="9">食用油</option>   
							    <option value="10">其它类别的食品和食用农产品</option>   
							     
							</select>
							&nbsp;&nbsp;&nbsp;
							<a href="javascript:void(0);"  onclick="searchFun();" ><img src="${pageContext.request.contextPath}/icon/查询.png" ></img></a>
					    </td>
					 </tr>
				
				</table>
			</form>
				
		</div>
		<div id="toolbar" style="display: none;" class="act" >
		
				<a onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true" ><img src="${pageContext.request.contextPath}/icon/添加.png" ></img></a>
				&nbsp;
			<a onclick="importSupplier();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true"><img src="${pageContext.request.contextPath}/icon/导入.png"></img></a>
			&nbsp;
			<a onclick="toExcel();" title="导出到EXCEL"><img src="${pageContext.request.contextPath}/icon/导出.png"></img></a>
			&nbsp;
			<a href="${pageContext.request.contextPath}/templates/采购品.xlsx" class="easyui-linkbutton" data-options="plain:true"><img src="${pageContext.request.contextPath}/icon/下载模板.png"></img></a>

		</div>		
		<div data-options="region:'center',border:false" id="g">
							<table id="dataGrid" title="<font  style='font-style: normal;font-weight: bolder;font-size:16px;'>原料表单</font>" data-options="collapsible:true" >
						
							</table>
							<style>
						#g .datagrid-btable tr{height: 45px;}
				</style>
		</div>
	</div>
	

</body>
</html>
