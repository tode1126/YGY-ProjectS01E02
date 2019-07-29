$(function(){
	$(".menu-update-upfile").change(function(){
		if(this.files && this.files[0]) {
			var reader = new FileReader;
			reader.onload = function(data) {
				$(".select_img img").prop("src", data.target.result).width(300);    
				//console.log(data.target.result);
			}
			reader.readAsDataURL(this.files[0]);
		}
	});
});
