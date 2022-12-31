<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/top.jspf" %>
<script src="https://kit.fontawesome.com/8d73d915f1.js" crossorigin="anonymous"></script>

<style>
.responsive-wrapper {
  background-color: #f5f5f7;
  background-size: cover;
  width: 100%;
  height: 100vh;
  margin: 0;
  padding: 1% 12%;
}
/* ------------------여기까지는 nav바 빼고 나머지 부분설정--------------------- */
.content {
  display: flex;
  align-items: flex-start;
}
.content-panel {
  display: flex;
  flex-direction: column;
  width: 25%;
  margin-right: 1em;
  background-color: #fff;
  color: #1d1d1f;
  box-shadow: 0 0 1px #dfdfdf;
  font-weight: bold;
  border-radius: 10px;
}
.content-panel h3{
  padding: 2.8em;
}
.content-panel>ul{
  margin: 0;
  padding: 0;
}
.content-panel>ul>li{
  padding: 1em;
  font-size: 14px; 
}
.content-panel>ul>li>i{
  margin: 0 1em; 
}
.content-panel>ul>li:last-child{
  margin-bottom: 3em;
}
/* ------------------------여기까지는 왼쪽 상자박스----------------------------------- */
.content-main{
  display: flex;
  flex-direction: column;
  width: 75%;
  background-color: #fff;
  color: #1d1d1f;
  box-shadow: 0 0 1px #dfdfdf;
  font-weight: bold;
  border-radius: 10px;
  padding: 3em;
}
.content-main h1{
  margin-bottom: 1em;
}
.order>ul>li:nth-child(2n+2){
  margin-bottom: 1em;
  font-size: .8em;
}
.order-title>ul>li{
  float: left;
  width: 20%;
  margin-bottom: 2em;

}
.order-title>ul>li:nth-child(3n+1){
  width: 60%;
}
.order-detail>ul>li{
  float:left;
  width: 25%;
  margin-bottom: 10em;
}
.order-detail>ul>li:nth-child(3n+1){
  width: 50%;
}
/* -----------------------여기는 오른쪽박스----------------------------- */
</style>

<div class="responsive-wrapper">
  <div class="content">
    <div class="content-panel">
      <h3>${vo.user_name}님</h3>
        <ul class="fa-ul">
					<li><i class="fa-solid fa-circle-user"></i><a href="/user/MyPage">회원정보 확인/수정</a></li>
					<li><i class="fa-brands fa-shopify"></i><a href="/user/MyOrderList">주문목록/배송조회</a></li>
					<li><i class="fa-sharp fa-solid fa-truck"></i><a href="/user/MyDeliveryList">배송지 관리</a></li>
        </ul>
    </div>
    <div class="content-main">
    <h1>주문목록</h1>
      <div class="order">
        <ul>
          <li>주문번호 : ${pVo.product_id}</li>
          i cla<li>주문일 : ${vo.order_writedate}</li>
        </ul>
      </div>
      <div class="order-title">
        <ul>
          <li>상품명</li>
          <li>수량</li>
          <li>가격</li>
        </ul>
      </div>
      <div class="order-detail">
        <ul>
          <li>${pVo.product_name}</li>
          <li>${pVo.product_quantity}</li>
          <li>${pVo.product_price}</li>
        </ul>
      </div>
    </div>
  </div>
</div>
