<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./inc/top.jspf" %>
<style>
  @import url('https://fonts.googleapis.com/css?family=Poppins');
  /* 메인구조 회색부분 */
  .login {
    position: relative;
    width: 100%;
    height: 100vh;
    margin: 0;
    padding: 3% 23%;
    background: #fafafa;
  }
  /* 폼을 세로로 정렬하기 위한 css */
  .wrapper {
    display: flex;
    align-items: center;
    flex-direction: column; 
    width: 100%;
  }
  /* 아이디, 비밀번호, 아이디|비밀번호 찾기 글씨설정 */
  p {
    font-size: 1.5em;
    font-weight: bold;
    margin: .5em;
  }
  /* 폼 흰색부분 */
  #formContent {
    border-radius: 10px;
    background: #fff;
    padding: 3%;
    width: 70%;
    position: relative;
    -webkit-box-shadow: 0 30px 60px 0 rgba(0,0,0,0.1);
    box-shadow: 0 30px 60px 0 rgba(0,0,0,0.1);
    text-align: center;
  }
  /* 아이디랑 비밀번호 입력란 설정 */
  input[type=text],[type=password] {
    background-color: #f5f5f7;
    border: none;
    color: #1d1d1f;
    padding: 1em;
    text-align: center;
    font-size: 1em;
    width: 85%;
    border: none;
    border-radius: 10px;
  }
  input[type=text]:placeholder {
    color: #cccccc;
  }
  /* 로그인(submit) */
  input[type=submit] {
    background-color: #56baed;
    color: #fff;
    padding: 1em;
    text-align: center;
    font-size: 1em;
    margin: 1.5em;
    width: 85%;
    border: none;
    border-radius: 10px;
    cursor: pointer;
  }
  /* 일반회원 회원가입 */
  #userReg {
    background-color: #F7D25A;
    color: #fff;
    padding: 1em;
    text-align: center;
    font-size: 1em;
    margin: 3em 0 .5em 0;
    width: 85%; 
    border: none;
    border-radius: 10px;
    cursor: pointer;
  }
  /* 기업회원 회원가입 */
  #comReg{
    background-color: #E162A2;
    color: #fff;
    padding: 1em;
    text-align: center;
    font-size: 1em;
    margin-bottom: 2em;
    width: 85%; 
    border: none;
    border-radius: 10px;
    cursor: pointer;
  }
</style>
<script>
$(function(){

    $("#FindId").click(function(){
			window.open("/cert/FindId","FindId","width=400, height=300");
		});

    $("#FindPwd").click(function(){
			window.open("/cert/FindPwd","FindPwd","width=400, height=300");
		});
});

</script>
<script>
    $(function(){
        $("#logFrm").submit(function(){

            if($("#genie_id").val()==""){
                alert("아이디를 입력하세요..");
		              $("#genie_id").focus();

                return false;
            }

            if($("#genie_pwd").val()==""){
                alert("비밀번호를 입력하세요..");

                  $("#genie_pwd").focus();
                return false;
            }
            return true;
        });
    });
</script>

<section class="login">
  <div class="wrapper">
    <div id="formContent">
      <!-- 로그인폼-->
      <form method="post" action="/loginOK" id="logFrm">
        <p>아이디</p>
        <input type="text" id="genie_id" name="genie_id" placeholder="아이디를 입력하세요">
      <!-- 비밀번호 -->
        <p>비밀번호</p>
        <input type="password" id="genie_pwd" name="genie_pwd" placeholder="비밀번호를 입력하세요">
        <input type="submit" value="로그인">
        <h3><a href="" id="FindId">아이디찾기</a> | <a href="" id="FindPwd">비밀번호 찾기</a></h3>
      <!-- 로그인폼-->
        <a href="/Registration"><input type="button" id="userReg" value="일반회원 회원가입"></a>
        <a href="/sellerForm"><input type="button" id="comReg" value="기업회원 회원가입"></a>
      </form>
    </div>
  </div>
<section>