/**
 * 
 */

function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	return location.href.substring(hostIndex, location.href.indexOf('/',
			hostIndex + 1));
}

$(function(){
	var path="";
	path=getContextPath();
	//전역변수
    var obj = [];              
    //스마트에디터 프레임생성
    nhn.husky.EZCreator.createInIFrame({
        oAppRef: obj,
        elPlaceHolder: "notice_content",
        sSkinURI: path+"/editor/SmartEditor2Skin.html",
        htParams : {
            // 툴바 사용 여부
            bUseToolbar : true,            
            // 입력창 크기 조절바 사용 여부
            bUseVerticalResizer : true,    
            // 모드 탭(Editor | HTML | TEXT) 사용 여부
            bUseModeChanger : true,
        }
    });
    //전송버튼
    $("#insertBoard").click(function(){
        //id가 smarteditor인 textarea에 에디터에서 대입
        obj.getById["notice_content"].exec("UPDATE_CONTENTS_FIELD", []);
        //폼 submit
        $("#insertBoardFrm").submit();
    });
});


function check(f) {
	if (!f.notice_subject.value.length>0 ) {
		swal("Oops", "제목이 없습니다", "error");
		return false;
	}

	return true;
}