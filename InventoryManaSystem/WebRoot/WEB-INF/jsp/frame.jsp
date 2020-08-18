<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>

<%-- <div class="right">
    <img class="wColck" src="${pageContext.request.contextPath }/statics/images/bangong1.jpg" alt=""/>
    <div class="wFont">
     	<h2>${user.userName }</h2>
      	<p>欢迎来到电子商城库存管理系统!</p>
  	</div>
</div> --%>
<html>
<body>
	<div class="right">
		<div
			style="width: 90%; height: 400px; padding-left: 100px; padding-top: 80px;">
			<div style="width: 100px; height: 100px; float: left;">
				<img alt="car"
					src="${pageContext.request.contextPath }/statics/images/bangong1.jpg"
					style="width: 200px; height: 200px; border-radius: 100%">
			</div>
			<div
				style="width: 450px; height: 200px; float: left; margin-left: 190px; margin-top: 30px;">
				<h1
					style="width: 400px; font-size: 50px; font-family: inherit; color: #ffD21b; text-shadow: 2px 2px #000;">${user.userName }</h1>
				<h1
					style="margin-top: 20px; font-size: 30px; font-family: inherit; color: #30A2AA; text-shadow: 1px 1px #000;">欢迎来到电子商城库存管理系统!</h1>
			</div>
		</div>
	</div>
</body>

</html>
<!-- include指令：当JSP转换成Servlet时引入指定文件 -->
<%@include file="/WEB-INF/jsp/common/foot.jsp"%>
