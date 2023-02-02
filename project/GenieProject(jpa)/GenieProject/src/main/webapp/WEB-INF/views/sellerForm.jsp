<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="./inc/top.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
	section{
		padding: 80px 18%;
	}
	.home{
		position: relative;
		width: 100%;
		/*height: 100vh;*/
		/*background: url(../img/background.jpg);*/
		background: #f5f5f7;
		background-size: cover;
		background-position: center;
		display: grid;
		grid-template-columns: repeat(1, 1fr);
		align-items: center;
	}
	.container{
		padding:30px;
		width:620px;
		height:1600px;
		background-color:white;
		margin:0 auto;
		font-size:1.2em;
		box-sizing: border-box;
		border-radius:15px;
		-webkit-border-radius: 10px 10px 10px 10px;
		-webkit-box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
    	box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
	    overflow:auto;
	}
	h1{
		font-size:27px;
		/*margin-top:20px;
		margin-bottom:20px;
		margin-left:65px;
		padding:10px;*/
		margin:1em;
		text-align:center;
		
	}
	.selForm{
		width: 500px;
	    height: 1000px;
	    margin: 0px auto;
	    margin-top: 0;
	    /*padding: 10px;*/
	    padding-bottom: 30px;
	}
	.selForm p{
		padding:10px;
		padding-left:0;
		font-weight:bold;
	}

	#sellerEmail{
		width:63%;
	}

	/* 아이디중복검사 */
	#emailCheck {
		width: 33%;
		padding: .5em;
		font-size: 1em;
		background: #E162A2;
		color: #fff;
		border: none;
		border-radius: 10px;
		cursor: pointer;
	}


	input[type=text], input[type=password], input[type=email]{
		width:100%;
		height:50px;
		background-color: #f6f6f6;
		color: #0d0d0d;
		font-size:1em;
		padding:20px;
		margin:5px;
		border: 2px solid #f6f6f6;
    	border-radius: 10px 10px 10px 10px;
	}

	#tel1, #tel2, #tel3{
		width:29%;
		
	}
	#genie_id{
		width:55%;
	}
	#sel_zipcode{
		width:50%;
	}
	#idCheck, #zipSearch {
		width:33%;
		padding:10px;
		display:inline-block;
		font-size: 15px;
		background: #E162A2;
		color: #fff;
		border:none;
		border-radius: 10px;
		transition: ease .40s;
		margin:10px;
	}
	#regForm input{
		font-size:20px;
		height:60px;
		
	}
	#formSubmit{
		padding:10px 100px 10px 100px;
		display:block;
		margin:50px auto;
		font-size: 23px;
		background: #E162A2;
		color: #fff;
		border:none;
		border-radius: 10px;
		transition: ease .40s;
	}
</style>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	$(function(){
		//우편번호 찾기
		$("#zipSearch").click(function(){
			new daum.Postcode({
		        oncomplete: function(data) {
		        	document.getElementById("sel_zipcode").value= data.zonecode;
		        	document.getElementById("sel_addr").value = data.address;
		        }
		    }).open();
		});
		
		//아이디 중복검사
		$("#idCheck").click(function(){
			window.open("/idCheck?genie_id="+$("#genie_id").val(),"sellerIdCheck","width=400, height=200");
		});

		$("#emailCheck").click(function(){
			window.open("/sellerEmailCheck?sellerEmail="+$("#sellerEmail").val(),"emailCheck","width=400,height=300");
		});

		$("#genie_id").change(function(){
			$("#idCheckState").val("N");
		});

		$("#emailCheck").change(function(){
			$("#emailCheckState").val("N");
		});
		
		//유효성 검사
		$("#sellerFrm").submit(function(){
			//아이디
			if($("#genie_id").val()===""){
				alert("아이디를 입력하세요.");
				return false;
			}
			//아이디 중복검사여부
			if($("#idCheckState").val()!=='Y'){
				alert("아이디를 중복검사하세요.");
				return false;
			}


			//비밀번호
			if($("#genie_pwd").val()===""){
				alert("비밀번호를 입력하세요.");
				return false;
			}
			//비밀번호 일치
			if($("#genie_pwd").val() !== $("#genie_pwd2").val()){
				alert("비밀번호가 일치하지 않습니다.");
				return false;
			}
			//회사명
			if($("#company_name").val()===""){
				alert("회사명을 입력하세요.");
				return false;
			}
			//대표자명
			if($("#ceo_name").val()===""){
				alert("대표자명을 입력하세요.");
				return false;
			}
			//전화번호
			if($("#tel1").val()==="" || $("#tel2").val()==="" || $("#tel3").val()===""){
				alert("전화번호를 입력하세요.");
				return false;
			}
			//이메일
			if($("#sellerEmail").val()===""){
				alert("이메일을 입력하세요.");
				return false;
			}
			//이메일 중복검사 여부
			if($("#emailCheckState").val()!=='Y'){
				alert("이메일을 중복검사 하세요");
				return false;
			}
			//홈페이지
			if($("#seller_website").val()===""){
				alert("홈페이지를 입력하세요.");
				return false;
			}
			//사업자 등록증
			if($("#seller_reg_no").val()===""){
				alert("사업자 등록증을 첨부하세요.");
				return false;
			}
			//우편번호
			if($("#sel_zipcode").val()===""){
				alert("우편번호를 입력하세요.");
				return false;
			}
			//주소
			if($("#sel_addr").val()===""){
				alert("주소를 입력하세요.");
				return false;
			}
			return true;
		});
	});
