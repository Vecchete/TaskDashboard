<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Tasks List</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
 
<body>
    <div class="generic-container">
        <div class="panel panel-default">
              <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">List of Tasks </span></div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Submited By</th>
                        <th>Priority</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${pairs}" var="pair">
                    <tr>
                        <td>${pair.getName()}</td>
                        <td>${pair.getUsername()}</td>
                        <td>${pair.getPriority()}</td>
                        <td><a href="<c:url value='/edit-task-${pair.getId()}' />" class="btn btn-success 
 
custom-width">edit</a></td>
                        <td><a href="<c:url value='/delete-task-${pair.getId()}' />" class="btn btn-danger 
 
custom-width">delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="well">
            <a href="<c:url value='/newtask' />">Add New Task</a>
        </div>
    </div>
</body>
</html>