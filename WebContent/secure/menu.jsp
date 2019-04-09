<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="heading.jsp"/>
	<br>
	<br>
	<a href="addbook.jsp">Add Book</a>
	<br>
	<br>
	<a href="deletebookbyid.jsp">Delete Book</a>
	<br>
	<br>
	<a href="ListAllBooksServlet">List All Books</a>
	<br>
	<br>
	<a href="searchbookbyid.jsp">Search Book By ID</a>
	<br>
	<br>
	<a href="searchbookbytitle.jsp">Search Book By Title</a>
	
	<br>
	<br>
	<a href="LogoutServlet">Logout</a>
	<br>
</body>
</html>