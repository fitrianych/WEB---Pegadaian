/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.insert;

import dao.UserManagementDAO;
import entities.Usermanagement;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tools.BCrypt;

/**
 *
 * @author Fitriany Chairunnisa
 */
@WebServlet(name = "AdminInsert", urlPatterns = {"/admininsert"})
public class AdminInsert extends HttpServlet {

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

        String id = request.getParameter("txtID");
        String username = request.getParameter("txtusername");
        String password = request.getParameter("txtpassword");

        HttpSession session = request.getSession();
        RequestDispatcher dis = null;
        String Pesan = "Gagal Insert Data";
        UserManagementDAO udao = new UserManagementDAO();
        try (PrintWriter out = response.getWriter()) {
//            Usermanagement u = new Usermanagement();
//            u.setId(BigDecimal.valueOf(new Long(id)));
//            u.setUsername(usermane);
//            u.setPassword(pasword);
//            u.setAkses("admin");
            Usermanagement um = new Usermanagement(BigDecimal.valueOf(new Long(id)),
                    username, BCrypt.hashpw(password, BCrypt.gensalt()), "admin"); //salt = seperti key nya

            if (udao.insert(um)) {
                Pesan = "Berhasil Insert dengan id = " + um.getId();
//                session.setAttribute("gdao", udao.getById(id));
//                session.setAttribute("Pesan", Pesan);
            }
            session.setAttribute("Pesan", Pesan);
            dis = request.getRequestDispatcher("adminservlet");
            dis.include(request, response);
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
