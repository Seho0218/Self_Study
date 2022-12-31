<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./inc/top.jspf"%>
<link rel="stylesheet" href="/js_css/css/product_detail_style.css" type="text/css"/>
<script src="/js_css/js/product_detail_js.js"></script>
<!-- jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>

<script>
    $(function(){
		function replyAllList(){
			$("#replyList>ul").empty();
			var url = "/reply/replyProductList";
			var params = {no:${pvo.product_id}};
			
			$.ajax({
				url:url,
				data:params,
				success:function(result){
					var $reply = $(result);
					
					$reply.each(function(i, vo){ // index, vo
						tag = "<li>";
						tag += "<div><b>"+"작성자 : "+vo.genie_id+" | "+vo.writedate+"</b>";
						// 수정, 삭제버튼(자신이 쓴 글일때만) 표시
						if(vo.genie_id=='${logId}'){
							tag += "<input type='button' value='리뷰수정'/>";
							tag += "<input type='button' value='리뷰삭제' title='"+vo.reply_no+"'/>";
						}
						tag += "<br/>"
                            if(vo.rating==5){ 
                                tag +='만족도 : <span>★★★★★</span>'
                            }else if(vo.rating==4){
                                tag +='만족도 : <span>★★★★☆</span>'
                            }else if(vo.rating==3){
                                tag +='만족도 : <span>★★★☆☆</span>'
                            }else if(vo.rating==2){
                                tag +='만족도 : <span>★★☆☆☆</span>'
                            }else if(vo.rating==1){
                                tag +='만족도 : <span>★☆☆☆☆</span>'
                            }
                        tag += "<br>"
                                +"리뷰내용 : "
                                +vo.comment+"<br></div>";
						// 로그인 아이디와 댓글 아이디 동일시 (수정폼)을 만들어준다.
						if(vo.genie_id=='${logId}'){
							tag += "<div style='display:none'><form method='post'>";
							tag += "<input type='hidden' name='reply_no' value='"+vo.reply_no+"'/>";
                            tag += "<fieldset>"
                                    +"<input type='radio' name='rating' value='5' id='rate6'>"
                                    +"<label for='rate6'>★</label>"
                                    +"<input type='radio' name='rating' value='4' id='rate7'>"
                                    +"<label for='rate7'>★</label>"
                                    +"<input type='radio' name='rating' value='3' id='rate8'>"
                                    +"<label for='rate8'>★</label>"
                                    +"<input type='radio' name='rating' value='2' id='rate9'>"
                                    +"<label for='rate9'>★</label>"
                                    +"<input type='radio' name='rating' value='1' id='rate10'>"
                                    +"<label for='rate10'>★</label>"
                                    +"</fieldset>"
							tag += "<textarea name='comment' style='width:100%; height:30vh;'/>"+vo.comment+"</textarea>";
							tag += "<input type='submit' value='리뷰 수정하기' style='display:flex; align-items:center; padding:1ch;'/>";
							tag += "</form></div>";
						}						
						tag += "</li>"
						
						$("#replyList>ul").append(tag);
					});
				}, error:function(e){
					console.log(e.responseText);
				}
			});
		}
		
		// 리뷰 작성
		$("#replyFrm").submit(function(){
			event.preventDefault();
			
			var params = $("#replyFrm").serialize();
			
			$.ajax({
				url:"/reply/replyProductWrite",
				data:params, 
				type:"POST", 
				success:function(result){
					$("#comment").val("");
					replyAllList();
				}, error:function(e){
					console.log(e.responseText);
				}
			});
		});
		
		// 리뷰 수정폼
		$(document).on('click','#replyList input[value=리뷰수정]',function(){
			$(this).parent().css("display","none"); // Edit버튼의 부모를 숨김
			$(this).parent().next().css("display","block"); // Edit 폼 보여주기
		});
		
		// 리뷰 수정(DB)
		$(document).on('submit','#replyList form',function(){
			event.preventDefault();
			var url = "/reply/replyProductEdit";
			var params = $(this).serialize();
			$.ajax({
				url:url,
				data:params,
				type:"POST",
				success:function(result){
					replyAllList();
				},error:function(e){
					console.log(e.responseText);
				}
			});
		});
		
		// 리뷰 삭제
		$(document).on('click','#replyList input[value=리뷰삭제]',function(){
			if(confirm("리뷰를 삭제하시겠습니까?")){	
				var params = {reply_no: $(this).attr('title')};
				
				$.ajax({
					url:"/reply/replyProductDel",
					data:params,
					success:function(result){
						replyAllList();
					}, error:function(e){
						console.log(e.responseText);
					}
				});
			}
		});
		replyAllList(); // 리뷰 목록 가져오기
    });
