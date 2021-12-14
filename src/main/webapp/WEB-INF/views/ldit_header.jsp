<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header>
	<nav>
		<ul>
			<li id="loginUser">${loginUser.stfName}(${loginUser.stfId }) 님 일하세요.</li>
			<li id="logout"><a href="logout.do" title="로그아웃"><i class="fas fa-sign-out-alt"></a></i></li>
			<li id="logo"><img src="./resources/image/logo.png"></li>
			<li id="setting"><i class="fas fa-cog"></i></li>
			<li id="bell"><i class="far fa-bell"></i></li>
			<li id="home"><a href="main"><i class="fas fa-home"></i></a></li>
		</ul>
	</nav>
</header>