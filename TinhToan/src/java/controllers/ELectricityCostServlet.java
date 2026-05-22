/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author VU VAN HUY
 */
public class ELectricityCostServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String electnum = request.getParameter("electnum");
        String err="";
        int rs=0;
        if (electnum.isEmpty()){
            err+="Please input the comsume electricity";
        } else {
            try {
                int n = Integer.parseInt(electnum);
                if (n<0)
                    err+="Number of electricity consum must be positive.";
                else{
                    if (n<=50)
                        rs= n*1984;
                    else if (n<=100) 
                        rs=50*1984+(n-50)*2050;
                    else if (n<=200)
                        rs=50*1984+50*2050+(n-100)*2380;
                    else if (n<=300)
                        rs=50*1984+50*2050+100*2380+(n-100)*2998;
                    else if (n<=400)
                        rs=50*1984+50*2050+100*2380+100*2998+(n-300)*3350;
                    else
                        rs=50*1984+50*2050+100*2380+100*2998+100*3350+(n-400)*3460;
                }
                    
            } catch (Exception e) {
                
            }
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ELectricityCostServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            if (err.isEmpty()){
                out.println("<table>");
                out.println("<tr>");
                out.println("<td>Electricity cost: </td>");
                out.println("<td>"+ rs +"</td>");                
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>Tax fee (VAT 10%): </td>");
                out.println("<td>"+ rs*0.1 +"</td>");                
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>Total electricity cost: </td>");
                out.println("<td>"+ rs*1.1 +"</td>");                
                out.println("</tr>");                
                out.println("</table>");
            } else 
                out.println("<h1>" + err + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
