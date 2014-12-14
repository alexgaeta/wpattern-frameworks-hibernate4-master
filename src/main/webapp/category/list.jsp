<%@page import="java.util.List"%>
<%@page import="org.wpattern.frameworks.hibernate4.entities.CategoryEntity"%>
<%@page import="org.wpattern.frameworks.hibernate4.utils.DaoFactory"%>
<%@page import="org.wpattern.frameworks.hibernate4.daos.CategoryDao"%>

<html>
<head>
	<script type="text/javascript" src="/resources/js/main.js"></script>
	<link rel="shortcut icon" type="image/x-icon" href="/resources/images/wpattern.ico" />
	<link rel="stylesheet" type="text/css" href="/resources/css/main.css" />
	<title>WPattern Frameworks Hibernate4</title>
</head>
<body>
	<script type="text/javascript">
		<%
			String message = request.getParameter("error");
		
			if (message == null) {
				message = "";
			}
			
			out.print("showError('" + message + "');");
		%>
	</script>

	<h1><% out.println("Categories"); %></h1>
	
	<a href="/category/add">Add Category</a> <br/> <br/>
	
	<table>
		<tr class="table_header">
			<td>ID</td>
			<td>Category Name</td>
			<td>Description</td>
			<td>Delete</td>
			<td>Edit</td>
		</tr>
		<%
			CategoryDao categoryDao = DaoFactory.categoryInstance();
			List<CategoryEntity> categories = categoryDao.findAll();
			
			for (int i = 0; i < categories.size(); i++) {%>
				<tr>
					<td><%=categories.get(i).getId()%></td>
					<td><%=categories.get(i).getCategoryName()%></td>
					<td><%=categories.get(i).getDescription()%></td>
					<td><%=String.format("<a href=\"/category/delete?id=%s\">Delete</a>", categories.get(i).getId())%></td>
					<td><%=String.format("<a href=\"/category/edit?id=%s\">Edit</a>", categories.get(i).getId())%></td>
				</tr>
		<% } %>
	</table>
</body>
</html>
