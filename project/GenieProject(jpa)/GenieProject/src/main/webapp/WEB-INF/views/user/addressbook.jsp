<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>

 <title>Genie 페이지</title>
  <!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css'>
<link rel='stylesheet' href='https://fonts.googleapis.com/icon?family=Material+Icons'><link rel="stylesheet" href="./style.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" type="text/css"
  href="https://www.pixinvent.com/materialize-material-design-admin-template/laravel/demo-1/css/themes/vertical-modern-menu-template/style.css">
<link rel="stylesheet" type="text/css" href="https://www.pixinvent.com/materialize-material-design-admin-template/laravel/demo-1/css/pages/dashboard-modern.css">
<link rel="stylesheet" type="text/css" href="https://www.pixinvent.com/materialize-material-design-admin-template/laravel/demo-1/css/pages/intro.css">
<!-- BEGIN: Custom CSS-->
<link rel="stylesheet" type="text/css" href="https://www.pixinvent.com/materialize-material-design-admin-template/laravel/demo-1/css/laravel-custom.css">
<link rel="stylesheet" type="text/css" href="https://www.pixinvent.com/materialize-material-design-admin-template/laravel/demo-1/css/custom/custom.css">
<!-- END: Custom CSS-->


<style>
.icon-block {
  padding: 0 15px;
}
.icon-block .material-icons {
  font-size: inherit;
}

.height-64px {
  height: 64px;
  line-height: 64px;
}

nav .sidenav-trigger i {
  height: 64px;
  line-height: 64px;
}

#Btn, #address_kakao {
  background-color: white; 
  color: black; 
  border: 2px solid #7600bc;
  padding: 10px;
  border-radius: 8px;
}

.Btn:hover {
  background-color: #7600bc;
  color: white;
}
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<body>

<body
  class="vertical-layout vertical-menu-collapsible page-header-dark vertical-modern-menu 2-columns  "
  data-open="click" data-menu="vertical-modern-menu" data-col="2-columns">

  <!-- BEGIN: Header-->
  <header class="page-topbar" id="header">
    <div class="navbar navbar-fixed ">
  <nav
    class="navbar-main navbar-color nav-collapsible no-shadow nav-expanded sideNav-lock  navbar-dark gradient-45deg-indigo-purple ">
    <div class="nav-wrapper">
      <div class="header-search-wrapper hide-on-med-and-down">
        <i class="material-icons">search</i>
        <input class="header-search-input z-depth-2" type="text" name="Search" placeholder="#배송확인, #주문확인"
          data-search="template-list">
        <ul class="search-list collection display-none"></ul>
      </div>
      <!-- translation-button-->
      <ul class="dropdown-content" id="translation-dropdown">
      </ul>
      <!-- notifications-dropdown-->
      <ul class="dropdown-content" id="notifications-dropdown">
        <li>
          <h6>알림<span class="new badge">2</span></h6>
        </li>
        <li class="divider"></li>
        <li>
          <a class="black-text" href="javascript:void(0)">
            <span class="material-icons icon-bg-circle red small">stars</span>
            결제가 완료되었습니다.
          </a>
          <time class="media-meta grey-text darken-2" datetime="2022-09-12T20:50:48+08:00">3 days ago</time>
        </li>
        <li>
          <a class="black-text" href="javascript:void(0)">
            <span class="material-icons icon-bg-circle amber small">trending_up</span>
            주문하신 물건의 배송이 완료되었습니다.
          </a>
          <time class="media-meta grey-text darken-2" datetime="2015-06-12T20:50:48+08:00">1 week ago</time>
        </li>
      </ul>
    </div>
    <nav class="display-none search-sm">
      <div class="nav-wrapper">
        <form id="navbarForm">
          <div class="input-field search-input-sm">
            <input class="search-box-sm mb-0" type="search" required="" placeholder='Explore Materialize' id="search"
              data-search="template-list">
            <label class="label-icon" for="search">
              <i class="material-icons search-sm-icon">search</i>
            </label>
            <i class="material-icons search-sm-close">close</i>
            <ul class="search-list collection search-list-sm display-none"></ul>
          </div>
        </form>
      </div>
    </nav>
  </nav>
</div>

</header>
  <!-- END: Header-->

</aside>  <!-- END: SideNav-->

  <!-- BEGIN: Page Main-->
  <div id="main">
    <div class="row">
                  
      <div
        class="content-wrapper-before  gradient-45deg-indigo-purple ">
      </div>
            

            <div class="col s12">
        <div class="container">
          
          <div class="section">
   <!-- Current balance & total transactions cards-->


