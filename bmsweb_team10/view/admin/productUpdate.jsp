<!--
作成日：2022/06/22
作成者：田中梨貴
内容：在庫数更新（jsp）
 -->
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.Product" %>

<%
Product product = (Product)request.getAttribute("product");
%>

<html>
<head>
<title>商品在庫数更新</title>
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
						<li><a href="<%=request.getContextPath()%>/view/admin/menu.jsp">[メニュー]</a></li>
					</ul>
				</div>

				<!-- ページタイトル -->
				<div id="page_title">
					<h2>商品在庫数更新</h2>
				</div>
			</div>
		</div>

		<div id="main" class="container">

			<!-- 変更画面 -->
			<form action="<%=request.getContextPath() %>/stockupdate" method="get">
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
							<th>商品No</th>
							<td><%=product.getProductid() %></td>
							<td><%=product.getProductid() %></td>
						</tr>
						<tr>
							<th>商品名</th>
							<td><%=product.getProductname() %></td>
							<td><%=product.getProductid() %></td>
						</tr>
						<tr>
							<th>価格</th>
							<td><%= product.getPrice() %></td>
							<td><%= product.getPrice() %></td>
						</tr>
						<tr>
							<th>在庫数</th>
							<td><%=product.getStock() %></td>
							<td><input type="text" name="stock"></td>
						</tr>
					</tbody>
				</table>
				<input type="hidden" name="productid" value="<%=product.getProductid()%>">
				<input type="hidden" name="cmd" value="update">
				<input type="submit" value="更新">
			</form>
		</div>

	</div>

</body>
</html>
