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

#address_kakao {
  background-color: white; 
  color: black; 
  border: 2px solid #7600bc;
  padding: 10px;
  border-radius: 8px;
}

#address_kakao:hover {
  background-color: #7600bc;
  color: white;
}
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<body>

<body class="vertical-layout vertical-menu-collapsible page-header-dark vertical-modern-menu 2-columns  " data-open="click" data-menu="vertical-modern-menu" data-col="2-columns">

  <!-- BEGIN: Header-->
  <header class="page-topbar" id="header">
    <div class="navbar navbar-fixed "></div>

</header>
<!-- END: Header-->
  <!-- BEGIN: Page Main-->
  <div id="main">
    <div class="row">          
      <div class="content-wrapper-before  gradient-45deg-indigo-purple "></div>
        <div class="col s12">
        <div class="container">
          
          <div class="section">
   <!-- Current balance & total transactions cards-->
   <div class="row vertical-modern-dashboard">
      <div class="col s12 m6 l6">
         <!-- Current Balance -->
         <div class="card animate fadeLeft"> 
            <div class="card-content">

<!-- 추가되는 부분 -->
    <div class="content-main">
      <h4>새로운 배송지</h4>
      <div class="inquiry">
      <form method="post" action="/user/addAddressbook">
        <input type="hidden" value="${vo.genie_id}" name="genie_id"/>
          <ul id="addrForm">
            <li>이름</li>
            <li><input type="text" name="user_name" id ="user_name"/></li>

            <ul id="phoneForm">
              <li>휴대폰 번호</li>
              <select id = "user_phone_num1" name = "user_phone_num1" size = "1">
                <option value="">선택하세요</option>
                <option value="010">010</option>
                <option value="011">011</option>
                <option value="016">016</option>
                <option value="017">017</option>
                <option value="018">018</option>
                <option value="019">019</option>
              </select>
              <input type ="text" name = "user_phone_num2" id ="user_phone_num2" maxlength = "4"/>
              <input type ="text" name = "user_phone_num3" id ="user_phone_num3" maxlength = "4"/>
            </ul>

            <li>우편번호</li>
            <li>
              <input type="text" name="user_zipcode" id ="user_zipcode" readonly/>
              <input type= "button" value = "우편번호찾기" id = "address_kakao"/>
            </li>
            <li>주소</li>
            <li><input type="text" name="user_addr" id ="user_addr" readonly/></li>
            <li>상세주소</li>
            <li><input type="text" name="user_detailaddr" id ="user_detailaddr" /></li> 
            <li><input type="submit" id = "address_kakao" value = "배송지 등록"/></li>
          </ul>
      </form>   
      </div>
    </div>
</div>
</div>
</div>
<!-- 추가되는 부분 끝 -->  

            </div>
         </div>
      </div>
   </div>
   <!--/ Current balance & total transactions cards-->
        
<!-- END RIGHT SIDEBAR NAV -->                  
</div>
        
        <div class="content-overlay"></div>
      </div>
    </div>
  </div>
  <!-- END: Page Main-->

  
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

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="../js_css/js/KakaoAddress.js"></script>
