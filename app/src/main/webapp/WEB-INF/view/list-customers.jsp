<%--
  Created by IntelliJ IDEA.
  User: dmytro
  Date: 26.02.21
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.coreteka.util.SortUtil" %>

<html>
<head>
    <title>Список все сотрудников</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div id="top">
    <div id="wrapper">
        <div id="header">
            <h2>CRM-Employee Relationship Manager</h2>
        </div>
    </div>

    <div id="container">
        <div id="content">
            <table>
                <tr>
                    <td>
                        <input type="button" value="Add customer"
                               onclick="window.location.href='addCustomerForm'; return false"
                               class="add-button"
                        />
                    </td>
                    <td>
                        <form:form action="search" method="get">
                            <input type="text" name="theSearchName" >
                            <input type="submit" value="Search" class="add-button">
                        </form:form>
                    </td>
                </tr>
            </table>
            <table>
                <c:url var="sortFirstName" value="/customer/list">
                    <c:param name="sort" value="<%= SortUtil.FIRST_NAME %>" />
                </c:url>
                <c:url var="sortLastName" value="/customer/list">
                    <c:param name="sort" value="<%= SortUtil.LAST_NAME %>" />
                </c:url>
                <c:url var="sortEmail" value="/customer/list">
                    <c:param name="sort" value="<%= SortUtil.EMAIL %>" />
                </c:url>
                <tr>
                    <th><a href="${sortFirstName}">First Name</a></th>
                    <th><a href="${sortLastName}"> Last Name</a></th>
                    <th><a href="${sortEmail}"> Email</a></th>
                    <th>Action</th>
                </tr>
                <c:forEach var="tempCustomer" items="${customery}">

                    <c:url var="deleteLink" value="/customer/deleteCustomerForm">
                        <c:param name="customerId" value="${tempCustomer.id}" />
                    </c:url>
                    <c:url var="updateLink" value="/customer/updateCustomerForm">
                        <c:param name="customerId" value="${tempCustomer.id}" />
                    </c:url>
                    <c:url var="customerDetail" value="/customer/customerDetailForm">
                        <c:param name="customer" value="${tempCustomer.id}" />
                    </c:url>
                    <tr>
                        <td><a href="${customerDetail}"> ${tempCustomer.firstName}</a></td>
                        <td>${tempCustomer.lastName}</td>
                        <td>${tempCustomer.email}</td>
                        <td><a href="${updateLink}">Update</a>
                            |
                            <a onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false" href="${deleteLink}">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<a href="${pageContext.request.contextPath}/"><h3>back</h3></a>
</body>
</html>
