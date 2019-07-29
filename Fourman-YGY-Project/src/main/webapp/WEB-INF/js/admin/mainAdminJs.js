/**
 * 
 */

$(function() {
	var path = "";
	var path2 = "";
	var path3 = "";
	var values = [];
	var str = "";

	path = getContextPath();
	path = path + "/admin/userCount.do"
	path2 = getContextPath();
	path2 = path2 + "/admin/userList.do";
	path3 = getContextPath();
	path3 = path3 + "/admin/userUnConnection.do";
	
	setInterval(function() {
		path = getContextPath();
		path = path + "/admin/userCount.do"
		path2 = getContextPath();
		path2 = path2 + "/admin/userList.do";
		$.ajax({
			async : true,
			type : 'POST',
			url : path,
			dataType : "json",
			contentType : "application/json; charset=UTF-8",
			success : function(data) {
				$("p.userCount").html(data.cnt);
			},
			error : function(error) {

			}
		});

		$.ajax({
			async : true,
			type : 'POST',
			url : path2,
			dataType : "json",
			contentType : "application/json; charset=UTF-8",
			success : function(data) {
				values = data.userList;
				str="<h2>현재 접속 중인 유저</h2>"
				$.each(values, function(index, value) {
					str+="<p>" + value + "<button email='"+value+"' class='button red f-right logout'>로그아웃</button></p>"
				});
				$("div.userList").html(str);
				str="";
			},
			error : function(error) {

			}
		});

	}, 1000);
	
	$(document).on("click",".logout", function() {
		var str = $(this).attr("email");
		$.ajax({
			async : true,
			type : 'POST',
			url : path3,
			data : str,
			contentType : "application/json; charset=UTF-8",
			success : function(data) {
			},
			error : function(error) {
				alert("error : " + error);
			}
		});
	})
});



function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	return location.href.substring(hostIndex, location.href.indexOf('/',
			hostIndex + 1));
}