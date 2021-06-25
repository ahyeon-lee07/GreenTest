<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!doctype html>
<html lang="ko">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
	
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>


<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<!-- 그린 스타일 -->
<link rel="stylesheet"
	href="${contextPath }/resources/css/greenStyle.css">

<link rel="stylesheet" href="${contextPath }/resources/css/chan.css">
<link rel="stylesheet" href="${contextPath }/resources/css/yeon.css">
<link rel="stylesheet" href="${contextPath }/resources/css/jin.css">
<link rel="stylesheet" href="${contextPath }/resources/css/won.css">

<title><tiles:insertAttribute name="title" /></title>
</head>

<body>

	<!-- 헤더 -->
	<tiles:insertAttribute name="header" />
	<!-- 메인 -->
	<tiles:insertAttribute name="main" />

	<!-- 푸터 -->
	<tiles:insertAttribute name="footer" />


	<!-- Optional JavaScript -->

	<script src="${contextPath }/resources/js/greenJs.js"></script>

	<script src="${contextPath }/resources/js/chan.js"></script>
	<script src="${contextPath }/resources/js/yeon.js"></script>
	<script src="${contextPath }/resources/js/jin.js"></script>
	<script src="${contextPath }/resources/js/won.js"></script>
</body>

</html>