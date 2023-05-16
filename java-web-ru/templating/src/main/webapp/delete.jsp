<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="exercise.Data" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- BEGIN -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete User</title>
</head>
<body>
<h1>Delete User</h1>
<p>Are you sure you want to delete this user?</p>
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
<% } %>
<form action="<%= request.getContextPath() %>/users/delete" method="post">
    <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
    <button type="submit" class="btn btn-danger">Delete</button>
</form>
</body>
</html>
<!-- END -->
