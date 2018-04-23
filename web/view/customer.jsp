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
                <div class="navbar-default sidebar" role="navigation">
                    <div class="sidebar-nav navbar-collapse">
                        <ul class="nav" id="side-menu">
                            <!--                            <li class="sidebar-search">
                                                            <div class="input-group custom-search-form">
                                                                <input type="text" class="form-control" placeholder="Search...">
                                                                <span class="input-group-btn">
                                                                    <a href="searchcustomer" class="btn btn-default" type="button">
                                                                        <i class="fa fa-search"></i>
                                                                    </a>
                                                                </span>
                                                            </div>
                                                        </li>-->
                            <li>
                                <a href="template/pages/index.html"><i class="fa fa-backward fa-fw"></i> Dashboard</a>
                            </li>
                        </ul>
                    </div>
                </div>

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
                            <a href="customertoinsert" class="btn btn-primary">Add Customer</a>
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
                                        <th>Update</th>
                                        <th>Delete</th>
                                    </tr>
                                </thead>
                                <%
                                    //List<Object> datas = new CustomerDAO().getAll();

                                    List<Object> datas = (List<Object>) session.getAttribute("dataCustomer");

                                    for (Object data : datas) {
                                        Customer c = (Customer) data;%>

                                <tr class="odd gradeX">
                                    <td><%= c.getNoIdentitas()%></td>
                                    <td><%= c.getNama()%></td>
                                    <td><%= c.getJenisKelamin()%></td>
                                    <td><%= c.getNoTelp()%></td>
                                    <td><%= c.getPekerjaan()%></td>
                                    <td><%= c.getAlamat()%></td>
                                    <td><a href="customerupdate?id=<%=c.getNoIdentitas()%>">update</a></td>
                                    <td><a href="${pageContext.request.contextPath}/customerdelete?id=<%=c.getNoIdentitas()%>">delete</a></td>
                                </tr>


                                <% }
                                %>



                            </table>
                        </div>
                    </div>
<!--                    <form name="report" action="reportservlet">
                        <input type="submit" value="Print Data Customer" name="btnver" class="btn btn-primary">
                    </form>  -->
                </div>           

            </div>
            <!--            <div class="row">
                            <div class="col-lg-12">
                                <h1 class="page-header">Form Customer</h1>
                            </div>
                        </div> -->
            <!--            <form role="form" action="customerinsert" method="post">
                            <div class="form-group">
                                <label>No. Identitas</label>
                                <input class="form-control"  name="txtID" type="text" >
                                                                            <p class="help-block">Example block-level help text here.</p>
                            </div>
            
                            <div class="form-group">
                                <label>Nama</label>
                                <input class="form-control" name="txtNama" type="text">
                                                                            <p class="help-block">Example block-level help text here.</p>
                            </div>
            
                            <div class="form-group">
                                <label>Jenis Kelamin</label>
                                <input class="form-control" name="txtJK" type="text">
                                                                            <p class="help-block">Example block-level help text here.</p>
                            </div>
            
                            <div class="form-group">
                                <label>No. Telp</label>
                                <input class="form-control" name="txtNoTelp" type="text">
                                                                            <p class="help-block">Example block-level help text here.</p>
                            </div>
            
                            <div class="form-group">
                                <label>Pekerjaan</label>
                                <input class="form-control" name="txtPekerjaan" type="text">
                                                                            <p class="help-block">Example block-level help text here.</p>
                            </div>
            
                            <div class="form-group">
                                <label>Alamat</label>
                                <input class="form-control" name="txtAlamat" type="text">
                                                                            <p class="help-block">Example block-level help text here.</p>
                            </div>
            
            
            
                            <div class="form-group">
                                                    <button type="button" name="submit" class="btn btn-primary">Tambah</button>
                                <input type="submit" class="btn btn-primary" value="Insert" name="submit">
                            </div>
                        </form>-->
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
            $(document).ready(function () {
                $('#dataTables-example').DataTable({
                    responsive: true
                });
            });
        </script>


    </body>
</html>
