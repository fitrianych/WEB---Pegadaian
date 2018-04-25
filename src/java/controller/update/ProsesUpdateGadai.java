/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.update;

import dao.GadaiDAO;
import dao.SettingDAO;
import entities.Customer;
import entities.Gadai;
import entities.Setting;
import entities.Status;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
@WebServlet(name = "ProsesUpdateGadai", urlPatterns = {"/prosesupdategadai"})
public class ProsesUpdateGadai extends HttpServlet {

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
        String tanggal_pengajuan = request.getParameter("txtPengajuan");
        //String jatuh_tempo = request.getParameter("txtJatuhTempo");
        String jumlah_pinjaman = request.getParameter("txtPinjaman");
        String no_identitas = request.getParameter("txtIdentitas");
        String status = request.getParameter("txtStatus");
        HttpSession session = request.getSession();
        RequestDispatcher dis = null;
        String Pesan = "Gagal Update";
        GadaiDAO gdao = new GadaiDAO();

        String DATE_FORMAT = "yyyy-MM-dd";
        Date currentDate = new Date();

        LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        localDateTime = localDateTime.plusYears(0).plusMonths(4).plusDays(0);
        Date date_jt = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        Date date1 = null;
        //Date date2 = null;

        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(tanggal_pengajuan);
        } catch (ParseException ex) {
            Logger.getLogger(ProsesUpdateGadai.class.getName()).log(Level.SEVERE, null, ex);
        }

//        try {
//            date2 = new SimpleDateFormat("yyyy-MM-dd").parse(jatuh_tempo);
//        } catch (ParseException ex) {
//            Logger.getLogger(ProsesUpdateGadai.class.getName()).log(Level.SEVERE, null, ex);
//        }
        Setting pem1 = (Setting) new SettingDAO().search("nama", "Bunga").get(0);
        int bunga = pem1.getKeterangan();

        Setting pem = (Setting) new SettingDAO().search("nama", "Pembagi Bunga").get(0);
        int pembagi = pem.getKeterangan();

        double tambahan = Double.parseDouble(jumlah_pinjaman);
        double result = tambahan + (tambahan * (bunga / pembagi));
        Long result1 = new Double(result).longValue();

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            Gadai gad = new Gadai();
            gad.setIdGadai(Long.parseLong(id));
            gad.setTanggalPengajuan(date1);
            gad.setJatuhTempo(date_jt);
            //gad.setJumlahPinjaman(Long.parseLong(jumlah_pinjaman));
            gad.setJumlahPinjaman(result1);
            gad.setNoIdentitas(new Customer(Integer.parseInt(no_identitas)));
            gad.setIdStatus(new Status(status));

//            if () { 
//                out.println("<script src = 'https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
//                out.println("<script src = 'https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
//                out.println("<script>");
//                out.println("$(document).ready(function(){");
//                out.println("swal('Maaf!', 'Tidak Dapat Perpanjang !', 'error');");
//                out.println("});");
//                out.println("</script>");
//                dis = request.getRequestDispatcher("gadaiservlet");
//                dis.include(request, response);
//            }
            if (gdao.update(gad)) {
                Pesan = "Berhasil Update dengan id" + gad.getIdGadai();
            }
            //out.println(Pesan);
            session.setAttribute("Pesan", Pesan);
            dis = request.getRequestDispatcher("gadaiservlet");
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
