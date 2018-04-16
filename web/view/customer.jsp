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
<html lang="en">
    <head>
<!--        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lihat Customer<table border="1">
               
        </title>-->

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Pegadaian v1.0</title>

    <!-- Bootstrap Core CSS -->
    <link href="template/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="template/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="template/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="template/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="template/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="template/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->   <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Pegadaian v1.0</title>

    <!-- Bootstrap Core CSS -->
    <link href="template/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="template/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="template/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="template/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="template/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="template/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
        
    </head>
    <body>
        <div id="wrapper">
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Pegadaian v1.0</a>
            </div>
            <!-- /.navbar-header -->

           
            <!-- /.navbar-top-links -->

            
            <!-- /.navbar-static-side -->
        </nav>
        </div>   
        
    <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Tabel Customer</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>    
    
    <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Customer
                        </div>
                         <!-- /.panel-heading -->
                        <div class="panel-body">
        <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
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
                    <tr class="odd gradeX">
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
                        </div>
                    </div>
                </div>
    </div>
    </div>
            
            <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="template/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="template/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="template/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="template/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="template/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="template/vendor/datatables-responsive/dataTables.responsive.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="template/dist/js/sb-admin-2.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>
            
            
    </body>
</html>
