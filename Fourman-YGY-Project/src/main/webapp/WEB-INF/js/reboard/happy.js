/**
 * 
 */

$(function() {
	$("img.heart").hide();
	$("span.reboard_happy").click(function() {
		var num=$(this).attr("num")
		//alert(num);
		var n=$(this);
		//하트이미지 나타났다가 사라지는 애니메이션
		$(n).next().show('fast').animate({
			"width":"+=20px"}).hide('fast');
		
		$.ajax({
			type:'get',
			url:"happy.aj",
			data:{"num":num},
			dataType:"json",
			success:function(redata){	
				console.log(redata.reboard_happy);
				$(n).text(redata.reboard_happy);	 	
			},
			error:function(err){
				alert("errorcode:"+err.status);//에러코드출력
				//200: 응답페이지오류:~data.jsp 문제
				//404: 매핑오류거나 jsp 를 못찾거나
				//500: 문법오류
			}
		});
	});
});
