<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>商品在庫数更新</title>
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
						<li><a href="<%=request.getContextPath()%>/view/admin/menu.jsp">[メニュー]</a></li>
					</ul>
				</div>

				<!-- ページタイトル -->
				<div id="page_title">
					<h2>商品在庫数更新</h2>
				</div>
			</div>
		</div>

		<!-- 書籍変更コンテンツ部分 -->
		<div id="main" class="container">

			<!-- 変更画面 -->
				<table class="input-table">
					<thead>
						<tr>
							<td></td>
							<th>&lt;&lt;変更前情報&gt;&gt;</th>
							<th>&lt;&lt;変更後情報&gt;&gt;</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>商品No</th>
							<td>1</td>
							<td>1</td>
						</tr>
						<tr>
							<th>商品名</th>
							<td>ユニフォームA</td>
							<td>ユニフォームA</td>
						</tr>
						<tr>
							<th>価格</th>
							<td>\300</td>
							<td>\300</td>
						</tr>
						<tr>
							<th>在庫数</th>
							<td>5</td>
							<td><input type="text" name=""></td>
						</tr>
					</tbody>
				</table>

				<input type="submit" value="更新">

		</div>

	</div>

</body>
</html>