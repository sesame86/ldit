<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header>
	<nav>
		<ul>
			<li id="loginUser">${loginUser.stfName}(${loginUser.stfNo})</li>
			<li id="logout"><a href="logout.do" title="로그아웃"><i class="fas fa-sign-out-alt"></a></i></li>
			<li id="logo"><a href="main"><img src="./resources/image/logo.png"></a></li>
			<li id="setting"><a href="eupdate" title="개인 정보 수정"><i class="fas fa-cog"></a></i></li>
			<li id="bell"><i class="far fa-bell"></i></li>
			<li id="home"><a href="main"><i class="fas fa-home"></i></a></li>
		</ul>
	</nav>
</header>