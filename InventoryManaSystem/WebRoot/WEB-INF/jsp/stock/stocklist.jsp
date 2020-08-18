<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>

<div class="right">
	<div class="location">
		<strong>你现在所在的位置是:</strong> <span>库存管理页面</span>
	</div>
	<div class="search">
		<%-- 点击查询后提交的位置为${path}/sys/bill --%>
		<form method="get" action="${path}/sys/stock">
			<span>商品名称：</span> <input name="productName" type="text"
				value="${productName }"> <input value="查 询" type="submit"
				id="searchbutton">
		</form>
	</div>
	<!--账单表格 样式和供应商公用-->
	<table class="providerTable" cellpadding="0" cellspacing="0">
		<tr class="firstTr">

			<th width="16%">商品名称</th>
			<th width="21%">商品描述</th>
			<th width="15%">商品数量</th>
			<th width="13%">商品单位</th>
			<!--               <th width="10%">创建者</th> -->
			<th width="15%">创建时间</th>
			<th width="20%">操作</th>
		</tr>
		<c:forEach var="bill" items="${billList }" varStatus="status">
			<tr>

				<td><span>${bill.productName }</span></td>
				<td><span>${bill.productDesc }</span></td>
				<td><span>${bill.productCount }</span></td>
				<td><span>${bill.productUnit }</span></td>
				<td><span> <fmt:formatDate value="${bill.creationDate}"
							pattern="yyyy-MM-dd" />
				</span></td>
				<td><span><a class="viewBill"
						href="${path }/sys/stockview?billid=${bill.id }"><img
							src="${path}/statics/images/read.png" alt="查看" title="查看" /></a></span> <c:if
						test="${bill.isPayment==1 }">
						<span><a class="modifyBill"
							href="${path }/sys/stockmodify?billid=${bill.id }"><img
								src="${path}/statics/images/xiugai.png" alt="修改" title="修改" /></a></span>
					</c:if> <span><a class="deleteBill" href="javascript:;"
						billid=${bill.id } productCount=${bill.productCount }><img
							src="${path}/statics/images/schu.png" alt="删除" title="删除" /></a></span></td>
			</tr>
		</c:forEach>
	</table>
	<input type="hidden" id="totalPageCount" value="${totalPage}" />
	<c:import url="rollpage.jsp">
		<c:param name="totalCount" value="${totalCount}" />
		<c:param name="currentPageNo" value="${currentPage}" />
		<c:param name="totalPageCount" value="${totalPage}" />
	</c:import>
</div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeBi">
	<div class="removerChid">
		<h2>提示</h2>
		<div class="removeMain">
			<p>你确定要删除该信息吗？</p>
			<a href="#" id="yes">确定</a> <a href="#" id="no">取消</a>
		</div>
	</div>
</div>

<%@include file="/WEB-INF/jsp/common/foot.jsp"%>
<script type="text/javascript" src="${path}/statics/js/stocklist.js"></script>