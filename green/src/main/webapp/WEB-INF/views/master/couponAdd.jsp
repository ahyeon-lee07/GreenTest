<!--아연3 상진4 규찬3-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!-- 메인 -->
<main class="mainH">
	<div class="container py-1">
		<!-- 페이지 타이틀 부분 -->
		<div class="d-flex justify-content-between mt-5">
			<div class="bd-highlight">
				<h4 class="page_title">쿠폰등록</h4>
			</div>
			<div class="bd-highlight page_subtitle">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb p-0 bg bg-transparent">
						<li class="breadcrumb-item"><a href="${contextPath }/main.do">홈</a></li>
						<li class="breadcrumb-item active" aria-current="page">쿠폰등록</li>
					</ol>
				</nav>
			</div>
		</div>
		<div class="bd-highlight" style="text-align: right;">
			<img src="${contextPath }/resources/img/require.png"> <span
				class="">필수입력사항</span>
		</div>
		<div class="row border-bottom pm-2"></div>
		<div class="row mb-4">
			<div class="col-12">
				<form name="memberEdit" method="POST">
				<div class="row border-bottom py-2">
							<div class="col p-0">
								<div class="d-flex bd-highlight">
									<label for="inputUseYN" class="bd-highlight col-form-label pl-2" style="width: 140px;">사용여부</label>
									<div class="d-flex flex-row bd-highlight pr-2">
										<div class="custom-control custom-switch pt-2">
											<input type="checkbox" class="custom-control-input YNChk" id="inputUseYN" value="Y" checked>
											<input id="useYN_V" class="input_V" type="text" name="useYN" value="Y" style="display: none;">
											<label id="inputUseYNLabel" class="custom-control-label" for="inputUseYN" style="width: 70px;">활성화</label>
										</div>
									</div>
								</div>
							</div>
						</div>
					<div class="row border-bottom py-2">
						<div class="col p-0">
							<div class="d-flex bd-highlight">
								<label for="inputMasterYN" class="bd-highlight col-form-label pl-2" style="width: 140px;">쿠폰 사용기간</label>
								<div class="d-flex flex-row bd-highlight pr-2">
									<input id="couponPeroid_start" class="mr-2 form-control" type='date' name='couponPeroid_start' value=''/> ~
									<input id="couponPeroid_end" class="ml-2 form-control"  type='date' name='couponPeroid_end' value=''/>
								</div>
							</div>
						</div>
					</div>
					<div class="row border-bottom py-2">
						<div class="col p-0">
							<div class="d-flex bd-highlight">
								<label for="inputCouponName" class="bd-highlight col-form-label pl-2" style="width: 140px;"><img src="${contextPath }/resources/img/require.png">쿠폰명</label>
								<div class="d-flex flex-row bd-highlight pr-2">
									<input type="text" class="form-control" id="inputCouponName" name="couponName" value="">
								</div>
							</div>
						</div>
					</div>
					<div class="row border-bottom py-2">
						<div class="col p-0">
							<div class="d-flex bd-highlight">
								<label for="inputCouponContent" class="bd-highlight col-form-label pl-2" style="width: 140px;">쿠폰혜택</label>
								<div class="d-flex flex-row bd-highlight pr-2">
									<input type="text" class="form-control" id="inputCouponContent" name="couponContent" value="">
								</div>
							</div>
						</div>
					</div>
					<div class="row border-bottom py-2">
						<div class="col p-0">
							<div class="d-flex bd-highlight">
								<label for="inputCouponPay" class="bd-highlight col-form-label pl-2" style="width: 140px;"><img src="${contextPath }/resources/img/require.png">쿠폰 할인금액</label>
								<div class="d-flex flex-row bd-highlight pr-2">
									<select id="inputState" class="form-control mr-2" name="discountType" style="width: 98px;">
										<option value="discountType" selected>가격</option>
										<option value="percent" >퍼센트</option>
									</select>
									<input type="number" class="form-control" id="inputCouponPay" name="couponPay" value="">
									
								</div>
							</div>
						</div>
					</div>
					 
					<!-- Button trigger modal -->
					<div class="row py-2 mt-3">
						<div class="d-flex flex-fill justify-content-between">
							<div class="bd-highlight">
								<a href="${contextPath }/memberList.do${pageMaker.makeQueryPage(bList.IDX, pageMaker.cri.page) }&options=${options }"><button type="button"
										class="btn btn-outline-secondary">취소</button></a>
							</div>
							<div class="d-highlight">
								
								<button id="btn_memberEdit" type="button"
									class="btn btn-success ml-2">쿠폰등록</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</main>
<script>

	// 활성화 여부
	var showYN = document.getElementById('inputUseYN');
	showYN.addEventListener('click', function () {
		var showYN_V = showYN.value;
		var Label = document.getElementById('inputUseYNLabel');
		var V = document.getElementById('useYN_V');

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

</script>

