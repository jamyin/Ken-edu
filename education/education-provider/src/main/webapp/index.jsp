<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>团餐管理系统</title>
<jsp:include page="inc.jsp"></jsp:include>
<script type="text/javascript">
	var index_tabs;
	var index_tabsMenu;
	var index_layout;
	$(function() {
		index_layout = $('#index_layout').layout({
			fit : true
		});
		/*index_layout.layout('collapse', 'east');*/

		index_tabs = $('#index_tabs')
				.tabs(
						{
							fit : true,
							border : false,
							onContextMenu : function(e, title) {
								e.preventDefault();
								index_tabsMenu.menu('show', {
									left : e.pageX,
									top : e.pageY
								}).data('tabTitle', title);
							},
							tools : [ {
								iconCls : 'database_refresh',
								handler : function() {
									var href = index_tabs.tabs('getSelected')
											.panel('options').href;
									if (href) {/*说明tab是以href方式引入的目标页面*/
										var index = index_tabs.tabs(
												'getTabIndex', index_tabs
														.tabs('getSelected'));
										index_tabs.tabs('getTab', index).panel(
												'refresh');
									} else {/*说明tab是以content方式引入的目标页面*/
										var panel = index_tabs.tabs(
												'getSelected').panel('panel');
										var frame = panel.find('iframe');
										try {
											if (frame.length > 0) {
												for (var i = 0; i < frame.length; i++) {
													frame[i].contentWindow.document
															.write('');
													frame[i].contentWindow
															.close();
													frame[i].src = frame[i].src;
												}
												if (navigator.userAgent
														.indexOf("MSIE") > 0) {// IE特有回收内存方法
													try {
														CollectGarbage();
													} catch (e) {
													}
												}
											}
										} catch (e) {
										}
									}
								}
							}
							/* 			, {
							 iconCls : 'delete',
							 handler : function() {
							 var index = index_tabs.tabs('getTabIndex', index_tabs.tabs('getSelected'));
							 var tab = index_tabs.tabs('getTab', index);
							 if (tab.panel('options').closable) {
							 index_tabs.tabs('close', index);
							 } else {
							 $.messager.alert('提示', '[' + tab.panel('options').title + ']不可以被关闭！', 'error');
							 }
							 }
							 }  */
							]
						});

		index_tabsMenu = $('#index_tabsMenu').menu(
				{
					onClick : function(item) {
						var curTabTitle = $(this).data('tabTitle');
						var type = $(item.target).attr('title');

						if (type === 'refresh') {
							index_tabs.tabs('getTab', curTabTitle).panel(
									'refresh');
							return;
						}

						if (type === 'close') {
							var t = index_tabs.tabs('getTab', curTabTitle);
							if (t.panel('options').closable) {
								index_tabs.tabs('close', curTabTitle);
							}
							return;
						}

						var allTabs = index_tabs.tabs('tabs');
						var closeTabsTitle = [];

						$.each(allTabs, function() {
							var opt = $(this).panel('options');
							if (opt.closable && opt.title != curTabTitle
									&& type === 'closeOther') {
								closeTabsTitle.push(opt.title);
							} else if (opt.closable && type === 'closeAll') {
								closeTabsTitle.push(opt.title);
							}
						});

					for (var i = 0; i < closeTabsTitle.length; i++) {
							index_tabs.tabs('close', closeTabsTitle[i]);
						}
					}
				});
	}); 
	
	function loadUrl(_this){
		var params = new Object();
		
		params.url = $(_this).attr("data-src");
		params.title = $(_this).attr("data-text");
		params.iconCls = $(_this).attr("iconCls");
		
		
		$(".tabs-title").html(params.title);
		//$("#index_tabs").find("span .tabs-title").html(params.title);
		//console.log($("#index_tabs").find("span .tabs-title"));
		$("#indexContext").attr("src",params.url);
		/* var iframe = '<iframe src="'
				+ params.url
				+ '" frameborder="0" style="border:0;width:100%;height:98%;"></iframe>';
		var t = $('#index_tabs');
		var opts = {
			title : params.title,
			closable : true,
			iconCls : params.iconCls,
			content : iframe,
			border : false,
			fit : true
		};
		if (t.tabs('exists', opts.title)) {
			t.tabs('select', opts.title);
			parent.$.messager.progress('close');
		} else {
			t.tabs('add', opts);
		} */
	};
