window.onload = function(){
	document.getElementById("address_kakao").addEventListener("click", function(){ 
		//카카오 지도 발생
		new daum.Postcode({
			oncomplete: function(data) { //선택시 입력값 세팅
				document.getElementById("user_zipcode").value = data.zonecode; 
				document.getElementById("user_addr").value = data.address; 
			}
		}).open();
	});
}