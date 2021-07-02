<!--상진8 규찬2-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
    <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                <% request.setCharacterEncoding("UTF-8"); %>
                    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
                    <!-- 메인 -->
                    <main class="mainH">
                        <div class="container">
                            <!-- 페이지 타이틀 부분 -->
                            <div class="d-flex justify-content-between mt-5">
                                <div class="bd-highlight">
                                    <h4 class="page_title">상품등록</h4>
                                </div>
                                <div class="bd-highlight page_subtitle">
                                    <nav aria-label="breadcrumb">
                                        <ol class="breadcrumb p-0 bg bg-transparent">
                                            <li class="breadcrumb-item"><a href="${contextPath }/main.do">홈</a></li>
                                            <li class="breadcrumb-item active" aria-current="page">상품등록</li>
                                        </ol>
                                    </nav>
                                </div>
                            </div>

                            <form action="#" name="loginForm" method="GET">

                            </form>
                        </div>
                    </main>