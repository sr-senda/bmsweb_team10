<%@page contentType="text/html; charset=UTF-8"%>

<header>

	<div class="topHeader">
		<div class="topHeaderContent">
			<a class="logoLink" href="/list"><img src="<%= request.getContextPath() %>/view/img/logo.png"
				class="mainLogo"></a>
			<div class="topHeaderRightBox">
				<a href="view/mypage.jsp"><img src="<%= request.getContextPath() %>/view/img/account.png"
					class="account"></a>
			</div>
		</div>
	</div>

	<div class="bottomHeader">
		<div class="bottomHeaderContentAll">
			<a href="javascript:history.back()" class="backLink"><img
				src="<%= request.getContextPath() %>/view/img/back.png" class="back"></a>
			<form class="searchWordForm" action="<%= request.getContextPath() %>/search">
				<input type="text" value="雑貨を見つける" name="searchWord"
					class="searchWordBox"> <img src="<%= request.getContextPath() %>/view/img/pass.png"
					class="pass">
			</form>
			<a href="<%= request.getContextPath() %>/view/insertItem.jsp" class="entryLink">出品</a>
		</div>
	</div>

</header>