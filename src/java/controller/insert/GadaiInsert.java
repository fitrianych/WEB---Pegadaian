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
        //String tanggal_pengajuan = request.getParameter("txtPengajuan");
        //String jatuh_tempo = request.getParameter("txtJatuhTempo");
        String jumlah_pinjaman = request.getParameter("txtPinjaman");
        // String status = request.getParameter("txtStatus");
        HttpSession session = request.getSession();
        RequestDispatcher dis = null;
        String Pesan = "Gagal Insert Data";
        GadaiDAO gdao = new GadaiDAO();
        Detail_GadaiDAO dgdao = new Detail_GadaiDAO();

        String DATE_FORMAT = "yyyy-MM-dd";
        Date currentDate = new Date();

        LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        localDateTime = localDateTime.plusYears(0).plusMonths(4).plusDays(0);
        Date date_jt = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        //Date date1 = null;
        // Date date2 = null;
        //Date date2 = null;
//        try {
//            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(tanggal_pengajuan);
//        } catch (ParseException ex) {
//            Logger.getLogger(GadaiInsert.class.getName()).log(Level.SEVERE, null, ex);
//        }
        //Date date2 = null;
//        try {
//           
//           Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(jt);
//        } catch (ParseException ex) {
//            Logger.getLogger(GadaiInsert.class.getName()).log(Level.SEVERE, null, ex);
//        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //gad.setTanggalPengajuan(date1);
//        try {
//           // int jml = 120;
//          Date date11 = new SimpleDateFormat("yyyy-MM-dd").parse("000-04-00"); 
//           long jt = date1.getTime() + date11.getTime();
//           Date date3 = new Date(jt);
//           SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
//           String dateText = df2.format(date3);
//           Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dateText);
//            System.out.println(dateText);
//           
//           gad.setJatuhTempo(date2);
//        } catch (ParseException ex) {
//            Logger.getLogger(GadaiInsert.class.getName()).log(Level.SEVERE, null, ex);
//        }
//            gad.setJatuhTempo(date2);

            Gadai gad = new Gadai();
            gad.setIdGadai(Long.parseLong(id));
            gad.setNoIdentitas(new Customer(Integer.parseInt(no_identitas)));
            gad.setTanggalPengajuan(currentDate);
            gad.setJatuhTempo(date_jt);

            gad.setJumlahPinjaman(Long.parseLong(jumlah_pinjaman));
            gad.setIdStatus(new Status("b"));

           
            if (gdao.update(gad)) {
                //Pesan = "Berhasil Insert dengan id" + gad.getIdGadai();

                out.println("<script src = 'https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                out.println("<script src = 'https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println("swal('Good job!', 'Berhasil Menambahkan Data!', 'success');");
                out.println("});");
                out.println("</script>");

                session.setAttribute("gdao", gdao.getById(id));
                dis = request.getRequestDispatcher("view/insert/insertdetailgadai.jsp");
                dis.include(request, response);
            } else {
                //out.println(id+", "+jenis);

                out.println("<script src = 'https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                out.println("<script src = 'https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                out.println("<script>");
                out.println("$(document).ready(function(){");
                out.println("swal('Oops...', 'Gagal Menambahkan Data !!', 'error');");
                out.println("});");
                out.println("</script>");
                //out.println(Pesan);

                // session.setAttribute("autoID", dgdao.getAutoID());
                session.setAttribute("gdao", gdao.getById(id));
                dis = request.getRequestDispatcher("view/insert/insertdetailgadai.jsp");
                dis.include(request, response);
            }
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
