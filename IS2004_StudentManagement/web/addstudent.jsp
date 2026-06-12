<%-- 
    Document   : addstudent
    Created on : Jun 12, 2026, 1:45:20 PM
    Author     : VU VAN HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new student</title>
    </head>
    <body>
    <center><h1>Add new student</h1></center>
    <form action="add" method="post">
        <table border="0">
            <tr>
                <td>Student Id</td>
                <td><input type="text" name="txtId" id="txtId"></td>
            </tr>
            <tr>
                <td>Student Name</td>
                <td><input type="text" name="txtName" id="txtName"></td>
            </tr>
            <tr>
                <td>Student DOB</td>
                <td><input type="text" name="txtDob" id="txtDob"></td>
            </tr>
            <tr>
                <td>Student Grade</td>
                <td><input type="text" name="txtGrade" id="txtGrade"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Add student" id="btnAdd"></td>
            </tr>
        </table>


    </form>
</body>
</html>
