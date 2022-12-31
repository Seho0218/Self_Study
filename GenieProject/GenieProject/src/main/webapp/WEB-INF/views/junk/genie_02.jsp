<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/top.jspf"%>
<style>
.home {
	position: relative;
	width: 100%;
	height: 100vh;
	margin: 0;
    padding:6% 23%;

	/*background: url(../img/background.jpg);*/
	background: #f5f5f7;
	background-size: cover;
	background-position: center;
}
.grid-container{
	display: grid;
	grid-template-columns: repeat(4, 1fr);
	gap: 2rem;
}
.genie_02 h2{
	margin-bottom: 2em;
	color: #1d1d1f;
	width: 35ch;
	animation: typing 2s steps(35), blink .5s step-end infinite alternate;
  	white-space: nowrap;
	overflow: hidden;
	border-right: .09em solid;
}
@keyframes typing {
  from {
    width: 0
  }
}
@keyframes blink {
  50% {
    border-color: transparent
  }
}
.button a{
	display: flex;
	align-content: stretch;
	justify-content: center;
	background-color: #fff;
	color: #1d1d1f;
	margin: 1%;
	padding: .8em 1.8em;
	font-size: 1.7em;
	font-weight: bold;
	border-radius: 25px;
	transition: ease .5s;
	box-shadow: 0 0 1px #dfdfdf;
}
.button a:hover{
	background-color: #fff;
	transform: scale(1.05);
	box-shadow: 0 0 5px #b4b4b4;
}  
</style>

<section class="home">
	<div class="genie_02">
		<h2>선물 예산은 어느정도로 생각하고 계신가요?</h2>
	</div>
		<div class="grid-container">
			<div class="button">
				<a href="/genie/genie_03">1만원</a>
			</div>
			<div class="button">
				<a href="/genie/genie_03">2만원</a>
			</div>
			<div class="button">
				<a href="/genie/genie_03">5만원</a>
			</div>
			<div class="button">
				<a href="/genie/genie_03">10만원</a>
			</div>
			<div class="button">
				<a href="/genie/genie_03">20만원</a>
			</div>
			<div class="button">
				<a href="/genie/genie_03">30만원</a>
			</div>
			<div class="button">
				<a href="/genie/genie_03">40만원</a>
			</div>
			<div class="button">
				<a href="/genie/genie_03">50만원</a>
			</div>
		</div>
	</div>
</section>
