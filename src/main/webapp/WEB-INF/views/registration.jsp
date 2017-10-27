<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Registration Form</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
 
<body>
 
    <div class="generic-container">
    <div class="well lead">Task Registration Form</div>
    <form:form method="POST" modelAttribute="task" class="form-horizontal">
        <form:input type="hidden" path="id" id="id"/>
         
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="TaskName">Task Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="TaskName" id="TaskName" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="TaskName" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
 
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="Description">Description</label>
                <div class="col-md-7">
                    <form:input type="text" path="Description" id="Description" class="form-control input-sm" />
                    <div class="has-error">
                        <form:errors path="Description" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
 
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="Priority">Priority</label>
                <div class="col-md-7">
                    <c:choose>
                        <c:when test="${edit}">
                            <form:input type="number" path="Priority" id="Priority" class="form-control 
 
input-sm" disabled="true"/>
                        </c:when>
                        <c:otherwise>
                            <form:input type="number" path="Priority" id="Priority" class="form-control 
 
input-sm" />
                            <div class="has-error">
                                <form:errors path="Priority" class="help-inline"/>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
  
 
        <div class="row">
            <div class="form-actions floatRight">
                <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a
 
href="<c:url value='/list' />">Cancel</a>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a
 
href="<c:url value='/list' />">Cancel</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
    </div>
</body>
</html>