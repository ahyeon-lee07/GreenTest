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
	<div class="container">
		<!-- 페이지 타이틀 부분 -->
		<div class="d-flex justify-content-between mt-5">
			<div class="bd-highlight">
				<h4>회원정보 수정/탈퇴</h4>
			</div>
			<div class="bd-highlight">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb p-0 bg bg-transparent">
						<li class="breadcrumb-item"><a href="${contextPath }/main.do">홈</a></li>
						<li class="breadcrumb-item active" aria-current="page">회원정보 수정/탈퇴</li>
					</ol>
				</nav>
			</div>
		</div>

		<div class="row border-bottom py-2"></div>
		<div class="row mb-4">
			<div class="col-12">
				<form action="#">
					<div class="row border-bottom py-2">
						<div class="col p-0">
							<div class="d-flex bd-highlight">
								<label for="inputId" class="bd-highlight col-form-label pl-2"
									style="width: 140px;">아이디</label>
								<div class="flex-grow bd-highlight pr-2">
									<input type="text" class="form-control" id="inputId" placeholder="아이디" disabled>
								</div>
							</div>
						</div>
					</div>
					<div class="row border-bottom py-2">
						<div class="col p-0">
							<div class="d-flex bd-highlight">
								<label for="inputPassword"
									class="bd-highlight col-form-label pl-2" style="width: 140px;">비밀번호</label>
								<div class="flex-grow bd-highlight pr-2">
									<input type="password" class="form-control" id="Password">
								</div>
								<span id="idMsg"></span> (영문 대소문자/숫자/특수문자 중 2가지 이상 조합, 10자~16자)
							</div>
						</div>
					</div>
					<div class="row border-bottom py-2">
						<div class="col p-0">
							<div class="d-flex bd-highlight">
								<label for="inputPassword"
									class="bd-highlight col-form-label pl-2" style="width: 140px;">비밀번호 확인</label>
								<div class="flex-grow bd-highlight pr-2">
									<input type="password" class="form-control" id="Password">
								</div>
							</div>
						</div>
					</div>
					<div class="row border-bottom py-2">
						<div class="col p-0">
							<div class="d-flex bd-highlight">
								<label for="inputName" class="bd-highlight col-form-label pl-2"
									style="width: 140px;">이름</label>
								<div class="flex-grow bd-highlight pr-2">
									<input type="text" class="form-control" id="inputName">
								</div>
							</div>
						</div>
					</div>
					<div class="row border-bottom py-2">
						<div class="col p-0">
							<div class="d-flex bd-highlight">
								<label for="inputBirth" class="bd-highlight col-form-label pl-2"
									style="width: 140px;">생년월일</label>
								<div class="flex-grow bd-highlight pr-2">
									<input type="text" class="form-control" id="inputBirth">
								</div>
							</div>
						</div>
					</div>
					<div class="row border-bottom py-2">
						<div class="col p-0">
							<div class="d-flex bd-highlight">
								<label for="inputUser" class="bd-highlight col-form-label pl-2"
									style="width: 140px;">주소</label>
								<div class="flex-grow-1 bd-highlight flex-column pr-2">
									<div class="bd-highlight mb-2">
										<div class="d-flex flex-row bd-highlight">
											<div class="bd-highlight">
												<input type="text" class="form-control"
													id="sample6_postcode" placeholder="우편번호" readonly>
											</div>
											<div class="bd-highlight ml-2">

												<button type="button" onclick="sample6_execDaumPostcode()"
													class="btn btn-secondary btn-sm" style="font-size: .8rem">
													우편번호 찾기</button>
											</div>
										</div>
									</div>
									<div class="bd-highlight mb-2">
										<div class="d-flex flex-row bd-highlight">
											<div class="bd-highlight">
												<input type="text" class="form-control" id="sample6_address"
													placeholder="주소" style="width: 300px;" readonly>
											</div>
										</div>
									</div>

									<div class="bd-highlight mb-2">
										<div class="d-flex bd-highlight">
											<div class="d-flex flex-row">
												<input type="text" class="form-control"
													id="sample6_detailAddress" placeholder="상세주소">
												<div class="p-2"></div>
												<input type="text" class="form-control"
													id="sample6_extraAddress" placeholder="참고항목" readonly>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row border-bottom py-2">
						<div class="col p-0">
							<div class="d-flex bd-highlight">
								<label for="inputNumber" class="bd-highlight col-form-label pl-2"
									style="width: 140px;">휴대전화</label>
								<div class="flex-grow bd-highlight pr-2">
									<input type="text" class="form-control" id="inputNumber">
								</div>
							</div>
						</div>
					</div>
					<div class="row border-bottom py-2">
						<div class="col p-0">
							<div class="d-flex bd-highlight">
								<label for="inputEmail" class="bd-highlight col-form-label pl-2"
									style="width: 140px;">이메일</label>
								<div class="flex-grow-1 bd-highlight flex-column pr-2">
									<div class="flex-grow-1 bd-highlight pr-2">
										<div class="d-flex flex-row">
											<input type="email" class="form-control" id="inputEmail1"
												style="width: 150px;">
											<div class="p-2">@</div>
											<select id="inputEmail2" class="form-control"
												style="width: 140px;">
												<option value="none" selected>선택</option>
												<option value="네이버">naver.com</option>
												<option value="다음">hanmail.net</option>
												<option value="네이트">nate.com</option>
												<option value="구글">gmail.com</option>
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
			<div class="form-group">
				이메일 수신 여부 &nbsp;&nbsp;
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio"
						name="inlineRadioOptions" id="inlineRadio1" value="option1">
					<label class="form-check-label" for="inlineRadio1">수신동의</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio"
						name="inlineRadioOptions" id="inlineRadio2" value="option2">
					<label class="form-check-label" for="inlineRadio2">수신거부</label>
				</div>
			</div>
			</div>
			<br>
			
				<!-- Button trigger modal -->
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" class="btn btn-outline-success"
					data-toggle="modal" data-target="#modify">회원정보 수정</button>
				<!-- Modal -->
				<div class="modal fade" id="modify" tabindex="-1" role="dialog"
					aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalCenterTitle">입력하신
									정보로 수정하시겠습니까?</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								확인을 누르면 회원정보 수정이 완료됩니다.<br> 되돌아가려면 취소를 눌러주세요.
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-outline-success" onclick="complet_checkform()">확인</button>
								<button type="button" class="btn btn-outline-success"
									data-dismiss="modal">취소</button>
							</div>
						</div>
					</div>
				</div>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="#" class="btn btn-outline-success btn-sm active"
					role="button" aria-pressed="true"
					style="margin: auto; width: 100px;">취소</a>
				<!-- Button trigger modal -->
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" class="btn btn-outline-success"
					data-toggle="modal" data-target="#Withdrawal">회원 탈퇴</button>

				<!-- Modal -->
				<div class="modal fade" id="Withdrawal" tabindex="-1" role="dialog"
					aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalCenterTitle">
									보유한 포인트와 쿠폰이 사라집니다.<br>회원 탈퇴를 하시겠습니까?
								</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								확인을 누르면 회원 탈퇴가 완료됩니다.<br> 되돌아가려면 취소를 눌러주세요.
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-outline-success" onclick="delete_checkform()">확인</button>
								<button type="button" class="btn btn-outline-success"
									data-dismiss="modal">취소</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</main>

