<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>注文内容詳細</title>
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
						<li><a
							href="<%=request.getContextPath()%>/view/admin/list.jsp">[注文内容一覧]</a></li>
					</ul>
				</div>

				<!-- ページタイトル -->
				<div id="page_title">
					<h2>注文内容詳細</h2>
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
						<th>商品名</th>
						<th>個数</th>
						<th>合計金額</th>
						<th>注文日</th>
						<th>入金状況</th>
						<th>発送状況</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>田中</td>
						<td>ユニフォームA<br>ユニフォームB
						</td>
						<td>3<br>2
						</td>
						<td>\2,100</td>
						<td>22/06/01</td>
						<td>入金待ち</td>
						<td>未</td>
						<td><a
							href="<%=request.getContextPath()%>/view/admin/update.jsp">更新</a></td>
					</tr>
				</tbody>
			</table>
		</div>

	</div>
</body>
</html>