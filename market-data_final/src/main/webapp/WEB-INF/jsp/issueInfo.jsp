<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<style>

	@import url(http://fonts.googleapis.com/earlyaccess/notosanskr.css);
	
	body, table, div, p {font-family:'Noto Sans KR', serif;}
	
	.div-result {
	    padding: 40px 80px;
	    position: absolute;
	    top: 100px;
	    right: 0;
	    left: 0;
	    bottom: 100px;
	}
	.div-result p{
		font-size: 15pt;
		margin: 0;
	}
	.div-result-left {
	    top: 40px;
	    left: 80px;
	    bottom: 100px;
	    position: absolute;
	    width: 360px;
	    display: inline-block;
	}
	.div-result-right {
	    position: absolute;
	    display: inline-block;
	    left: 440px;
	    right: 80px;
	    padding-top: 4px;
	}
	.div-result-right .div-result-right-sub {
		height: 100px;
    	position: relative;
    	border-top: 1px solid #333;
	}
	.div-result-right .div-result-right-sub .div-label {
	    display: inline-block;
	    top: 0;
	    position: absolute;
	    width: 120px;
	}
	.div-result-right .div-result-right-sub .div-content {
		display: inline-block;
	    position: absolute;
	    top: 0;
	    left: 140px;
	    right: 0;
	}
	.div-result-right .div-result-right-sub ul {
		margin: 0;
	    padding-left: 15px;
	}
	.div-result-right .div-result-right-sub ul li {
		font-size: 15pt;
	}
	
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
		<div class="div-result">
			<div class="div-result-left">
				<p style="font-size: 20pt; font-weight:bold;">${masterInfo.isuKorAbbrv} (${masterInfo.isuSrtCd})</p>
			</div>
			<div class="div-result-right">
				<div class="div-result-right-sub">
					<div class="div-label">
						<p>회사 개요 </p>
					</div>
					<div class="div-content">
						<p>식품 유통업 </p>
					</div>
				</div>
				<div class="div-result-right-sub">
					<div class="div-label">
						<p>주요 사업 </p>
					</div>
					<div class="div-content">
						<p>가공유, 아이스크림</p>
					</div>
				</div>
				<div class="div-result-right-sub">
					<div class="div-label">
						<p>재무 분석 </p>
					</div>
					<div class="div-content">
						<p>PER : ${masterInfo.per}</p>
						<p>PBR : ${masterInfo.pbr}</p>
					</div>
				</div>
				<div class="div-result-right-sub">
					<div class="div-label">
						<p>추천 이유 </p>
					</div>
					<div class="div-content">
						<ul>
							<li>동사는 아이스크림 유통 업체로, 여름이 다가오기 전인 매년 5월 ~ 6월에 주가가  상승하는 경향이 있음.</li>
							<li>재무 분석 결과 동사의 1분기 영업이익은 전년대비 15% 증가하였으며, PER 10, PBR 10으로 재무구조가 건전함.</li>
						</ul>
					</div>
				</div>
				
			</div>
		</div>
		<footer><img class="logo" src="/images/logo_koscom.jpg" alt="Smiley face"></footer>
	</body>
</html>
