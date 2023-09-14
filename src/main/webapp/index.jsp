<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<style>
table {
	margin: auto;
}

td {
	text-align: center;
}
</style>
</head>
<body>
	<form action="/insert.contact" method="get">
		<table border="1px">
			<th colspan="2">Index</th>
			<tr>
				<td><a href="/Input.jsp">toInput</a></td>
				<td><a href="/Output.contact">toOutput</a></td>
			</tr>
		</table>
	</form>
</body>
</html>