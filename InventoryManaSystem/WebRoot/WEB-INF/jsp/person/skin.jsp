<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<html>
<head>
<style type="text/css">
body {
	background-size: cover;
	background-color: yellow;
}

.sign {
	height: 24px;
	width: 24px;
	background: yellow;
	border-radius: 50%;
	font-size: 18px;
	color: blue;
	text-align: center;
	line-height: 24px;
	box-shadow: 0px 0px 3px 5px gray; /* 阴影 */
}

#box {
	position: relative; /* 相对定位 */
	width: 83%;
	height: 200px;
	margin: 200px auto;
	background: pink;
}

#pre {
	position: absolute; /* 绝对定位 */
	top: 85px;
	left: 10px;
}

#next {
	position: absolute;
	top: 85px;
	right: 10px;
}

#con {
	width: 94%;
	height: 100%;
	/* background: aqua; */
	margin: auto;
	overflow: hidden; /* 超出盒子的部分进行隐藏 */
	position: relative;
}

#scroll {
	width: 1000%;
	position: absolute;
	left: 0px;
}

.images {
	width: 250px;
	float: left;
	margin: 25px 20px;
}
</style>
</head>
<div class="right">
	<div id="header" class="location">
		<strong>你现在所在的位置是:</strong> <span>换肤界面</span>
	</div>
	<div id="box">
		<div id="pre" class="sign">&lt</div>
		<div id="next" class="sign">&gt</div>
		<div id="con">
			<div id="scroll">
				<img class="images"
					src="${pageContext.request.contextPath }/statics/images/background.jpg"
					title="点击换装"> <img class="images"
					src="${pageContext.request.contextPath }/statics/images/background1.jpg"
					title="点击换装"> <img class="images"
					src="${pageContext.request.contextPath }/statics/images/background2.jpg"
					title="点击换装"> <img class="images"
					src="${pageContext.request.contextPath }/statics/images/background3.jpg"
					title="点击换装"> <img class="images"
					src="${pageContext.request.contextPath }/statics/images/background4.jpg"
					title="点击换装"> <img class="images"
					src="${pageContext.request.contextPath }/statics/images/background5.jpg"
					title="点击换装"> <img class="images"
					src="${pageContext.request.contextPath }/statics/images/background6.jpg"
					title="点击换装"> <img class="images"
					src="${pageContext.request.contextPath }/statics/images/background7.jpg"
					title="点击换装">
			</div>
		</div>
	</div>
	<!-- <footer style="width: 100%;line-height: 40px;text-align: center;color: white;">版权</footer> -->
</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	var i=0;
	var path;
	/* 按钮的点击 */
	$("#next").click(function(){
		if(i<1){
			i++;
		}else if(i==1){
			return;
		}
		$("#scroll").animate({left:-i*1160},1000);
	});
	$("#pre").click(function(){
		if(i>0){
			i--;
		}else if(i==0){
			return;
		}
		$("#scroll").animate({left:i*1160},1000);
	});
	/* 点击图片换肤 */
	/* 只能切换当前jsp页面的背景 */
	$(".images").click(function(){
		path=$(this).attr("src");
		$("body").css("background","url("+path+")");
	});
</script>
</html>
<%@include file="/WEB-INF/jsp/common/foot.jsp"%>