package pl.polsl.lab.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import pl.polsl.lab.servlets.controller.Database;

/**
 * Servlet handling runtime error
 *
 * @author Gall Anonim
 * @version 1.0
 */
@WebServlet("/Display")
public class DisplayServlet extends HttpServlet
{

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
            throws ServletException, IOException
    {
        response.setContentType("text/html; charset=ISO-8859-2");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body style=\"background-color:#B1D0E0;\">");
        var library = Database.getLibrary();
        if (library == null)
        {
            out.println("No database loaded!");
        } 
        else
        {
            var books = library.getBooksListReadOnly();
            out.println("<html>\n<body>\n<center><br><br><br>");

            if (books.size() > 0)
            {
                out.println("<table style=\"background-color:#daedf7;\"><tr><th>ID</th><th>Author</th><th>Title</th><th>Publisher</th><th>Release Date</th></tr>");
                for (int i = 0; i < books.size(); ++i)
                {
                    var book = books.get(i);
                    out.println(String.format("<tr><td>%d</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>", book.getId(), book.getAuthor(), book.getTitle(), book.getPublishingHouse(), book.getReleaseDateText()));
                }
                out.println("</table>");
            } else
            {
                out.println("Empty list");
            }
            out.println("\n</center></body>\n</html>");
        }
    }
}
