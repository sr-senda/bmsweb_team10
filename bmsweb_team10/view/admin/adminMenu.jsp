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

		<!-- ヘッダー部分 -->
		<%@ include file="/common/header.jsp"%>

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
				<li><a href="<%=request.getContextPath()%>/view/insert.jsp">【注文内容一覧】</a></li>
				<li><a href="<%=request.getContextPath()%>/list">【配送状況確認】</a></li>
				<li><a href="<%=request.getContextPath()%>/showCart">【商品一覧】</a></li>
				<li><a href="<%=request.getContextPath()%>/logout" class="mb50">【ログアウト】</a></li>
			</ul>
		</div>

		<!-- フッター部分 -->
		<%@ include file="/common/footer.jsp"%>

	</div>
</body>

</html>