<%-- 
    Document   : chunhat
    Created on : May 26, 2026, 5:16:41 PM
    Author     : VU VAN HUY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tính chu vi diện tích</title>
    </head>
    <body>
        <center><h1>Tính chu vi diện tích hình chữ nhật</h1></center>
    <form action="chunhat.jsp" method="POST">
        <table>
            <tr>
                <td>Chiều dài (cm)</td>
                <td><input type="text" name="txtDai" id="txtd"></td>
            </tr>
            <tr>
                <td>Chiều rộng (cm)</td>
                <td><input type="text" name="txtRong" id="txtr"></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="radio" name="rbMethod" value="cv" id="txtcv" checked>Chu vi<br>
                    <input type="radio" name="rbMethod" value="dt" id="txtdt">Diện tích
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Tính" style="width: 80px; background-color: yellow">
                    <input type="reset" value="xoá" style="width: 80px; background-color: greenyellow">
                </td>
            </tr>
        </table>
    </form>  
    <hr>
    <%!
        double chuvi(double x, double y){return (x+y)*2;}
        double dientich(double x, double y){return (x*y);}
    %>
    <%
        String dai=request.getParameter("txtDai"); 
        String rong=request.getParameter("txtRong"); 
        String method=request.getParameter("rbMethod");
        double d=0, r=0, rs=0;
        if (dai!=null && dai!="" && rong!=null && rong!=""){
            try {
                d = Double.parseDouble(dai);
                r = Double.parseDouble(rong);
                if (method.equals("cv")){ %>
                    <div id="txtOutput">Chu vi của hình chữ nhật là: <%=chuvi(d,r)%></div>                    
                <%} else { %>
                    <div id="txtOutput">Diện tích của hình chữ nhật là: <%=dientich(d,r)%> </div>                    
            <%}    
            } catch (NumberFormatException e) { %>
                <div id="txtError">Đồ đần, phải nhập số vào. </div>                    
            <%}}%>
    </body>
</html>
