<%-- 
    Document   : cuuchuong
    Created on : May 26, 2026, 4:36:18 PM
    Author     : VU VAN HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bảng cửu chương</title>
    </head>
    <body>
        <center><h1>Bảng cửu chương</h1></center>
        <form action="cuuchuong.jsp" method="post">
            <table>
                <tr>
                    <td>Input</td>
                    <td><input type="text" name="txtNum" id="txtn"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Submit" id="btnCal"></td>
                </tr>
            </table>
        </form>
        <hr>
        <%
        String num=request.getParameter("txtNum");
        int n=0;
        if(num!=null && num!=""){
            try {
                n = Integer.parseInt(num); %>
                <table>
                    <% for(int i=0; i<=10; i++){ %>
                    <tr>
                        <td><%=n%></td>
                        <td>x</td>
                        <td><%=i%></td>
                        <td>=</td>
                        <td><%=n*i%></td>
                    </tr>
                    <%}%>
                </table>
        <%        
            } catch (NumberFormatException e) { %>
                <div id="txtErr">Đồ đần, phải nhập số vào.</div> 
        <% }}%>
    </body>
</html>
