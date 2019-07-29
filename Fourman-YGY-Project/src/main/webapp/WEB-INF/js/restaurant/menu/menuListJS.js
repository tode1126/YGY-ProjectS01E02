$(function(){
	$(".btn-delete").click(function(e) {
		var n = $(this);
		//console.log(n.attr("menu_pk"));
		if (confirm("정말 삭제하시겠습니까??") == true){    //확인
		    location.href="./menuDelete.do?menu_pk="+n.attr("menu_pk");
		} else {   //취소
		    return false;
		}
	});
});