</script>
</head>
<body>

	<jsp:include page="user/login.jsp"></jsp:include>
	<jsp:include page="user/reg.jsp"></jsp:include>

	<div id="index_layout">
		<div data-options="region:'north',href:'${pageContext.request.contextPath}/layout/north.jsp'" style="height: 70px; overflow: hidden;" class="logo"></div>
		<%-- <div data-options="region:'west',href:'${pageContext.request.contextPath}/layout/west.jsp',split:true" title="模块导航" style="width: 200px; overflow: hidden;"></div> --%>
		<div data-options="region:'center'" title="<font  style='font-style: normal;font-weight: bolder;font-size:18px;'>欢迎使用团餐供应商系统</font>" style="overflow: hidden;">
			<div style="padding:5px;background:#fafafa;width:100%;border:1px solid #ccc">
				<a onclick="loadUrl(this);" data-src="waresController/manager" data-text="采购品管理" class="easyui-linkbutton" plain="true" iconCls="icon-edit">
								<font  style="font-style: normal;font-size:18px;">采购品管理</font>
				</a>
				<a onclick="loadUrl(this);" data-src="proSupplierController/manager" data-text="供应商管理" class="easyui-linkbutton" plain="true" iconCls="icon-refresh">
				<font  style="font-style: normal;font-size:18px;">供应商管理</font>
				</a>
				<a onclick="loadUrl(this);" data-src="ledgerController/manager" data-text="配货管理" class="easyui-linkbutton" plain="true" iconCls="icon-search">
				<font  style="font-style: normal;font-size:18px;">配货管理</font>
				</a>
				
				<a onclick="loadUrl(this);" data-src="ledgerAddressController/manager" data-text="配货点管理" class="easyui-linkbutton" plain="true" iconCls="icon-print">
				<font  style="font-style: normal;font-size:18px;">配货点管理</font>
				</a>
				<a onclick="loadUrl(this);" data-src="userController/manager" data-text="用户管理" class="easyui-linkbutton" plain="true"  iconCls="icon-pencil"><font  style="font-style: normal;font-size:18px;">用户管理</font></a>
				<a onclick="loadUrl(this);" data-src="personalController/manager" data-text="个人中心" class="easyui-linkbutton" plain="true"  iconCls="icon-user"><font  style="font-style: normal;font-size:18px;">个人中心</font></a>
				<a onclick="loadUrl(this);" data-src="corporateController/manager" data-text="我的信息" class="easyui-linkbutton" plain="true" iconCls="icon-ok">
				<font  style="font-style: normal;font-size:18px;">
				我的信息</font>
				
				</a>
			</div>
			<div id="index_tabs" style="overflow: hidden;">
				<div title="<font  style='font-style: normal;font-weight: bolder;font-size:18px;'>首页</font>" data-options="border:false" style="overflow: hidden;">
					<iframe id="indexContext" src="${pageContext.request.contextPath}/portal/index.jsp" frameborder="0" style="border: 0; width: 100%; height: 90%;"></iframe>
				</div>
			</div>
		</div>


	</div>

	<div id="index_tabsMenu" style="width: 120px; display: none;">
		<div title="refresh" data-options="iconCls:'transmit'">刷新</div>
		<div class="menu-sep"></div>
		<div title="close" data-options="iconCls:'delete'">关闭</div>
		<div title="closeOther" data-options="iconCls:'delete'">关闭其他</div>
		<div title="closeAll" data-options="iconCls:'delete'">关闭所有</div>
	</div>

</body>
</html>