<!-- 추가되는 부분 끝 -->  
<!-- 추가되는 2부분 시작 -->

   <!-- Current balance & total transactions cards-->

      <div class="col s12 m6 l6">
         <!-- Current Balance -->
         <div class="card animate fadeLeft">
            <div class="card-content">

    <div class="my-delivery">
      <h4>배송지 목록</h4>
        <ul id="delivery_1">
        <c:forEach var="dvo" items="${dlist}">
            <h5>배송지</h5>
            <input type="hidden" value="${dvo.address_num}" readonly/>
            <input type="hidden" id="addressStatus" value="Y" readonly/>
            <li>수령자 이름</li>
            <input type="text" id="receiver_name" value="${dvo.receiver_name}" readonly/>
            <li>전화번호</li>
            <input type="text" id="receiver_tel" value="${dvo.receiver_tel}" readonly/>
            <li>우편번호</li>
            <input type="text" id="receiver_zipcode" value="${dvo.receiver_zipcode}" readonly/>
            <li>주소</li>
            <input type="text" id="receiver_addr" value="${dvo.receiver_addr}, ${dvo.receiver_detailaddr}" readonly/><br>
            <div><input type="hidden" value='${dvo.address_num}' /></div>
            <div><input type="button" value='선택' id="select" class="Btn"/>
            <input type="button" value='삭제' address_num="${dvo.address_num}" class="Btn" /></div>
        </c:forEach>    
    </div>
        <a href="/user/Addaddressbook"><input type="button" value='추가' class="Btn" id="addBtn"/></div></a>
         
  <!-- BEGIN: Footer-->
<footer
  class="page-footer footer gradient-shadow  footer-static   footer-dark gradient-45deg-indigo-purple ">
  <div class="footer-copyright">
    <div class="container">
      <span>&copy; 2022 <a href="/"
          target="_blank">Genie</a> All rights reserved.
      </span>
      <span class="right hide-on-small-only">
        <a href="/"></a>
      </span>
    </div>
  </div>
</footer>

<!-- END: Footer-->  
  <!-- BEGIN VENDOR JS-->
<script src="https://www.pixinvent.com/materialize-material-design-admin-template/laravel/demo-1/js/vendors.min.js"></script>
<!-- BEGIN VENDOR JS-->
<!-- BEGIN PAGE VENDOR JS-->
<script src="https://www.pixinvent.com/materialize-material-design-admin-template/laravel/demo-1/vendors/chartjs/chart.min.js"></script>
<script src="https://www.pixinvent.com/materialize-material-design-admin-template/laravel/demo-1/vendors/chartist-js/chartist.min.js"></script>
<script src="https://www.pixinvent.com/materialize-material-design-admin-template/laravel/demo-1/vendors/chartist-js/chartist-plugin-tooltip.js"></script>
<script src="https://www.pixinvent.com/materialize-material-design-admin-template/laravel/demo-1/vendors/chartist-js/chartist-plugin-fill-donut.min.js"></script>
<!-- END PAGE VENDOR JS-->
<!-- BEGIN THEME  JS-->
<script src="https://www.pixinvent.com/materialize-material-design-admin-template/laravel/demo-1/js/plugins.js"></script>
<script src="https://www.pixinvent.com/materialize-material-design-admin-template/laravel/demo-1/js/search.js"></script>
<script src="https://www.pixinvent.com/materialize-material-design-admin-template/laravel/demo-1/js/custom/custom-script.js"></script>
<script src="https://www.pixinvent.com/materialize-material-design-admin-template/laravel/demo-1/js/scripts/customizer.js"></script>
<!-- END THEME  JS-->
<script>
	$(document).on('click','#delivery_1 input[value=삭제]',function(){

		var params = {address_num: $(this).attr('address_num')};
		    $.ajax({
				url:"/user/delDelivery",
				data:params,
				success:function(result){
          alert("삭제되었습니다.");
					location.reload();
				},error:function(e){
					console.log(e.responseText);
				}
			});	
	  });
</script>
<script>
	document.getElementById("select").addEventListener('click',function(){
    opener.document.getElementById("receiver_name").value=document.getElementById("receiver_name").value;
    opener.document.getElementById("receiver_tel").value=document.getElementById("receiver_tel").value;
    opener.document.getElementById("receiver_zipcode").value=document.getElementById("receiver_zipcode").value;
    opener.document.getElementById("receiver_addr").value=document.getElementById("receiver_addr").value;
    opener.document.getElementById("addressStatus").value=document.getElementById("addressStatus").value;
    window.close();
  })
</script>
