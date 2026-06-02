/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Data;

/**
 *
 * @author VU VAN HUY
 */
@WebServlet(name = "TinhtoanServlet", urlPatterns = {"/calculate"})
public class TinhtoanServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TinhtoanServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TinhtoanServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String strNum1 = request.getParameter("txtNum1");
        String strNum2 = request.getParameter("txtNum2");
        String op = request.getParameter("op");
        String err = "";
        double n1, n2, rs = 0;
        //Khoi tao session
        HttpSession session = request.getSession();
        if (strNum1 != null && !strNum1.isEmpty()
                && strNum2 != null && !strNum2.isEmpty()) {
            try {
                n1 = Double.parseDouble(strNum1);
                n2 = Double.parseDouble(strNum2);
                switch (op) {
                    case "+":
                        rs = n1 + n2;
                        break;
                    case "-":
                        rs = n1 - n2;
                        break;
                    case "*":
                        rs = n1 * n2;
                        break;
                    case "/":
                        if (n2 != 0) {
                            rs = n1 / n2;
                        } else {
                            rs = 0;
                            err = "Number 2 must not be zero.";
                        }
                        break;
                }

                List<Data> listData;
                if (session.getAttribute("listData") == null) {
                    listData = new ArrayList<>();
                } else {
                    //Ep kieu cho session
                    listData = (List<Data>) session.getAttribute("listData");
                }
                Data x = new Data(n1, n2, op, rs);
                listData.add(x);
                session.setAttribute("listData", listData);
                session.setAttribute("n1", n1);
                session.setAttribute("n2", n2);
            } catch (NumberFormatException e) {
                err = "You must input number.";
            }
        } else {
            err = "Number must not be empty.";
        }
        session.setAttribute("errmess", err);
        request.getRequestDispatcher("tinhtoan.jsp")
                .forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
