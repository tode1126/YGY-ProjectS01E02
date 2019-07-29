/**
 * 
 */

$(document).ready(function(){
	$("#btnDelete").click(function(){		
		if(confirm("정말 삭제하시겠습니까?")==true){ //확인
			location.href="./delete.do?num=${dto.reboard_pk}&pageNum=${pageNum}"
		}else{ //취소
			return false;
		}
	});
});
