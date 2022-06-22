<!--
作成日：2022/06/22
作成者：田中梨貴
内容：商品一覧（JSP）
 -->
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Product" %>

<html>
<head>
<title>商品一覧</title>
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
					<h2>商品一覧</h2>
				</div>
			</div>
		</div>

		<!-- 書籍一覧のコンテンツ部分 -->
		<div id="main" class="container">

			<!-- 書籍情報リスト -->
			<form action = "<%=request.getContextPath()%>/stockupdate">
			<table class="list-table">
				<thead>
					<tr>
						<th>商品No</th>
						<th>商品名</th>
						<th>価格</th>
						<th>在庫数</th>
						<th></th>
					</tr>
				</thead>
				<tbody>

			<%
			ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("product_list");
			if(list != null){
				for(int i=0;i<list.size();i++){
					Product product = (Product)list.get(i);
			%>

					<tr>
						<td><%=product.getProductid()%></td>
						<td><%=product.getProductname()%></td>
						<td><%=product.getPrice()%></td>
						<td><%=product.getStock()%></td>

						<td>
							<input type="hidden" name="productid" value="<%=product.getProductid()%>"></input>
							<input type="hidden" name="productname" value="<%=product.getProductname()%>"></input>
							<input type="hidden" name="price" value="<%=product.getPrice()%>"></input>
							<input type="hidden" name="stock" value="<%=product.getStock()%>"></input>
							<input type="hidden" name="cmd" value="detail">
							<input type="submit" value="更新"></a>
						</td>
					</tr>



				</tbody>
				<% }
			}%>
			</table>
			</form>
		</div>

	</div>
</body>
</html>