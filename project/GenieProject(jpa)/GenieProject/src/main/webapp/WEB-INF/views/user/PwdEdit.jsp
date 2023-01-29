<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style>

* {
	font-family: 'Noto Sans KR', sans-serif;
 }

#passwordForm {
    background-color: #fff;
}

#geniePwd, #geniePwd1, #geniePwd2 {
    background-color: #fff;
}

#FindPwd{
    background-color: #56baed;
	box-shadow: 0 0 15px #fbfbfb;
	border: none;
	padding: 10px;
	border-radius: 8px;
	color: #fff;
}

#geniePwd, #geniePwd1, #geniePwd2{
    width:11em;
    height:2em;
    border-radius:8px;
}


</style>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/js-sha256/0.9.0/sha256.min.js"></script>
<script>
    $(function(){
        $("#logFrm").submit(function(){
            if($("#geniePwd").val()===""){
                alert("비밀번호를 입력하세요..");
				$("#genie_id").focus();
                return false;
            }
            if($("#geniePwd1").val()===""){
                alert("비밀번호를 입력하세요..");
				$("#genie_pwd").focus();
                return false;
            }
			if($("#geniePwd2").val() !== $("#geniePwd1").val()){
                alert("비밀번호가 일치하지 않습니다.");
				$("#genie_pwd").focus();
                return false;
            }
            return true;
        });
    });
</script>

<section class="home">
<form method="post" action="/user/PwdEditOk" id="logFrm">
    <div id="passwordForm">
		<input type="hidden" value="${vo.genieId}" name="genieId"/>
		<p>비밀번호</p>
			<input type="password" id="geniePwd" name="geniePwd" placeholder="현재 비밀번호를 입력하세요">
		<p>새 비밀번호</p>
			<input type="password" id="geniePwd1" name="geniePwd1" placeholder="새 비밀번호를 입력하세요">
		<p>새 비밀번호 다시 입력</p>
			<input type="password" id="geniePwd2" name="changedPwd" placeholder="새 비밀번호를 입력하세요"><br/><br/>
			<input type="submit" id="Find_pwd" value="비밀번호 변경"/><br/>
	</div>
</form>
</section>