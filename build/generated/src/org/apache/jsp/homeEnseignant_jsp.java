package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class homeEnseignant_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<?php \n");
      out.write("session_start();\n");
      out.write("\n");
      out.write("if(isset($_SESSION['id'])){ ?>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <!-- start: Meta -->\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <title>Bootstrap Metro Dashboard by Dennis Ji for ARM demo</title>\n");
      out.write("        <meta name=\"description\" content=\"Bootstrap Metro Dashboard\">\n");
      out.write("        <meta name=\"author\" content=\"Dennis Ji\">\n");
      out.write("        <meta name=\"keyword\" content=\"Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina\">\n");
      out.write("        <!-- end: Meta -->\n");
      out.write("\n");
      out.write("        <!-- start: Mobile Specific -->\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <!-- end: Mobile Specific -->\n");
      out.write("\n");
      out.write("        <!-- start: CSS -->\n");
      out.write("        <link id=\"bootstrap-style\" href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/bootstrap-responsive.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link id=\"base-style\" href=\"css/style.css\" rel=\"stylesheet\">\n");
      out.write("        <link id=\"base-style-responsive\" href=\"css/style-responsive.css\" rel=\"stylesheet\">\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>\n");
      out.write("        <!-- end: CSS -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- start: Favicon -->\n");
      out.write("        <link rel=\"shortcut icon\" href=\"img/favicon.ico\">\n");
      out.write("        <!-- end: Favicon -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <!-- start: Header -->\n");
      out.write("        <div class=\"navbar\">\n");
      out.write("            <div class=\"navbar-inner\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <a class=\"btn btn-navbar\" data-toggle=\"collapse\" data-target=\".top-nav.nav-collapse,.sidebar-nav.nav-collapse\">\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                    </a>\n");
      out.write("                    <a class=\"brand\" href=\"\"><span>IIT</span></a>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <!-- start: Header Menu -->\n");
      out.write("                    <div class=\"nav-no-collapse header-nav\">\n");
      out.write("                        <ul class=\"nav pull-right\">\n");
      out.write("                            \n");
      out.write("                            <!-- start: Notifications Dropdown -->\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <li>\n");
      out.write("                                <a class=\"btn\" href=\"./include/logout.php\">\n");
      out.write("                                    <i class=\"halflings-icon white  off\"></i>\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- start: Header -->\n");
      out.write("\n");
      out.write("        <div class=\"container-fluid-full\">\n");
      out.write("            <div class=\"row-fluid\">\n");
      out.write("\n");
      out.write("                <!-- start: Main Menu -->\n");
      out.write("\n");
      out.write("                <div id=\"sidebar-left\" class=\"span2\">\n");
      out.write("                    <div class=\"nav-collapse sidebar-nav\">\n");
      out.write("                        <ul class=\"nav nav-tabs nav-stacked main-menu\">\n");
      out.write("\n");
      out.write("                            <li><a href=\"consultroupeEnsServlet\"><i class=\"icon-edit\"></i><span class=\"hidden-tablet\"> Consulter les groupes</span></a></li>\n");
      out.write("                            <li><a href=\"EtudiantServlet\"><i class=\"icon-edit\"></i><span class=\"hidden-tablet\"> Consulter les Notes</span></a></li>\n");
      out.write("                            <li><a href=\"GroupeServlet\"><i class=\"icon-edit\"></i><span class=\"hidden-tablet\"> Saisie des Notes</span></a></li>\n");
      out.write("    \n");
      out.write("                            \n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- end: Main Menu -->\n");
      out.write("\n");
      out.write("                <noscript>\n");
      out.write("                <div class=\"alert alert-block span10\">\n");
      out.write("                    <h4 class=\"alert-heading\">Warning!</h4>\n");
      out.write("                    <p>You need to have <a href=\"http://en.wikipedia.org/wiki/JavaScript\" target=\"_blank\">JavaScript</a> enabled to use this site.</p>\n");
      out.write("                </div>\n");
      out.write("                </noscript>\n");
      out.write("\n");
      out.write("                <!-- start: Content -->\n");
      out.write("                <div id=\"content\" class=\"span10\">\n");
      out.write("\n");
      out.write("                    <ul class=\"breadcrumb\">\n");
      out.write("                        <li>\n");
      out.write("                            <i class=\"icon-home\"></i>\n");
      out.write("                            <a href=\"home.php\">Home</a>\n");
      out.write("                            <i class=\"icon-angle-right\"></i> \n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"box-content\">\n");
      out.write("                        <div class=\"masonry-gallery\">\n");
      out.write("                            \n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div><!--/span-->\n");
      out.write("\n");
      out.write("                </div><!--/row-->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- start: JavaScript-->\n");
      out.write("\n");
      out.write("        <script src=\"js/jquery-1.9.1.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery-migrate-1.0.0.min.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"js/jquery-ui-1.10.0.custom.min.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"js/jquery.ui.touch-punch.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"js/modernizr.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"js/jquery.cookie.js\"></script>\n");
      out.write("\n");
      out.write("        <script src='js/fullcalendar.min.js'></script>\n");
      out.write("\n");
      out.write("        <script src='js/jquery.dataTables.min.js'></script>\n");
      out.write("\n");
      out.write("        <script src=\"js/excanvas.js\"></script>\n");
      out.write("        <script src=\"js/jquery.flot.js\"></script>\n");
      out.write("        <script src=\"js/jquery.flot.pie.js\"></script>\n");
      out.write("        <script src=\"js/jquery.flot.stack.js\"></script>\n");
      out.write("        <script src=\"js/jquery.flot.resize.min.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"js/jquery.chosen.min.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"js/jquery.uniform.min.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"js/jquery.cleditor.min.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"js/jquery.noty.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"js/jquery.elfinder.min.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"js/jquery.raty.min.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"js/jquery.iphone.toggle.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"js/jquery.uploadify-3.1.min.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"js/jquery.gritter.min.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"js/jquery.imagesloaded.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"js/jquery.masonry.min.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"js/jquery.knob.modified.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"js/jquery.sparkline.min.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"js/counter.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"js/retina.js\"></script>\n");
      out.write("\n");
      out.write("        <script src=\"js/custom.js\"></script>\n");
      out.write("        <!-- end: JavaScript-->\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("<?php \n");
      out.write("} ?>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
