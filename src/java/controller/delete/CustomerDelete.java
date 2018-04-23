/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.delete;

import dao.CustomerDAO;
import entities.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fitriany Chairunnisa
 */
@WebServlet(name = "CustomerDelete", urlPatterns = {"/customerdelete"})
public class CustomerDelete extends HttpServlet {

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

        String id = request.getParameter("id");
        RequestDispatcher dis = null;
        HttpSession sesi = request.getSession();
        String Pesan = "Gagal Hapus";
        CustomerDAO cdao = new CustomerDAO();
        try (PrintWriter out = response.getWriter()) {

//            Customer cstm = new Customer();
//            cstm.setNoIdentitas(Integer.parseInt(id));
//             out.println("<b>"+id);
            out.println("<script src = 'https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
            out.println("<script src = 'https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            out.println("<script>");
            out.println("$(document).ready(function(){");
            out.println("swal({\n"
                    + "            title: \"Are you sure to delete ?\",\n"
                    + "            text: \"You will not be able to recover this imaginary file !!\",\n"
                    + "            type: \"warning\",\n"
                    + "            showCancelButton: true,\n"
                    + "            confirmButtonColor: \"#DD6B55\",\n"
                    + "            confirmButtonText: \"Yes, delete it !!\",\n"
                    + "            cancelButtonText: \"No, cancel it !!\",\n"
                    + "            closeOnConfirm: false,\n"
                    + "            closeOnCancel: false\n"
                    + "        },\n"
                    + "        function(isConfirm){\n"
                    + "            if (isConfirm) {\n"
                    + "                swal(\"Deleted !!\", \"Hey, your imaginary file has been deleted !!\", \"success\");\n"
                    + "            }\n"
                    + "            else {\n"
                    + "                swal(\"Cancelled !!\", \"Hey, your imaginary file is safe !!\", \"error\");\n"
                    + "            }\n"
                    + "        });");
            out.println("});");
            out.println("</script>");

            if (cdao.delete(id)) {
                Pesan = "Berhasil Delete dengan id" + id;

            }

            sesi.setAttribute("Pesan", Pesan);
            dis = request.getRequestDispatcher("customerservlet");
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
