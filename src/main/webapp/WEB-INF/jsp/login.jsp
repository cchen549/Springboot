<%--
  Created by IntelliJ IDEA.
  User: chencecheng
  Date: 2023/2/23
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form method="post" action="/users/login">
    <div>
        <label>Username:</label>
        <input type="text" name="username" />
    </div>
    <div>
        <label>Password:</label>
        <input type="password" name="password" />
    </div>
    <div>
        <input type="submit" value="Login" />
    </div>
</form>
<% if (request.getAttribute("errorMessage") != null) { %>
<p><%= request.getAttribute("errorMessage") %></p>
<% } %>
</body>
</html>