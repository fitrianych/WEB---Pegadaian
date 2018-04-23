/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import dao.CustomerDAO;
import entities.Customer;
import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "ReportServlet", urlPatterns = {"/reportservlet"})
public class ReportServlet extends HttpServlet {

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
        //response.setContentType("text/html;charset=UTF-8");

        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();
        RequestDispatcher dispatcher = null;
        HttpSession session = request.getSession();
        CustomerDAO cdao = new CustomerDAO();

        try {
            try {
                Document doc = new Document();
                PdfWriter.getInstance(doc, out);

                doc.open();

                Paragraph par1 = new Paragraph();
                Font fontitulo = new Font(Font.HELVETICA, 16, Font.BOLD, Color.BLACK);

//                Image img = Image.getInstance("E:\\Icon Pegadaian\\c12.png");
//                img.setAlignment(Element.ALIGN_TOP);
//                img.scaleToFit(200, 500);
//                doc.add(img);
                par1.add(new Phrase("Report Customer", fontitulo));
                par1.setAlignment(Element.ALIGN_CENTER);
                par1.add(new Phrase(Chunk.NEWLINE));
                par1.add(new Phrase(Chunk.NEWLINE));
                doc.add(par1);

                PdfPTable pTable = new PdfPTable(6);
                PdfPCell cell1 = new PdfPCell(new Paragraph("No Identitas", FontFactory.getFont("Arial", 12, Font.BOLD)));
                PdfPCell cell2 = new PdfPCell(new Paragraph("Nama", FontFactory.getFont("Arial", 12, Font.BOLD)));
                PdfPCell cell3 = new PdfPCell(new Paragraph("Jenis Kelamin", FontFactory.getFont("Arial", 12, Font.BOLD)));
                PdfPCell cell4 = new PdfPCell(new Paragraph("No Telepon", FontFactory.getFont("Arial", 12, Font.BOLD)));
                PdfPCell cell5 = new PdfPCell(new Paragraph("Pekerjaan", FontFactory.getFont("Arial", 12, Font.BOLD)));
                PdfPCell cell6 = new PdfPCell(new Paragraph("Alamat", FontFactory.getFont("Arial", 12, Font.BOLD)));

                pTable.addCell(cell1);
                pTable.addCell(cell2);
                pTable.addCell(cell3);
                pTable.addCell(cell4);
                pTable.addCell(cell5);
                pTable.addCell(cell6);

                List<Object> datas = new CustomerDAO().getAll();
                for (Object data : datas) {
                    Customer cu = (Customer) data;
                    pTable.addCell(cu.getNoIdentitas().toString());
                    pTable.addCell(cu.getNama());
                    pTable.addCell(cu.getJenisKelamin());
                    pTable.addCell(cu.getNoTelp());
                    pTable.addCell(cu.getPekerjaan());
                    pTable.addCell(cu.getAlamat());
                    
                }
                doc.add(pTable);
                
                doc.close();
            } catch (Exception e) {
                e.getMessage();
            }
        } finally {
            out.close();
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
