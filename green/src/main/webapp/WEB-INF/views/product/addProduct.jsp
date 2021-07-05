<!--상진8 규찬2-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
    <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                <% request.setCharacterEncoding("UTF-8"); %>
                    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
                    <!-- 메인 -->
                    <!-- 메인 -->
                    <main class="mainH">
                        <div class="container">
                            <!-- 페이지 타이틀 부분 -->
                            <div class="d-flex justify-content-between mt-5">
                                <div class="bd-highlight">
                                    <h4 class="page_title">상품등록</h4>
                                </div>
                            </div>
                            <div class="bd-highlight" style="text-align: right;">
                                <img src="${contextPath }/resources/img/require.png">
                                <span class="">필수입력사항</span>
                            </div>
                            <form action="${contextPath }/product/addEdit.do" method="POST" name="addProduct">
                                <div class="row border-bottom pm-2"></div>
                                <div class="row mb-4">
                                    <div class="col-12">
                                        <form name="joinForm" method="POST">
                                            <div class="row border-bottom py-2">
                                                <div class="col p-0">
                                                    <div class="d-flex bd-highlight">
                                                        <label for="inputShowYN"
                                                            class="bd-highlight col-form-label pl-2"
                                                            style="width: 140px;">활성화 여부</label>
                                                        <div class="d-flex flex-row bd-highlight pr-2">
                                                            <div class="custom-control custom-switch pt-2">
                                                                <input type="checkbox"
                                                                    class="custom-control-input YNChk" id="inputShowYN"
                                                                    value="Y" checked>
                                                                <input id="showYN_V" class="input_V" type="text"
                                                                    name="showYN" value="Y" style="display: none;">
                                                                <label id="inputShowYNLabel"
                                                                    class="custom-control-label" for="inputShowYN"
                                                                    style="width: 70px;">활성화</label>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row border-bottom py-2">
                                                <div class="col p-0">
                                                    <div class="d-flex bd-highlight">
                                                        <label for="inputGroup" class="bd-highlight col-form-label pl-2"
                                                            style="width: 140px;">
                                                            상품 구분
                                                        </label>
                                                        <div class="flex-grow bd-highlight flex-column pr-2">
                                                            <div class="flex-grow-1 bd-highlight pr-2">
                                                                <div class="d-flex">
                                                                    <select id="inputGroup" class="form-control "
                                                                        name="p_group">
                                                                        <option value="hard" selected>하드케이스</option>
                                                                        <option value="gel">젤케이스</option>
                                                                        <option value="card">카드케이스</option>
                                                                        <option value="airPods">에어팟케이스</option>
                                                                        <option value="buds">버즈케이스</option>
                                                                        <option value="keyring">키링</option>
                                                                        <option value="smart">스마트톡</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row border-bottom py-2">
                                                <div class="col p-0">
                                                    <div class="d-flex bd-highlight">
                                                        <label for="inputProductName"
                                                            class="bd-highlight col-form-label pl-2"
                                                            style="width: 140px;"><img
                                                                src="${contextPath }/resources/img/require.png">상품명</label>
                                                        <div class="flex-grow-1 bd-highlight pr-2">
                                                            <input type="text" class="form-control"
                                                                id="inputProductName" name="productName">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row border-bottom py-2">
                                                <div class="col p-0">
                                                    <div class="d-flex bd-highlight">
                                                        <label for="inputProductOption"
                                                            class="bd-highlight col-form-label pl-2"
                                                            style="width: 140px;"><img
                                                                src="${contextPath }/resources/img/require.png">상품
                                                            옵션</label>
                                                        <div class="flex-grow bd-highlight pr-2 flex-column">
                                                            <button id="btn_addOption" type="button"
                                                                class="btn btn-secondary"
                                                                style="font-size:.8rem; height:38px;">
                                                                옵션 추가</button>
                                                            <div id="optionList"
                                                                class="d-flex bd-highlight flex-column ">
                                                                <!-- <div class="d-flex flex-row bd-highlight mt-2">
                                                <div class="d-flex bd-highlight pr-2"><span
                                                        class="bd-highlight pt-2">1.</span></div>
                                                <div class="bd-highlight pr-2" style="width: 450px;">
                                                    <input type="text" class="form-control" id="inputOption"
                                                        name="option">
                                                </div>
                                                <div class="d-flex flex-row bd-highlight pr-2">
                                                    <span class="bd-highlight pr-1 pt-2">재고수량:</span><input
                                                        type="number" class="form-control" id="inputStock" name="stock"
                                                        min="0" style="width: 80px;">
                                                </div>
                                                <div class="bd-highlight">
                                                    <button id="btn_addOption" type="button"
                                                        class="btn btn-outline-danger"
                                                        style="font-size:.8rem; height:38px;">
                                                        삭제</button>
                                                </div>
                                            </div> -->

                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row border-bottom py-2">
                                                <div class="col p-0">
                                                    <div class="d-flex bd-highlight">
                                                        <label for="inputPrice" class="bd-highlight col-form-label pl-2"
                                                            style="width: 140px;"><img
                                                                src="${contextPath }/resources/img/require.png">판매가</label>
                                                        <div class="d-flex flex-row bd-highlight pr-2">
                                                            <input type="number" class="form-control" id="inputPrice"
                                                                name="price" min="0">
                                                            <span class="bd-highlight pl-2 pt-2">원</span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row border-bottom py-2">
                                                <div class="col p-0">
                                                    <div class="d-flex bd-highlight">
                                                        <label for="inputDiscountYN"
                                                            class="bd-highlight col-form-label pl-2"
                                                            style="width: 140px;">할인 여부</label>
                                                        <div class="d-flex flex-row bd-highlight pr-2">
                                                            <div class="custom-control custom-switch pt-2">
                                                                <input type="checkbox"
                                                                    class="custom-control-input YNChk"
                                                                    id="inputDiscountYN" value="N">
                                                                <input id="discountYN_V" class="input_V" type="text"
                                                                    name="discountYN" value="N" style="display: none;">
                                                                <label id="discountYNLabel" class="custom-control-label"
                                                                    for="inputDiscountYN"
                                                                    style="width: 50px;">미할인</label>
                                                            </div>
                                                            <div class="d-flex flex-row bd-highlight pl-3 pr-2">
                                                                <input type="number" class="form-control"
                                                                    id="discountYN_Num" min="0" max="100"
                                                                    style="width: 102px;" disabled> <span
                                                                    class="bd-highlight pl-2 pt-2">%</span>
                                                            </div>
                                                            <div id="discountBox" class="d-flex flex-row bd-highlight "
                                                                style="visibility: hidden;">
                                                                <span class="bd-highlight pt-2 ml-3 text-danger"> 할인가 :
                                                                </span>
                                                                <input type="text"
                                                                    class="form-control text-danger bg-white border-0 pl-1"
                                                                    id="discount" name="discount"
                                                                    style="width: 70px; text-align: right;" value=""
                                                                    readonly>
                                                                <span class="bd-highlight pt-2 text-danger"> 원</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row border-bottom py-2">
                                                <div class="col p-0">
                                                    <div class="d-flex bd-highlight">
                                                        <label for="inputProductMileage"
                                                            class="bd-highlight col-form-label pl-2"
                                                            style="width: 140px;"><img src="${contextPath }/resources/img/require.png">상품적립금</label>
                                                        <div class="d-flex flex-row bd-highlight pr-2">
                                                            <input type="number" class="form-control"
                                                                id="inputProductMileage" name="productMileage" min="0" value="0">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row border-bottom py-2">
                                                <div class="col p-0">
                                                    <div class="d-flex bd-highlight">
                                                        <label for="inputImgURL_product_M"
                                                            class="bd-highlight col-form-label pl-2"
                                                            style="width: 140px;"><img
                                                                src="${contextPath }/resources/img/require.png">상품이미지</label>
                                                        <div class="d-flex flex-row bd-highlight pr-2 pt-1">
                                                            <input type="file" class="form-control-file"
                                                                id="inputImgURL_product_M" name="imgURL_product_M">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row border-bottom py-2">
                                                <div class="col p-0">
                                                    <div class="d-flex bd-highlight">
                                                        <label for="inputImgURL_product_S"
                                                            class="bd-highlight col-form-label pl-2"
                                                            style="width: 140px;"><img
                                                                src="${contextPath }/resources/img/require.png">상품상세이미지</label>
                                                        <div class="d-flex flex-row bd-highlight pr-2 pt-1">
                                                            <input type="file" class="form-control-file"
                                                                id="inputImgURL_product_S" name="imgURL_product_S">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Button trigger modal -->
                                            <div class="text-center mt-3">
                                                <button type="submit" class="btn btn-success"
                                                    onclick="return checkLogin()">등록</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </main>

                    <script>

                        //스위치 YN 체크
                        window.onload = function () {
                            var YNChk = document.getElementsByClassName('YNChk');
                            var input_V = document.getElementsByClassName('input_V');

                            for (var i = 0; i <= YNChk.length; i++) {
                                var Chk = YNChk[i];
                                var IV = input_V[i];

                                if (YNChk.value == "Y") {
                                    YNChk.value = "Y"
                                    IV.value = "Y"
                                } else {
                                    YNChk.value = "N"
                                    YNChk.value = "N"
                                }
                            }
                        };

                        // 활성화 여부
                        var showYN = document.getElementById('inputShowYN');
                        showYN.addEventListener('click', function () {
                            var showYN_V = showYN.value;
                            var Label = document.getElementById('inputShowYNLabel');
                            var V = document.getElementById('showYN_V');

                            if (showYN_V != "N") {
                                showYN.value = "N";
                                V.value = "N";
                                Label.innerHTML = "비활성화";
                            } else {
                                showYN.value = "Y";
                                V.value = "Y";
                                Label.innerHTML = "활성화";
                            }
                        });

                        // 할인 여부
                        var discountYN = document.getElementById('inputDiscountYN');
                        discountYN.addEventListener('click', function () {
                            var discountYN_V = discountYN.value;
                            var Label = document.getElementById('discountYNLabel');
                            var Num = document.getElementById('discountYN_Num');
                            var V = document.getElementById('discountYN_V');

                            if (discountYN_V != "N") {
                                discountYN.value = "N";
                                V.value = "N";
                                Label.innerHTML = "미할인";
                                Num.value = "";
                                document.getElementById('discount').value = "";
                                document.getElementById('discountBox').style.visibility = 'hidden';
                                Num.disabled = true;
                            } else {
                                discountYN.value = "Y";
                                V.value = "Y";
                                Label.innerHTML = "할인";
                                Num.value = "0";
                                Num.disabled = false;


                            }
                        });

                        //할인가 표시
                        document.getElementById('discountYN_Num').addEventListener('input', function () {

                            var price = document.getElementById('inputPrice').value;
                            var discountP = document.getElementById('discountYN_Num').value;
                            var discountPrice = price * (discountP / 100);

                            var discount = Math.floor(price - discountPrice);
                            // document.getElementById('discount').value = "할인가: " + discount + " 원";
                            document.getElementById('discountBox').style.visibility = '';
                            document.getElementById('discount').value = discount;
                        });

                        //옵션 버튼
                        var addOption = document.getElementById('btn_addOption');
                        var count = 0;
                        addOption.addEventListener('click', function () {
                            var List = document.getElementById('optionList');
                            var plusUl = document.createElement('dir');
                            var str = "";

                            plusUl.id = "O_" + count;
                            plusUl.setAttribute('class', 'd-flex flex-row bd-highlight mt-2 p-0 mb-0');

                            str += '<div class="d-flex bd-highlight pr-2"  style="width: 30px;"><span class="listNum bd-highlight pt-2"></span></div>';
                            str += '<div class="bd-highlight pr-2" style="width: 450px;"><input type="text" class="form-control" id="inputOption" name="option"></div>';
                            str += '<div class="d-flex flex-row bd-highlight pr-2"><span class="bd-highlight pr-1 pt-2">재고수량:</span><input type="number" class="form-control" id="inputStock" name="stock" min="0" style="width: 80px;"></div>';
                            str += '<div class="bd-highlight"><button id="btn_OptionDel" type="button" class="btn btn-outline-danger" onclick="optionDel_click(' + count + ');" style="font-size:.8rem; height:38px;">삭제</button></div>';

                            plusUl.innerHTML = str;
                            count++;
                            List.appendChild(plusUl);

                            //옵션 리스트 숫자
                            listNumbering();
                        });

                        //옵션 삭제
                        function optionDel_click(n) {
                            document.getElementById('O_' + n).remove();
                            listNumbering();
                        };

                        //옵션 리스트 숫자
                        function listNumbering() {
                            var listBox = document.getElementsByClassName('listNum');

                            for (var i = 0; i < listBox.length; i++) {
                                document.getElementsByClassName('listNum')[i].innerHTML = (i + 1) + '. ';
                            }
                        }

                        //전송 체크
                        function checkLogin() {
                            var form = document.addProduct;
                            //상품 옵션. 이미지 필수 체크 추가 되어야 함.  
                            if (form.productName.value == "") {
                                alert("상품명을 입력해 주세요.");
                                return false;

                            }else if (form.price.value == "") {
                                alert("판매가를 입력해 주세요.");
                                return false;
                            }else if (form.discountYN.value == "N") {
                                form.discountYN.value = "N";
                                form.discount.value = 0;
                            }else if (form.productMileage.value == "") {
                                alert("상품적립금을 입력해 주세요.");
                                return false;
                            }else if (form.productMileage.value == "") {
                                form.productMileage.value = 0;
                            }
                            else {
                                form.submit();
                            }
                        }
                    </script>