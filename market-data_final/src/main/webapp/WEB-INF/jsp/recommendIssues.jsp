<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<style>

	@import url(http://fonts.googleapis.com/earlyaccess/notosanskr.css);
	
	body, table, div, p {font-family:'Noto Sans KR', serif;}
	
	h1, p {
		color: #333333;
	}
	body {
		margin: 0;
	}
	body header {
		background: #ED6D1F; 
		height: 100px; 
		display: block;
	}
	body header h1 {
		color: #fff; 
		padding: 28px 80px;
	}
	body footer {
		background: #333333;
	    height: 100px;
	    position: absolute;
	    bottom: 0;
	    left: 0;
	    right: 0;
	}
	body footer .logo {
		height: 60px;
		width: 221px;
		position: absolute;
		right: 0;
		bottom: 100px;
	}
</style>

<html>
	<body>
		<header>
			<h1>L&I : 일상생활 종목 추천 시스템</h1>
		</header>
		<div style="padding: 40px 80px;">
			<p style="font-size:15pt;">${month}월 현재 매수하기 좋은 종목은 아래와 같습니다.</p>
			<p style="font-size:15pt;">종목을 클릭하시면 추천 이유를 볼 수 있습니다.</p>
			<div style="margin-top: 40px;">
			<c:forEach items="${recommendIssues}" var="issue">
					<button type="button" onclick="javascript:location.href='http://localhost:8080/issue?isuSrtCd=${issue.isuSrtCd}'" style="padding:10px 20px; margin-bottom:10px; margin-right:10px">${issue.isuKorNm}</button>
			</c:forEach>
			</div>
		</div>
		<footer><img class="logo" src="/images/logo_koscom.jpg" alt="Smiley face"></footer>
	</body>
</html>
