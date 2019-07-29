$(function(){
	var Order = `&nbsp;<b>주문/결제</b> <br><br>
	<dl>
	<dt class="FAQTitle">
	<b class="Category">주문/결제</b>
	<a href="javascript:void(0)" class="Subject">주문취소는 어떻게 할수 있나요?</a>
</dt>
<dd class="FAQDetail">
	<div class="FAQAnswer" id="dvFAQAnswer_0">입금예정, 입금확인 단계에서는 고객님께서 즉시 취소처리가 가능하며, 배송준비중 상태에서는 고객센터(02-2189-3900) 또는 1:1게시판을 통해서만 취소요청이 가능합니다.
(단, 상품의 특성 및 주문조건에 따라 주문취소가 불가능할 수도 있습니다.)
* 취소요청 절차 안내 
[주문배송조회] -&gt; [주문/배송현황]  취소하고자 하는 주문을 확인한 후 주문취소 버튼을 누른 후 주문취소 사유 및 환불계좌 등의 내용을 입력해 주시면 됩니다
</div>
</dd>
</dl><dl>
<dt class="FAQTitle">
	<b class="Category">주문/결제</b>
	<a href="javascript:void(0)" class="Subject">전화로 주문이 가능한가요?</a>
</dt>
<dd class="FAQDetail">
	<div class="FAQAnswer" id="dvFAQAnswer_1">고객님의 개인정보 보호를 위해 전화상으로는 주문 및 결제가 불가능하며, 번거로우시더라도 온라인상에서 회원 로그인 또는 비회원으로 주문해 주셔야 합니다.</div>
</dd>
</dl><dl>
<dt class="FAQTitle">
	<b class="Category">주문/결제</b>
	<a href="javascript:void(0)" class="Subject">신용카드로 결제 후 취소했는데 어떻게 환불받나요?</a>
</dt>
<dd class="FAQDetail">
	<div class="FAQAnswer" id="dvFAQAnswer_2">신용카드로 결제하신 후 주문 취소 또는 반품 후 환불받으실 경우 카드 승인 취소는 바로 접수되고 있으나 카드사에 반영되기 까지 3일 ~ 7일정도 소요되고 있습니다.  고객님의 카드대금 결제일자에 따라 다음달 청구금액에서 상계처리될 수 있습니다.</div>
</dd>
</dl><dl>
<dt class="FAQTitle">
	<b class="Category">주문/결제</b>
	<a href="javascript:void(0)" class="Subject">주문 취소를 했는데 환불은 어떻게 받나요?</a>
</dt>
<dd class="FAQDetail">
	<div class="FAQAnswer" id="dvFAQAnswer_3">고객님의 결제방법에 따라 환불 기간이 다소 차이가 있을 수 있습니다. 

- 신용카드 결제 : 카드승인 취소는 바로 접수되며, 카드사 반영되기 까지 3~7일 정도 소요됩니다.
- 계좌이체 결제 : 주문 취소 신청후 바로 접수되며, 고객님의 계좌로 1~2일내 환불됩니다. (토,일, 공휴일제외)
- 가상계좌 결제 : 마이페이지 &gt; 환불계좌관리 &gt; 정상적인 환불계좌로 등록해놓으신 경우 2~3일 안으로 환불 받으실 수 있습니다. (단 토, 일, 공휴일은 제외됩니다.) 
</div>
</dd>
</dl><dl>
<dt class="FAQTitle">
	<b class="Category">주문/결제</b>
	<a href="javascript:void(0)" class="Subject">가상계좌 입금은 무엇인가요?</a>
</dt>
<dd class="FAQDetail">
	<div class="FAQAnswer" id="dvFAQAnswer_4">고객님께 편의를 제공하고자 가상계좌를 부여하고 있으며 입금자명과 관계없이 금액만 정확히 일치하여 입금하시면 됩니다.
(단, 주문후 3일간 미입금 시 주문건은 자동으로 취소됩니다)</div>
</dd>
</dl><dl>
<dt class="FAQTitle">
	<b class="Category">주문/결제</b>
	<a href="javascript:void(0)" class="Subject">장바구니에는 얼마동안 보관이 되나요?</a>
</dt>
<dd class="FAQDetail">
	<div class="FAQAnswer" id="dvFAQAnswer_5">장바구니에서는 30일간 저장이 가능합니다. 
단, 상품 가격이나 쿠폰/일시불 등의 판매조건과 재고사항이 변동될 수 있어 장바구니에 담았을 때와 주문했을 때의 조건이 달라질 수 있습니다.

선택상품 오랫동안 저장하기를 원하시는 경우에는 '찜하기' 기능을 이용하십시오.</div>
</dd>
</dl><dl>
<dt class="FAQTitle">
	<b class="Category">주문/결제</b>
	<a href="javascript:void(0)" class="Subject">지금까지 주문한 내역을 모두 볼수 있나요?</a>
</dt>
<dd class="FAQDetail">
	<div class="FAQAnswer" id="dvFAQAnswer_6">주문배송조회 - 주문/배송조회 에서 주문하신 내역을 확인하실 수 있습니다.</div>
</dd>
</dl>`

$("#Order").click(function(){
	$("div.FAQSelect").hide();
	document.getElementById("Disp").innerHTML = Order;
	$("#Disp").show();
	$("div.FAQAnswer").hide();

});


});