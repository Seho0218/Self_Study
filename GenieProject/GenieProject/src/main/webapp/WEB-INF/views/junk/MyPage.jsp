<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/top.jspf" %>

<style>
/* ------------------nav바 빼고 나머지 밑에 회색부분 페이지 설정--------------------- */
.responsive-wrapper {
	background-color: #f5f5f7;
	width: 100%;
	height: 100vh;
	margin: 0;
	padding: 1% 12%;
}
/* ---------------------------------왼쪽 흰색 상자박스설정----------------------------------- */
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
/* ----------------------------------------------------------------------- */
/* ---------------------오른쪽상자박스------------------------ */
/* 오른쪽 흰색박스 크기와 내부크기 */
.content-main{
	width: 75%;
	padding: 1em 15em;
	background-color: #fff;
	border-radius: 10px;
	box-shadow: 0 0 1px #dfdfdf;
}
/* 회원정보 글씨설정 */
.content-main h1{
	text-align: center;
	margin: .5em 0 1em 0;
}
/* 리스트스타일 글자설정 */
.userForm li{
	font-weight: bold;
	margin: 1em 0;
}
/* -------------------------------------------------------------------------------------- */
/* 비밀번호 글자설정 */
#passwordForm{
	display: flex;
	justify-content: flex-start;
	align-items: center;
	font-size: 1em;
}
/* 비밀번호찾기 글자설정 */
#PwdEdit{
	margin-left: 2vw;
	border: none;
	border-radius: 10px;
	background: #F7D25A;
	color: #fff;
	padding: .5em;
	font-size: 1em;
	cursor: pointer;
}
/* --------------------------------------------------------------------------------------- */
/* 휴대폰번호 빼고 회색부분 설정 */
input[type=text], input[type=email]{
	width: 100%;
	background-color: #f5f5f7;
	color: #1d1d1f;
	font-size: 1em;
	padding: .7em;
	border: none;
	border-radius: 10px;
}
/* ------------------------------------------------- */
/* 휴대폰번호 회색부분 설정 */
#user_phone_num1{
	width: 25%;
	background-color: #f5f5f7;
	color: #1d1d1f;
	font-size: 1em;
	padding: .7em;
	border: none;
	border-radius: 10px;
}
#user_phone_num2, #user_phone_num3{
	width: 33%;
	margin-left: .5em;
}
/* -------------------------------------------------- */
/* 회원정보수정 버튼 */
#formSubmit{
	display: flex;
	justify-content: center;
	align-items: center;
	padding: .5em;
	margin: 1em auto;
	font-size: 1.5em;
	background: #F7D25A;
	color: #fff;
	border:none;
	border-radius: 10px;
	cursor: pointer;
}
</style>

<!-- -----------------------------------------스크립트 부분 시작---------------------------------- -->
<script>
	$(function(){
		$("#PwdEdit").click(function(){
			window.open("/user/PwdEdit","PwdEdit","width=400,height=300");
		});
		
		//유효성 검사
       	$("#logFrm").submit(function(){

			// 전화번호
			if($("#user_phone_num1").val()=="" || $("#user_phone_num2").val()=="" || $("#user_phone_num3").val()==""){
				alert("연락처를 입력하세요");
				return false;
			}
			return true;
			// 우편번호
			if($("#user_zipcode").val()==""){
				alert("우편번호를 선택하세요");
				$("#user_zipcode").focus();
				return false;
			}
			if($("#user_addr").val()==""){
				alert("주소를 입력하세요");
				$("#user_addr").focus();
				return false;
			}
			if($("#user_detailaddr").val()==""){
				alert("상세 주소를 입력하세요");
				$("#user_detailaddr").focus();
				return false;
			}
			// 이메일
			if($("#user_email").val()==""){
				alert("이메일을 입력하세요");
				$("#user_email").focus();
				return false;
			}			
			return true;
		});
    });
</script>
<!-- ------------------------------------스크립트부분 끝------------------------------------------->
<div class="responsive-wrapper">
 	<div class="content">
		<div class="content-panel">
			<h3>${vo.user_name} ${svo.ceo_name}님</h3>
				<ul class="fa-ul">
					<li><i class="fa-solid fa-circle-user"></i><a href="/user/MyPage">회원정보 확인/수정</a></li>
					<li><i class="fa-brands fa-shopify"></i><a href="/user/MyOrderList">주문목록/배송조회</a></li>
					<li><i class="fa-sharp fa-solid fa-truck"></i><a href="/user/MyDeliveryList">배송지 관리</a></li>
				</ul>
		</div>
			<div class="content-main">
				<h1>회원정보</h1>
				<div class="userForm">
					<form method="post" action="/user/UserEditOk" id="logFrm">
						<ul id="idForm">
							<li>아이디</li>
							<input type="text" id="genie_id" name="genie_id" value= "${vo.genie_id} ${svo.genie_id}" readonly>
							<input type ="hidden" id = "idCheckState" value = "Y"/>
						</ul>
						<ul id="name">
							<li>이름</li>
							<input type="text" id="user_name" name="user_name" value= "${vo.user_name} ${svo.ceo_name}" readonly>
						</ul>
						<ul id="passwordForm">
							<li>비밀번호</li>
							<li><input type="button" id="PwdEdit" value="비밀번호를 변경하려면 클릭하세요"/></li>
						</ul>
						<ul id="phoneForm">
							<li>휴대폰 번호</li>
							<select id = "user_phone_num1" name = "user_phone_num1" size = "1" value = "${vo.user_phone_num1}">
								<option value="010">010</option>
								<option value="011">011</option>
								<option value="016">016</option>
								<option value="017">017</option>
								<option value="018">018</option>
								<option value="019">019</option>
							</select>
							<input type ="text" name = "user_phone_num2" id ="user_phone_num2" maxlength = "4" value ="${vo.user_phone_num2}"/>
							<input type ="text" name = "user_phone_num3" id ="user_phone_num3" maxlength = "4" value ="${vo.user_phone_num3}"/>
						</ul>
						<ul id="emailForm">
							<li>이메일</li>
							<input type="email" id="user_email" name="user_email" value ="${vo.user_email} ${svo.seller_email}" placeholder="이메일을 입력하세요">
						</ul>
						<%-- <input type = "submit" id="formSubmit" value = "회원정보 수정"/>
					</form>
				</div>
			</div>
		</div>
	</div>
</div> --%>