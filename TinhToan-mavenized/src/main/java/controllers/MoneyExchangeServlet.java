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
public class MoneyExchangeServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String amount = request.getParameter("amount");
        String method = request.getParameter("method");
        String moneyType = request.getParameter("moneytype");
        String err="";
        Double rs = 0.0;
        if (amount.isEmpty())
            err+="Please input amount of money to exchange.";
        else {
            try {
                Double m = Double.parseDouble(amount);
                switch (moneyType){
                    case "usd":
                        if (method.equals("buy"))
                            rs = m*26160;
                        else
                            rs = m*26390;
                        break;
                    case "eur":
                        if (method.equals("buy"))
                            rs = m*30150;
                        else
                            rs = m*31422.6;
                        break;
                    case "gbp":
                        if (method.equals("buy"))
                            rs = m*34831.03;
                        else
                            rs = m*35946.38;
                        break;
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
            out.println("<title>Money Exchange</title>");  
            out.println("</head>");
            out.println("<body>");
            if (err.isEmpty())
                out.println("<h1>Exchange "+amount+
                        " "+ moneyType.toUpperCase() + " to VND is: "+ rs + "</h1>");
            else
                out.println("<h1>" + err+"</h1>");
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
