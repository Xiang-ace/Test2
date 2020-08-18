<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>超市账单管理系统</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/style.css">
</head>
<body
	style="background-image: url('${pageContext.request.contextPath}/statics/images/error.jpg');">
	<div style="height: 300px"></div>
	<div style="margin-top: 60px;">
		<h2 style="text-align: center; font-size: 40px; color: white">
			对不起，您不是系统管理员没有权限访问，请<a
				href="${pageContext.request.contextPath }/sys/frame"
				style="color: red; text-decoration: none">返回</a>
		</h2>
	</div>
	<!--/span-->
	<div style="text-align: center;">
		<!-- <img src="statics/images/jg.png" /> -->
	</div>
	<!--/span-->

</body>
</html>


