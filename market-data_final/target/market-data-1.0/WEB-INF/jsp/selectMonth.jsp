<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<style>

	@import url(http://fonts.googleapis.com/earlyaccess/notosanskr.css);
	
	body, table, div, p {font-family:'Noto Sans KR', serif;}
	
	.div-form{
		height:40px;
	}
	.div-form label {
		width: 120px;
    	display: inline-block;
	}
	.div-form input[type=text] {
		height: 26px;
		width: 300px;
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
		<div style="padding: 40px 80px;">
			<p style="font-size: 15pt;">아래 정보를 입력하면, 보다 적합한 종목을 추천할 수 있습니다.</p>
			
			<form action="/list" id="monthform" style="margin-top:50px;">
				<div class="div-form">
			        <label for="sex">성별</label>
			        <input type="text" id="sex" value="여"/>
			    </div>
			    <div class="div-form">
			        <label for="age">나이</label>
			        <input type="text" id="age" value="29"/>
			    </div>
			    <div class="div-form">
			        <label for="job">직종</label>
			        <input type="text" id="job" value="요식업"></input>
			    </div>
			    <div class="div-form">
			        <label for="interest">관심분야</label>
			        <input type="text" id="interest" value="디저트"></input>
			    </div>
			    <div class="div-form" style="margin-top: 20px;">
			    	 <label for="">월 선택</label>
			    	<select name="month" form="monthform" style="height:30px; width:220px;">
					  <option value="1">1월</option>
					  <option value="2">2월</option>
					  <option value="3">3월</option>
					  <option value="4">4월</option>
					  <option value="5">5월</option>
					  <option value="6">6월</option>
					  <option value="7">7월</option>
					  <option value="8">8월</option>
					  <option value="9">9월</option>
					  <option value="10">10월</option>
					  <option value="11">11월</option>
					  <option value="12">12월</option>
					</select>
					<input type="submit" value="검색" style="height:30px; margin-left: 30px;">
			    </div>
			</form>
		</div>
		<div style="padding-left: 80px; padding-top: 180px;">
		    <div class="div-form">
		    	<label for="count">종목 수</label>
		    	<input form="monthform" type="text" id="count" name="count" value="60"></input>
		    </div>
		    <div class="div-form">
		    	<label for="diff">재무 기준</label>
		    	<input form="monthform" type="text" id="diff" name="diff" value="15"></input>
		    </div>
		</div>
		<footer><img class="logo" src="/images/logo_koscom.jpg" alt="Smiley face"></footer>
	</body>
	</html>
