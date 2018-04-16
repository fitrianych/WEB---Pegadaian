<%-- 
    Document   : jenis
    Created on : Apr 16, 2018, 4:41:47 PM
    Author     : Fitriany Chairunnisa
--%>

<%@page import="entities.JenisBarang"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jenis Barang</title>
    </head>
    <body>
       <table border ="1"</table>
         <thead>
                    <tr>
                        <th>ID Jenis</th>
                        <th>Jenis</th>
                        
                    </tr>
                </thead>
        <%
                //List<Object> datas = new CustomerDAO().getAll();
                
                List<Object> datas =(List<Object>) session.getAttribute("dataJenis");
            
            for (Object data : datas) {
                JenisBarang jb = (JenisBarang) data; %>
                  <tbody>
                    <tr>
                        <td><%= jb.getIdJenis()%></td>
                        <td><%= jb.getNamaJenis()%></td>

                    </tr>
                  
                </tbody>
           <% }
            %>
        
        
              
            </table>
            
    </body>
</html>
