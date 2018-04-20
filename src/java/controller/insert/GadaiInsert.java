/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.insert;

import dao.Detail_GadaiDAO;
import dao.GadaiDAO;
import entities.Customer;
import entities.Gadai;
import entities.Status;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "GadaiInsert", urlPatterns = {"/gadaiinsert"})
public class GadaiInsert extends HttpServlet {

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
        String no_identitas = request.getParameter("txtIdentitas");
        String tanggal_pengajuan = request.getParameter("txtPengajuan");
        String jatuh_tempo = request.getParameter("txtJatuhTempo");
        String jumlah_pinjaman = request.getParameter("txtPinjaman");
       // String status = request.getParameter("txtStatus");
        HttpSession session = request.getSession();
        RequestDispatcher dis = null;
        String Pesan = "Gagal Insert Data";
        GadaiDAO gdao = new GadaiDAO();
        Detail_GadaiDAO dgdao = new Detail_GadaiDAO();

        Date date1 = null;
        Date date2 = null;

        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(tanggal_pengajuan);
        } catch (ParseException ex) {
            Logger.getLogger(GadaiInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        try {
            date2 = new SimpleDateFormat("yyyy-MM-dd").parse(jatuh_tempo);
        } catch (ParseException ex) {
            Logger.getLogger(GadaiInsert.class.getName()).log(Level.SEVERE, null, ex);
        }
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */

                Gadai gad = new Gadai();
                gad.setIdGadai(Long.parseLong(id));
                gad.setNoIdentitas(new Customer(Integer.parseInt(no_identitas)));
                gad.setTanggalPengajuan(date1);
                gad.setJatuhTempo(date2);
                gad.setJumlahPinjaman(Long.parseLong(jumlah_pinjaman));
                gad.setIdStatus(new Status("b"));

                if (gdao.update(gad)) {
                    Pesan = "Berhasil Insert dengan id" + gad.getIdGadai();
                }
                out.println(Pesan);
                           // session.setAttribute("autoID", dgdao.getAutoID());
                            session.setAttribute("gdao", gdao.getById(id));
                dis = request.getRequestDispatcher("view/insert/insertdetailgadai.jsp");
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
