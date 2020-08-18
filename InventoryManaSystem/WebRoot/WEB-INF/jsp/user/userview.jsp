<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<div class="right">
	<div class="location">
		<strong>你现在所在的位置是:</strong> <span>用户管理页面 >> 用户信息查看页面</span>
	</div>
	<div class="providerView">
		<p>
			<strong>用户编号：</strong><span>${user1.userCode }</span>
		</p>
		<p>
			<strong>用户名称：</strong><span>${user1.userName }</span>
		</p>
		<p>
			<strong>用户性别：</strong> <span> <c:if
					test="${user1.gender == 1 }">男</c:if> <c:if
					test="${user1.gender == 2 }">女</c:if>
			</span>
		</p>
		<p>
			<strong>出生日期：</strong><span>${user1.birthday }</span>
		</p>
		<p>
			<strong>用户电话：</strong><span>${user1.phone }</span>
		</p>
		<p>
			<strong>用户地址：</strong><span>${user1.address }</span>
		</p>
		<p>
			<strong>用户角色：</strong><span>${user1.role.roleName}</span>
		</p>
		<p>
			<strong>用户头像：</strong><br> <img alt="加载中..." class="photo"
				style="margin-left: 200px"
				src="${pageContext.request.contextPath }/statics/upload/${user1.userPhoto }" />
		</p>
		<div class="providerAddBtn">
			<input type="button" id="back" name="back" value="返回">
		</div>
	</div>
</div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp"%>
<script type="text/javascript" src="${path}/statics/js/userview.js"></script>