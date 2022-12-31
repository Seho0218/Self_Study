<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./inc/top.jspf"%>
<link rel="stylesheet" href="/js_css/css/genie_style.css" type="text/css"/>
<script src="/js_css/js/genie_js.js"></script>

<!-- <ul class="page_gradient">
	<li><input type="button" onclick="next1()" style="background-color: rgb(100,200,200)"></li>
	<li><input type="button" onclick="next2()"></li>
	<li><input type="button" onclick="next3()"></li>
	<li><input type="button" onclick="next4()"></li>
	<li><input type="button" onclick="next5()"></li>
</ul> -->

<form method='post' class="grid-container" id="genieFrm" action="/selectProduct">
	<div class="genie">
		<section class="genie_00">
			<div>
				<h2>어떤 분에게 선물할 계획인가요?</h2>
			</div>
			<div class="grid-container-button">
				<div class="tag_name">
					<input type="radio" name="genie_who" id="1" value="부모님">
					<label for="1">부모님</label>
				</div>
				<div class="tag_name">
					<input type="radio" name="genie_who" id="2" value="배우자">
					<label for="2">배우자</label>
				</div>			
				<div class="tag_name">
					<input type="radio" name="genie_who" id="3" value="연인">
					<label for="3">연인</label>
				</div>
				<div class="tag_name">
					<input type="radio" name="genie_who" id="4" value="가족/친척">
					<label for="4">친척/가족</label>
				</div>			
				<div class="tag_name">
					<input type="radio" name="genie_who" id="5" value="친구/지인">
					<label for="5">친구/지인</label>
				</div>			
				<div class="tag_name">
					<input type="radio" name="genie_who" id="6" value="회사동료">
					<label for="6">회사동료</label>
				</div>			
				<div class="tag_name">
					<input type="radio" name="genie_who" id="7" value="스승/멘토">
					<label for="7">스승/멘토</label>
				</div>
			</div>
		</section>

		<section class="genie_01">
			<div>
				<h2>어떤 특별한 날에 드릴 선물인가요?</h2>
			</div>
			<div class="grid-container-button">
				<div class="tag_name">
					<input type="radio" name="genie_day" id="8" value="생일">
					<label for="8">생일</label>
				</div>
				<div class="tag_name">
					<input type="radio" name="genie_day" id="9" value="기념일">
					<label for="9">기념일</label>
				</div>
				<div class="tag_name">
					<input type="radio" name="genie_day" id="10" value="백일">
					<label for="10">백일</label>
				</div>
				<div class="tag_name">
					<input type="radio" name="genie_day" id="11" value="집들이">
					<label for="11">집들이</label>
				</div>
				<div class="tag_name">
					<input type="radio" name="genie_day" id="12" value="서프라이즈">
					<label for="12">서프라이즈</label>
				</div>
				<div class="tag_name">
					<input type="radio" name="genie_day" id="13" value="응원">
					<label for="13">응원</label>
				</div>
				<div class="tag_name">
					<input type="radio" name="genie_day" id="14" value="감사">
					<label for="14">감사</label>
				</div>
				<div class="tag_name">
					<input type="radio" name="genie_day" id="15" value="결혼">
					<label for="15">결혼</label>
				</div>
				<div class="tag_name">
					<input type="radio" name="genie_day" id="16" value="출산">
					<label for="16">출산</label>
				</div>
				<div class="tag_name">
					<input type="radio" name="genie_day" id="17" value="임신">
					<label for="17">임신</label>
				</div>
				<div class="tag_name">
					<input type="radio" name="genie_day" id="18" value="개업">
					<label for="18">개업</label>
				</div>
				<div class="tag_name">
					<input type="radio" name="genie_day" id="19" value="위로">
					<label for="19">위로</label>
				</div>
			</div>
		</section>

		<section class="genie_02">
			<div>
				<h2>선물 받는 분의 나이대가 어떻게 되나요?</h2>
			</div>
			<div class="grid-container-button">
				<div class="tag_name">
					<input type="radio" name="genie_old" id="26" value="10대이하">
					<label for="26">10대이하</label>
				</div>
				<div class="tag_name">
					<input type="radio" name="genie_old" id="27" value="20대">
					<label for="27">20대</label>
				</div>
				<div class="tag_name">
					<input type="radio" name="genie_old" id="28" value="30대">
					<label for="28">30대</label>
				</div>
				<div class="tag_name">
					<input type="radio" name="genie_old" id="29" value="40대">
					<label for="29">40대</label>
				</div>
				<div class="tag_name">
					<input type="radio" name="genie_old" id="30" value="50대">
					<label for="30">50대</label>
				</div>
				<div class="tag_name">
					<input type="radio" name="genie_old" id="31" value="60대이상">
					<label for="31">60대이상</label>
				</div>
			</div>
		</section>

		<section class="genie_03">
			<div>
				<h2>선물 받는 분의 성별은 어떻게 되나요?</h2>
			</div>
			<div class="grid-container-button">
				<div class="tag_name">
					<input type="radio" name="gender" id="32" value="남성">
					<label for="32">남자</label>
				</div>
				<div class="tag_name">
					<input type="radio" name="gender" id="33" value="여성">
					<label for="33">여자</label>
				</div>
			</div>
		</section>

		<section class="genie_04">
			<div>
				<h2>최소 예산은 어느 정도로 생각하고 계신가요?</h2>
			</div>
			<div class="grid-container-button">
				<div class="tag_name">
					<input type="radio" name="money_low" id="20" value="0">
					<label for="20">보고 선택할게요</label>
				</div>
				<div class="tag_name">
					<input type="radio" name="money_low" id="21" value="10000">
					<label for="21">10,000원</label>
				</div>
				<div class="tag_name">
					<input type="radio" name="money_low" id="22" value="30000">
					<label for="22">30,000원</label>
				</div>
				<div class="tag_name">
					<input type="radio" name="money_low" id="23" value="50000">
					<label for="23">50,000원</label>
				</div>
				<div class="tag_name">
					<input type="radio" name="money_low" id="24" value="100000">
					<label for="24">100,000원</label>
				</div>
				<div class="tag_name">
					<input type="radio" name="money_low" id="25" value="200000">
					<label for="25">200,000원</label>
				</div>
			</div>
		</section>

		<section class="genie_05">
			<div>
				<h2>최대 예산은 어느 정도로 생각하고 계신가요?</h2>
			</div>
			<div class="grid-container-button">
				<div class="tag_name">
					<input type="radio" name="money_max" id="40" value="10000">
					<label for="40">10,000원</label>
				</div>
				<div class="tag_name">
					<input type="radio" name="money_max" id="41" value="29999">
					<label for="41">30,000원</label>
				</div>
				<div class="tag_name">
					<input type="radio" name="money_max" id="42" value="49999">
					<label for="42">50,000원</label>
				</div>
				<div class="tag_name">
					<input type="radio" name="money_max" id="43" value="99999">
					<label for="43">100,000원</label>
				</div>
				<div class="tag_name">
					<input type="radio" name="money_max" id="44" value="199999">
					<label for="44">200,000원</label>
				</div>
				<div class="tag_name">
					<input type="radio" name="money_max" id="45" value="9999999">
					<label for="45">그런거 없다.</label>
				</div>
			</div>
		</section> 
	</div>

	<ul class="page_order">
		<li><input type="button"></li>
		<li><input type="button"></li>
		<li><input type="button"></li>
		<li><input type="button"></li>
		<li><input type="button"></li>
		<li><input type="button"></li>
		
		<!-- <li><input type="button"></li> -->
    </ul>

</form>
