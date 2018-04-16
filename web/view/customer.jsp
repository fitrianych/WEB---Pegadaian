<%-- 
    Document   : customer
    Created on : Apr 16, 2018, 1:16:43 PM
    Author     : Fitriany Chairunnisa
--%>

<%@page import="entities.Customer"%>
<%@page import="dao.CustomerDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lihat Customer<table border="1">
               
        </title>
    </head>
    <body>
        <table border ="1"</table>
         <thead>
                    <tr>
                        <th>No. Identitas</th>
                        <th>Nama</th>
                        <th>Jenis Kelamin</th>
                        <th>No Telp</th>
                        <th>Pekerjaan</th>
                        <th>Alamat</th>
                    </tr>
                </thead>
        <%
                //List<Object> datas = new CustomerDAO().getAll();
                
                List<Object> datas =(List<Object>) session.getAttribute("dataCustomer");
            
            for (Object data : datas) {
                Customer c = (Customer) data; %>
                  <tbody>
                    <tr>
                        <td><%= c.getNoIdentitas()%></td>
                        <td><%= c.getNama()%></td>
                        <td><%= c.getJenisKelamin()%></td>
                        <td><%= c.getNoTelp()%></td>
                        <td><%= c.getPekerjaan()%></td>
                        <td><%= c.getAlamat()%></td>
                    </tr>
                  
                </tbody>
           <% }
            %>
        
        
              
            </table>
            
            <a href="..\customerservlet">test</a>
    </body>
</html>
