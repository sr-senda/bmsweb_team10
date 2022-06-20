<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>入金・発送状況更新</title>
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
						<li><a href="<%=request.getContextPath()%>/view/admin/list.jsp">[注文内容一覧]</a></li>
					</ul>
				</div>

				<!-- ページタイトル -->
				<div id="page_title">
					<h2>入金・発送状況更新</h2>
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
						<th>入金状況</th>
						<th>発送状況</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>
							<label><input type="radio">入金待ち</label>
							<label><input type="radio">入金済み</label>
						</td>
						<td>
							<label><input type="radio">未発送</label>
							<label><input type="radio">発送準備中</label>
							<label><input type="radio">発送済み</label>
						</td>
					</tr>
				</tbody>
			</table>
			<input type="submit" value="更新">
		</div>

	</div>
</body>
</html>