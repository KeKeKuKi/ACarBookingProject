<%--
  Created by IntelliJ IDEA.
  User: 31961
  Date: 2019/10/9
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/layui/css/layui.css" type="text/css">
<script src="${pageContext.request.contextPath }/static/layui/layui.js"></script>
<script src="${pageContext.request.contextPath }/static/js/jquery-1.2.6.js"></script>
<head>

<title>懂车行信息管理系统</title>
<script>
	function welcome() {
		$("#mainiforame", parent.document.body).attr("src",
				"${pageContext.request.contextPath }/home/welcome.jsp")
	}

	function getTechnologyFrontend() {
		$("#mainiforame", parent.document.body)
				.attr("src",
						"${pageContext.request.contextPath }/technology/getTechnologyFrontendAndData")
	}
</script>
<script>
	layui.use('element', function() {
		var element = layui.element;

	});
</script>

</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo" onclick="welcom()">懂车行信息管理系统</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item"><a href="">商品管理</a></li>
				<li class="layui-nav-item"><a href="">关于用户</a></li>
				<li class="layui-nav-item"><a href="javascript:;">其它系统</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">邮件管理</a>
						</dd>
						<dd>
							<a href="">消息管理</a>
						</dd>
						<dd>
							<a href="">授权管理</a>
						</dd>
					</dl></li>
			</ul>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> <img
						src="${pageContext.request.contextPath }/static/images/LOGO.png" class="layui-nav-img">
						${sessionScope.user.userName}
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">基本资料</a>
						</dd>
						<dd>
							<a href="">安全设置</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item"><a
					href="${pageContext.request.contextPath }/singoutServlet">注销</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<li class="layui-nav-item"><a class="" href="javascript:;">车辆管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:welcome();">车辆信息维护</a>
							</dd>
							<dd>
								<a href="">车辆订购</a>
							</dd>
						</dl>
					</li>
					<li class="layui-nav-item"><a class="" href="javascript:;">其他管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;">所有用户信息</a>
							</dd>
							<dd>
								<a href="">用户注册</a>
							</dd>
						</dl>
					</li>
					<li class="layui-nav-item"><a href="">发布销售</a></li>
					<li class="layui-nav-item"><a href="">关于</a></li>
				</ul>
			</div>
		</div>

		<div class="layui-body">
				<iframe id="mainiforame"
					src="${pageContext.request.contextPath }/home/firstin.jsp"
					width="100%" height="95%" style="border: medium none;">
				</iframe>
		</div>
		<div class="layui-footer">
			© <a href="http://www.zhaozezhong.fun">zhaozezhong.fun</a> - 欢迎访问主页
		</div>
	</div>

</body>
</html>
