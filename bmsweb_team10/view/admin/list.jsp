<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Order" %>

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
			<%
			ArrayList<Order> list = (ArrayList<Order>)request.getAttribute("order_list");
			if(list != null){
				for(int i=0;i<list.size();i++){
					Order order = (Order)list.get(i);
			%>
				<tbody>
					<tr>
						<td><%=order.getOrderid()%></td>
						<td><%=order.getName()%></td>
						<td><%=order.getOrderday()%></td>
						<td><a
							href="<%=request.getContextPath()%>/detail">詳細</a></td>
						<td><a
							href="<%=request.getContextPath()%>/statusupdate">更新</a></td>
				<%
				}
			}
				%>
				</tbody>
			</table>
		</div>

	</div>
</body>
</html>