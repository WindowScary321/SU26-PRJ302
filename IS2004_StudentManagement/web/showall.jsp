<%-- 
    Document   : showall
    Created on : Jun 5, 2026, 2:37:12 PM
    Author     : VU VAN HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show All students</title>
    </head>
    <body>
        <center><h1>STUDENT LIST</h1></center>
        <p><a href="addstudent.jsp">Add new student</a></p>
        <table border="1">
            <thead>
                <tr>
                    <th>N0</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>DOB</th>
                    <th>Grade</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="i" items="${listStd}" varStatus="no">
                <tr>
                    <td>${no.count}</td>
                    <td>${i.id}</td>
                    <td>${i.name}</td>
                    <td>${i.dob}</td>
                    <td>${i.grade}</td>
                    <td>
                        <a href="#">Update</a> | <a href="delete?sid=${i.id}">Delete</a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

    
    </body>
</html>
