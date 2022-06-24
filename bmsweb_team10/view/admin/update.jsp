<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.Order" %>
<%
Order order = (Order)request.getAttribute("order");
%>
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
						<li><a href="<%=request.getContextPath()%>/statusupdate?cmd=list">[注文内容一覧]</a></li>
					</ul>
				</div>

				<!-- ページタイトル -->
				<div id="page_title">
					<h2>入金・発送状況更新</h2>
				</div>
			</div>
		</div>

<%
String payment=null;
String deliver=null;
if(order.getPayment().equals("1")){
	payment = "入金待ち";
}else if(order.getPayment().equals("2")){
	payment = "入金済み";
}

if(order.getDelivery().equals("1")){
	deliver = "未発送";
}else if(order.getDelivery().equals("2")){
	deliver = "発送準備中";
}else if(order.getDelivery().equals("3")){
	deliver = "発送済み";
}
%>
		<!-- 書籍一覧のコンテンツ部分 -->
		<div id="main" class="container">

<table><td>「<%=order.getName() %>様」の現在の入金配送状況　「<%=payment %>」、「<%=deliver %>」</table>
			<!-- 書籍情報リスト -->
			<form action="<%=request.getContextPath()%>/statusupdate">
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
						<td><%=order.getOrderid() %></td>
						<td>
							<label><input type="radio" name="payment" value="1">入金待ち</label>
							<label><input type="radio" name="payment" value="2">入金済み</label>
						</td>
						<td>
							<label><input type="radio" name="delivery" value="1">未発送</label>
							<label><input type="radio" name="delivery" value="2">発送準備中</label>
							<label><input type="radio" name="delivery" value="3">発送済み</label>
						</td>
					</tr>
				</tbody>
			</table>
			<input type="hidden" name="orderid" value="<%= order.getOrderid()%>">
			<input type="hidden" name="cmd" value="list">
			<input type="submit" value="更新" >
			</form>
		</div>

	</div>
</body>
</html>