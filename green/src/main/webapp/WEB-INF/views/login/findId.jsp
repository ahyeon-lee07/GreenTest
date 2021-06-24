<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
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
				<h4>아이디 찾기</h4>
			</div>
			<div class="bd-highlight page_subtitle">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb p-0 bg bg-transparent">
						<li class="breadcrumb-item"><a href="${contextPath }/main.do">홈</a></li>
						<li class="breadcrumb-item"><a href="${contextPath }/login.do">로그인</a></li>
						<li class="breadcrumb-item"><a href="${contextPath }/member.do">기존회원 로그인</a></li>
						<li class="breadcrumb-item active" aria-current="page">아이디 찾기</li>
					</ol>
				</nav>
			</div>
		</div>

		<form action="#" name="loginForm" method="POST">
            <div class="d-flex justify-content-center mt-5">
                <div class="bd-highlight rounded border" style="width: 480px; height: 185px;">
                    <div class="d-flex flex-row bd-highlight py-3 px-5"  >
                        <div class="bd-highlight mt-4">
                            <div class="bd-highlight d-flex flex-column">
                                <div class="bd-highlight d-flex flex-row">
                                    <label for="inputName" class="bd-highlight col-form-label font-weight-bold" style="width: 90px;">이름</label>
                                    <div class="placeholderText">
                                        <input id="inputName" class="form-control" name="name" type="text">
                                    </div>
                                </div>
                                <div class="bd-highlight d-flex flex-row mt-3 mt-4 mb-2">
                                    <label for="inputEmail" class="bd-highlight col-form-label font-weight-bold" style="width: 90px;">이메일</label>
                                    <div>
                                        <input id="inputEmail" class="form-control" name="email" type="text">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="bd-highlight d-flex align-items-stretch ml-3 mt-4 mb-2">
                            <div class="bd-highlight d-flex align-items-stretch ">
                                <input type="button" class="btn btn-success btn-lg btn-block font-weight-bold" value="확인" onclick="checkLogin()">
                            </div>
                        </div>
                    </div>
   		</form>
	</div>
</main>

<!-- 유효성 검사 -->
<script type="text/javascript">
	function checkLogin() {
		var form = document.loginForm;
		if (form.name.value == "") {
			alert("이름을 입력해주세요!");
			form.name.focus();
			return false;
		}
		else if (form.email.value == "") {
			alert("이메일을 입력해주세요!");
			form.email.focus();
			return false;
		}
		form.submit();
	}
</script>