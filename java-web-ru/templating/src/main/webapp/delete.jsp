<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="exercise.Data" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- BEGIN -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Example application | Users</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <a href="/users">All users</a>
    <p>Are you sure that you want to delete this user ${user.get("firstName")} ${user.get("lastName")} ?</p>

    <form action='/users/delete?id=${user.get("id")}' method="post">
        <button type="submit" class="btn btn-danger">Delete</button>
    </form>
</body>
</html>
<!-- END -->
