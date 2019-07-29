/**
 * 
 */

$(function() {
	$("img.no").hide();
	$("span.reboard_unhappy").click(function() {
		var num=$(this).attr("num")
		//alert(num);
		var n=$(this);
		
		$(n).next().show('fast').animate({
			"width":"+=20px"}).hide('fast');
		
		$.ajax({
			type:'get',
			url:"unhappy.aj",
			data:{"num":num},
			dataType:"json",
			success:function(redata){	
				console.log(redata.reboard_unhappy);
				$(n).text(redata.reboard_unhappy);	 	
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
