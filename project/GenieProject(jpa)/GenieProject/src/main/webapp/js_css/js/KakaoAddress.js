window.onload = function(){
	document.getElementById("address_kakao").addEventListener("click", function(){ 
		//카카오 지도 발생
		new daum.Postcode({
			oncomplete: function(data) { //선택시 입력값 세팅
				document.getElementById("zipCode").value = data.zonecode; 
				document.getElementById("addr").value = data.address; 
			}
		}).open();
	});
}