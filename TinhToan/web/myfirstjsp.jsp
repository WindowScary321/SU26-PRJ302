<%-- 
    Document   : myfirstjsp
    Created on : May 26, 2026, 4:08:55 PM
    Author     : VU VAN HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My First JSP</title>
    </head>
    <body>
        <center><h1>Hello JSP World!</h1></center>
        <%int n=26; 
        for (int i=0; i<n; i++){%>
        <p><%=i+1%>. Anh yêu em!</p>
        <%}%>
        <%!
        char convertToChar(int i){
            return (char)(65+i);
        }
        %>
        <table border="1">
            <tr>
                <th>STT</th>
                <th>Họ và Tên</th>
                <th>Ghi chú</th>
            </tr>
            <%for(int i=0; i<n; i++){%>
            <tr>
                <td><%=i+1%></td>
                <td>Vũ Văn <%=convertToChar(i)%></td>
                <td></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
