package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class authentification_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_escapeXml_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_out_value_escapeXml_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_out_value_escapeXml_nobody.release();
    _jspx_tagPool_c_if_test.release();
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <!-- start: Meta -->\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <title> </title>\n");
      out.write("        \n");
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
      out.write("\n");
      out.write("        <link rel=\"shortcut icon\" href=\"img/favicon.ico\">\n");
      out.write("        <!-- end: Favicon -->\n");
      out.write("\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            body { background: url(img/bg-login.jpg) !important; }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container-fluid-full\">\n");
      out.write("            <div class=\"row-fluid\">\n");
      out.write("\n");
      out.write("                <div class=\"row-fluid\">\n");
      out.write("                    <div class=\"login-box\">\n");
      out.write("                        <div class=\"icons\">\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <h2><center>Authentification</center></h2>\n");
      out.write("                        ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                       \n");
      out.write("                        <form class=\"form-horizontal\" action=\"AuthentificationServlet\" method=\"post\">\n");
      out.write("\n");
      out.write("                            <fieldset>\n");
      out.write("                                <input  name=\"verif\"  type=\"hidden\" />\n");
      out.write("                              \n");
      out.write("\n");
      out.write("                                <div class=\"input-prepend\" title=\"Username\">\n");
      out.write("                                    <span class=\"add-on\"><i class=\"halflings-icon user\"></i></span>\n");
      out.write("                                    <input class=\"input-large span10\" name=\"username\" id=\"username\" type=\"text\" placeholder=\"Identificateur\"/>\n");
      out.write("                                </div>\n");
      out.write("         \n");
      out.write("                                <div class=\"clearfix\"></div>\n");
      out.write("\n");
      out.write("                                <div class=\"input-prepend\" title=\"Password\">\n");
      out.write("                                    <span class=\"add-on\"><i class=\"halflings-icon lock\"></i></span>\n");
      out.write("                                    <input class=\"input-large span10\" name=\"password\" id=\"password\" type=\"password\" placeholder=\"Mot de passe\"/>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"clearfix\"></div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                <div class=\"button-login\">\t\n");
      out.write("                                    <button type=\"submit\" class=\"btn btn-primary\">Login</button>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"clearfix\"></div>\n");
      out.write("                        </form>\n");
      out.write("                        <hr>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </div><!--/span-->\n");
      out.write("                </div><!--/row-->\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div><!--/.fluid-container-->\n");
      out.write("\n");
      out.write("        </div><!--/fluid-row-->\n");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.erreur != null }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\n");
        out.write("\t\n");
        out.write("\n");
        out.write("                        \n");
        out.write("                        <div class=\"box-content alerts\">\n");
        out.write("                            <div class=\"alert alert-error\">\n");
        out.write("                                <button type=\"button\" class=\"close\" data-dismiss=\"alert\">×</button>\n");
        out.write("                                <strong>Erreur !  </strong> ");
        if (_jspx_meth_c_out_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
          return true;
        out.write(" \n");
        out.write("                            </div>\n");
        out.write("                        </div>\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_out_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_escapeXml_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(_jspx_page_context);
    _jspx_th_c_out_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.erreur}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_out_0.setEscapeXml(true);
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_escapeXml_nobody.reuse(_jspx_th_c_out_0);
      return true;
    }
    _jspx_tagPool_c_out_value_escapeXml_nobody.reuse(_jspx_th_c_out_0);
    return false;
  }
}
