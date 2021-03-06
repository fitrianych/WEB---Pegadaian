<%-- 
    Document   : index
    Created on : Apr 24, 2018, 11:03:20 AM
    Author     : Fitriany Chairunnisa
--%>

<%@page import="entities.Usermanagement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Pegadaian v1.0</title>

        <!-- Bootstrap Core CSS -->
        <link href="./template/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="./template/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

        <!-- DataTables CSS -->
        <link href="./template/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

        <!-- DataTables Responsive CSS -->
        <link href="./template/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="./template/dist/css/sb-admin-2.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="./template/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

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
        <link href="./template/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="./template/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

        <!-- DataTables CSS -->
        <link href="./template/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

        <!-- DataTables Responsive CSS -->
        <link href="./template/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="./template/dist/css/sb-admin-2.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="./template/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

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
                    <%if (session.getAttribute("Pesan") != null) { %>
                    <div class="alert alert-success alert-dismissable">  
                        <%out.print(session.getAttribute("Pesan") + "<br>");
                            session.removeAttribute("Pesan"); %> 
                    </div>

                    <% }%> 

                </div>
                <!-- /.navbar-header -->
                <% Usermanagement us = (Usermanagement) session.getAttribute("u");%>
                <ul class="nav navbar-top-links navbar-right">
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                            <i>Hi, <%=us.getUsername()%></i>
                        </a>


                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="./logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>


                            </li>
                        </ul>
                        <!-- /.dropdown-user -->
                    </li>
                    <!-- /.dropdown -->
                </ul>

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
                                <!-- /input-group -->
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
                                        <a href="idgadaireport">By Id Gadai</a>
                                    </li>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>

                        </ul>
                    </div>
                    <!-- /.sidebar-collapse -->
                </div>
                <!-- /.navbar-static-side -->
            </nav>

            <div id="page-wrapper">                            
                <div class="row">
                    <div class="col-lg-12">

                        <h1>
                            <marquee behavior="alternate" class="page-header">Welcome, <%=us.getUsername()%>
                            </marquee>
                        </h1>
                    </div>
                </div>
                <!-- /.col-lg-12 -->

                <!-- /.row -->
                <div class="row">
                    <!-- Bootstrap CSS -->
                    <!DOCTYPE html>
                    <title>My Example</title>

                    <!-- Bootstrap CSS -->
                    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
                    <div class="container-fluid">

                        <!-- Carousel container -->
                        <div id="my-pics" class="carousel slide" data-ride="carousel" style="width:800px;margin:auto;">

                            <!-- Indicators -->
                            <ol class="carousel-indicators">
                                <li data-target="#my-pics" data-slide-to="0" class="active"></li>
                                <li data-target="#my-pics" data-slide-to="1"></li>
                                <li data-target="#my-pics" data-slide-to="2"></li>
                            </ol>

                            <!-- Content -->
                            <div class="carousel-inner" role="listbox">

                                <!-- Slide 1 -->
                                <div class="item active">
                                    <img src="./template/img/pict6.png" alt="Sunset over beach">
                                </div>

                                <!-- Slide 2 -->
                                <div class="item">
                                    <img src="./template/img/pict7.jpg" alt="Rob Roy Glacier">
                                </div>

                                <!-- Slide 3 -->
                                <div class="item">
                                    <img src="./template/img/pict8.jpg" alt="Longtail boats at Phi Phi">
                                </div>

                            </div>

                            <!-- Previous/Next controls -->
                            <a class="left carousel-control" href="#my-pics" role="button" data-slide="prev">
                                <span class="icon-prev" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="right carousel-control" href="#my-pics" role="button" data-slide="next">
                                <span class="icon-next" aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                            </a>

                        </div>

                    </div>
                    

                    <!-- jQuery library -->
                    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
                    <!-- Bootstrap JS -->
                    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

                    <!-- Initialize Bootstrap functionality -->
                    <script>
                        // Initialize tooltip component
                        $(function () {
                            $('[data-toggle="tooltip"]').tooltip()
                        })

                        // Initialize popover component
                        $(function () {
                            $('[data-toggle="popover"]').popover()
                        })
                    </script>

                </div>

                <!-- jQuery library -->
                <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
                <!-- Bootstrap JS -->
                <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

                <!-- Initialize Bootstrap functionality -->
                <script>
                        // Initialize tooltip component
                        $(function () {
                            $('[data-toggle="tooltip"]').tooltip()
                        })

                        // Initialize popover component
                        $(function () {
                            $('[data-toggle="popover"]').popover()
                        })
                </script>
            </div>
            <!-- /.row -->

            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="./template/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="./template/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="./template/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="./template/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="./template/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="./template/vendor/datatables-responsive/dataTables.responsive.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="./template/dist/js/sb-admin-2.js"></script>

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
