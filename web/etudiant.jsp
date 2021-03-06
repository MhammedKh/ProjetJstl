
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
                            <a href="#">Editer Etudiant</a>
                        </li>
                    </ul>
                    <div class="row-fluid sortable">
                        <div class="box span12">
                            <div class="box-header" data-original-title>
                                <h2><i class="halflings-icon edit"></i><span class="break"></span>Ajouter Etudiant</h2>
                                <div class="box-icon">

                                    <a href="#" class="btn-minimize"><i class="halflings-icon chevron-up"></i></a>
                                    <a href="#" class="btn-close"><i class="halflings-icon remove"></i></a>
                                </div>


                            </div>
                            <c:if test="${requestScope.erreur != null }">




                                <div class="box-content alerts">
                                    <div class="alert alert-error">
                                        <button type="button" class="close" data-dismiss="alert">�</button>
                                        <strong>Erreur !  </strong> <c:out value="${requestScope.erreur}" escapeXml="true"></c:out> 
                                        </div>
                                    </div>
                            </c:if>


                            <div class="box-content">

                                <form class="form-horizontal" method="Get" action="ActionEtudiantServlet">
                                    <fieldset>
                                        <input type="hidden"  name="id_event" value="form" required> 
                                        <c:if test="${requestScope.btnmodif != null }">
                                            <input type="hidden"  name="action" value="modifier" required>
                                            <input type="hidden"  name="etud" value="<c:out value="${requestScope.etud.id}" escapeXml="true"></c:out>" required> 
                                        </c:if>
                                         <c:if test="${requestScope.btnmodif == null }">
                                            <input type="hidden"  name="action" value="ajout" required> 
                                        </c:if>
                                        
                                        <div class="control-group">
                                            <label class="control-label"  for="inputError">Cin</label>
                                            <div class="controls">
                                                <input type="Number" max="999999999" name="cin" value="<c:out value="${requestScope.etud.cin}" escapeXml="true"></c:out>" required> <!--id="inputError">
                                              <span class="help-inline">Please correct the error</span> -->
                                            </div>
                                        </div>    
                                        <div class="control-group">
                                            <label class="control-label" for="focusedInput">Nom</label>
                                            <div class="controls">
                                                <input type="text" name="nom" value="<c:out value="${requestScope.etud.nom}" escapeXml="true"></c:out>" > <!--id="inputError">
                                                <span class="help-inline">Please correct the error</span> -->
                                            </div>
                                        </div>

                                        <div class="control-group">
                                            <label class="control-label" for="inputError">Pr�nom</label>
                                            <div class="controls">
                                                <input type="text" name="prenom" value="<c:out value="${requestScope.etud.prenom}" escapeXml="true"></c:out>" > <!--id="inputError">
                                                <span class="help-inline">Please correct the error</span> -->
                                            </div>
                                        </div>

                                        <div class="control-group">
                                            <label class="control-label" for="inputError">Num�ro T�l�phone</label>
                                            <div class="controls">
                                                <input type="Number"  name="tel" value="<c:out value="${requestScope.etud.tel}" escapeXml="true"></c:out>"> <!--id="inputError">
                                              <span class="help-inline">Please correct the error</span> -->
                                            </div>
                                        </div> 

                                        <div class="control-group">
                                            <label class="control-label" for="inputError">Adresse</label>
                                            <div class="controls">
                                                <input type="text" name="adr" value="<c:out value="${requestScope.etud.adresse}" escapeXml="true"></c:out>" > <!--id="inputError">
                                                <span class="help-inline">Please correct the error</span> -->
                                            </div>
                                        </div>
                                                 <div class="control-group">
								<label class="control-label" for="selectError">Groupe</label>
								<div class="controls">
								  <select id="selectError" name="groupe" data-rel="chosen">
                                                                      <c:forEach items="${requestScope.groupList}" var="groupe">
                                                                          <option value="<c:out value="${groupe.g.id}"></c:out>" <c:if test="${groupe.g.id}==${requestScope.etud.groupe}"> selected </c:if> ><c:out value="${groupe.g.nom}"></c:out></option>
                                                                      </c:forEach>
								  </select>
								</div>
							  </div> 
                                                
                                                
                                                
                                                

                                        <div class="control-group">
                                            <label class="control-label" for="inputError">Identificateur</label>
                                            <div class="controls">
                                                <input type="text" name="Iden" > <!--id="inputError">
                                                <span class="help-inline">Please correct the error</span> -->
                                            </div>
                                        </div>
                                        <div class="control-group">
                                            <label class="control-label" for="inputError">Mot de Passe</label>
                                            <div class="controls">
                                                <input type="Password" name="Passe" > <!--id="inputError">
                                                <span class="help-inline">Please correct the error</span> -->
                                            </div>
                                        </div>
                                        <div class="control-group">
                                            <label class="control-label" for="inputError">Confirmer Mot de Passe</label>
                                            <div class="controls">
                                                <input type="Password" name="c_Passe" > <!--id="inputError">
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
                                <h2><i class="halflings-icon user"></i><span class="break"></span>Liste des Etudiant</h2>
                                <div class="box-icon">

                                    <a href="#" class="btn-minimize"><i class="halflings-icon chevron-up"></i></a>
                                    <a href="#" class="btn-close"><i class="halflings-icon remove"></i></a>
                                </div>


                            </div>



                            <div class="box-content">

                                <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                    <thead>
                                        <tr>
                                            <th>CIN</th>
                                            <th>Nom</th>
                                            <th>Prenom</th>
                                            <th>Adreese</th>
                                            <th>Numero T�l�phone </th>
                                            <th>Groupe </th>
                                            <th>Actions</th>
                                        </tr>
                                    </thead>   
                                    <tbody>
                                        <c:forEach items="${requestScope.etudList}" var="etud">
                                            <tr>
                                                <td style="vertical-align:middle;" class="center" ><c:out value="${etud.cin}"></c:out></td>
                                                <td style="vertical-align:middle;" class="center" ><c:out value="${etud.nom}"></c:out></td>
                                                <td style="vertical-align:middle;" class="center"><c:out value="${etud.prenom}"></c:out> </td>
                                                <td style="vertical-align:middle;" class="center"><c:out value="${etud.adresse}"></c:out> </td>
                                                <td style="vertical-align:middle;" class="center"><c:out value="${etud.tel}"></c:out></td>
                                                 <td style="vertical-align:middle;" class="center"><c:out value="${etud.groupe}"></c:out></td>
                                                    <td style="vertical-align:middle;" class="center">
                                                        
                                                        <a class="btn btn-info" href="ActionEtudiantServlet?id_event=edit&id_e=<c:out value="${etud.id}"></c:out>" >
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
