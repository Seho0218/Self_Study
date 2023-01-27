<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<style>
.thumb {
  width: 100px;
}

#page{
	width:20%; margin-left:auto; margin-right:auto; list-style-type:none; 
}

#page li{
	float:left; padding:10px;
}
</style>

<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->

  <title>Genie</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Theme style -->
  <link rel="stylesheet" href="/js_css/dist/css/adminlte.min.css">
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="/js_css/fontawesome-free/css/all.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script>
	$(function(){
		$("#searchFrm").submit(function(){
			if($("#searchWord").val()==""){
				alert("검색어를 입력하세요.");
				return false;
			}
			return true;
		});
	});
</script>
<body class="hold-transition sidebar-mini">
<div class="wrapper">

  <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="/" class="nav-link">Home</a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="#" class="nav-link">상품관리</a>
      </li>
    </ul>
  </nav>
  <!-- /.navbar -->

 <!-- Main Sidebar Container -->
 <aside class="main-sidebar sidebar-dark-primary elevation-4">
  <!-- Brand Logo -->
  <a href="/admin/adminMain" class="brand-link">
    <img src="/js_css/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
    <span class="brand-text font-weight-light">Genie-Admin</span>
  </a>

  <!-- Sidebar -->
  <div class="sidebar">
    <!-- Sidebar user panel (optional) -->
    <div class="user-panel mt-3 pb-3 mb-3 d-flex">
      <div class="image">
        <img src="https://st.depositphotos.com/1105977/1271/i/950/depositphotos_12715373-stock-photo-blue-circle-splash.jpg" class="img-circle elevation-2" alt="User Image">
      </div>
      <div class="info">
        <a href="#" class="d-block">조준환</a>
      </div>
    </div>

    <!-- SidebarSearch Form -->
    <div class="form-inline">
      <div class="input-group" data-widget="sidebar-search">
        <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
        <div class="input-group-append">
          <button class="btn btn-sidebar">
            <i class="fas fa-search fa-fw"></i>
          </button>
        </div>
      </div>
    </div>

    <!-- Sidebar Menu -->
    <nav class="mt-2">
      <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
        <!-- Add icons to the links using the .nav-icon class
             with font-awesome or any other icon font library -->
        <li class="nav-item menu-open">
          <a href="/admin/adminMain" class="nav-link">
            <i class="nav-icon fas fa-chart-pie"></i>
            <p>
              관리자페이지
              <i class="right fas fa-angle-left"></i>
            </p>
          </a>
          <ul class="nav nav-treeview">
            <li class="nav-item">
              <a href="/admin/adminTag" class="nav-link">
                <i class="nav-icon fas fa-copy"></i>
                <p>태그관리</p>
              </a>
            </li>
            <li class="nav-item">
              <a href="/admin/adminCategory" class="nav-link">
                <i class="nav-icon far fa-envelope"></i>
                <p>카테고리관리</p>
              </a>
            </li>
            <li class="nav-item">
              <a href="adminProduct" class="nav-link">
                <i class="nav-icon fas fa-columns"></i>
                <p>상품관리</p>
              </a>
            </li>
          </ul>
        </li>
        <li class="nav-item">
          <a href="/admin/admember" class="nav-link active">
            <i class="nav-icon fas fa-table"></i>
            <p>고객관리</p>
          </a>
        </li>
        <li class="nav-item">
          <a href="/admin/adcompany" class="nav-link">
            <i class="nav-icon fas fa-tree"></i>
            <p>업체관리</p>
          </a>
        </li>
        <li class="nav-item">
          <a href="/" class="nav-link">
            <i class="nav-icon fas fa-th"></i>
            <p>More..</p>
          </a>
        </li>
      </ul>
    </nav>
    <!-- /.sidebar-menu -->
  </div>
  <!-- /.sidebar -->
</aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">Genie 관리자 페이지</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="/admin/">Home</a></li>
              <li class="breadcrumb-item active">Main</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <div class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-lg-12">
            <div class="card card-primary card-outline">
              <div class="card-body">
                <h5 class="card-title">고객관리</h5>
                <p class="card-text">
                <div>
					<form method="get" action="/admin/admember" id="searchFrm">
						<select name="searchKey">
							<option value="genie_id">아이디</option>
							<option value="user_name">이름</option>
							<option value="user_tel">연락처</option>
							<option value="user_email">이메일</option>
						</select>
						
						<input type="text" name="searchWord" id="searchWord"/>
						<input type="submit" value="Search"/>
						
						</form>
					</div>
                  <table class="table">
                    <thead>
                      <tr>
                        <th>아이디</th>
                        <th>이름</th>
                        <th>연락처</th>
                        <th>이메일</th>
                        <th>가입일</th>
                        <th>관리</th>
                      </tr>
                    </thead>
                    <tbody>
                      <!-- 태그 반복 -->
                      <c:forEach var="vo" items="${admember }">
                      <tr>
					             	<td>${vo.genie_id}</td>
					            	<td>${vo.user_name}</td>
					             	<td>${vo.user_tel}</td>
                        <td>${vo.user_email}</td>
                        <td>${vo.sign_in_date}</td>
                        <td><a href="/admin/admemberPop?genie_id=${vo.genie_id}"><input type="button" value="관리"></a></td>
                      </tr>
                    </c:forEach> 
                    </tbody>
                  </table>
                  <div>
          <ul id="page">
						<c:if test="${pVO.nowPage<=1}">
							<li>prev</li>
						</c:if>
						<c:if test="${pVO.nowPage>1}">
							<li><a href="/admin/admember?nowPage=${pVO.nowPage-1}<c:if test='${pVO.searchWord!=null}'>&searchKey=${pVO.searchKey}&searchWord=${pVO.searchWord}</c:if>">prev</a></li>
						</c:if>
						<c:forEach var="p" begin="${pVO.startPage}" end="${pVO.startPage+pVO.onePageCount-1}">
							<c:if test="${p<=pVO.totalPage}">
								<li
									<c:if test="${p==pVO.nowPage}">
										style="background-color:#ddd; color:#fff;"
									</c:if>
								>
								<a href="/admin/admember?nowPage=${p}<c:if test='${pVO.searchWord!=null}'>&searchKey=${pVO.searchKey}&searchWord=${pVO.searchWord}</c:if>">${p}</a></li>
							</c:if>
						</c:forEach>
								
						<c:if test="${pVO.nowPage==pVO.totalPage}">
							<li>next</li>
						</c:if>
						<c:if test="${pVO.nowPage<pVO.totalPage}">
							<li><a href="/admin/admember?nowPage=${pVO.nowPage+1}<c:if test='${pVO.searchWord!=null}'>&searchKey=${pVO.searchKey}&searchWord=${pVO.searchWord}</c:if>">next</a></li>
						</c:if>
					</ul>
                  </div>
                <!-- </p>-->
              </div>
            </div><!-- /.card -->
          </div>
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
    <div class="p-3">
      <h5>Title</h5>
      <p>Sidebar content</p>
    </div>
  </aside>
  <!-- /.control-sidebar -->

  <!-- Main Footer -->
  <footer class="main-footer">
    <!-- To the right -->
    <div class="float-right d-none d-sm-inline">
      By Genie
    </div>
    <!-- Default to the left -->
    <strong>Copyright &copy; 2022 <a href="https://localhost:9070">genie</a>.</strong> All rights reserved.
  </footer>
</div>
<!-- ./wrapper -->

<!-- REQUIRED SCRIPTS -->

<!-- jQuery -->
<script src="plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="/js_css/dist/js/adminlte.min.js"></script>
