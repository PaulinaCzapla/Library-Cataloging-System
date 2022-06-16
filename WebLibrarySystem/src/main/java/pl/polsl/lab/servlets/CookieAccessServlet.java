package pl.polsl.lab.servlets;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet presenting the use of cookies
 *
 * @author Gall Anonim
 * @version 1.0
 */
@WebServlet("/CookieAccess")
public class CookieAccessServlet extends HttpServlet {

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

        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CookiesAccess</title>");
            out.println("</head>");
            out.println("<body style=\"background-color:#B1D0E0;\">");
            Cookie[] cookies = request.getCookies();
            String lastFile = "never";
    
            out.println("<b>");
            out.println("Uploaded files:");
            out.println("</b>");
            out.println("<br>");
            
            if (cookies != null) {
                for (Cookie cookie : cookies) 
                {
                    if (cookie.getName().contains("uploadedFile")) {
                        lastFile = cookie.getValue();
                        out.println(lastFile);
                        out.println("<br>");
                    }
                }
            }
            out.println("<br>");
            out.println("<br>");
            out.println("<b>");
            out.println("Deleted books: ");
            out.println("</b>");
            out.println("<br>");
             
            if (cookies != null) {
                for (Cookie cookie : cookies) 
                {
                    if (cookie.getName().contains("deletedBook")) {
                        String book  = cookie.getValue();
                        out.println(book);
                        out.println("<br>");
                    }
                }
            }
          out.println("<br>");
          out.println("<br>");
          out.println("<b>");
          out.println("Added books:");
          out.println("<br>");
          out.println("</b>");
            if (cookies != null) {
                for (Cookie cookie : cookies) 
                {
                    if (cookie.getName().contains("addedBook")) {
                        String book  = cookie.getValue();
                        out.println(book);
                        out.println("<br>");
                    }
                }
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
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
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
