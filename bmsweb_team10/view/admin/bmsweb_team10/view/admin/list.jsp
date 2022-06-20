<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>注文内容一覧</title>
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
					<h2>注文内容一覧</h2>
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
						<th>氏名</th>
						<th>注文日</th>
						<th>内容詳細</th>
						<th>入金・発送</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>田中</td>
						<td>22/06/01</td>
						<td><a
							href="<%=request.getContextPath()%>/view/admin/detail.jsp">詳細</a></td>
						<td><a
							href="<%=request.getContextPath()%>/view/admin/update.jsp">更新</a></td>
					</tr>
					<tr>
						<td>2</td>
						<td>山田</td>
						<td>22/06/01</td>
						<td><a
							href="<%=request.getContextPath()%>/view/admin/detail.jsp">詳細</a></td>
						<td><a
							href="<%=request.getContextPath()%>/view/admin/update.jsp">更新</a></td>
					</tr>
					<tr>
						<td>3</td>
						<td>田中</td>
						<td>22/06/02</td>
						<td><a
							href="<%=request.getContextPath()%>/view/admin/detail.jsp">詳細</a></td>
						<td><a
							href="<%=request.getContextPath()%>/view/admin/update.jsp">更新</a></td>
					</tr>
				</tbody>
			</table>
		</div>

	</div>
</body>
</html>