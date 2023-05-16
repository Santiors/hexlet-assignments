<%@ page import="java.util.Map" %>
<%@ page import="exercise.Data" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- BEGIN -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Users</title>
</head>
<body>
<h1>Users</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>FirstName</th>
        <th>LastName</th>>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <% for (Map<String, String> user : Data.getUsers()) { %>
    <tr>
        <td><a href="<%= request.getContextPath() %>/users/show?id=<%= user.get("id") %>"><%= user.get("id") %></a></td>
        <td><%= user.get("firstName") %></td>
        <td><%= user.get("lastName") %></td>
        <td><%= user.get("email") %></td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
<!-- END -->
