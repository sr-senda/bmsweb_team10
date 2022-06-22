<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.Order"%>

<%
Order admin = (Order) request.getAttribute("admin");
%>

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
						<td><%=admin.getOrderid()%></td>
						<td><%=admin.getName()%></td>
						<td><%=admin.getProductid()%><br><%=admin.getProductid()%>
						</td>
						<td><%=admin.getQuantity()%><br><%=admin.getQuantity()%>
						</td>
						<td><%=admin.getSumprice()%></td>
						<td><%=admin.getOrderday()%></td>
						<td><%=admin.getPayment()%></td>
						<td><%=admin.getDelivery()%></td>
						<td><a
							href="<%=request.getContextPath()%>/view/admin/update.jsp">更新</a></td>
					</tr>
				</tbody>
			</table>
		</div>

	</div>
</body>
</html>