<!-- 우편번호 API -->
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function sample6_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var addr = ''; // 주소 변수
						var extraAddr = ''; // 참고항목 변수

						//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							addr = data.roadAddress;
						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							addr = data.jibunAddress;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
						if (data.userSelectedType === 'R') {
							// 법정동명이 있을 경우 추가한다. (법정리는 제외)
							// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
							if (data.bname !== ''
									&& /[동|로|가]$/g.test(data.bname)) {
								extraAddr += data.bname;
							}
							// 건물명이 있고, 공동주택일 경우 추가한다.
							if (data.buildingName !== ''
									&& data.apartment === 'Y') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
							if (extraAddr !== '') {
								extraAddr = ' (' + extraAddr + ')';
							}
							// 조합된 참고항목을 해당 필드에 넣는다.
							document.getElementById("sample6_extraAddress").value = extraAddr;

						} else {
							document.getElementById("sample6_extraAddress").value = '';
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('sample6_postcode').value = data.zonecode;
						document.getElementById("sample6_address").value = addr;
						// 커서를 상세주소 필드로 이동한다.
						document.getElementById("sample6_detailAddress")
								.focus();
					}
				}).open();
	}
</script>

<!-- 회원정보 수정 -->
<script type="text/javascript">
function complet_checkform() {
alert("회원정보 수정이 완료되었습니다!");
}
</script>

<!-- 회원 탈퇴 -->
<script type="text/javascript">
function delete_checkform() {
alert("회원 탈퇴하였습니다!");
}
</script>