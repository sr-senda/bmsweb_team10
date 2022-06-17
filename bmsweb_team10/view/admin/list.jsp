<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Book,util.MyFormat"%>

<%
	ArrayList<Book> book_list = (ArrayList<Book>) request.getAttribute("book_list");
	MyFormat format = new MyFormat();
%>

<html>
<head>
<title>注文内容一覧</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>

<body>
	<!-- ブラウザ全体 -->
	<div id="wrap">

		<!--ヘッダー部分  -->
		<%@ include file="/common/header.jsp"%>

		<!-- メニュー部分 -->
		<div id="menu">
			<div class="container">
				<!-- ナビゲーション  -->
				<div id="nav">
					<ul>
						<li><a href="<%=request.getContextPath()%>/view/menu.jsp">[メニュー]</a></li>
					</ul>
				</div>

				<!-- ページタイトル -->
				<div id="page_title">
					<h2>注文内容一覧</h2>
				</div>
			</div>
		</div>

		<!-- 書籍一覧のコンテンツ部分 -->
		<div id="main" class="container">

			<!-- 検索フォーム -->
			<form class="inline-block" action="<%=request.getContextPath()%>/search">
				ISBN <input type="text" name="isbn">
				TITLE <input　type="text" name="title">
				価格 <input type="text" name="price">
				<input type="submit" value="検索">
			</form>
			<form class="inline-block" action="<%=request.getContextPath()%>/list">
				<input type="submit" value="全件表示">
			</form>

			<!-- 書籍情報リスト -->
			<table class="list-table">
				<thead>
					<tr>
						<th>No</th>
						<th>氏名</th>
						<th>種類</th>
						<th>個数</th>
						<th>合計金額</th>
						<th>発注日</th>
						<th>入金状況</th>
						<th>発送状況</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<%
						if (book_list != null) {
							for (Book book : book_list) {
					%>
					<tr>
						<td><%=book.getId()%></td>
						<td><%=book.getName()%></td>
						<td><%=book.getProdact()%></td>
						<td><%=book.getQuantity()%></td>
						<td><%=format.moneyFormat(book.getPrice())%></td>
						<td><%=book.getDay()%></td>
						<td><%=book.get()%>入金状況</td>
						<td><%=book.get()%>発送状況</td>
						<td>詳細/更新</td>
					</tr>
					<%
						}
						}
					%>
				</tbody>
			</table>
		</div>

		<!-- フッター部分 -->
		<%@ include file="/common/footer.jsp"%>

	</div>
</body>
</html>