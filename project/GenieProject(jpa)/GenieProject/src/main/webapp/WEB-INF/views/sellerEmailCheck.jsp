<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<style>
	#topMenu, #logo, #mainMenu, .footer{
	display:none;
	}
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function(){
		//조회한 이메일을 opener에 셋팅하고 현재 window를 닫아야한다.
		$("#setId").click(function(){
			opener.$('#sellerEmail').val('${sellerEmail}');
			opener.$('#emailCheckState').val('Y');
			window.close();
		});
	});
	console.log(idCnt);
</script>
<div>
	<c:if test="${emailCnt==0}">
		<b>${sellerEmail}</b>는 사용가능한 이메일 입니다.
		<input type = "button" value = "이메일 사용하기" id="setId"/>
	</c:if>
	<c:if test="${emailCnt>0}">
		<b>${sellerEmail}는 사용 불가능한 이메일 입니다.</b>
	</c:if>
	<hr/>
	<form method = "get" action="/sellerEmailCheck">
		아이디 : <input type = "text" name = "sellerEmailCheck" id = "sellerEmailCheck"/>
		<input type = "submit" value ="이메일 중복 검사하기"/>
	</form>
</div>