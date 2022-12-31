<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/top.jspf"%>
<link rel="stylesheet" href="../js_css/product_style.css" type="text/css"/>
<script src="../js_css/css/product_js.js"></script>
<style>
/*----------백그라운드-----------*/
.container {
	position: relative;
	width: 100%;
    margin: 0;
    padding: 10vh 10vw;
	background: #fafafa;
}
/*--------mbti-------------*/
#title h1{
	text-align:center;
	font-size:3.5em;
	margin:12vh 0;
}
.mbti_list{
	display: grid;
	grid-template-columns: 12vw 12vw 12vw 12vw;
	justify-content: space-evenly;
	row-gap: 4rem;
	margin-bottom:12vh;
}
.mbti_list img{
	width:100%;
	height:auto;
	border-radius:50%;
	box-shadow: 0 0 50px #eee;
}
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
</script>

<section class="container">
	<div id="title">
		<h1>MBTI별 선물 추천</h1>
	</div>
	<div class="mbti_list">
		<span><a href="/mbti/E"><img src="/image/mbtiE.png"/></a></span>
		<span><a href="/mbti/S"><img src="/image/mbtiS.png"/></a></span>
		<span><a href="/mbti/T"><img src="/image/mbtiT.png"/></a></span>
		<span><a href="/mbti/J"><img src="/image/mbtiJ.png"/></a></span>
		<span><a href="/mbti/I"><img src="/image/mbtiI.png"/></a></span>
		<span><a href="/mbti/N"><img src="/image/mbtiN.png"/></a></span>
		<span><a href="/mbti/F"><img src="/image/mbtiF.png"/></a></span>
		<span><a href="/mbti/P"><img src="/image/mbtiP.png"/></a></span>
	</div>
</section>
