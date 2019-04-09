<%@page import="com.livetechstudy.library.model.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 5px;
	text-align: left;
}
</style>
</head>
<body>
Books Details :
	<br>
	<table>
		<tr>
			<th>BookId</th>
			<th>Book Title</th>
			<th>Book Author</th>
		</tr>

		<%
			Book book = (Book) request.getAttribute("foundbook");
		%>
		<tr>
			<td><%=book.getBookId()%></td>
			<td><%=book.getBookTitle()%></td>
			<td><%=book.getAuthor()%></td>
		</tr>
	</table>
	<br>
	<a href="menu.jsp">Show Menu </a>
</body>
</html>