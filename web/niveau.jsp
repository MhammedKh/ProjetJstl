
<!DOCTYPE html>

<html lang="en">
    <head>

        <!-- start: Meta -->
        <meta charset="utf-8">
        <title>Bootstrap Metro Dashboard by Dennis Ji for ARM demo</title>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <meta name="description" content="Bootstrap Metro Dashboard">
        <meta name="author" content="Dennis Ji">
        <meta name="keyword" content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
        <!-- end: Meta -->

        <!-- start: Mobile Specific -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- end: Mobile Specific -->

        <!-- start: CSS -->
        <link id="bootstrap-style" href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-responsive.min.css" rel="stylesheet">
        <link id="base-style" href="css/style.css" rel="stylesheet">
        <link id="base-style-responsive" href="css/style-responsive.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
        <!-- end: CSS -->




        <!-- start: Favicon -->
        <link rel="shortcut icon" href="img/favicon.ico">
        <!-- end: Favicon -->




    </head>

    <body>
        <!-- start: Header -->
        <div class="navbar">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href=""><span>IIT</span></a>


                    <!-- start: Header Menu -->
                   <jsp:include page="/includeJSP/Admin.jsp" />
                <!-- end: Main Menu -->

                <noscript>
                <div class="alert alert-block span10">
                    <h4 class="alert-heading">Warning!</h4>
                    <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
                </div>
                </noscript>

                <!-- start: Content -->
                <div id="content" class="span10">

                    <ul class="breadcrumb">
                        <li>
                            <i class="icon-home"></i>
                            <a href="../home.php">Home</a>
                            <i class="icon-angle-right"></i> 
                        </li>
                        <li>
                            <i class="icon-edit"></i>
                            <a href="#">Editer Niveau</a>
                        </li>
                    </ul>
                    <div class="row-fluid sortable">
                        <div class="box span12">
                            <div class="box-header" data-original-title>
                                <h2><i class="halflings-icon edit"></i><span class="break"></span>Ajouter Niveau</h2>
                                <div class="box-icon">

                                    <a href="#" class="btn-minimize"><i class="halflings-icon chevron-up"></i></a>
                                    <a href="#" class="btn-close"><i class="halflings-icon remove"></i></a>
                                </div>


                            </div>
                         


                            <div class="box-content">

                                <form class="form-horizontal" method="Get" action="ActionNiveauServlet">
                                    <fieldset>
                                        <input type="hidden"  name="id_event" value="form" required> 
                                        <c:if test="${requestScope.btnmodif != null }">
                                            <input type="hidden"  name="action" value="modifier" required>
                                            <input type="hidden"  name="niveau" value="<c:out value="${requestScope.niveau.id}" escapeXml="true"></c:out>" required> 
                                        </c:if>
                                         <c:if test="${requestScope.btnmodif == null }">
                                            <input type="hidden"  name="action" value="ajout" required> 
                                        </c:if>
                                        
                                          
                                        <div class="control-group">
                                            <label class="control-label" for="focusedInput">Nom</label>
                                            <div class="controls">
                                                <input type="text" name="nom" value="<c:out value="${requestScope.niveau.nom}" escapeXml="true"></c:out>" > <!--id="inputError">
                                                <span class="help-inline">Please correct the error</span> -->
                                            </div>
                                        </div>

                                        <div class="control-group">
                                            <label class="control-label" for="inputError">Code</label>
                                            <div class="controls">
                                                <input type="text" name="code" value="<c:out value="${requestScope.niveau.code}" escapeXml="true"></c:out>" > <!--id="inputError">
                                                <span class="help-inline">Please correct the error</span> -->
                                            </div>
                                        </div>

                                                 
                                                
                                                
                                                
                                                

                                        



                                        <div class="form-actions">
                                            
                                               
	
                                            <button type="submit" class="btn btn-primary"><c:if test="${requestScope.btnmodif == null }">Ajouter</c:if><c:if test="${requestScope.btnmodif != null }">Modifier</c:if></button>
                                            <button  type="reset" class="btn">Cancel</button>
                                        </div>
                                    </fieldset>
                                </form>
                            </div>




                        </div><!--/span-->

                    </div><!--/row-->


                    <div class="row-fluid sortable">
                        <div class="box span12">
                            <div class="box-header" data-original-title>
                                <h2><i class="halflings-icon user"></i><span class="break"></span>Liste des Niveau</h2>
                                <div class="box-icon">

                                    <a href="#" class="btn-minimize"><i class="halflings-icon chevron-up"></i></a>
                                    <a href="#" class="btn-close"><i class="halflings-icon remove"></i></a>
                                </div>


                            </div>



                            <div class="box-content">

                                <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                    <thead>
                                        <tr>
                                            
                                            <th>Nom</th>
                                            <th>Code</th>
                                            <th>Nombre de groupe</th>
                                            
                                            <th>Actions</th>
                                        </tr>
                                    </thead>   
                                    <tbody>
                                        <c:forEach items="${requestScope.niveauList}" var="niveau">
                                            <tr>
                                              
                                                <td style="vertical-align:middle;" class="center" ><c:out value="${niveau.nom}"></c:out></td>
                                                <td style="vertical-align:middle;" class="center"><c:out value="${niveau.code}"></c:out> </td>
                                                <td style="vertical-align:middle;" class="center"><c:out value="${niveau.nbrGroupe}"></c:out> </td>
                                               
                                                    <td style="vertical-align:middle;" class="center">
                                                        <a class="btn btn-success" href="ActionNiveauServlet?id_event=zoom&id_n=<c:out value="${niveau.id}"></c:out>" >
                                                            <i class="halflings-icon white zoom-in"></i>  
                                                        </a>
                                                        <a class="btn btn-info" href="ActionNiveauServlet?id_event=edit&id_n=<c:out value="${niveau.id}"></c:out>" >
                                                            <i class="halflings-icon white edit"></i>  
                                                        </a>

                                                    </td>
                                                </tr>
                                        </c:forEach>



                                    </tbody>
                                </table> 

                            </div>




                        </div><!--/span-->

                    </div><!--/row-->


                </div>
            </div>
        </div>








        <!-- start: JavaScript-->

        <script src="js/jquery-1.9.1.min.js"></script>
        <script src="js/jquery-migrate-1.0.0.min.js"></script>

        <script src="js/jquery-ui-1.10.0.custom.min.js"></script>

        <script src="js/jquery.ui.touch-punch.js"></script>

        <script src="js/modernizr.js"></script>

        <script src="js/bootstrap.min.js"></script>

        <script src="js/jquery.cookie.js"></script>

        <script src='js/fullcalendar.min.js'></script>

        <script src='js/jquery.dataTables.min.js'></script>

        <script src="js/excanvas.js"></script>
        <script src="js/jquery.flot.js"></script>
        <script src="js/jquery.flot.pie.js"></script>
        <script src="js/jquery.flot.stack.js"></script>
        <script src="js/jquery.flot.resize.min.js"></script>

        <script src="js/jquery.chosen.min.js"></script>

        <script src="js/jquery.uniform.min.js"></script>

        <script src="js/jquery.cleditor.min.js"></script>

        <script src="js/jquery.noty.js"></script>

        <script src="js/jquery.elfinder.min.js"></script>

        <script src="js/jquery.raty.min.js"></script>

        <script src="js/jquery.iphone.toggle.js"></script>

        <script src="js/jquery.uploadify-3.1.min.js"></script>

        <script src="js/jquery.gritter.min.js"></script>

        <script src="js/jquery.imagesloaded.js"></script>

        <script src="js/jquery.masonry.min.js"></script>

        <script src="js/jquery.knob.modified.js"></script>

        <script src="js/jquery.sparkline.min.js"></script>

        <script src="js/counter.js"></script>

        <script src="js/retina.js"></script>

        <script src="js/custom.js"></script>


        <!-- end: JavaScript-->

    </body>
</html>
