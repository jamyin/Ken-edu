<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<jsp:include page="../inc.jsp"></jsp:include>
<!-- <script type="text/javascript" charset="utf-8">
	var portalLayout;
	var portal;
	$(function() {
		portalLayout = $('#portalLayout').layout({
			fit : true
		});
		$(window).resize(function() {
			portalLayout.layout('panel', 'center').panel('resize', {
				width : 1,
				height : 1
			});
		});

		panels = [ {
			id : 'p1',
			title : '教委系统架构图',
			height : 200,
			collapsible : true,
			href : '${pageContext.request.contextPath}/baseController/portal/about'
		}, {
			id : 'p2',
			title : '面板顺序说明',
			height : 200,
			collapsible : true,
			href : '${pageContext.request.contextPath}/baseController/portal/seq'
		}, {
			id : 'p3',
			title : '修复数据库',
			height : 200,
			collapsible : true,
			href : '${pageContext.request.contextPath}/baseController/portal/repair'
		}, {
			id : 'p4',
			title : '教委系统架构介绍',
			height : 200,
			collapsible : true,
			href : '${pageContext.request.contextPath}/baseController/portal/link'
		}, {
			id : 'p5',
			title : '教委开发人员介绍',
			height : 200,
			collapsible : true,
			href : '${pageContext.request.contextPath}/baseController/portal/about2'
		}, {
			id : 'p6',
			title : '更新日志',
			height : 200,
			collapsible : true,
			href : '${pageContext.request.contextPath}/baseController/portal/qun'
		} ];

		portal = $('#portal').portal({
			border : false,
			fit : true,
			onStateChange : function() {
				$.cookie('portal-state', getPortalState(), {
					expires : 7
				});
			}
		});
		var state = $.cookie('portal-state');
		if (!state) {
			state = 'p1,p2,p3:p4,p5,p6';/*冒号代表列，逗号代表行*/
		}
		addPortalPanels(state);
		portal.portal('resize');

	});

	function getPanelOptions(id) {
		for ( var i = 0; i < panels.length; i++) {
			if (panels[i].id == id) {
				return panels[i];
			}
		}
		return undefined;
	}
	function getPortalState() {
		var aa = [];
		for ( var columnIndex = 0; columnIndex < 2; columnIndex++) {
			var cc = [];
			var panels = portal.portal('getPanels', columnIndex);
			for ( var i = 0; i < panels.length; i++) {
				cc.push(panels[i].attr('id'));
			}
			aa.push(cc.join(','));
		}
		return aa.join(':');
	}
	function addPortalPanels(portalState) {
		var columns = portalState.split(':');
		for ( var columnIndex = 0; columnIndex < columns.length; columnIndex++) {
			var cc = columns[columnIndex].split(',');
			for ( var j = 0; j < cc.length; j++) {
				var options = getPanelOptions(cc[j]);
				if (options) {
					var p = $('<div/>').attr('id', options.id).appendTo('body');
					p.panel(options);
					portal.portal('add', {
						panel : p,
						columnIndex : columnIndex
					});
				}
			}
		}
	}</script> -->

