
<!DOCTYPE html>

<html>
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
                            <a href="#">Editer Session</a>
                        </li>
                    </ul>
                    <c:if test="${requestScope.listN == null}"> 
                        <div class="row-fluid sortable">
                            <div class="box span12">
                                <div class="box-header" data-original-title>
                                    <h2><i class="halflings-icon edit"></i><span class="break"></span>choisir groupe et matiére</h2>
                                    <div class="box-icon">

                                        <a href="#" class="btn-minimize"><i class="halflings-icon chevron-up"></i></a>
                                        <a href="#" class="btn-close"><i class="halflings-icon remove"></i></a>
                                    </div>


                                </div>



                                <div class="box-content">

                                    <form class="form-horizontal" method="Get" action="consultnote">
                                        <fieldset>


                                            <c:if test="${requestScope.matiereList == null}">   
                                                <div class="control-group">
                                                    <label class="control-label" for="selectError">Groupe</label>
                                                    <div class="controls">
                                                        <select id="selectError" value=" " name="groupe" data-rel="chosen" onchange='window.location.href = "consultnote?id_s=" +<c:out value="${requestScope.id_session }"></c:out> + "&id_event=mat&id_g=" + this.options[this.selectedIndex].value;'>
                                                                <option value=""> </option>
                                                            <c:forEach items="${requestScope.groupList}" var="groupe">
                                                                <option value="<c:out value="${groupe.g.id}"></c:out>"> <c:out value="${groupe.g.nom}"></c:out></option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </div> 
                                            </c:if>
                                            <c:if test="${requestScope.matiereList != null}"> 
                                                <input type="hidden"  name="id_event" value="form" required> 
                                                <input type="hidden"  name="group" value="<c:out value="${requestScope.groupe.id}" escapeXml="true"></c:out>" required> 
                                                <input type="hidden"  name="sess" value="<c:out value="${requestScope.id_session}" escapeXml="true"></c:out>" required> 
                                                <input type="hidden"  name="nom_groupe" value="<c:out value="${requestScope.groupe.nom}" escapeXml="true"></c:out>" required> 
                                                    <div class="control-group">
                                                        <label class="control-label">Groupe</label>
                                                        <div class="controls">
                                                            <span class="input-xlarge uneditable-input" ><c:out value="${requestScope.groupe.nom}" escapeXml="true"></c:out></span>
                                                        </div>
                                                    </div>



                                                    <div class="control-group">
                                                        <label class="control-label" for="selectError">Matiére</label>
                                                        <div class="controls">
                                                            <select id="selectError" name="matiere" data-rel="chosen"   >
                                                            <c:forEach items="${requestScope.matiereList}" var="matiere">
                                                                <option value="<c:out value="${matiere.id}"></c:out>"><c:out value="${matiere.nom}"></c:out></option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </div> 


                                                <div class="form-actions">



                                                    <button type="submit" class="btn btn-primary">Ajouter</button>
                                                    <button  type="reset" class="btn"  onClick='window.location.href = "ListeGroupeEnseignant?id_e=" +<c:out value="${requestScope.id_e }"></c:out>' > Cancel</button>
                                                    </div>
                                            </c:if>
                                        </fieldset>
                                    </form>
                                </div>




                            </div><!--/span-->

                        </div><!--/row-->
                    </c:if>
                    <c:if test="${requestScope.listN != null}"> 


                        <div class="row-fluid sortable">
                            <div class="box span12">
                                <div class="box-header" data-original-title>
                                    <h2><i class="halflings-icon list"></i><span class="break"></span>Groupe et matiére</h2>
                                    <div class="box-icon">

                                        <a href="#" class="btn-minimize"><i class="halflings-icon chevron-up"></i></a>
                                        <a href="#" class="btn-close"><i class="halflings-icon remove"></i></a>
                                    </div>


                                </div>



                                <div class="box-content">


                                    <div class="form-horizontal">





                                        <div class="control-group">
                                            <label class="control-label">Groupe</label>
                                            <div class="controls">
                                                <span class="input-xlarge uneditable-input" ><c:out value="${requestScope.nom_g}" escapeXml="true"></c:out></span>
                                                </div>
                                            </div>



                                            <div class="control-group">
                                                <label class="control-label">Matiére</label>
                                                <div class="controls">
                                                    <span class="input-xlarge uneditable-input" name="nom_matiere"><c:out value="${requestScope.matiere.nom}" escapeXml="true"></c:out></span>
                                                </div>
                                            </div>






                                        </div>


                                    </div>

                                </div><!--/span-->

                            </div><!--/row-->










                            <div class="row-fluid sortable">
                                <div class="box span12">
                                    <div class="box-header" data-original-title>
                                        <h2><i class="halflings-icon edit "></i><span class="break"></span>Liste des Notes</h2>
                                        <div class="box-icon">

                                            <a href="#" class="btn-minimize"><i class="halflings-icon chevron-up"></i></a>
                                            <a href="#" class="btn-close"><i class="halflings-icon remove"></i></a>
                                        </div>


                                    </div>



                                    <div class="box-content">
                                       
                                           
                                       
                                            <table class="table table-striped table-bordered bootstrap-datatable datatable" >
                                                <thead>
                                                    <tr>

                                                        <th>CIN</th>
                                                        <th>Nom </th>
                                                        <th>Prenom</th>
                                                        <th>Numéro de compostage</th>
                                                        <th>Note TP</th> 
                                                        <th>Note DS</th> 
                                                        <th>Note Examain</th> 
                                                        <th>Note Précense</th> 


                                                    </tr>
                                                </thead>   
                                                <tbody>

                                                <c:forEach items="${requestScope.listN}" var="note">
                                                    <tr>

                                                        <td style="vertical-align:middle;" class="center"><c:out value="${note.e.cin}"></c:out></td>
                                                        <td style="vertical-align:middle;" class="center"><c:out value="${note.e.nom}"></c:out> </td>
                                                        <td style="vertical-align:middle;" class="center"><c:out value="${note.e.prenom}"></c:out> </td>
                                                        <td style="vertical-align:middle;" class="center">  <c:out value="${note.n.numCompostage}"></c:out>  </td>
                                                        <td style="vertical-align:middle;" class="center"><c:if test="${note.n.ds != -1}"><c:out value="${note.n.tp}"></c:out></c:if></td>
                                                        <td style="vertical-align:middle;" class="center"><c:if test="${note.n.ds != -1}"><c:out value="${note.n.ds}"></c:out> </c:if></td>
                                                        <td style="vertical-align:middle;" class="center"><c:if test="${note.n.ds != -1}"><c:out value="${note.n.examain}"></c:out></c:if> </td>
                                                        <td style="vertical-align:middle;" class="center"><c:if test="${note.n.ds != -1}"><c:out value="${note.n.presentielle}"></c:out> </c:if></td>

                                                        </tr>
                                                </c:forEach>


                                            </tbody>
                                        </table> 

                                        

                                    </div>




                                </div><!--/span-->

                            </div><!--/row-->
                    </c:if>


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
