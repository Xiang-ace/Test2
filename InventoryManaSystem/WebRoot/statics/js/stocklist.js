var billObj;

//库存管理页面上点击删除按钮弹出删除框(stocklist.jsp)
function deleteBill(obj){
	$.ajax({
		type:"GET", 
		url:path+"/sys/stockdel",
		data:{billid:obj.attr("billid"),productCount:obj.attr("productCount")},
		dataType:"json",
		success:function(data){
			if(data.delResult == "true"){//删除成功：移除删除行
				cancleBtn();
				obj.parents("tr").remove();
			}else if(data.delResult == "cannot"){
				changeDLGContent("对不起，该产品还有库存，不可以删除");
			}else if(data.delResult == "false"){//删除失败
				changeDLGContent("对不起，删除失败");
			}else if(data.delResult == "notexist"){
				changeDLGContent("对不起，该库存信息项不存在");
			}
		},
		error:function(data){
			alert("对不起，删除失败");
		}
	});
}

function openYesOrNoDLG(){
	$('.zhezhao').css('display', 'block');
	$('#removeBi').fadeIn();
}

function cancleBtn(){
	$('.zhezhao').css('display', 'none');
	$('#removeBi').fadeOut();
}
function changeDLGContent(contentStr){
	var p = $(".removeMain").find("p");
	p.html(contentStr);
}

$(function(){
	
	$('#no').click(function () {
		cancleBtn();
	});
	
	$('#yes').click(function () {
		deleteBill(billObj);
	});

	$(".deleteBill").on("click",function(){
		billObj = $(this);
		changeDLGContent("你确定要删除此信息项吗？");
		openYesOrNoDLG();
	});
	
	
});