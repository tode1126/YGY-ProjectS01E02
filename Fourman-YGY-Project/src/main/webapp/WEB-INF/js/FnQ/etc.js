$(function(){
	var Etc = `&nbsp;<b>기타</b> <br><br>
	<p class="regist-nocontent-type1">검색어와 일치하는 내용이 없습니다. 다시 검색해주세요.</p>`

$("#Etc").click(function(){
	$("div.FAQSelect").hide();
	document.getElementById("Disp").innerHTML = Etc;
	$("#Disp").show();
	$("div.FAQAnswer").hide();
});


});