</script>

<script>
	// 좋아요
    $(function(){
    	// 해당상품 좋아요 숫자 가져오기
		var likeNum = ${lvo.product_like};
		$("#likeBtn").append("<p>"+likeNum+"</p>");
		
		// 로그인 아이디의 해당상품 좋아요 판별
		if("${cvo.genie_id}"!=""){ // 이미 좋아요를 누른상태면
			likeRed();
		}else { // 좋아요를 누른적이 없으면
			likeGray();
		}
		
        $('#likeBtn').click(function(){
            $.ajax({
                url:"reply/likeStatus",
                data:{product_id:${pvo.product_id}},
                success:function(result){
                    if (result>100){ // 좋아요 클릭
                        likeRed();
                    	likeNum += 1;
                    	$("#likeBtn>p").remove();
                        $("#likeBtn").append("<p>"+likeNum+"</p>");
                    }else { // 좋아요 취소
                        likeGray();
                    	likeNum -= 1;
                    	$("#likeBtn>p").remove();
                        $("#likeBtn").append("<p>"+likeNum+"</p>");
                    }
                },error:function(e){
                    console.log(e.responseText);
                }
            });
        });
        
        function likeRed(){ // 좋아요 클릭 시 CSS
            $('#likeBtn').css('color','red');
        }
        
        function likeGray(){ // 좋아요 취소 시 CSS
            $('#likeBtn').css('color','gray');
        }        
       
    });
    </script>

<section class="product_detail">
    <!--<h1>상세페이지</h1>-->
    <form method="post" action="/addCart" id="Cart">
        <div class="box-wrapper1"> 
            <input type="hidden" value="${logId}" name="genie_id">
            <input type="hidden" value="${pvo.product_id}" name="product_id">
            <input type="hidden" name="product_name" value="${pvo.product_name}">
 
            <div class="box1" style="background-image:url(${pvo.product_image1})"></div>
            <div class="box2" onclick="detail1('${pvo.product_image1}')" style="background-image:url(${pvo.product_image1})"></div>
            <div class="box3" onclick="detail1('${pvo.product_image2}')" style="background-image:url(${pvo.product_image2})"></div>
            <div class="box4" onclick="detail1('${pvo.product_image3}')" style="background-image:url(${pvo.product_image3})"></div>
            <div class="box5">
                ${pvo.product_name}
                
                <div class="w3-button w3-black w3-round" style="text-align:center;">
    				<i class="fa fa-heart likeChange" id="likeBtn"></i>
   				</div>
            </div>
            <div class="box6">
                상품가격 : <fmt:formatNumber value="${pvo.product_price}" pattern="#,###원"/>
                <input type="hidden" value="${pvo.product_price}" name="cart_price">
            </div>
            <div class="box7">
                상품설명 : ${pvo.product_info}
            </div>
            <div class="box8">
                상품카테고리 : ${pvo.product_category}
            </div>
            <div class="box9">
                셀러명 : ${svo.ceo_name}
            </div>
            <div class="box10">
                회사이름 : ${svo.company_name}
            </div>
            <div class="box11">
                상품 수량 : <input type="text" id="cart_qty" name="cart_qty" value="1" 
                                oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
            </div>
            <button class="box12" id="addCart">
                장바구니
            </button>
            <input class="box13" type="button" id="buynow" value="구매하기" onclick='return submit2(this.form);'/>
        </div>
    </form>

