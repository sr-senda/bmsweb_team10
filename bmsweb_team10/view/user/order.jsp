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
		<!-- メニュー部分 -->
		<div id="menu">
			<div class="container">

				<!-- ページタイトル -->
				<div id="page_title">
					<h2>ユニフォーム注文</h2>
				</div>
			</div>
		</div>

		<!-- 書籍変更コンテンツ部分 -->
		<div id="main" class="container">

			<!--  入力フォーム -->
			<form action="<%=request.getContextPath()%>/view/user/menu.jsp">
				<!-- 変更画面 -->
				<table class="input-table">
					<tbody>
						<tr>
							<th>会員ID：</th>
							<td><input type="text" name=""></td>
						</tr>
						<tr>
							<th>氏名：</th>
							<td><input type="text" name=""></td>
						</tr>
						<tr>
							<th>mail：</th>
							<td><input type="text" name=""></td>
						</tr>
						<tr>
							<th>住所</th>
							<td><input type="text" name=""></td>
						</tr>
						<tr>
							<th>商品</th>
							<td><select name="">
									<option value="ユニフォームA">ユニフォームA</option>
									<option value="ユニフォームB">ユニフォームB</option>
									<option value="ユニフォームC">ユニフォームC</option>
							</select></td>
						</tr>
						<tr>
							<th>個数</th>
							<td><input type="text" name=""></td>
						</tr>
					</tbody>
				</table>
				<input type="submit" value="注文">
			</form>
		</div>

	</div>

</body>
</html>
