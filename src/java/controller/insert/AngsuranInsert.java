/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.insert;

import dao.AngsuranDAO;
import dao.GadaiDAO;
import entities.Angsuran;
import entities.Customer;
import entities.Gadai;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
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
@WebServlet(name = "AngsuranInsert", urlPatterns = {"/angsuraninsert"})
public class AngsuranInsert extends HttpServlet {

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

        String no_transaksi = request.getParameter("txtNoTransaksi");
        String no_identitas = request.getParameter("txtNoIdentitas");
        // String nama = request.getParameter("txtNama");
        String id_gadai = request.getParameter("txtIdGadai");
        String pinjaman = request.getParameter("txtPinjaman");
        String tgl_pengajuan = request.getParameter("txtTglPengajuan");
        String jatuh_tempo = request.getParameter("txtTglJatuhTempo");
        String tgl_angsuran = request.getParameter("txtTglAngsuran");
        String jml_angsuran = request.getParameter("txtJmlAngsuran");

        HttpSession session = request.getSession();
        RequestDispatcher dis = null;
        String Pesan = "Gagal Insert";
        AngsuranDAO bdao = new AngsuranDAO();
        Angsuran a = new Angsuran();
        GadaiDAO gdao = new GadaiDAO();
        Gadai g = new Gadai();
        Date date1 = null;

        DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        //String jatuh_tempo = request.getParameter(g.getJatuhTempo() + "");

        Date date2 = null;

        Date date3 = null;

        try {
            date1 = (Date) date.parse(tgl_angsuran);
        } catch (ParseException ex) {
            Logger.getLogger(AngsuranInsert.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            date2 = (Date) date.parse(jatuh_tempo);
        } catch (ParseException ex) {
            Logger.getLogger(AngsuranInsert.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            date3 = (Date) date.parse(tgl_pengajuan);
        } catch (ParseException ex) {
            Logger.getLogger(AngsuranInsert.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (PrintWriter out = response.getWriter()) {

            a.setIdAngsuran(no_transaksi);
            a.setNoIdentitas(new Customer(Integer.parseInt(no_identitas)));
            a.setIdGadai(new Gadai(Long.parseLong(id_gadai)));

            a.setTanggalAngsuran(date1);
            a.setJumlahAngsuran(Long.parseLong(jml_angsuran));

            long bedaHari = (date1.getTime() - date2.getTime());
            long days = TimeUnit.MILLISECONDS.toDays(bedaHari);

            Long pinjam = Long.parseLong(pinjaman);
            System.out.println(days);

            if (days >= 7) {
                //long denda = (long) (TimeUnit.MILLISECONDS.toDays(bedaHari));

                //double total_denda = days * new Double(0.01).longValue() * pinjam;
                double total_denda = days * 0.01 * pinjam;
                a.setDenda(new Double(total_denda).longValue());
            } else {
                a.setDenda(Long.valueOf(0));
                System.out.println("tidak ada denda");
            }
            double x = Double.parseDouble(a.getDenda() + "");
            double y = Double.parseDouble(a.getJumlahAngsuran() + "");
            double hasil = x + y;
            a.setTotal(new Double(hasil).longValue());

            if (bdao.insert(a)) {
                Pesan = "Berhasil Insert dengan id" + a.getIdAngsuran();

                boolean cek = cek(id_gadai);
                if (cek) {
                    gdao.update(id_gadai, "a");

                }

            }

//            if (bdao.update(a)) {
//            }
            out.println(Pesan);
            dis = request.getRequestDispatcher("view/insert/insertangsuran.jsp");
            dis.include(request, response);

        }
    }

    public boolean cek(String id) {
        Gadai gadai = (Gadai) new GadaiDAO().getById(id);
        if (gadai.getJumlahPinjaman() == 0) {
            System.out.println("LUNAS");
            return true;
        } else {
            System.out.println("BELUM LUNAS");
            return false;
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
