/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.34
 * Generated at: 2013-04-04 18:31:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class formCheck_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("     <META http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-5\">\r\n");
      out.write("     <title>Javascript Assignment -- Form Completion</title>\r\n");
      out.write("     <link rel='stylesheet' href='csci4300.css'>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("  /**\r\n");
      out.write("   * Returns true if all form fields have been completed.\r\n");
      out.write("   * Otherwise, displays an alert box with an error message\r\n");
      out.write("   * for the first uncompleted form field and returns false.\r\n");
      out.write("   */\r\n");
      out.write("   function formOK()\r\n");
      out.write("  {\r\n");
      out.write("\t   var form = document.forms[\"submitInfo\"];\r\n");
      out.write("\t   var firstName = form[\"firstName\"].value;\r\n");
      out.write("\t   var lastName = form[\"lastName\"].value;\r\n");
      out.write("\t   var phoneNumber = form[\"phoneNumber\"].value;\r\n");
      out.write("\t   var city = form[\"city\"].value;\r\n");
      out.write("\t   var zipCode = document.getElementById(\"zipCode\").value;\r\n");
      out.write("\t   \r\n");
      out.write("\t   if(firstName && lastName && phoneNumber && city && zipCode != \"initial\")\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"Form has been submitted.\");\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}else\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"Form is invalid.\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("  }\r\n");
      out.write("</script>\r\n");
      out.write("     </head>\r\n");
      out.write("<body style=\"background-color:lightyellow\">\r\n");
      out.write("\r\n");
      out.write("<form name=\"submitInfo\" method=\"post\" onSubmit = \"return formOK()\" action=\"Echo\" >\r\n");
      out.write("<div>\r\n");
      out.write("<table>\r\n");
      out.write("       <tr><th colspan=4>Please tell us who you are (Georgia residents only)\r\n");
      out.write("       <tr><td>First name<td><input type='text' size=20 name='firstName' >\r\n");
      out.write("           <td>Last name<td><input type='text' size=20 name='lastName'>\r\n");
      out.write("       <tr><td>Telephone <td><input type='text' size=15 name='phoneNumber'> <td>&nbsp;<td>&nbsp;\r\n");
      out.write("        <tr><td>City<td><input type='text' size=20 name='city'>\r\n");
      out.write("            <td>Zip code:<td><select id=\"zipCode\" name=\"zipCode\"><option value=\"initial\">Select</option><option>12345</option><option>99999</option></select>\r\n");
      out.write("           \r\n");
      out.write("        <tr><td colspan=6 style=\"text-align:center\"><input type='submit' value=\"Share personal info with our unscrupulous marketing staff\">\r\n");
      out.write("</table>\r\n");
      out.write("<input type='text' size=50 id=\"status\">\r\n");
      out.write("</div>\r\n");
      out.write("</form>\r\n");
      out.write("<p>\r\n");
      out.write("      <a href=\"http://validator.w3.org/check/referer\"><img\r\n");
      out.write("          src=\"http://www.w3.org/Icons/valid-html401\"\r\n");
      out.write("          alt=\"Valid HTML 4.01!\" height=\"31\" width=\"88\"></a>\r\n");
      out.write("    </p>\r\n");
      out.write("</body>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}