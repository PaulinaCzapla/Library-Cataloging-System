package pl.polsl.lab.servlets.add;

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Main class of the servlet that demonstrates parameter download given during
 * servlet initialization
 *
 * @author Gall Anonim
 * @version 1.0
 */
@WebServlet("/Add")
public class AddServlet extends HttpServlet {

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

        var html = "<form action=\"AddResponse\" method=\"GET\">\n" +
            "<p>Title:<input type=text size=20 name=title></p>\n" +
            "<p>Author:<input type=text size=20 name=author></p>\n" +
            "<p>Publishing house:<input type=text size=20 name=publishing></p>\n" +
            "<p>Date of release:<input type=text size=20 name=releaseDate></p>\n" +                     
            "<input type=\"submit\" value=\"Add\" />\n" +
            "</form>";
        
        out.println("<html>\n<body style=\"background-color:#B1D0E0;\"><center><br><br><br>" +html + "</center></body>\n</html>");
    }
}
