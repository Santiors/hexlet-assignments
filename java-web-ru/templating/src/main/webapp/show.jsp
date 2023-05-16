<%@ page import="java.util.Map" %>
<%@ page import="exercise.Data" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- BEGIN -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Details</title>
</head>
<body>
<h1>User Details</h1>
<%
    String id = request.getParameter("id");
    Map<String, String> user = null;
    List<Map<String, String>> users = Data.getUsers();
    for (Map<String, String> u : users) {
        if (u.get("id").equals(id)) {
            user = u;
            break;
        }
    }

    if (user == null) {
        response.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
%>
<% if (user != null) { %>
<p>ID: <%= user.get("id") %></p>
<p>First Name: <%= user.get("firstName") %></p>
<p>Last Name: <%= user.get("lastName") %></p>
<p>Email: <%= user.get("email") %></p>
<a href="<%= request.getContextPath() %>/users/delete?id=<%= user.get("id") %>">Delete User</a>
<% } %>
</body>
</html>
<!-- END -->
