<!--
作成日：2022/06/22
作成者：田中梨貴
内容：管理者メニュー
 -->
<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>MENU</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<!-- ブラウザ全体 -->
	<div id="wrap">

		<!-- メニュー部分 -->
		<div id="menu">
			<div class="container">
				<!-- ページタイトル -->
				<div id="page_title">
					<h2>MENU</h2>
				</div>
			</div>
		</div>

		<!-- コンテンツ(本文) -->
		<div id="main" class="container">
			<ul class="link">
				<li><a href="<%=request.getContextPath()%>/orderlist">【注文内容一覧】</a></li>
				<li><a href="<%=request.getContextPath()%>/productlist">【商品一覧】</a></li>
				<li><a href="<%=request.getContextPath()%>/logout?cmd=adminlogin" class="mb50">【ログアウト】</a></li>
			</ul>
		</div>

	</div>
</body>

</html>