<!-- ------------------------------------------------------------------------------------------- -->
    <div class="review-wrapper">
        <button class="box_1" onclick="content1()">
            <h1>리뷰</h1>
        </button>
        <button class="box_2" onclick="content2()">
            <h1>상품문의</h1>
        </button>
        <button class="box_3" onclick="content3()">
            <h1>반품/교환정보</h1>
        </button>
        <div class="box_4">
            <h2>상품리뷰</h2>
            <h3>동일한 상품에 대해 작성한 상품평이며 상품을 구매하신 분들이 직접 작성하신 리뷰입니다.</h3>
        </div>

        <form class="replyFrm" name="replyFrm" id="replyFrm" method="post">
            <div class="box_5">
                <fieldset>
                    <span class="text-bold">만족도</span>
                    <input type="radio" name="rating" value="5" id="rate1">
                    <label for="rate1">★</label>
                    <input type="radio" name="rating" value="4" id="rate2">
                    <label for="rate2">★</label>
                    <input type="radio" name="rating" value="3" id="rate3">
                    <label for="rate3">★</label>
                    <input type="radio" name="rating" value="2" id="rate4">
                    <label for="rate4">★</label>
                    <input type="radio" name="rating" value="1" id="rate5">
                    <label for="rate5">★</label>
                </fieldset>
            </div>

            <div class="box_6">
                <input type="hidden" name="product_id" value="${pvo.product_id}"/>
                <textarea class="col-auto form-control" type="text" id="comment" name="comment" placeholder="다른 고객님에게 도움이 되도록 상품에 대한 솔직한 평가를 남겨주세요."></textarea>
            </div>

            <div class="box_7">
                <input type="submit" value="리뷰 등록하기"/>
            </div>
        </form>

        <div class="box_8">
            <div id="replyList">
                <ul>
                    
                </ul>
            </div>
        </div>

    </div>
    
    <div class="qna-wrapper">
        <div class="qna">
            <button class="box_01" onclick="content1()">
                <h1>리뷰</h1>
            </button>
            <button class="box_02" onclick="content2()">
                <h1>상품문의</h1>
            </button>
            <button class="box_03" onclick="content3()">
                <h1>반품/교환정보</h1>
            </button>
            <div class="box_04">
                <h2>자주 묻는 질문</h2>
            </div>
        </div>
        <div class="qna-content">
            <div class="box_05">Q. 아이디와 비밀번호가 기억나지 않아요.</div>
            <div class="box_06">A. 로그인 화면에서 아이디찾기/비밀번호를 찾기를 통해 확인 가능합니다.</div>
            <div class="box_07">Q. 구매했을 때 보다 가격이 떨어졌어요 차액 환불이 되나요?</div>
            <div class="box_08">
                A. 상품 금액은 온라인 판매처 특성상 유동적으로 변동될 수 있어 차액 환불은 가능하지 않습니다.<br>
                ※ 판매 가격 변동으로 인한 교환(환불) 신청 시 반품 배송비는 회원님 부담으로 진행됩니다.<br>
                ※ 출고 처리중인 경우 취소는 가능하지 않습니다.
            </div>
            <div class="box_09">Q. 상품을 받는 주소(배송지) 등록은 어떻게 하나요?</div>
            <div class="box_10">
                A. 마이페이지 > 배송지 관리<br>
                배송지 관리 또는 주문서 작성 시 배송지 관리에서 배송 주소를 등록/수정/삭제할 수 있습니다.<br>
                ※ 주소지는 행정안전부의 [도로명 조회 사이트]에서 검색되는 주소를 기반으로 합니다.<br>
                ※ 띄어쓰기, 오타 여부 및 검색을 통해 실제 있는 주소인지 확인해 주세요.<br>
                ※ 주소가 등록되어 있지 않거나 건물명이 다른 경우 도로명주소 도움센터에 등록(변경) 요청해 주세요.<br>
                ※ 도로명 주소가 있지 않은 주소지는 등록이 가능하지 않습니다.
            </div>
            <div class="box_11">Q. 주문한 상품이 일부만 도착했어요.</div>
            <div class="box_12">
                A. 브랜드 및 상품에 따라 출고지가 다르기 때문에 여러 개 상품을 주문한 경우에는 각각 배송이 됩니다.<br>
                브랜드가 달라도 상품 주문 시 한 번에 결제할 수 있습니다.
            </div>
            <div class="box_13">
                Q. 일반 배송 상품은 언제 배송 되나요??
            </div>
            <div class="box_14">
                A. 일반배송은 브랜드마다 일정이 다르고 평일 기준으로 출고 됩니다.<br>
                평일 기준 출고로 연휴 및 공휴일은 배송일에서 제외됩니다.<br>
                지니스토어는 전 상품 100% 무료 배송입니다.<br>
                주문 시 배송 메모에 배송 희망 일자를 작성하셔도 해당일에 지정 배송은 어렵습니다.
            </div>
        </div>
    </div>

    <div class="exchange-wrapper">
        <div class="exchange">
            <button class="box_001" onclick="content1()">
                <h1>리뷰</h1>
            </button>
            <button class="box_002" onclick="content2()">
                <h1>상품문의</h1>
            </button>
            <button class="box_003" onclick="content3()">
                <h1>반품/교환정보</h1>
            </button>
        </div>
        <div class="exchange-content">
            <div class="box_004"><h1>배송정보</h1></div>
            <div class="box_005">배송비</div>
            <div class="box_006">무료배송</div>
            <div class="box_007">묶음배송 여부</div>
            <div class="box_008">가능</div>
            <div class="box_009">배송기간</div>
            <div class="box_010">
                <h4>- 서비스 이용 지역별 상이(단, 주문 시간별 도착 예정 시간은 지역 및 상황에 따라 변동될 수 있어, 정확한 정보는 결제 완료 시 안내되는 문구를 꼭 확인 부탁드립니다)</h4>
                <h4>- 천재지변, 물량 수급 변동 등 예외적인 사유 발생 시, 다소 지연될 수 있는 점 양해 부탁드립니다.</h4>
            </div>
            <div class="box_011">
                <h1>교환/반품 안내</h1>
                <h4>ㆍ교환/반품에 관한 일반적인 사항은 판매자가 제시사항보다 관계법령이 우선합니다.
                다만, 판매자의 제시사항이 관계법령보다 소비자에게 유리한 경우에는 판매자 제시사항이 적용됩니다.</h4>
            </div>    
            <div class="box_012">교환/반품 비용</div>
            <div class="box_013">무료로 반품/교환 가능</div>
            <div class="box_014">교환/반품 신청 기준일</div>
            <div class="box_015">ㆍ상품의 내용이 표시·광고의 내용과 다른 경우에는 상품을 수령한 날부터 3개월 이내, 그 사실을 안 날 또는 알 수 있었던 날부터 30일 이내에 청약철회 가능</div>
            <div class="box_016">
                <h1>교환/반품 제한사항</h1>
                <h4>ㆍ주문/제작 상품의 경우, 상품의 제작이 이미 진행된 경우</h4>
                <h4>ㆍ상품 포장을 개봉하여 사용 또는 설치 완료되어 상품의 가치가 훼손된 경우 (단, 내용 확인을 위한 포장 개봉의 경우는 예외)</h4>
                <h4>ㆍ고객의 사용, 시간경과, 일부 소비에 의하여 상품의 가치가 현저히 감소한 경우</h4>
                <h4>ㆍ세트상품 일부 사용, 구성품을 분실하였거나 취급 부주의로 인한 파손/고장/오염으로 재판매 불가한 경우</h4>
                <h4>ㆍ모니터 해상도의 차이로 인해 색상이나 이미지가 실제와 달라, 고객이 단순 변심으로 교환/반품을 무료로 요청하는 경우</h4>
                <h4>ㆍ제조사의 사정 (신모델 출시 등) 및 부품 가격 변동 등에 의해 무료 교환/반품으로 요청하는 경우</h4>
                <h4>※ 각 상품별로 아래와 같은 사유로 취소/반품이 제한될 수 있습니다.</h4>
            </div>
            <div class="box_017">의류/잡화/수입명품</div>
            <div class="box_018">ㆍ상품의 택(TAG) 제거, 라벨 및 상품 훼손, 구성품 누락으로 상품의 가치가 현저히 감소된 경우</div>
            <div class="box_019">계절상품/식품/화장품</div>
            <div class="box_020">
                <h4>ㆍ신선/냉장/냉동 식품의 단순변심의 경우</h4>
                <h4>ㆍ뷰티 상품 이용 시 트러블(알러지, 붉은 반점, 가려움, 따가움)이 발생하는 경우,진료 확인서 및 소견서 등을 증빙하면 환불이 가능 (제반비용 고객부담)</h4>
            </div>
            <div class="box_021">전자/가전/설치상품</div>
            <div class="box_022">
                <h4>ㆍ설치 또는 사용하여 재판매가 어려운 경우, 액정이 있는 상품의 전원을 켠 경우</h4>
                <h4>ㆍ상품의 시리얼 넘버 유출로 내장된 소프트웨어의 가치가 감소한 경우 (내비게이션, OS시리얼이 적힌 PMP)</h4>
                <h4>ㆍ홀로그램 등을 분리, 분실, 훼손하여 상품의 가치가 현저히 감소하여 재판매가 불가할 경우 (노트북, 데스크탑 PC 등)</h4>
                </div>
            <div class="box_023">자동차용품</div>
            <div class="box_024">ㆍ상품을 개봉하여 장착한 이후 단순변심인 경우</div>
            <div class="box_025">CD/DVD/GAME/BOOK</div>
            <div class="box_026">ㆍ복제가 가능한 상품의 포장 등을 훼손한 경우</div>
            <div class="box_027"><h1>판매자 정보</h1></div>
            <div class="box_028">판매자</div>
            <div class="box_029">${svo.company_name}</div>
        </div>
    </div>
</section>
<script>
function submit2(form) { 
    form.action='/order/BuyNow'; 
    form.submit(); 
    return true; 
}
</script>