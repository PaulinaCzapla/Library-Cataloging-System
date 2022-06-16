package pl.polsl.lab.servlets.delete;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;
import javax.servlet.annotation.WebServlet;

/**
 * Main class of the servlet that demonstrates communicaton between servlets and
 * the ways of redirecting the request
 * 
 * @author Gall Anonim
 * @version 1.0
 */
@WebServlet("/Delete")
public class DeleteServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    
     /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=ISO-8859-2");
        PrintWriter out = response.getWriter();
        
        var html = "<form action=\"DeleteResponse\" method=\"GET\">\n" +
            "<p>ID:<input type=text size=20 name=id></p>\n" +                     
            "<input type=\"submit\" value=\"Delete\" />\n" +
            "</form>";
        
        out.println("<html>\n<body>\n" + html + "\n</body>\n</html>");
    }
}
