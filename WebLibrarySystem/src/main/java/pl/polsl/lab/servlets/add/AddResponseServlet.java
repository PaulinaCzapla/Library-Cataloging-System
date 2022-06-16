package pl.polsl.lab.servlets.add;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import pl.polsl.lab.servlets.helpers.AddResourceController;

/**
 * Main class of the servlet that demonstrates parameter download given during
 * servlet initialization
 *
 * @author Gall Anonim
 * @version 1.0
 */
@WebServlet("/AddResponse")
public class AddResponseServlet extends HttpServlet {

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
        var title = request.getParameter("title");
        var author = request.getParameter("author");
        var publisher = request.getParameter("publishing");
        var releaseDate = request.getParameter("releaseDate");
        
        var message = new AddResourceController().addResource(title, author, publisher, releaseDate);

        
        
          if(message.equals(""))
        {
            Cookie cookie = new Cookie ("addedBook"+title.length()+author.length()+publisher.length()+releaseDate, title + ", " + author + ", " + publisher + ", "+ releaseDate);
            response.addCookie(cookie);
        }
        
        var output = message.equals("") ? "Added book!" : message;
        out.println("<html>\n<body style=\"background-color:#B1D0E0;\">\n" + output + "\n</body>\n</html>");
    }
}
