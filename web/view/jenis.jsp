<%-- 
    Document   : jenis
    Created on : Apr 16, 2018, 4:41:47 PM
    Author     : Fitriany Chairunnisa
--%>

<%@page import="dao.Jenis_BarangDAO"%>
<%@page import="entities.JenisBarang"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
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
                            <li class="sidebar-search">
                                <div class="input-group custom-search-form">
                                    <input type="text" class="form-control" placeholder="Search...">
                                    <span class="input-group-btn">
                                        <button class="btn btn-default" type="button">
                                            <i class="fa fa-search"></i>
                                        </button>
                                    </span>
                                </div>
                            </li>
                            <li>
                                <a href="./login?ID=<%= session.getAttribute("login")%>&password=<%=session.getAttribute("login1")%>"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>

                            </li>
                            <li>
                                <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Master<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="./customerservlet">Customer</a>
                                    </li>
                                    <li>
                                        <a href="./gadaiservlet">Gadai</a>
                                    </li>
                                    <li>
                                        <a href="./angsuranservlet">Angsuran</a>
                                    </li>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>

                            <li>
                                <a href="#"><i class="fa fa-database"></i> Barang<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="./jenisservlet">Jenis Barang</a>
                                    </li>
                                    <li>
                                        <a href="./barangservlet">List Barang</a>
                                    </li>
                                    <li>
                                        <a href="./detailgadaiservlet">Detail Barang</a>
                                    </li>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>

                            <li>
                                <a href="#"><i class="fa fa-file-pdf-o"></i> Report<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="./reportservlet">Customer</a>
                                    </li>
                                    <li>
                                        <a href="./reportangsuran">Angsuran</a>
                                    </li>
                                    <li>
                                        <a href="./reportgadai">Gadai</a>
                                    </li>
                                    <li>
                                        <a href="morris.html">Filter</a>
                                    </li>
                                </ul>
                                <!-- /.nav-second-level -->
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
                    <h1 class="page-header">Tabel Jenis Barang</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>    

            <div class="row"> 

                <div class="col-lg-12">
                    <div class="panel panel-default">

                        <div class="panel-heading">
                            <!--                            <a href="jenistoinsert" class="btn btn-primary">Add Jenis</a>-->
                            <button data-toggle="modal" data-target="#myModal" class="btn btn-primary btn-circle"><i class="fa fa-plus"></i></button>
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Form Jenis</h4>
                                        </div>
                                        <% int autoid = new Jenis_BarangDAO().getAutoID();%>
                                        <form role="form" action="jenisinsert" method="post">
                                            <input class="form-control hidden"  name="txtID" type="text" value="<%= autoid%>"> 
                                            <div class="modal-body">
                                                <div class="form-group">
                                                    <label>Jenis</label>
                                                    <input class="form-control" name="txtJenis" type="text">
                                                </div>
                                                <div class="form-group">

                                                    <input type="submit" class="btn btn-primary" value="Insert" name="submit">
                                                    <a href="jenisservlet" class="btn btn-danger">Cancel</a>
                                                </div>
                                            </div>

                                        </form>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">

                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <%if (session.getAttribute("Pesan") != null) { %>
                                <div class="alert alert-success alert-dismissable">  
                                    <%out.print(session.getAttribute("Pesan") + "<br>");
                                        session.removeAttribute("Pesan"); %> 
                                </div>

                                <% }%>     

                                <thead>
                                    <tr>
                                        <th>ID Jenis</th>
                                        <th>Jenis</th>
                                        <th>Aksi</th>                        
                                    </tr>
                                </thead>
                                <%
                                    List<Object> datas = (List<Object>) session.getAttribute("dataJenis");

                                    for (Object data : datas) {
                                        JenisBarang jb = (JenisBarang) data;%>
                                <tbody>
                                    <tr>
                                        <td><%= jb.getIdJenis()%></td>
                                        <td><%= jb.getNamaJenis()%></td>
                                        <td>
<!--                                            <a href="jenisupdate?id=<%--jb.getIdJenis()--%>"class="btn btn-warning btn-circle"><i class="fa fa-edit"></i></a>                              -->
                                            <button data-toggle="modal" data-target="#myModaledit<%=jb.getIdJenis()%>" class="btn btn-warning btn-circle"><i class="fa fa-edit"></i></button>
                                            <button data-toggle="modal" data-target="#myModal<%=jb.getIdJenis()%>" class="btn btn-danger btn-circle"><i class="fa fa-times"></i></button>
                                        </td>

                                    </tr>

                                <div class="modal fade" id="myModaledit<%=jb.getIdJenis()%>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title" id="myModalLabel">Update Jenis</h4>
                                            </div>
                                            <div class="modal-body">
                                                <% JenisBarang jnss = (JenisBarang) new Jenis_BarangDAO().getById(jb.getIdJenis().toString());%>
                                                <form role="form" action="${pageContext.request.contextPath}/prosesupdatejenis" method="post">
                                                    <div class="form-group">
                                                        <label>ID Jenis</label>
                                                        <input class="form-control" name="txtID" readonly="true" type="text" value="<%= jnss.getIdJenis()%>">

                                                    </div>

                                                    <div class="form-group">
                                                        <label>Jenis</label>
                                                        <input class="form-control" name="txtJenis" type="text" value="<%= jnss.getNamaJenis()%>">

                                                    </div>


                                                    <div class="form-group">
                                                        <input type="submit" value="Update" class="btn btn-primary" name="submit">
                                                        <a href="jenisservlet" class="btn btn-danger">Cancel</a>
                                                    </div>


                                                </form>
                                            </div>

                                        </div>
                                        <!-- /.modal-content -->
                                    </div>
                                    <!-- /.modal-dialog -->
                                </div>


                                <div class="modal fade" id="myModal<%=jb.getIdJenis()%>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title" id="myModalLabel">Delete</h4>
                                            </div>
                                            <div class="modal-body">
                                                Are You Sure to Delete?
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" data-dismiss="modal" class="btn btn-primary">Cancel</button>
                                                <a href="jenisdelete?id=<%=jb.getIdJenis()%>" type="button" class="btn btn-danger">Delete</a>
                                            </div>
                                        </div>
                                        <!-- /.modal-content -->
                                    </div>
                                    <!-- /.modal-dialog -->
                                </div>


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
            $(document).ready(function () {
                $('#dataTables-example').DataTable({
                    responsive: true
                });
            });
        </script>

    </body>
</html>
