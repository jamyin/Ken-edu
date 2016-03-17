<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>项目管理</title>
<jsp:include page="../../inc.jsp"></jsp:include>
	<c:if 
	    test="${fn:contains(sessionInfo.resourceList, '/projectController/addPage')}">
			<script type="text/javascript">
		$.canAddDept= true;
	</script>
		</c:if>

<script type="text/javascript">
	var dataGrid;
	var treeGrid;
    var editRow = undefined; //定义全局变量：当前编辑的行
	$(function() {
		dataGrid = $('#dataGrid').datagrid({
			url : '${pageContext.request.contextPath}/projectController/dataGrid',
			fit : true,
			fitColumns : true,
			border : false,
			pagination : true,
			rownumbers : true,
			idField : 'id',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'name',
			sortOrder : 'asc',
			checkOnSelect : false,
			selectOnCheck : true,
			nowrap : false,
			frozenColumns : [ [ {
				field : 'id',
				title : '编号',
				width : 244,
				checkbox : true,
				hidden : true
			}, {
				field : 'projName',
				title : '项目名称',
				width : 210,
				 editor: { type: 'validatebox', options: { required: true}}
			} ] ],
			columns : [ [ {
				field : 'describes',
				title : '描述',
				width : 300,
				 editor: { type: 'validatebox', options: { required: true}}
			},	{
				field : 'createTime',
				title : '创建时间',
				width : 240,
				formatter : function(value, row, index) {
					var unixTimestamp = new Date(value);
					return '<font style="font-style: normal;font-weight: bolder;">'
							+ (unixTimestamp
									.toLocaleString())
							+ '</font>';
				}

			},{
				field : 'lastUpdateTime',
				title : '更新时间',
				width : 240,
				formatter : function(value, row, index) {
					var unixTimestamp = new Date(value);
					if(value!=null){
					return '<font style="font-style: normal;font-weight: bolder;">'
							+ (unixTimestamp
									.toLocaleString())
							+ '</font>';}else{
								return '';
							}
				}

			},{
				field : 'userNames',
				title : '项目所有用户',
				width : 400
			},
			{
				field : 'action',
				title : '操作',
				width : 150,
				formatter : function(value, row, index) {
					var str = '';
					
						str += $.formatString('<img onclick="editFun(\'{0}\');" src="{1}" title="编辑"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/pencil.png');
					
				        str += '&nbsp;';
				
						str += $.formatString('<img onclick="adduserFun(\'{0}\');" src="{1}" title="用户授权"/>', row.id, '${pageContext.request.contextPath}/style/images/extjs_icons/key.png');
				
						
					return str;
				}
			} ] ],
			queryParams: { action: 'query' }, //查询参数
			//toolbar : '#toolbar',
			    toolbar: [{ text: '添加', iconCls: 'pencil_add', handler: function () {//添加列表的操作按钮添加，修改，删除等
                    //添加时先判断是否有开启编辑的行，如果有则把开户编辑的那行结束编辑
                    if (editRow != undefined) {
                    	dataGrid.datagrid("endEdit", editRow);
                    }
                    //添加时如果没有正在编辑的行，则在datagrid的第一行插入一行
                    if (editRow == undefined) {
                    	dataGrid.datagrid("insertRow", {
                            index: 0, // index start with 0
                            row: {

                            }
                        });
                        //将新插入的那一行开户编辑状态
                        dataGrid.datagrid("beginEdit", 0);
                        //给当前编辑的行赋值
                        editRow = 0;
                    }

                }
                }, '-',
                 { text: '删除', iconCls: 'l-btn-icon delete', handler: function () {
                     //删除时先获取选择行
                     var rows = dataGrid.datagrid("getSelections");
                     //选择要删除的行
                     if (rows.length > 0) {
                              var ids = [];
                                 for (var i = 0; i < rows.length; i++) {
                                     ids.push(rows[i].ID);
                                     deleteFun(rows[i].ID);
                                 }
                     }
                     else {
                         $.messager.alert("提示", "请选择要删除的行", "error");
                     }
                 }
                 }, 
                  '-',
                 { text: '保存', iconCls: 'icon-ok', handler: function () {
                     //保存时结束当前编辑的行，自动触发onAfterEdit事件如果要与后台交互可将数据通过Ajax提交后台
                     dataGrid.datagrid("endEdit", editRow);
                 }
                 }, '-',
                 { text: '取消编辑', iconCls: 'pencil_delete', handler: function () {
                     //取消当前编辑行把当前编辑行罢undefined回滚改变的数据,取消选择的行
                	 cancelEdit();
                 }
                 },'-',
                 { text: '搜索', iconCls: 'icon-search', handler: function () {
                     editRow = undefined;
                	 searchFun();
                 }
                 }, '-'],
                onAfterEdit: function (rowIndex, rowData, changes) {
                    //endEdit该方法触发此事件
                    var a= $.isEmptyObject(changes);
                   if(a==false){
               		parent.$.messager.confirm('询问', '您是否要提交刚才编辑的内容？', function(b) {
            			if (b) {
                	     //如果不是空数组（做过修改）, 则提交到后台
                	     insertOrEdit(rowData);
                        }
               		});
                   }
                   cancelEdit();
              	
                },
                onDblClickRow: function (rowIndex, rowData) {
                //双击开启编辑行
        
                    if (editRow != undefined) {
                     	dataGrid.datagrid("endEdit", editRow);
                 }
                    if (editRow == undefined) {
                    	dataGrid.datagrid("beginEdit", rowIndex);
                        editRow = rowIndex;
                    }
                },
			onLoadSuccess : function() {
				$('#searchForm table').show();
				parent.$.messager.progress('close');

				//$(this).datagrid('tooltip');
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

function cancelEdit(){
    editRow = undefined;
    dataGrid.datagrid("rejectChanges");
    dataGrid.datagrid("unselectAll");
}

	function deleteFun(id) {
		if (id == undefined) {//点击右键菜单才会触发这个
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].id;
		} else {//点击操作里面的删除图标会触发这个
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.messager.confirm('询问', '您是否要删除当前项目？', function(b) {
			if (b) {
				var currentUserId = '${sessionInfo.id}';/*当前登录用户的ID*/
				if (currentUserId != id) {
					parent.$.messager.progress({
						title : '提示',
						text : '数据处理中，请稍后....'
					});
					$.post('${pageContext.request.contextPath}/projectController/delete', {
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
			href : '${pageContext.request.contextPath}/projectController/editProject?id=' + id,
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

	function addFun() {
		parent.$.modalDialog({
			title : '添加项目',
			width : 700,
			height : 130,
			href : '${pageContext.request.contextPath}/projectController/addPage',
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

function insertOrEdit(rowData){
    $.post('${pageContext.request.contextPath}/projectController/insertOrEdit',{
		"id":               rowData.id,
		"projName": rowData.projName,
		"describes":  rowData.describes
	}, function(result) {
		if (result.success) {
			parent.$.messager.alert('提示', result.msg, 'info');
			dataGrid.datagrid('reload');
		}else {
			parent.$.messager.alert('错误', result.msg, 'error');
		}
		parent.$.messager.progress('close');
	}, 'JSON');
    editRow = undefined;
}
	


	function searchFun() {
		dataGrid.datagrid('load', $.serializeObject($('#searchForm')));
	}
	function cleanFun() {
		$('#searchForm input').val('');
	
		dataGrid.datagrid('load', {});
	}
	

	
/* 	function adduserFun(id) {
		dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		parent.$.modalDialog({
			title : '用户授权',
			width : 680,
			height : 800,
			href : '${pageContext.request.contextPath}/projectController/grantUserPage?ids=' + id,
			buttons : [ {
				text : '授权',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为授权成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#form');
					f.submit();
				}
			} ]
		});
	} */
	
	
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
						<th>项目描述</th>
						<td><input name="describes" placeholder="可以查询描述" class="span2" style="width:279px;"/></td>
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