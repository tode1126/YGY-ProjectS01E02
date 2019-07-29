$(function(){
	
	$("a.li1").click(function(){
		$("a.li1").removeClass("Active");
		$(this).addClass("Active");

	});
	
	var All = `&nbsp;<b>자주묻는 질문 TOP 10</b> <br><br>
	<div id="Disp" class="FAQSelect">

	<dl>
	  <dt class="FAQTitle">
		<b class="Category">회원</b>
		<a href="javascript:void(0)" class="Subject">모바일에서 로그인이 안 돼요. 어떻게 하나요?</a>
	</dt>

	<dd class="FAQDetail">
		<div class="FAQAnswer" id="dvFAQAnswer_0"><p><span style="font-size:14px;">컴퓨터에서는 로그인할 수 있지만 휴대기기, 스마트폰에서 로그인할 수 없는 문제를 해결하려면 아래 내용을 참고하세요.</span><br></p><p><span style="font-size:14px;"><br></span></p><p><span style="font-size:14px;">시작하기 전에: <b>기기를 다시 시작해 보세요.</b> 이 방법으로 문제가 쉽게 해결되기도 합니다.</span><br><br><br><span style="font-size:14px;"><b>1. 아이디/비밀번호를 정확히 입력하셨는지 확인해주세요.</b>(PC에서 비밀번호 변경 하셨다면 변경된 비밀번호로 로그인 하셔야 합니다.)</span><br><span style="font-size:14px;"> </span><br><span style="font-size:14px;">  ① 키보드 자동대문자 설정이 'ON'으로 되어 있는지 확인해주세요.</span><br><span style="font-size:14px;">  ② 한글로 설정하신 비밀번호(비밀-&gt;qlalf) 는 입력 오류가 발생할 가능성이 높으니, 다시 확인해주세요.</span><br><span style="font-size:14px;">  ③ 특수문자가 포함되신 경우, 키보드에서의 특수문자와 휴대폰에서 보여지는 특수문자의 위치가 다를수 있으니 확인 부탁드립니다.</span><br><span style="font-size:14px;"> </span><br><span style="font-size:14px;">  위의 사항들로 인하여 입력 실수 등이 발생할 수 있으니,</span><br><span style="font-size:14px;">  비밀번호를 정확하게 확인하신 후에 입력해 주시기를 부탁드립니다.</span><br><br><br><span style="font-size:14px;">만약 정확한 아이디/비밀번호를 입력했는데도 로그인 실패가 반복된다면, 아래의 설정값을 확인해주시기 바랍니다.</span><br><br><br><span style="font-size:14px;"><b>2. 안드로이드 (스마트폰, 스마트패드 등) 브라우저 쿠키 설정 방법</b></span><br><span style="font-size:14px;"> ※ 갤럭시폰 화면으로 안내드리니 참고해주세요.</span><br><span style="font-size:14px;">  ① 홈 화면의 [인터넷] 브라우저를 실행해주세요.</span><br><span style="font-size:14px;">  ② 왼쪽 하단의 목록 버튼을 누르시고 [더보기]를 선택해주세요.</span><br><span style="font-size:14px;">  ③ 항목 중에서 [설정] 항목을 선택해주세요.</span><br><span style="font-size:14px;">  ④ [자바 스크립트 실행] 및 [쿠키 허용] 항목의 체크박스를 [V] 선택해주세요.</span><br><span style="font-size:14px;">  ⑤ 동일하게 [설정] 항목에서 [캐시 삭제], [기록 삭제], [모든 쿠키 삭제]를 진행하신 후, 재로그인해주세요.</span><br><span style="font-size:14px;"> </span><br><br><span style="font-size:14px;"><b>3. iOS (아이폰, 아이패드, 아이팟터치용) 브라우저 쿠키 설정 방법</b></span><br><span style="font-size:14px;">  ① 홈 화면의 [설정] 메뉴 실행해주세요.</span><br><span style="font-size:14px;">  ② [설정] 메뉴의 [Safari]를 선택해주세요.</span><br><span style="font-size:14px;">  ③ 아래와 같이 4가지 항목을 설정해주세요.</span><br><span style="font-size:14px;">     * [개인정보 보호 브라우징] 항목을 "미허용" (하얀색 표시)으로 설정</span><br><span style="font-size:14px;">     * [쿠키 허용] 항목을 "방문한 곳" 또는 "항상" 으로 선택</span><br><span style="font-size:14px;">     * [쿠키 및 데이터 지우기] 항목을 실행    </span><br><span style="font-size:14px;">     * [JavaScript] 항목을 "허용"(파란색 표시)으로 설정</span><br><span style="font-size:14px;">  ④ 브라우저 쿠키 설정이 변경되었으니, 재로그인 해주세요.</span><br><br><br><span style="font-size:14px;">만약, 모바일 기기에서 브라우저 설정 후에도 로그인이 어려우신 고객님께서는 고객센터로 문의해주시면 신속하게 확인하여 도움을 드리도록 하겠습니다.</span></p></div>
	</dd>
	</dl>



	<dl>
	<dt class="FAQTitle">
		<b class="Category">반품/교환/환불</b>
		<a href="javascript:void(0)" class="Subject">교환이나 반품 시 배송비는 누가 부담하는건가요?</a>
	</dt>
	<dd class="FAQDetail">
		<div class="FAQAnswer" id="dvFAQAnswer_1"><p>제품의 하자 또는 오배송 등으로 인해 교환/반품을 하실 경우 배송비는 입점사 또는 정관장몰에서 부담하며, 고객님의 주관적인 불만사항들(사이즈,색상,소재 등)에 의한 교환/반품을 신청하실 경우에는 고객님께 부과 됩니다.</p></div>
	</dd>
	</dl>



	<dl>
	<dt class="FAQTitle">
		<b class="Category">반품/교환/환불</b>
		<a href="javascript:void(0)" class="Subject">반품시 상품은 어떻게 보내면 되나요?</a>
	</dt>
	<dd class="FAQDetail">
		<div class="FAQAnswer" id="dvFAQAnswer_2">배송된 상품의 반품을 접수 하시면 입점사에서 택배 회수접수를 해드리고 있으며 상품을 미리 포장하여 두시면, 택배기사님이 방문시 전달해 주시면 됩니다. 환불은 상품이 입점사 또는 물류팀에 입고되어 검수절차를 거친 후 환불처리 됩니다.</div>
	</dd>
	</dl>



	<dl>
	<dt class="FAQTitle">
		<b class="Category">배송</b>
		<a href="javascript:void(0)" class="Subject">정관장몰 배송정책 안내 입니다.</a>
	</dt>
	<dd class="FAQDetail">
		<div class="FAQAnswer" id="dvFAQAnswer_3"><p>1. 본사배송상품
	- 당일 오후 2시 이전 입금확인된 건에 대하여 당일 출고됩니다. (토,일,공휴일 제외) 
	단, 택배물량증가(성수기시즌), 일시품절, 재고부족 등으로 인해 당일출고가 안될수 있으며, 평균 2일 ~ 5일정도 소요될 수 있습니다.
	</p><p>품절로 인해 상품 출고가 어려울 경우 별도로 전화상담 후 배송하고 있습니다.

	2. 입점사 배송상품
	- 정관장몰 입점사에서 직접 배송하는 상품으로 기본 배송일은 2일 ~ 5일정도 소요됩니다.
	</p><p>단, 배송기간은 상품의 특성에 따라 차이가 있을 수 있습니다.
	- 배송비는 각 입점사별로 차등 적용되며 무료, 조건부무료, 착불(상품수령시 지불)등으로 주문 전에 미리 확인하실 수 있습니다.
	- 상품의 부피/중량에 따라 추가 배송비가 발생될 수 있습니다.(도서지역은 추가 도선료 발생함)</p></div>
	</dd>
	</dl>



	<dl>
	<dt class="FAQTitle">
		<b class="Category">배송</b>
		<a href="javascript:void(0)" class="Subject">비회원으로도 배송조회 가능한가요?</a>
	</dt>
	<dd class="FAQDetail">
		<div class="FAQAnswer" id="dvFAQAnswer_4">비회원으로 상품을 구입하신 고객님께서는 [주문배송조회] 에서 주문번호 및 주문자명 입력 후 배송현황을 확인하실 수 있습니다</div>
	</dd>
	</dl>



	<dl>
	<dt class="FAQTitle">
		<b class="Category">배송</b>
		<a href="javascript:void(0)" class="Subject">문자서비스(SMS)로 배송상황을 알 수 있나요?</a>
	</dt>
	<dd class="FAQDetail">
		<div class="FAQAnswer" id="dvFAQAnswer_5"><p>로그인 후 보이는 메뉴 상단 우측의 [마이페이지]에서 SMS 수신을 동의하신 고객님이시라면 문자서비스를 </p><p>받으실 수 있습니다. </p><p> </p><p>운송장번호를 등록함과 동시에 택배사명과 운송장번호가 고객님의 휴대폰으로 SMS 발송되고 있습니다.
	단, 택배사가 아닌 업체(설치)배송 상품의 경우는 SMS 서비스를 제공해드리지 않습니다.
	</p></div>
	</dd>
	</dl>



	<dl>
	<dt class="FAQTitle">
		<b class="Category">상품</b>
		<a href="javascript:void(0)" class="Subject">상품에 대한 문의는 어떻게 하나요?</a>
	</dt>
	<dd class="FAQDetail">
		<div class="FAQAnswer" id="dvFAQAnswer_6"><p>상품 관련 문의는 해당 상품페이지 하단 상품 Q and A를 이용하시면 입점사에서 답변을 드리고 있으며,</p><p>고객센터 1:1게시판을 통해서도 문의하실 수 있습니다.</p><p> </p><p>또는 02)2189-3900 으로 연결하셔도됩니다.</p></div>
	</dd>
	</dl>



	<dl>
	<dt class="FAQTitle">
		<b class="Category">영수증/세금계산서/증빙서류</b>
		<a href="javascript:void(0)" class="Subject">신용카드 영수증은 어디에서 확인할 수 있나요?</a>
	</dt>
	<dd class="FAQDetail">
		<div class="FAQAnswer" id="dvFAQAnswer_7">신용카드 영수증은 주문/배송내역 메뉴에서 상세주문내역을 조회하신 후 인쇄하실 수 있습니다.

	이용방법 : 주문배송조회 &gt; 나의쇼핑내역 &gt; 증빙문서관리 &gt; 신용카드매출전표
	</div>
	</dd>
	</dl>



	<dl>
	<dt class="FAQTitle">
		<b class="Category">주문/결제</b>
		<a href="javascript:void(0)" class="Subject">주문취소는 어떻게 할수 있나요?</a>
	</dt>
	<dd class="FAQDetail">
		<div class="FAQAnswer" id="dvFAQAnswer_8">입금예정, 입금확인 단계에서는 고객님께서 즉시 취소처리가 가능하며, 배송준비중 상태에서는 고객센터(02-2189-3900) 또는 1:1게시판을 통해서만 취소요청이 가능합니다.
	(단, 상품의 특성 및 주문조건에 따라 주문취소가 불가능할 수도 있습니다.)
	* 취소요청 절차 안내 
	[주문배송조회] -&gt; [주문/배송현황]  취소하고자 하는 주문을 확인한 후 주문취소 버튼을 누른 후 주문취소 사유 및 환불계좌 등의 내용을 입력해 주시면 됩니다
	</div>
	</dd>
	</dl>



	<dl>
	<dt class="FAQTitle">
		<b class="Category">주문/결제</b>
		<a href="javascript:void(0)" class="Subject">신용카드로 결제 후 취소했는데 어떻게 환불받나요?</a>
	</dt>
	<dd class="FAQDetail">
		<div class="FAQAnswer" id="dvFAQAnswer_9">신용카드로 결제하신 후 주문 취소 또는 반품 후 환불받으실 경우 카드 승인 취소는 바로 접수되고 있으나 카드사에 반영되기 까지 3일 ~ 7일정도 소요되고 있습니다.  고객님의 카드대금 결제일자에 따라 다음달 청구금액에서 상계처리될 수 있습니다.</div>
	</dd>
	</dl>

	</div>`

	$("#All").click(function() {
		$(".FAQSelect").hide();
		document.getElementById("Disp").innerHTML = All;
		$("#Disp").show();
		$("div.FAQAnswer").hide();
	});

	$(document).on("click","a.Subject",function(){
		$("div.FAQAnswer").not($(this).closest(".FAQTitle").next().children("div.FAQAnswer")).hide();
		$(this).closest(".FAQTitle").next().children("div.FAQAnswer").toggle();
	});

	
	

});
