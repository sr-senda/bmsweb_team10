<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.Book,util.MyFormat"%>

<%
	Book book = (Book) request.getAttribute("book");
	MyFormat format = new MyFormat();
%>

<html>
<head>
<title>会員情報変更</title>
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
						<li><a href="<%=request.getContextPath()%>/view/userMenu.jsp">[メニュー]</a></li>
					</ul>
				</div>

				<!-- ページタイトル -->
				<div id="page_title">
					<h2>会員情報変更</h2>
				</div>
			</div>
		</div>

		<!-- 書籍変更コンテンツ部分 -->
		<div id="main" class="container">

			<!-- 変更画面 -->
			<form action="<%=request.getContextPath()%>/update">
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
							<th>メールアドレス</th>
							<td><%=book.getIsbn()%></td>
							<td><%=book.getIsbn()%></td>
						</tr>
						<tr>
							<th>氏名</th>
							<td><%=book.getTitle()%></td>
							<td><input type="text" name="name"></td>
						</tr>
						<tr>
							<th>住所</th>
							<td><%=format.moneyFormat(book.getPrice())%></td>
							<td><input type="text" name="adress"></td>
						</tr>
						<tr>
							<th>パスワード</th>
							<td><input type="text" name="password"></td>
						</tr>
					</tbody>
				</table>
				<input type="hidden" name="isbn" value="<%=book.getIsbn()%>">

				<input type="submit" value="変更完了">
			</form>

		</div>

		<!-- フッター部分 -->
		<%@ include file="/common/footer.jsp"%>

	</div>

</body>
</html>
