$(function(){
	
	var goods = `&nbsp;<b>상품</b> <br><br>
	<dl>
		<dt class="FAQTitle">
	<b class="Category">상품</b>
	<a href="javascript:void(0)" class="Subject">상품에 대한 문의는 어떻게 하나요?</a>
</dt>
<dd class="FAQDetail">
	<div class="FAQAnswer" id="dvFAQAnswer_0"><p>상품 관련 문의는 해당 상품페이지 하단 상품 Q and A를 이용하시면 입점사에서 답변을 드리고 있으며,</p><p>고객센터 1:1게시판을 통해서도 문의하실 수 있습니다.</p><p> </p><p>또는 02)2189-3900 으로 연결하셔도됩니다.</p></div>
</dd>
</dl><dl>
<dt class="FAQTitle">
	<b class="Category">상품</b>
	<a href="javascript:void(0)" class="Subject">상품정보가 잘못되어 있는데 어떻게 하나요?</a>
</dt>
<dd class="FAQDetail">
	<div class="FAQAnswer" id="dvFAQAnswer_1">잘못된 상품 정보 및 내용에 대해서는 고객센터(02-2189-3900) 또는 1:1 게시판을 통해 문의해주시면 확인 후 수정해드리도록 하겠습니다.</div>
</dd>
</dl><dl>
<dt class="FAQTitle">
	<b class="Category">상품</b>
	<a href="javascript:void(0)" class="Subject">상품의 배송비는 얼마인가요?</a>
</dt>
<dd class="FAQDetail">
	<div class="FAQAnswer" id="dvFAQAnswer_2">상품페이지에 배송비 및 배송비조건을 확인하실 수 있습니다.
무료배송의 경우 부담하실 비용은 없으나 상품의 부피 및 중량에 따라 초과 운임비가 발생될 수 있습니다.
단, 도서산간지역의 경우 도선료가 발생할 수 있습니다.</div>
</dd>
</dl><dl>
<dt class="FAQTitle">
	<b class="Category">상품</b>
	<a href="javascript:void(0)" class="Subject">상품의 리스트에 표시되는 금액과 상품페이지의 상품금액 달라요</a>
</dt>
<dd class="FAQDetail">
	<div class="FAQAnswer" id="dvFAQAnswer_3">시스템에 의한 시간차로 인해 상품 리스트, 가격비교, 검색결과 내용과 상품 페이지의 내용이 차이가 있을 수 있습니다.
상품 페이지에서 표기되는 가격 및 할인혜택 정보가 정확한 조건입니다.</div>
</dd>
</dl>`
	
	  $("#Goods").click(function(){
		  $("div.FAQSelect").hide();
		  document.getElementById("Disp").innerHTML = goods;
		  $("#Disp").show();
		  $("div.FAQAnswer").hide();
	  });

});