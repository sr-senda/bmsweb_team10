<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>会員情報変更</title>
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
					<h2>会員情報変更</h2>
				</div>
			</div>
		</div>

		<!-- 書籍変更コンテンツ部分 -->
		<div id="main" class="container">

			<!--  入力フォーム -->
			<form action="<%=request.getContextPath()%>/view/user/menu.jsp">
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
							<th>会員ID</th>
							<td>＊＊＊＊</td>
							<td>＊＊＊＊</td>
						</tr>
						<tr>
							<th>氏名</th>
							<td>＊＊＊＊</td>
							<td><input type="text" name=""></td>
						</tr>
						<tr>
							<th>mail</th>
							<td>＊＊＊＊</td>
							<td><input type="text" name=""></td>
						</tr>
						<tr>
							<th>住所</th>
							<td>＊＊＊＊</td>
							<td><input type="text" name=""></td>
						</tr>
					</tbody>
				</table>

				<input type="submit" value="変更完了">
			</form>
		</div>

	</div>

</body>
</html>
