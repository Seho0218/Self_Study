let cart = {
  totalCount: 0,
  totalPrice: 0,

  //체크한 장바구니 상품 비우기
  delCheckedItem: function () {
    //document.querySelectorAll("input[name=noList]:checked").forEach(function (item) {
    //item.parentElement.remove();
    //var cart_num= item.getAttribute('value');
    var cart_num = $("#multiChk").serialize();
    console.log(cart_num);
    $.ajax({
      url: "/delMultiCart",
      data: cart_num,
      success: function (result) {
        alert("제품이 삭제되었습니다.");
        location.reload();
      },
      error: function (e) {
        console.log(e.responseText);
      },
    });

    //전송 처리 결과가 성공이면
    this.reCalc();
    this.updateUI();
  },

  //재계산
  reCalc: function () {
    //console.log("count : 999999");
    this.totalCount = 0;
    this.totalPrice = 0;
    document.querySelectorAll(".cart_qty").forEach(function (item) {
      if (item.parentElement.parentElement.firstElementChild.checked == true) {
        //console.log(item.parentElement.parentElement.firstElementChild.checked==true);
        var count = parseInt(item.getAttribute("value"));
        this.totalCount += count;
        var price =
          item.parentElement.previousElementSibling.getAttribute("value");
        this.totalPrice += count * price;
      }
    }, this);
  },
  //화면 업데이트
  updateUI: function () {
    document.querySelector("#total").textContent =
      "총 상품가격 : " + this.totalPrice.formatNumber() + "원";
    let c_style = document.getElementById("total").style;
    c_style.border = "0px solid #fff";
  },
  //개별 수량 변경
  changePNum: function (pos) {
    var item = document.querySelector("input[id=cart_qty" + pos + "]");
    var cart_qty = parseInt(item.getAttribute("value"));
    var newval = event.target.classList.contains("up")
      ? cart_qty + 1
      : event.target.classList.contains("down")
      ? cart_qty - 1
      : event.target.value;

    if (parseInt(newval) < 1 || parseInt(newval) > 99) {
      return false;
    }

    item.setAttribute("value", newval);
    item.value = newval;
    //console.log("newval : " + newval);
    var price = item.parentElement.previousElementSibling.getAttribute("value");
    //console.log(price);
    item.parentElement.nextElementSibling.nextElementSibling.textContent =
      (newval * price).formatNumber() + "원";

    $.ajax({
      url: "/updateCart",
      type: "post",
      data: {
        cart_num: $("input[id=cart_qty" + pos + "]")
          .parent()
          .parent()
          .children()
          .val(),
        cart_qty: $("input[id=cart_qty" + pos + "]").val(),
      },
      success: function (result) {
        //console.log("");
      },
      error: function (e) {
        console.log(e.responseText);
      },
    });

    //전송 처리 결과가 성공이면
    this.reCalc();
    this.updateUI();
  },
  checkItem: function () {
    this.reCalc();
    this.updateUI();
  },
};

// 숫자 3자리 콤마찍기
Number.prototype.formatNumber = function () {
  if (this == 0) return 0;
  let regex = /(^[+-]?\d+)(\d{3})/;
  let nstr = this + "";
  while (regex.test(nstr)) nstr = nstr.replace(regex, "$1" + "," + "$2");
  return nstr;
};

$(function () {
  //리스트 전체 선택
  $("#allChk").click(function () {
    $(".cart-list input[type=checkbox]").prop(
      "checked",
      $("#allChk").prop("checked")
    );
    cart.checkItem();
  });
});

$(document).on("click", ".cart-list input[value=Del]", function () {
  var params = { cart_num: $(this).attr("cart_num") };

  $.ajax({
    url: "/delCart",
    data: params,
    success: function (result) {
      alert("제품이 삭제되었습니다.");
      location.reload();
    },
    error: function (e) {
      console.log(e.responseText);
    },
  });
});

window.onload = function () {
  $("#multiChk").submit(function () {
    const query = 'input[name="cartList"]:checked';

    if ($(query).length == "0") {
      alert("1개 이상의 상품을 선택해주세요");
      return false;
    }
    console.log("fdsfsfsfds");
    return true;
  });
};
