$(function(){
	$(".authority-res-yes").click(function(e) {
		$(".authority-res-time").prop("disabled", false);
	});
	$(".authority-res-no").click(function(e) {
		$(".authority-res-time").val("");
		$(".authority-res-time").prop("disabled", true);
	});
});