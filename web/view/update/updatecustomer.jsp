<%-- 
    Document   : updatecustomer
    Created on : Apr 17, 2018, 9:22:25 AM
    Author     : Fitriany Chairunnisa
--%>

<%@page import="entities.Customer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Customer</title>
    </head>
    <body>
        <% Customer cuss = (Customer) session.getAttribute("cus");%>
        <form role="form" action="prosesupdatecustomer" method="post">
            <div class="form-group">
                <label>No. Identitas</label>
                <input class="form-control" name="txtID" readonly="true" type="text" value="<%= cuss.getNoIdentitas()%>">

            </div>

            <div class="form-group">
                <label>Nama</label>
                <input class="form-control" name="txtNama" type="text" value="<%= cuss.getNama()%>">
                <!--                                            <p class="help-block">Example block-level help text here.</p>-->
            </div>

            <div class="form-group">
                <label>Jenis Kelamin</label>
                <input class="form-control" name="txtJK" type="text" value="<%= cuss.getJenisKelamin()%>">
                <!--                                            <p class="help-block">Example block-level help text here.</p>-->
            </div>

            <div class="form-group">
                <label>No. Telp</label>
                <input class="form-control" name="txtNoTelp" type="text" value="<%= cuss.getNoTelp()%>">
                <!--                                            <p class="help-block">Example block-level help text here.</p>-->
            </div>

            <div class="form-group">
                <label>Pekerjaan</label>
                <input class="form-control" name="txtPekerjaan" type="text" value="<%= cuss.getPekerjaan()%>">
                <!--                                            <p class="help-block">Example block-level help text here.</p>-->
            </div>

            <div class="form-group">
                <label>Alamat</label>
                <input class="form-control" name="txtAlamat" type="text" value="<%= cuss.getAlamat()%>">
                <!--                                            <p class="help-block">Example block-level help text here.</p>-->
            </div>



            <div class="form-group">
                <input type="submit" value="Update" name="submit">
            </div>


        </form>
    </body>
</html>
