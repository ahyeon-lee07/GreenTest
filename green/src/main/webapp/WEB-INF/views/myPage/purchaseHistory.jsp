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
				<h4>구매내역조회</h4>
			</div>
			<div class="bd-highlight">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb p-0 bg bg-transparent">
						<li class="breadcrumb-item"><a href="${contextPath }/main.do">홈</a></li>
						<li class="breadcrumb-item active" aria-current="page">구매내역조회</li>
					</ol>
				</nav>
			</div>
		</div>

        <div class="row">
            <div class="col-md-2">
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton"
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        주문처리상태
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="#">입금전</a>
                        <a class="dropdown-item" href="#">상품준비중</a>
                        <a class="dropdown-item" href="#">배송중</a>
                        <a class="dropdown-item" href="#">배송완료</a>
                    </div>
                </div>
            </div>
            <div class="col-md-5">
                <button type="button" class="btn btn-secondary btn-sm">오늘</button>
                <button type="button" class="btn btn-secondary btn-sm">일주일</button>
                <button type="button" class="btn btn-secondary btn-sm">1개월</button>
                <button type="button" class="btn btn-secondary btn-sm">3개월</button>
                <button type="button" class="btn btn-secondary btn-sm">6개월</button>
            </div>
            <div class="col-md-5">
                <input type="date">~<input type="date">
                <a href="#" class="btn btn-secondary">조회</a>
            </div>
        </div>
        <br>
        <br>
        <div>
            <h5><strong>주문 상품 정보</strong></h5>
            <table style="width:1100px; height:200px; text-align: center;">
            
                <tr>
                    <th>주문번호</th>
                    <th>이미지</th>
                    <th>상품정보</th>
                    <th>수량</th>
                    <th>구매금액</th>
                    <th>주문처리상태</th>
                    <th>취소/교환/반품</th>
                </tr>
              
                <tr class="border-top"> 
                    <td>
                        12345678
                        <div>
                            <button type="button" class="btn btn-secondary btn-sm">취소</button>
                            <button type="button" class="btn btn-secondary btn-sm">반품</button>
                            <button type="button" class="btn btn-secondary btn-sm">교환</button>
                        </div>
                    </td>
                    <td>
                        <img style="width:150px; height:150px" src="${contextPath}/resources/img/케이스이미지.PNG" alt="..." />
                    </td>
                    <td>
                        귤곰 케이스
                    </td>
                    <td>
                        1
                    </td>
                    <td>
                        10000원
                    </td>
                    <td>
                        배송준비중
                    </td>
                    <td>
                        -
                    </td>
                </tr>
            </table>
        </div>
    </div>


	</div>
</main>