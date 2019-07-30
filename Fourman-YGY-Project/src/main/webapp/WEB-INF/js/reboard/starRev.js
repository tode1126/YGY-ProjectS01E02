
$(function(){
	// 별점 평가
	$('.StarRev span').click(function(){
	     $(this).parent().children('span').removeClass('on');
	     $(this).addClass('on').prevAll('span').addClass('on');
	     var star_score =  $(this).text();
	     $("#star_score").val(star_score);
	     //alert($("#star_score").val());
	     return false;
	   });
});