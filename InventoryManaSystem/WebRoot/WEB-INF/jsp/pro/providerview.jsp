<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<div class="right">
	<div class="location">
		<strong>你现在所在的位置是:</strong> <span>供应商管理页面 >> 信息查看</span>
	</div>
	<div class="providerView">
		<p>
			<strong>供应商编码：</strong><span>${provider.providerCode }</span>
		</p>
		<p>
			<strong>供应商名称：</strong><span>${provider.providerName }</span>
		</p>
		<p>
			<strong>联系人：</strong><span>${provider.providerContact }</span>
		</p>
		<p>
			<strong>联系电话：</strong><span>${provider.providerPhone }</span>
		</p>
		<p>
			<strong>传真：</strong><span>${provider.providerFax }</span>
		</p>
		<p>
			<strong>描述：</strong><span>${provider.providerDesc}</span>
		</p>
		<div class="providerAddBtn">
			<input type="button" id="back" name="back" value="返回">
		</div>
	</div>
</div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp"%>
<script type="text/javascript" src="${path}/statics/js/providerview.js"></script>
