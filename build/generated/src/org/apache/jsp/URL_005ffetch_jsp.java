package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class URL_005ffetch_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n");
      out.write("        <script src=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <!------ Include the above in your HEAD tag ---------->\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.1.0/css/all.css\" integrity=\"sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt\" crossorigin=\"anonymous\">\n");
      out.write("        <style>\n");
      out.write("            .form-control-borderless {\n");
      out.write("                border: none;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .form-control-borderless:hover, .form-control-borderless:active, .form-control-borderless:focus {\n");
      out.write("                border: none;\n");
      out.write("                outline: none;\n");
      out.write("                box-shadow: none;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <br/>\n");
      out.write("            <div class=\"row justify-content-center\">\n");
      out.write("                <div class=\"col-12 col-md-10 col-lg-8\">\n");
      out.write("                    <form class=\"card card-sm\">\n");
      out.write("                        <div class=\"card-body row no-gutters align-items-center\">\n");
      out.write("                            <div class=\"col-auto\">\n");
      out.write("                                <i class=\"fas fa-search h4 text-body\"></i>\n");
      out.write("                            </div>\n");
      out.write("                            <!--end of col-->\n");
      out.write("                            <div class=\"col\">\n");
      out.write("                                <input class=\"form-control form-control-lg form-control-borderless\" type=\"search\" placeholder=\"Search topics or keywords\">\n");
      out.write("                            </div>\n");
      out.write("                            <!--end of col-->\n");
      out.write("                            <div class=\"col-auto\">\n");
      out.write("                                <button class=\"btn btn-lg btn-success\" type=\"submit\">Search</button>\n");
      out.write("                            </div>\n");
      out.write("                            <!--end of col-->\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <!--end of col-->\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
