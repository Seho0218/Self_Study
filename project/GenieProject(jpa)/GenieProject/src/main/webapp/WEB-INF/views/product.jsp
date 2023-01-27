<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./inc/top.jspf"%>
<link rel="stylesheet" href="/js_css/css/product_style.css" type="text/css"/>
<style>
#product_order_list{
	text-align:right;
	margin:3vh 1vw;
}
#product_order_list button{
	border:none;
	background-color:#fafafa;
	font-size:1.1em;
}
</style>
<section class="product ">
    <div class="bubbles">
        <h1>${pvo.product_category}${pvo.product_tag}</h1>
        <c:if test="${pvo.product_category == null && pvo.product_tag == null }">
        	<h1></h1>
        </c:if>
    </div>
	
	<div id="product_order_list">
		<c:choose>
			<c:when test="${pvo.product_category == null && pvo.product_tag == null }">
	        	<p>
				<button type="button" onclick="location.href='/product/likelist'">지니 PICK</button>&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp
				<button type="button" onclick="location.href='/product/recentlist'">최신순</button>&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp
				<button type="button" onclick="location.href='/product/pricelist'">가격낮은순</button>&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp
				<button type="button" onclick="location.href='/product/pricelistdesc'">가격높은순</button> </p>
	        </c:when>
			<c:when test="${pvo.product_tag != null }">
				<p>
				<button type="button" onclick="location.href='/product_tag/${pvo.product_tag}/likelist'">지니 PICK</button>&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp
				<button type="button" onclick="location.href='/product_tag/${pvo.product_tag}/recentlist'">최신순</button>&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp
				<button type="button" onclick="location.href='/product_tag/${pvo.product_tag}/pricelist'">가격낮은순</button>&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp
				<button type="button" onclick="location.href='/product_tag/${pvo.product_tag}/pricelistdesc'">가격높은순</button> </p>
			</c:when>
			<c:otherwise>
			<p>
			<button type="button" onclick="location.href='/product/${pvo.product_category}/likelist'">지니 PICK</button>&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp
			<button type="button" onclick="location.href='/product/${pvo.product_category}/recentlist'">최신순</button>&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp
			<button type="button" onclick="location.href='/product/${pvo.product_category}/pricelist'">가격낮은순</button>&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp
			<button type="button" onclick="location.href='/product/${pvo.product_category}/pricelistdesc'">가격높은순</button> </p>
			</c:otherwise>
		</c:choose>
	</div>
	
    <div class="grid-container">
        <c:forEach var="pvo" items="${plist}">
        <div class="wrapper">
            <div class="product-list">
                <a class="product-title" href="/product_detail?product_id=${pvo.product_id}"><i class="fa-solid fa-magnifying-glass"></i></a>
                <div class="item">
                    <img src="${pvo.product_image1}">
                </div>
            </div>
            <ul>
                <li>${pvo.genie_id}</li>
                <li>${pvo.product_name}</li>
                <li><fmt:formatNumber value="${pvo.product_price}" pattern="#,###원"/></li>
            </ul>
        </div>
        </c:forEach>
    </div>
</section>
<script src="/js_css/js/product_js.js"></script>
