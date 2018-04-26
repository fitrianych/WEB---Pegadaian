<%-- 
    Document   : idcustomerreport
    Created on : Apr 26, 2018, 10:06:40 AM
    Author     : Fitriany Chairunnisa
--%>

<%@page import="org.hibernate.engine.jdbc.connections.spi.ConnectionProvider"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.File"%>
<%@page import="tools.HibernateUtil"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                String no_identitas = request.getParameter("no_identitas");
                Integer no_identitass = Integer.parseInt(no_identitas);
//                parameter.put("nip", nip);
                parameter.put("no_identitas", no_identitass);
//                Class.forName(driver);
//                Connection conn = DriverManager.getConnection(konek, user, password);                
                Connection connection = HibernateUtil.getSessionFactory().getSessionFactoryOptions().getServiceRegistry().getService(ConnectionProvider.class).getConnection();
                File reportFile = new File(application.getRealPath("/view/laporan/CustomerReport.jasper"));
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
