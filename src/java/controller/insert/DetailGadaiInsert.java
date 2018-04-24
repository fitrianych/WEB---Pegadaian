/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.insert;

import dao.BarangDAO;
import dao.Detail_GadaiDAO;
import dao.GadaiDAO;
import entities.Barang;
import entities.DetailGadai;
import entities.Gadai;
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
@WebServlet(name = "DetailGadaiInsert", urlPatterns = {"/detailgadaiinsert"})
public class DetailGadaiInsert extends HttpServlet {

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

        String id_detail = request.getParameter("txtIdDetail");
        String[] barang = request.getParameterValues("txtBarang");
        String id_gadai = request.getParameter("txtIdGadai");
        String keterangan = request.getParameter("txtKeterangan");
        HttpSession session = request.getSession();
        RequestDispatcher dis = null;
        String Pesan = "Gagal Insert Data";
        Detail_GadaiDAO gdao = new Detail_GadaiDAO();
        BarangDAO bdao = new BarangDAO();
        try (PrintWriter out = response.getWriter()) {
            DetailGadai dgad = new DetailGadai();
            // dgad.setIdDetailGadai(Short.parseShort(id_detail));
            //dgad.setIdBarang(new Barang(Short.parseShort(barang)));

            dgad.setKeterangan(keterangan);

//            if (barang.length > 0) {
            for (int i = 0; i < barang.length; i++) {
                int id_detail_gadai = Integer.parseInt(id_detail) + i;
                dgad.setIdDetailGadai(Short.parseShort(id_detail_gadai + ""));
                dgad.setIdBarang(new Barang(Short.parseShort(barang[i])));
                dgad.setIdGadai(new Gadai(Long.parseLong(id_gadai)));
                System.out.println(barang[i]);
                if (gdao.insert(dgad)) {
//                    System.out.println("berhasil");
                    Pesan = "Berhasil Insert dengan id" + dgad.getIdDetailGadai();

                } 
                session.setAttribute("Pesan", Pesan);
                    dis = request.getRequestDispatcher("gadaiservlet");
                    dis.include(request, response);
                }
            
//            for (int i = 0; i < barang.length; i++) {
//                System.out.println(barang[i]);
//            }

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
