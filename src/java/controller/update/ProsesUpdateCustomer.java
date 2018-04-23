/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.update;

import dao.CustomerDAO;
import entities.Customer;
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

/**
 *
 * @author Fitriany Chairunnisa
 */
@WebServlet(name = "ProsesUpdateCustomer", urlPatterns = {"/prosesupdatecustomer"})
public class ProsesUpdateCustomer extends HttpServlet {

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
        String nama = request.getParameter("txtNama");
        String jenis_kelamin = request.getParameter("txtJK");
        String no_telp = request.getParameter("txtNoTelp");
        String pekerjaan = request.getParameter("txtPekerjaan");
        String alamat = request.getParameter("txtAlamat");

        HttpSession session = request.getSession();
        RequestDispatcher dis = null;
        String Pesan = "Gagal Update";
        CustomerDAO cdao = new CustomerDAO();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Customer cst = new Customer();
//          cst.setNoIdentitas(BigDecimal.valueOf(Long.valueOf(id)));
            cst.setNoIdentitas(Integer.parseInt(id));
            cst.setNama(nama);
            cst.setJenisKelamin(jenis_kelamin);
            cst.setNoTelp(no_telp);
            cst.setPekerjaan(pekerjaan);
            cst.setAlamat(alamat);

            if (cdao.update(cst)) {
                //Pesan = "Berhasil Update dengan id" +cst.getNoIdentitas();
                out.println("<script src = 'https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                out.println("<script src = 'https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println("swal('Good job!', 'Berhasil Update Data!', 'success');");
                out.println("});");
                out.println("</script>");
                dis = request.getRequestDispatcher("view/update/updatecustomer.jsp");
                dis.include(request, response);
            } else {
                //out.println(id+", "+jenis);

                out.println("<script src = 'https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                out.println("<script src = 'https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println("swal('Oops...', 'Gagal Update Data !!', 'error');");
                out.println("});");
                out.println("</script>");
                //out.println(Pesan);
                dis = request.getRequestDispatcher("view/update/updatecustomer.jsp");
                dis.include(request, response);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
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
