<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/top.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<link rel="stylesheet" href="/js_css/css/cart_style.css" type="text/css"/>
<link rel="stylesheet" href="/js_css/css/payment.css" type="text/css"/>

<!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
<script>
 var cartList = [];
</script>
<div class="wrapper">
    <div class="cart">

        <!-- partial:index.partial.html -->
        <div id="invoiceholder">

        <div id="headerimage"></div>
        <div id="invoice" class="effect2">
            <div id="invoice-top">
            <div class="logo"></div>
            <div class="info">
                <h2>Genie</h2>
                <p> admin@genie.com <br/>
                    02-564-5843
                </p>
            </div><!--End Info-->
            </div><!--End InvoiceTop-->
          <%-- <form type="post" action="/orderCompletion" id="payFrm"> --%>

            <div class="clientlogo"></div>
            <div class="info">
              <h2>구매자 정보</h2>
              <div>
                <h3>${uvo.userName}</h3>
                <li><input type="hidden" name="genieId" value="${uvo.genieId}"></li>
                <p>${uvo.userEmail}<br/>
                  ${uvo.userTel}<br/></p>
              </div>

          <div class="payment-container">
            <table class="payment-table">
                <tr>
                    <%-- <th>카트번호</th> --%>
                    <th>제품명</th>
                    <th>가격</th>
                    <th>개수</th>
                        <th>총액</th>
                </tr>

              <%-- 장바구니 구매 --%>
              <c:choose>
              <c:when test="${plist ne null}">
                  <c:set var="total" value="0"/>
                <c:forEach items="${plist}" var="pvo">
                    <c:set var="sum_of_each" value="${total+pvo.productPrice*pvo.cartQty}"/>
                    <script>cartList.push(${pvo.cartNum});</script>
                    <tr>
                        <%-- <th><input type="hidden" id="cart_num${pvo.cart_num}" name="cartList" value="${pvo.cart_num}">${pvo.cart_num}</th> --%>
                        <th><input type="hidden" id="productName${pvo.cartNum}" name="productName" value="${pvo.productName}"/> ${pvo.productName}</th>
                        <th><input type="hidden" id="cartPrice${pvo.cartNum}" name="cartPrice" value="${pvo.cartPrice}"/>${pvo.cartPrice}원</th>
                        <th><input type="hidden" id="cartQty${pvo.cartNum}" name="cartQty" value="${pvo.cartQty}"/>${pvo.cartQty}개</th>
                        <th><fmt:formatNumber value="${sum_of_each}" pattern="#,###원"/></th>
                        <input type="hidden" id="sum${pvo.cartNum}" name="each" value="${sum_of_each}">
                    </tr>
                </c:forEach>
            </table>

                    <c:set var="total" value="0"/>
                    <c:forEach var="pvo" items="${plist}">
                    <c:set var="total" value="${total+pvo.productPrice*pvo.cartQty}"/>
                    </c:forEach><br/>
                    <div class="total-price">총액: <fmt:formatNumber value="${total}" pattern="#,###원"/>
                    <li><input type="hidden" id="total" name="total" value="${total}"></li></div>
              </c:when>
              <c:otherwise>

              <%-- 바로 구매 --%>
                <tr>

                  <%-- <th><input type="hidden" id="cart_num${pvo.cart_num}" name="cartList" value="${bvo.cart_num}">${bvo.cart_num}</th> --%>
                  <input type="hidden" name="productId" value="${bvo.productId}"/>
                  <th><input type="hidden" id="productName${bvo.cartNum}" name="productName" value="${bvo.productName}"/>${bvo.productName}</th>
                  <th><input type="hidden" id="cartPrice${bvo.cartNum}" name="cartPrice" value="${bvo.cartPrice}"/>${bvo.cartPrice}원</th>
                  <th><input type="hidden" id="cartQty${bvo.cartNum}" name="cartQty" value="${bvo.cartQty}"/>${bvo.cartQty}개</th>
                  <th><fmt:formatNumber value="${bvo.cartPrice*bvo.cartQty}" pattern="#,###원"/></th>
                  <input type="hidden" id="sum${bvo.cartNum}" name="total" value="${bvo.cartPrice*bvo.cartQty}">
                </tr>
                </table>
                <fmt:formatNumber value="${bvo.cartPrice*bvo.cartQty}" pattern="#,###원"/>

             </c:otherwise>
            </c:choose>
          </div>

            <!--Invoice Mid-->
            <div id="invoice-bot">

                <div id="table">
                    <table>

                    <tr class="service">
                        <td class="tableitem">
                    <input type="button" id="selectAddress" value="배송지 선택" class="itemtext-top">
                          <input type="hidden" id="addressStatus" value="N"/>
                          <p class="itemtext"><input type="text" class="itemtext-inner" id="userName" name="userName" placeholder="받는사람 이름" readonly></p>
                          <p class="itemtext"><input type="text" class="itemtext-inner" id="zipCode" name="zipCode" placeholder="우편번호" readonly></p>
                          <p class="itemtext"><input type="text" class="itemtext-inner" id="addr" name="addr" placeholder="받는사람 주소" readonly></p>
                          <p class="itemtext"><input type="text" class="itemtext-inner" id="userTel" name="userTel" placeholder="받는 사람 전화번호" readonly></p>
                          </td>
                    </tr>
                    <tr class="service">
                          <td class="tableitem"><p class="itemtext">
                          요청사항 : <input type="text" class="itemtext-inner" id="recipient_request" name="recipient_request" placeholder="요청사항을 적어주세요"></p></td>
                    </tr>

                    </table>
                </div><!--End Table-->

                <span class="submit-wrapper">
                    <input type="submit" id="buy" value="결제하기"/>
                </span>
          <%-- </form> --%>

          <div id="legalcopy">
              <p class="legal"><strong>교환 또는 환불을 원하시는 분들은 7일 이내에 가능합니다.</strong></p>
          </div>


        </div><!--End InvoiceBot-->
        </div><!--End Invoice-->
        </div><!-- End Invoice Holder-->
        <!-- partial -->

    </div>