</script>
</head>
<section class="home">
	<div class="container">
		<h1>기업회원 회원가입</h1>
		<form method="post" action="/sellerWrite" id="sellerFrm">
			<input type="hidden" value="SELLER" name="ROLE"/>
			<input type="hidden" value="N" name="sellerStatus"/>
			<ul class="selForm">
				<div id="idForm">
					<p>아이디</p>
					<input type="text" id="genie_id" name="genieId" value = "seller" placeholder="아이디를 입력하세요">
					<input type="button" value="아이디 중복검사" id="idCheck"/>
					<input type="hidden" id="idCheckState" value="N"/>
				</div>
				<div id="pwdForm">
					<p>비밀번호</p>
					<input type="password" id="genie_pwd" name="geniePwd" value = "123" placeholder="비밀번호를 입력하세요">
					<p>비밀번호 확인</p>
					<input type="password" id="genie_pwd2" name="geniePwd2" value = "123"placeholder="비밀번호를 입력하세요">
				</div>
				<div>
					<p>회사명</p>
					<input type="text" id="company_name" name="companyName" value = "회사명" placeholder="회사명을 입력하세요">
				</div>
				<div>
					<p>대표자명</p>
					<input type="text" id="ceo_name" name="ceoName" value = "대표자명" placeholder="대표자명을 입력하세요">
				</div>
				<div id="telForm">
					<p>전화번호</p>
					<input type ="text" name = "tel1" id ="tel1" value = "123" maxlength = "3"/>
					<input type ="text" name = "tel2" id ="tel2" value = "1234" maxlength = "4"/>
					<input type ="text" name = "tel3" id ="tel3" value = "1234" maxlength = "4"/>
				</div>
				<div>
					<p>이메일</p>
					<input type="text" id="sellerEmail" name="sellerEmail" value = "ghdtpgh8913@gmail.com" placeholder="이메일을 입력하세요">
					<input type="button" id="emailCheck" value="이메일 중복 검사"/>
					<input type ="hidden" id = "emailCheckState" value = "N"/>
				</div>
				<div>
					<p>홈페이지</p>
					<input type="text" id="seller_website" name="sellerWebsite" value = "naver.com" placeholder="홈페이지를 입력하세요">
				</div>
				<div id="regForm">
					<p>사업자 등록증</p>
					<input type="file" id="seller_reg_no" name="sellerRegNo" value = "123"/>
				</div>
				
				<div id="addrForm">
					<p>우편번호</p>
					<input type="text" id="sel_zipcode" name="sel_zipcode" value = "12344"/>
					<input type="button" value="우편번호찾기" id="zipSearch"/>
					<p>주소</p>
					<input type="text" id="sel_addr" name="selAddr" value = "123" placeholder="">
					<p>상세주소</p>
					<input type="text" id="sel_detailaddr"  value = "123" name="selDetailAddr"/>
				</div>
				<li><input type="submit" id="formSubmit" value="회원가입하기"/></li>
			</ul>
		</form>
	</div>		
</section>
</html>
