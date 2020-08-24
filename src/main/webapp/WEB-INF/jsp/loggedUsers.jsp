<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>

<!DOCTYPE html>
<html>
<body>
    <h2>Currently logged in users</h2>
    <div th:each="user : ${users}">
        <p th:text="${user}">user</p>
    </div>
</body>
</html>