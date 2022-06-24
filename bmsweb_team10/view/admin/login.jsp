<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>ログイン画面</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>

<body>
	<!-- ブラウザ全体 -->
	<div id="wrap">

		<!-- ログインのコンテンツ部分 -->
		<div id="main" class="container">

			<form action="<%=request.getContextPath()%>/adminlogin" method="POST">
				<table class="input-table">
					<tr>
						<th>ID</th>
						<td><input type="text" size="25" name="id"></td>
					</tr>
					<tr>
						<th>パスワード</th>
						<td><input type="password" size="25" name="password"></td>
					</tr>
				</table>
				<input type="submit" value="ログイン">
			</form>
		</div>

	</div>
</body>
</html>