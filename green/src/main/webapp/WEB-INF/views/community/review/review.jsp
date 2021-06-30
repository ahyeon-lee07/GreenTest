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
				<h4>리뷰</h4>
			</div>
			<div class="bd-highlight">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb p-0 bg bg-transparent">
						<li class="breadcrumb-item"><a href="${contextPath }/main.do">홈</a></li>
						<li class="breadcrumb-item active" aria-current="page">리뷰</li>
					</ol>
				</nav>
			</div>
		</div>

<table class="table table-hover">
            <thead class="table-primary border-bottom-0">
                <tr>
                    <th class="text-center border-bottom-0" style="width: 68px">번호</th>
                    <th class="text-center border-bottom-0" style="width: 140px">상품정보</th>
                    <th class="text-center border-bottom-0" style="width: auto">제목</th>
                    <th class="text-center border-bottom-0" style="width: 100px">작성자</th>
                    <th class="text-center border-bottom-0" style="width: 116px">작성일</th>
                    <th class="text-center border-bottom-0" style="width: 100px">조회수</th>
                </tr>
            </thead>
            <tbody>
                <tr class="border-bottom ">
                    <th class="text-center align-middle">1</th>
                    <td class="text-center align-middle"><img src="${contextPath }/resources/img/케이스이미지.PNG"
                            class="img-thumbnail" alt="#"></td>
                    <td class="text-center align-middle">Otto</td>
                    <td class="text-center align-middle">관리자</td>
                    <td class="text-center align-middle">2020-00-00</td>
                    <td class="text-center align-middle">70</td>
                </tr>
            </tbody>
        </table>

        <div class="row justify-content-between px-4">
            <div class="">
                <div class="btn-group">
                    <form action="#">
                        <div class="form-row">
                            <div class="form-group d-flex justify-content-start ">
                                <select id="inputState" class="form-control form-control-sm" style="width: 90px;">
                                    <option selected>제목</option>
                                    <option selected>내용</option>
                                    <option selected>글쓰기</option>
                                </select>
                                <input class="form-control form-control-sm mx-2" type="text" placeholder="">
                                <button type="submit" class="btn btn-secondary btn-sm col-2">검색</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            
        </div>

        <nav aria-label="Page navigation example row">
            <ul class="pagination d-flex justify-content-center">
              <li class="page-item">
                <a class="page-link" href="#" aria-label="Previous">
                  <span aria-hidden="true">&laquo;</span>
                </a>
              </li>
              <li class="page-item"><a class="page-link" href="#">1</a></li>
              <li class="page-item"><a class="page-link" href="#">2</a></li>
              <li class="page-item"><a class="page-link" href="#">3</a></li>
              <li class="page-item">
                <a class="page-link" href="#" aria-label="Next">
                  <span aria-hidden="true">&raquo;</span>
                </a>
              </li>
            </ul>
          </nav>

	</div>
</main>