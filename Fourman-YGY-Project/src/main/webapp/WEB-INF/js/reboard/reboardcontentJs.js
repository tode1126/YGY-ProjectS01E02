/**
 * 
 */

	$(function() {
		$("img.heart").hide();
		$("span.reboard_happy").click(function() {
			var reboard_pk = "";
			reboard_pk = $(this).attr("reboard_pk")
			
			var n=$(this);
			
			$.ajax({
				async : true,
				type : 'POST',
				url : "happy.do",
				data: reboard_pk,
				dataType:"json",
				contentType : "application/json; charset=UTF-8",
				
				success:function(data){	
					$(n).text(data.cnt);	 	
				},
				error:function(err){
				}
			});	
		});
		
		$("span.reboard_unhappy").click(function() {
			var reboard_pk = "";
			reboard_pk = $(this).attr("reboard_pk")
			
			var n=$(this);
			
			$.ajax({
				async : true,
				type : 'POST',
				url : "unhappy.do",
				data: reboard_pk,
				dataType:"json",
				contentType : "application/json; charset=UTF-8",
				
				success:function(data){	
					$(n).text(data.cnt);	 	
				},
				error:function(err){
				}
			});	
		});
		
	});