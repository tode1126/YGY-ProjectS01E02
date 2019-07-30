$(function(){
	$(".menu-insert-upfile").change(function(){
		if(this.files && this.files[0]) {
			var reader = new FileReader;
			reader.onload = function(data) {
				$(".select_img img").attr("src", data.target.result).width(300);        
			}
			reader.readAsDataURL(this.files[0]);
		}
	});
});
