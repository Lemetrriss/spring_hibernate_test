<%--
  Created by IntelliJ IDEA.
  User: dmytro
  Date: 01.03.21
  Time: 01:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Подробно о ${customer.lastName} ${customer.firstName}</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Подробноя информация: </h2>
    </div>
</div>
<div id="container">
    <div id="content">
        <table>
            <tr>
                <th>id</th>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Почта</th>
            </tr>
            <tr>
                <td>${customer.id}</td>
                <td>${customer.firstName}</td>
                <td>${customer.lastName}</td>
                <td>${customer.email}</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>