</div>
<script>
    $(function(){

        $("#buy").click(function (){
        var IMP = window.IMP; // 생략가능
        IMP.init('imp48507577');

        $("#selectAddress").change(function(){
          $("#addressStatus").val("N");
        });

        if($("#addressStatus").val()!=='Y'){
          alert("주소를 선택하세요");
          return false;
        }

        if($("#recipient_request").val()===""){
            alert("요청사항을 입력하세요");
            return false;
        }

        IMP.request_pay({
            pg: 'html5_inicis',
            pay_method: 'card',
            merchant_uid: 'merchant_' + new Date().getTime(),
            name:'<c:forEach var="pvo" items="${plist}">[${pvo.productName}]</c:forEach>${bvo.productName}',

            amount: $("input[name=total]").val(),//가격

            buyer_email: '${uvo.userEmail}',
            buyer_name: $("#userName").val(),
            buyer_tel: $("#userTel").val(),
            buyer_postcode: $("#zipCode").val(),
            buyer_addr: $("#addr").val()

            }, function (rsp) {

            if(rsp.success) {

                var msg = '결제가 완료되었습니다.';
                var orderData = {
                      orderNum: rsp.imp_uid,
                      merchant_uid: rsp.merchant_uid,

                      genieId:$("input[name=genieId]").val(),
                      cartList: cartList,
                      productId:$("input[name=productId]").val(),
                      productName:$("input[name=productName]").val(),
                      orderPrice: $("input[name=cartPrice]").val(),
                      orderQty: $("input[name=cartQty]").val(),

                      recipientName: $("#userName").val(),
                      recipientPhone: $("#userTel").val(),
                      recipientAddress: $("#addr").val(),
                      recipientRequest: $("#recipient_request").val(),

                      total_price: $("input[name=total]").val(),

                      paymentMethod: rsp.card_name,

                };//data
                //alert(JSON.stringify(orderData));
                // if(rsp.paid_amount === orderData.total_price){
                    $.ajax({
                        url: "/order/orderCompletion", // 예: https://www.myservice.com/payments/complete
                        data: orderData,
                        type: "get",
                        contentType: "application/json",
                        async: false,
                        success:function(){

                                window.location.replace("/order/completion");
                                console.log(orderData);

                        },error:function(e){
                            console.log(e.responseText);
                        }
                    });
                // }else {
                //   alert("결제 실패");
                // }

            }else{
                var msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
              }
                alert(msg);
            });
          });
      });

    window.onload=function(){

      $("#selectAddress").click(function(){
          window.open("/user/addressbook","addressbook","width=500, height=800");
        });
      };
</script>
