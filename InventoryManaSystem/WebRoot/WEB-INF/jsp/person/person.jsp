<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<div class="right"
	style="background-image:url('${pageContext.request.contextPath }/statics/images/.jpg');">
	<div id="header" class="location">
		<strong>你现在所在的位置是:</strong> <span>个人中心界面</span>
	</div>
	<div
		style="width: 95%; height: 500px; padding-left: 60px; padding-top: 30px; border: 2px solid #009090; border-radius: 10px">
		<h1 style="font-size: 24px; height: 50px; color: #4682be">----------------------欢迎进入***${user.userName }***的个人空间----------------------</h1>
		<p style="font-size: 18px; height: 30px;">
			姓名：<span style="color: #bd644e;">${user.userName }</span>
		</p>
		<p style="font-size: 18px; height: 30px;">
			年龄：<span style="color: #bd644e;">${user.age }</span>
		</p>
		<p style="font-size: 18px; height: 30px;">
			电话：<span style="color: #bd644e;">${user.phone }</span>
		</p>
		<p style="font-size: 18px; height: 30px;">
			身份： <span style="color: #bd644e;"> <c:if
					test="${user.userRole==1}">系统管理员</c:if> <c:if
					test="${user.userRole==2}">经理</c:if> <c:if
					test="${user.userRole==3}">普通员工</c:if>
			</span>
		</p>
		<div class="photo" style="margin-right: 60px; margin-top: 10px;">
			<p style="font-size: 18px">头像：</p>
			<img alt="加载中..." class="photo"
				src="${pageContext.request.contextPath }/statics/upload/${user.userPhoto }" />
			<form
				action="${pageContext.request.contextPath }/sys/userPhotoModify?userid=${user.id }"
				enctype="multipart/form-data" method="post">
				<div
					style="float: left; width: 600px; height: 50px; margin-top: 10px">
					<div style="float: left; margin-top: 5px">
						<a class="file"
							style="font-size: 15px; font-weight: bold; width: 80px; height: 50px; text-align: center;">
							修改<input type="file" name="photo" id="photo">
						</a>
					</div>
					<div style="float: left; margin-left: 25px;">
						<input type="submit" value="保 存"
							style="font-size: 15px; font-weight: bold; width: 80px; letter-spacing: 3px; text-align: center;">
					</div>
				</div>

			</form>
		</div>
		<!--         </div> -->
	</div>
	<!-- <footer style="width: 100%;line-height: 40px;text-align: center;color: white;">版权</footer> -->
</div>
<%@include file="/WEB-INF/jsp/common/foot.jsp"%>