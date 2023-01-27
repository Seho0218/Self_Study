<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/top.jspf" %>

<style>
  .responsive-wrapper {
    background-color: #f5f5f7;
    background-size: cover;
    width: 100%;
    height: 100vh;
    margin: 0;
    padding: 1% 12%;
  }
  /* ------------------여기까지는 nav바 빼고 나머지 부분(회색부분)설정--------------------- */
.content {
  display: flex;
  align-items: flex-start;
}
.content h2{
  margin-bottom: 1em;
}
/* 박스를 가로로 정렬하기 위한 설정과 오른쪽 박스들의 h2 설정 */
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
  width: 30%;
  background-color: #fff;
  color: #1d1d1f;
  box-shadow: 0 0 1px #dfdfdf;
  font-weight: bold;
  border-radius: 10px;
  padding: 3em;
}
.content-main>ul{
  margin: 0;
  padding: 0;
}
.content-main h1{
  margin-bottom: 1em;
}

/* -----------------------여기까지는 첫번째오른쪽박스----------------------------- */
.my-delivery{
  display: flex;
  flex-direction: column;
  width: 40%;
  background-color: #fff;
  color: #1d1d1f;
  box-shadow: 0 0 1px #dfdfdf;
  font-weight: bold;
  border-radius: 10px;
  padding: 3em;
  margin-left: 1em;
}
/* --------------------------여기까지 두번째 오른쪽박스----------------------------*/
</style>
<!-- -----------------------------------------스크립트부분---------------------------------- -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="../js_css/KakaoAddress.js"></script>
<!-- ------------------------------------스크립트부분 끝---------------------------------------- -->
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
      <h2>새로운 배송지</h2>
        <div class="inquiry">
        <form method="post" action="/user/MyDeliveryEditOk">
        <input type="hidden" value="${vo.genie_id}" name="genie_id"/>
          <ul id="addrForm">
            <li>이름</li>
            <li><input type="text" name="receiver_name" id ="user_name"/></li>

            <ul id="phoneForm">
              <li>휴대폰 번호</li>
              <select id = "user_phone_num1" name = "user_phone_num1" size = "1">
                <option value="">선택하세요</option>
                <option value="010">010</option>
                <option value="011">011</option>
                <option value="016">016</option>
                <option value="017">017</option>
                <option value="018">018</option>
                <option value="019">019</option>
              </select>
              <input type ="text" name = "user_phone_num2" id ="user_phone_num2" maxlength = "4"/>
              <input type ="text" name = "user_phone_num3" id ="user_phone_num3" maxlength = "4"/>
            </ul>

            <li>우편번호</li>
            <li>
              <input type="text" name="receiver_zipcode" id ="user_zipcode" readonly/>
              <input type= "button" value = "우편번호찾기" id = "address_kakao"/>
            </li>
            <li>주소</li>
            <li><input type="text" name="receiver_addr" id ="user_addr" readonly/></li>
            <li>상세주소</li>
            <li><input type="text" name="receiver_detailaddr" id ="user_detailaddr" /></li>	
            <li><input type="submit" value = "배송지 등록"/></li>
          </ul>
        </form>   
        </div>
    </div>
    <div class="my-delivery">
      <h2>${vo.user_name}님의 배송지 목록</h2>
        <ul id="delivery_1">
          <h3>배송지1</h3>

          <li>우편번호</li>
          <input type = "text" name = "user_zipcode" id ="user_zipcode" value="${vo.user_zipcode}" readonly/>
           <li>주소</li>
          <li><input type = "text" name = "user_addr" id ="user_addr" value="${vo.user_addr}" readonly/></li>
          <li>상세주소</li>
          <li><input type = "text" name = "user_detailaddr" id ="user_detailaddr" value="${vo.user_detailaddr}" readonly/></li><br>
        </ul>
        <ul id="delivery_2">
          <h3>배송지2</h3>

          <li>우편번호</li>
          <input type = "text" name = "user_zipcode" id ="user_zipcode" readonly/>
           <li>주소</li>
          <li><input type = "text" name = "user_addr" id ="user_addr" readonly/></li>
          <li>상세주소</li>
          <li><input type = "text" name = "user_detailaddr" id ="user_detailaddr" readonly/></li><br>
        <ul id="delivery_3">
          <h3>배송지3</h3>

          <li>우편번호</li>
          <input type = "text" name = "user_zipcode" id ="user_zipcode" readonly/>
          <li>주소</li>
          <li><input type = "text" name = "user_addr" id ="user_addr" readonly/></li>
          <li>상세주소</li>
          <li><input type = "text" name = "user_detailaddr" id ="user_detailaddr" readonly/></li>
        </ul>
    </div>
  </div>
</div> --%><%-- 