package pl.polsl.lab.servlets.delete;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import pl.polsl.lab.servlets.helpers.DeleteResourceController;

/**
 * Main class of the servlet that demonstrates communicaton between servlets and
 * the ways of redirecting the request
 * 
 * @author Gall Anonim
 * @version 1.0
 */
@WebServlet("/DeleteResponse")
public class DeleteResponseServlet extends HttpServlet {

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
        HttpSession session = request.getSession(true);
       
        String id =(String)session.getAttribute("id");
        var flag = new DeleteResourceController().delete(id);
        
        var ouput = flag ? String.format("Succsefully deleted book with id: %s", id) : String.format("Error deleting book with id: %s", id);
        
        if(flag)
        {
            Cookie cookie = new Cookie ("deletedBook"+id, id + ", " + (String)session.getAttribute("title")+ ", " + (String)session.getAttribute("author")
            + ", " + (String)session.getAttribute("publishingHouse")+ ", " + (String)session.getAttribute("date"));
            response.addCookie(cookie);
        }
        
        out.println("<html>\n<body style=\"background-color:#B1D0E0;\">\n" + ouput + "\n</body>\n</html>");
    }
}
