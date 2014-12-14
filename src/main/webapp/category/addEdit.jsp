<html>
<head>
	<link rel="shortcut icon" type="image/x-icon" href="/resources/images/wpattern.ico" />
	<link rel="stylesheet" type="text/css" href="/resources/css/main.css" />
	<title>WPattern Frameworks Hibernate4</title>
</head>

<body>
	<h1><%
			Long id = (Long)session.getAttribute("id");

			session.removeAttribute("id");

			String strId = "";
			
			if (id == null) {
			   out.println("Add");
			} else {
			   out.println("Edit");
			   strId = id + "";
			}								
		%>
	</h1>
	
	<a href="/category/list.jsp">List Categories</a> <br/> <br/>
	
	<form action="/category/edit" method="post">
		<% out.println("<input type=\"text\" name=\"id\" hidden=\"true\" value=\"" + strId + "\" />"); %>
		
		<table>
			<tr>
				<td>Category Name</td>
				<td>
					<%
						String categoryName = (String)session.getAttribute("categoryName");
					
						if (categoryName == null) {
							categoryName = "";
						}
					
						out.println("<input type=\"text\" name=\"categoryName\" value=\"" + categoryName + "\" />");						
						session.removeAttribute("categoryName");
					%>
				</td>
			</tr>
			<tr>
				<td>Description</td>
				<td>
					<%
						String description = (String)session.getAttribute("description");
						
						if (description == null) {
							description = "";
						}
						
						out.println("<input type=\"text\" name=\"description\" value=\"" + description + "\" />");						
						session.removeAttribute("description");
					%>
				</td>
			</tr>
		</table>
		
		<br/>
		
		<input type="submit" value="Save" />
	</form>
	
</body>
</html>
