<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  <title>Genie Seller</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Theme style -->
  <link rel="stylesheet" href="/js_css/dist/css/adminlte.min.css">
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="/js_css/fontawesome-free/css/all.min.css">

<body class="hold-transition sidebar-mini">
<div class="wrapper">

  <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <!-- <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a> -->
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="/" class="nav-link" >Genie Home</a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="/seller/sellerMain" class="nav-link">Seller Home</a>
      </li>
    </ul>

    <!-- Right navbar links -->
    <ul class="navbar-nav ml-auto">
      <li class="nav-item">
        <a class="nav-link" data-widget="fullscreen" href="#" role="button">
          <i class="fas fa-expand-arrows-alt"></i>
        </a>
      </li>
    </ul>
  </nav>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4" style="background-color: #4846F5 !important;"> <!-- blueviolet -->
    <!-- Brand Logo -->
    <a href="/seller/sellerMain" class="brand-link">
      <img src="/js_css/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text" style="color: white;">지니셀러센터</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="info">
          <a href="#" class="d-block"><b>${logName }님</b> 환영합니다!</a>
        </div>
      </div>
  
      <!-- Sidebar Menu -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item">
            <a href="/seller/sellerMain" class="nav-link">
              <i class="nav-icon fas fa-chart-pie"></i>
              <p>대시보드</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="/seller/productForm" class="nav-link">
              <i class="nav-icon fas fa-copy"></i>
              <p>상품등록</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="/seller/sellerProduct" class="nav-link">
              <i class="nav-icon far fa-envelope"></i>
              <p>상품관리</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="/seller/sellerOrder" class="nav-link">
              <i class="nav-icon fas fa-columns"></i>
              <p>주문관리</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="/seller/sellerSales" class="nav-link">
              <i class="nav-icon fas fa-table"></i>
              <p>매출관리</p>
            </a>
          </li>
        </ul>
      </nav>
 
      <script>
        $(function(){
          var url = window.location;
          $('.mt-2 a').filter(function(){
            return this.href == url ;
          }).addClass('active');
        });
      </script>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>