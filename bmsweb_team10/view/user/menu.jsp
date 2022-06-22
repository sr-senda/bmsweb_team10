<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.User"%>
<%
	//getAttributeメソッドからセッションコープに登録したuserInfoを取得
	User userInfo =(User)request.getAttribute("userInfo");
	//String error = (String) request.getAttribute("error");
%>
<html>
<head>
<title>会員トップ</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<!-- ブラウザ全体 -->
	<div id="wrap">

		<!-- メニュー部分 -->
		<div id="menu">
			<div class="container">
				<!-- ページタイトル -->
				<div id="page_title">
					<h2>会員トップ</h2>
				</div>
			</div>
		</div>

		<!-- コンテンツ(本文) -->
		<div id="main" class="container">
			<table class="input-table">
				<tbody>
					<tr>
						<th>会員ID</th>
						<td><%=userInfo.getUserid() %></td>
					</tr>
					<tr>
						<th>氏名</th>
						<td><%=userInfo.getName() %></td>
					</tr>
					<tr>
						<th>mail</th>
						<td><%=userInfo.getMail() %></td>
					</tr>
					<tr>
						<th>住所</th>
						<td><%=userInfo.getAddress() %></td>
					</tr>
				</tbody>
			</table>
			<ul class="link">
				<li><a href="<%=request.getContextPath()%>/view/user/userUpdate.jsp">【会員情報変更】</a></li>
				<li><a
					href="<%=request.getContextPath()%>/view/user/order.jsp">【注文する】</a></li>
				<li><a href="<%=request.getContextPath()%>/logout?cmd=userlogin" class="mb50">【ログアウト】</a></li>
			</ul>
		</div>

	</div>
</body>

</html>