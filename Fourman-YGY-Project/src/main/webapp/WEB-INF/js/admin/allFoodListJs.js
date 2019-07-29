/**
 * 
 */

$(function(){
	var path="";
	var pageNum="";
	path = getContextPath();

	$(document).on("change",".state",function(){
		var changeVal = $(this).val();
		var rest_pk = $(this).attr("rest_pk");
		pageNum= $(this).attr("pageNum");
		
		window.location.href=path+"/admin/foodManagement/foodStateChange.do?rest_pk="+rest_pk+"&changeVal="+changeVal+"&pageNum=";
	});
	
});


function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	return location.href.substring(hostIndex, location.href.indexOf('/',
			hostIndex + 1));
}
