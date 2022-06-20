<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>商品一覧</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>

<body>
	<!-- ブラウザ全体 -->
	<div id="wrap">

		<!-- メニュー部分 -->
		<div id="menu">
			<div class="container">
				<!-- ナビゲーション  -->
				<div id="nav">
					<ul>
						<li><a
							href="<%=request.getContextPath()%>/view/admin/menu.jsp">[メニュー]</a></li>
					</ul>
				</div>
				<!-- ページタイトル -->
				<div id="page_title">
					<h2>商品一覧</h2>
				</div>
			</div>
		</div>

		<!-- 書籍一覧のコンテンツ部分 -->
		<div id="main" class="container">

			<!-- 書籍情報リスト -->
			<table class="list-table">
				<thead>
					<tr>
						<th>受注No</th>
						<th>商品名</th>
						<th>価格</th>
						<th>在庫数</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>ユニフォームA</td>
						<td>\300</td>
						<td>5</td>
						<td><a
							href="<%=request.getContextPath()%>/view/admin/productUpdate.jsp">更新</a></td>
					</tr>
					<tr>
						<td>2</td>
						<td>ユニフォームB</td>
						<td>\600</td>
						<td>3</td>
						<td><a
							href="<%=request.getContextPath()%>/view/admin/productUpdate.jsp">更新</a></td>
					</tr>
					<tr>
						<td>3</td>
						<td>ユニフォームC</td>
						<td>\900</td>
						<td>7</td>
						<td><a
							href="<%=request.getContextPath()%>/view/admin/productUpdate.jsp">更新</a></td>
					</tr>
				</tbody>
			</table>
		</div>

	</div>
</body>
</html>