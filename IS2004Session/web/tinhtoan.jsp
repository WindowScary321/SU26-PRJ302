<%-- 
    Document   : tinhtoan
    Created on : Jun 2, 2026, 4:28:51 PM
    Author     : VU VAN HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Máy tính IS2004</title>
    </head>
    <body>
        <h1>FPT Calculator by IS2004</h1>
        <form action="calculate" method="post">
            <table border="0">
                <tr>
                    <td>Number 1</td>
                    <td><input type="text" name="txtNum1" id="txtn1" value="${n1}"></td>
                </tr>
                <tr>
                    <td>Number 2</td>
                    <td><input type="text" name="txtNum2" id="txtn2" value="${n2}"></td>
                </tr>
                <tr>
                    <td>Operator</td>
                    <td>
                        <input type="radio" name="op" value="+" checked id ="rbSum">Sum<br>
                        <input type="radio" name="op" value="-" id ="rbSub">Subtract<br>
                        <input type="radio" name="op" value="*" id ="rbProd">Product<br>
                        <input type="radio" name="op" value="/" id ="rbQuo">Quotient<br>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Calculate" id="btnCal"></td>
                </tr>
            </table>
        </form>
        <hr>
        <p style="color:red"> ${errmess}</p>
        <table border="1">
            <thead>
                <tr>
                    <th>Number 1</th>
                    <th>Operator</th>
                    <th>Number 2</th>
                    <th></th>
                    <th>Results</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="i" items="${listData}">
                <tr>
                    <td style="text-align: center">${i.n1}</td>
                    <td style="text-align: center">${i.op}</td>
                    <td style="text-align: center">${i.n2}</td>
                    <td style="text-align: center">=</td>
                    <td style="text-align: center">${i.rs}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
