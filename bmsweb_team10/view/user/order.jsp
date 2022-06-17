<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>ユニフォーム注文</title>
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
				<!-- ナビゲーション  -->
				<div id="nav">
					<ul>
						<li><a
							href="<%=request.getContextPath()%>/view/user/userMenu.jsp">[メニュー]</a></li>
					</ul>
				</div>

				<!-- ページタイトル -->
				<div id="page_title">
					<h2>注文画面</h2>
				</div>
			</div>
		</div>

		<!-- 書籍登録コンテンツ部分 -->
		<div id="main" class="container">

			<!--  入力フォーム -->
			<form action="<%=request.getContextPath()%>/insert">
				<table class="input-table" align="center">
					<tr>
						<th>氏名</th>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<th>mail</th>
						<td><input type="text" name="email"></td>
					</tr>
					<tr>
						<th>商品</th>
						<td><select name="product">
								<option value="ユニフォームA">ユニフォームA</option>
								<option value="ユニフォームB">ユニフォームB</option>
								<option value="ユニフォームC">ユニフォームC</option>
						</select></td>
					</tr>
					<tr>
						<th>個数</th>
						<td><input type="text" name="price"></td>
					</tr>
				</table>

				<input type="submit" value="登録">
			</form>



		</div>

		<!-- フッター部分 -->
		<%@ include file="/common/footer.jsp"%>

	</div>
</body>
</html>