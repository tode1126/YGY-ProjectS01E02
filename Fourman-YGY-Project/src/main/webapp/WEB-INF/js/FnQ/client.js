$(function(){
	var client = `&nbsp;<b>회원</b> <br><br>
	<dl>
	<dt class="FAQTitle">
		<b class="Category">회원</b>
		<a href="javascript:void(0)" class="Subject">모바일에서 로그인이 안 돼요. 어떻게 하나요?</a>
	</dt>
	<dd class="FAQDetail">
		<div class="FAQAnswer" id="dvFAQAnswer_0"><p><span style="font-size:14px;">컴퓨터에서는 로그인할 수 있지만 휴대기기, 스마트폰에서 로그인할 수 없는 문제를 해결하려면 아래 내용을 참고하세요.</span><br></p><p><span style="font-size:14px;"><br></span></p><p><span style="font-size:14px;">시작하기 전에: <b>기기를 다시 시작해 보세요.</b> 이 방법으로 문제가 쉽게 해결되기도 합니다.</span><br><br><br><span style="font-size:14px;"><b>1. 아이디/비밀번호를 정확히 입력하셨는지 확인해주세요.</b>(PC에서 비밀번호 변경 하셨다면 변경된 비밀번호로 로그인 하셔야 합니다.)</span><br><span style="font-size:14px;"> </span><br><span style="font-size:14px;">  ① 키보드 자동대문자 설정이 'ON'으로 되어 있는지 확인해주세요.</span><br><span style="font-size:14px;">  ② 한글로 설정하신 비밀번호(비밀-&gt;qlalf) 는 입력 오류가 발생할 가능성이 높으니, 다시 확인해주세요.</span><br><span style="font-size:14px;">  ③ 특수문자가 포함되신 경우, 키보드에서의 특수문자와 휴대폰에서 보여지는 특수문자의 위치가 다를수 있으니 확인 부탁드립니다.</span><br><span style="font-size:14px;"> </span><br><span style="font-size:14px;">  위의 사항들로 인하여 입력 실수 등이 발생할 수 있으니,</span><br><span style="font-size:14px;">  비밀번호를 정확하게 확인하신 후에 입력해 주시기를 부탁드립니다.</span><br><br><br><span style="font-size:14px;">만약 정확한 아이디/비밀번호를 입력했는데도 로그인 실패가 반복된다면, 아래의 설정값을 확인해주시기 바랍니다.</span><br><br><br><span style="font-size:14px;"><b>2. 안드로이드 (스마트폰, 스마트패드 등) 브라우저 쿠키 설정 방법</b></span><br><span style="font-size:14px;"> ※ 갤럭시폰 화면으로 안내드리니 참고해주세요.</span><br><span style="font-size:14px;">  ① 홈 화면의 [인터넷] 브라우저를 실행해주세요.</span><br><span style="font-size:14px;">  ② 왼쪽 하단의 목록 버튼을 누르시고 [더보기]를 선택해주세요.</span><br><span style="font-size:14px;">  ③ 항목 중에서 [설정] 항목을 선택해주세요.</span><br><span style="font-size:14px;">  ④ [자바 스크립트 실행] 및 [쿠키 허용] 항목의 체크박스를 [V] 선택해주세요.</span><br><span style="font-size:14px;">  ⑤ 동일하게 [설정] 항목에서 [캐시 삭제], [기록 삭제], [모든 쿠키 삭제]를 진행하신 후, 재로그인해주세요.</span><br><span style="font-size:14px;"> </span><br><br><span style="font-size:14px;"><b>3. iOS (아이폰, 아이패드, 아이팟터치용) 브라우저 쿠키 설정 방법</b></span><br><span style="font-size:14px;">  ① 홈 화면의 [설정] 메뉴 실행해주세요.</span><br><span style="font-size:14px;">  ② [설정] 메뉴의 [Safari]를 선택해주세요.</span><br><span style="font-size:14px;">  ③ 아래와 같이 4가지 항목을 설정해주세요.</span><br><span style="font-size:14px;">     * [개인정보 보호 브라우징] 항목을 "미허용" (하얀색 표시)으로 설정</span><br><span style="font-size:14px;">     * [쿠키 허용] 항목을 "방문한 곳" 또는 "항상" 으로 선택</span><br><span style="font-size:14px;">     * [쿠키 및 데이터 지우기] 항목을 실행    </span><br><span style="font-size:14px;">     * [JavaScript] 항목을 "허용"(파란색 표시)으로 설정</span><br><span style="font-size:14px;">  ④ 브라우저 쿠키 설정이 변경되었으니, 재로그인 해주세요.</span><br><br><br><span style="font-size:14px;">만약, 모바일 기기에서 브라우저 설정 후에도 로그인이 어려우신 고객님께서는 고객센터로 문의해주시면 신속하게 확인하여 도움을 드리도록 하겠습니다.</span></p></div>
	</dd>
</dl>`

$("#Client").click(function(){
	$("div.FAQSelect").hide();
	document.getElementById("Disp").innerHTML = client;
	$("#Disp").show();
	$("div.FAQAnswer").hide();
});



});