<%-- 
    Document   : idgadaireport
    Created on : Apr 26, 2018, 1:17:06 AM
    Author     : Fitriany Chairunnisa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="tools.HibernateUtil"%>
<%@page import="org.hibernate.engine.jdbc.connections.spi.ConnectionProvider"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.io.File"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.HashMap"%>
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cetak PDF</title>
    </head>
    <body>
        <%
            try {
//                String path = "E://WEB//WebPegadaian//web//view//Report.jasper";
//                String path1 = "//view//laporan//Report.jasper";
//                String driver = "oracle.jdbc.OracleDriver";
//                String konek = "jdbc:oracle:thin:@localhost:1521:XE";
//                String user = "system";
//                String password = "password";
                HashMap parameter = new HashMap();
//                int nip = Integer.parseInt(request.getParameter("nip"));
                String idGadai = request.getParameter("idGadai");
                Integer IdGadai = Integer.parseInt(idGadai);
//                parameter.put("nip", nip);
                parameter.put("idGadai", IdGadai);
//                Class.forName(driver);
//                Connection conn = DriverManager.getConnection(konek, user, password);                
                Connection connection = HibernateUtil.getSessionFactory().getSessionFactoryOptions().getServiceRegistry().getService(ConnectionProvider.class).getConnection();
                File reportFile = new File(application.getRealPath("/view/laporan/Report.jasper"));
                byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameter, connection);

                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                ServletOutputStream outputStream = response.getOutputStream();
                outputStream.write(bytes, 0, bytes.length);
                outputStream.flush();
                outputStream.close();
            } catch (Exception e) {
                out.println("Error :" + e.getMessage());
            }

        %>
    </body>
</html>

