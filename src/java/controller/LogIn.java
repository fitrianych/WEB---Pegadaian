/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserManagementDAO;
import entities.Usermanagement;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fitriany Chairunnisa
 */
public class LogIn extends HttpServlet {

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

        String ID = request.getParameter("ID");
        String password = request.getParameter("password");
        RequestDispatcher dispatcher = null;
        HttpSession session = request.getSession();
        String category = "id";
        String er = "";
        Usermanagement u = (Usermanagement) new UserManagementDAO().getById(ID);

        UserManagementDAO udao = new UserManagementDAO();
        try (PrintWriter out = response.getWriter()) {
            if (ID.equals("") || password.equals("")) {
                er = "Login Gagal";
                dispatcher = request.getRequestDispatcher("log.jsp");
            } else if (udao.search(category, ID).isEmpty()) {
                er = "Login Gagal";
                dispatcher = request.getRequestDispatcher("log.jsp");
            } else if (!udao.login(ID, password)) {
                er = "Login Gagal";
                dispatcher = request.getRequestDispatcher("log.jsp");
            } else if (udao.login(ID, password)) {
                if (u.getAkses().equals("manajer")) {
                    er = "Berhasil";
                    dispatcher = request.getRequestDispatcher("view/index1.jsp");
                } else {
                    dispatcher = request.getRequestDispatcher("view/index.jsp");
                }

            }
           // session.setAttribute("er", er);
            //out.println(ID);
            session.setAttribute("login", ID);
            session.setAttribute("login1", password);
            session.setAttribute("u", u);
            dispatcher.include(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