</head>
<body>
	<div id="portalLayout">
								<h1 align="center"  ><font color="read ">这片弹幕由我承包</font></h1>
									<h1 align="center"  ><font color="RoyalBlue  ">这片弹幕由我承包</font></h1>
								<h1 align="center"  ><font color="red ">这片弹幕由我承包</font></h1>
								<h1 align="center"  ><font color="Yellow  ">这片弹幕由我承包</font></h1>								
								<h1 align="center"  ><font color="VioletRed">这片弹幕由我承包</font></h1>
								<h1 align="center"  ><font color="red ">王老菊</font></h1>
								<h1 align="center"  ><font color="PaleGreen  ">此人智商高达50</font></h1>
		<h1 align="left"  ><font color="AntiqueWhite ">还有谁</font></h1>			<h1 align="right"  ><font color="red">还有谁</font></h1>  	<h1 align="center"  ><font color="red">还有谁</font></h1>
		<h1 align="left"  ><font color="AntiqueWhite ">还有谁</font></h1>			<h1 align="right"  ><font color="AntiqueWhite ">还有谁</font></h1> <h1 align="center"  ><font color="AntiqueWhite ">还有谁</font></h1>
					<h1 align="left"  ><font color="Aqua">还有谁</font></h1> 
		<h1 align="left"  ><font color="AntiqueWhite ">还有谁</font></h1>			<h1 align="right"  ><font color="Aquamarine ">还有谁</font></h1> 
	<h1 align="left"  ><font color="AntiqueWhite ">还有谁</font></h1>				<h1 align="center"  ><font color="Azure ">还有谁</font></h1> <h1 align="center"  ><font color="AntiqueWhite ">还有谁</font></h1>
	<h1 align="left"  ><font color="AntiqueWhite ">还有谁</font></h1>				<h1 align="center"  ><font color="Beige ">还有谁</font></h1> 
					<h1 align="left"  ><font color="Bisque ">还有谁</font></h1> <h1 align="center"  ><font color="AntiqueWhite ">还有谁</font></h1>
		<h1 align="center"  ><font color="AntiqueWhite ">还有谁</font></h1>			<h1 align="right"  ><font color="Black">还有谁</font></h1> 
					<h1 align="left"  ><font color="BlanchedAlmond ">还有谁</font></h1> 
					<h1 align="left"  ><font color="Blue">还有谁</font></h1> <h1 align="center"  ><font color="AntiqueWhite ">还有谁</font></h1>
	<h1 align="left"  ><font color="AntiqueWhite ">还有谁</font></h1>				<h1 align="center"  ><font color="BlueViolet ">还有谁</font></h1> 
					<h1 align="center"  ><font color="Brown">还有谁</font></h1> <h1 align="center"  ><font color="AntiqueWhite ">还有谁</font></h1>
	<h1 align="left"  ><font color="AntiqueWhite ">还有谁</font></h1>				<h1 align="center"  ><font color="BurlyWood">还有谁</font></h1> 
					<h1 align="left"  ><font color="BurlyWood">还有谁</font></h1><h1 align="center"  ><font color="AntiqueWhite ">还有谁</font></h1>
	<h1 align="center"  ><font color="AntiqueWhite ">还有谁</font></h1>				<h1 align="left"  ><font color="AntiqueWhite ">还有谁</font></h1> 
					<h1 align="left"  ><font color="Aqua">还有谁</font></h1> <h1 align="center"  ><font color="AntiqueWhite ">还有谁</font></h1>
		<h1 align="center"  ><font color="AntiqueWhite ">还有谁</font></h1>			<h1 align="left"  ><font color="Aquamarine ">还有谁</font></h1> <h1 align="center"  ><font color="AntiqueWhite ">还有谁</font></h1>
					<h1 align="left"  ><font color="Azure ">还有谁</font></h1> 
					<h1 align="left"  ><font color="Beige ">还有谁</font></h1> <h1 align="center"  ><font color="AntiqueWhite ">还有谁</font></h1>
					<h1 align="left"  ><font color="Bisque ">还有谁</font></h1> 
	<h1 align="center"  ><font color="AntiqueWhite ">还有谁</font></h1>				<h1 align="left"  ><font color="Black">还有谁</font></h1> 
					<h1 align="left"  ><font color="BlanchedAlmond ">还有谁</font></h1> 
					<h1 align="right"  ><font color="Blue">还有谁</font></h1> 
					<h1 align="right"  ><font color="BlueViolet ">还有谁</font></h1> 
					<h1 align="left"  ><font color="Brown">还有谁</font></h1> 
					<h1 align="left"  ><font color="BurlyWood">还有谁</font></h1> 
	</div>
</body>
</html>