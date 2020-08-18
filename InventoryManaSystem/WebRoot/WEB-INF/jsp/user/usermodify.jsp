<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<div class="right">
	<div class="location">
		<strong>你现在所在的位置是:</strong> <span>用户管理页面 >> 用户修改页面</span>
	</div>
	<div class="providerAdd">
		<form id="userForm" name="userForm" method="post"
			enctype="multipart/form-data"
			action="${path}/sys/admin/modifyusersave?userPhoto=${user2.userPhoto}">
			<input type="hidden" name="id" value="${user2.id }" />
			<div>
				<label for="userName">用户名称：</label> <input type="text"
					name="userName" id="userName" value="${user2.userName }"> <font
					color="red"></font>
			</div>
			<div>
				<label>用户性别：</label> <select name="gender" id="gender">
					<c:choose>
						<c:when test="${user2.gender == 1 }">
							<option value="1" selected="selected">男</option>
							<option value="2">女</option>
						</c:when>
						<c:otherwise>
							<option value="1">男</option>
							<option value="2" selected="selected">女</option>
						</c:otherwise>
					</c:choose>
				</select>
			</div>
			<div>
				<label for="data">出生日期：</label> <input type="text" Class="Wdate"
					id="birthday" name="birthday" value="${user2.birthday }"
					readonly="readonly" onclick="WdatePicker();"> <font
					color="red"></font>
			</div>

			<div>
				<label for="userphone">用户电话：</label> <input type="text" name="phone"
					id="phone" value="${user2.phone }"> <font color="red"></font>
			</div>
			<div>
				<label for="userAddress">用户地址：</label> <input type="text"
					name="address" id="address" value="${user2.address }">
			</div>
			<div>
				<label>用户角色：</label>
				<!-- 列出所有的角色分类 -->
				<input type="hidden" value="${user2.userRole }" id="rid" /> <select
					name="userRole" id="userRole"></select> <font color="red"></font>
			</div>
			<div>
				<label for="userAddress">用户头像：</label> <br> <img alt="加载中..."
					class="photo" style="margin-left: 200px"
					src="${pageContext.request.contextPath }/statics/upload/${user2.userPhoto }" />
				<a class="file" style="width: 75px;"> 选择头像<input type="file"
					name="photo" id="photo">
				</a>
			</div>
			<div class="providerAddBtn">
				<input type="button" name="save" id="save" value="保存" /> <input
					type="button" id="back" name="back" value="返回" />
			</div>
		</form>
	</div>
</div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/js/usermodify.js"></script>
