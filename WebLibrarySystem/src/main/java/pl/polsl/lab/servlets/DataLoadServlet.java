package pl.polsl.lab.servlets;

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import pl.polsl.lab.servlets.controller.Database;

/**
 * Main class of the servlet that demonstrates parameter download given during
 * servlet initialization
 *
 * @author Gall Anonim
 * @version 1.0
 */
@WebServlet("/DataLoad")
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class DataLoadServlet extends HttpServlet {

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
  public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    HttpSession session = request.getSession(true);
    
    
    PrintWriter out = response.getWriter();
    Part filePart = request.getPart("file");
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<body style=\"background-color:#B1D0E0;\">");
    var flag = Database.set(filePart.getSubmittedFileName(), filePart.getInputStream());
    var output = flag ? "Successfully loaded database!" : "Error loading database!";
    
    if(flag)
    {
      Cookie cookie = new Cookie ("uploadedFile" + filePart.getSubmittedFileName() , filePart.getSubmittedFileName());
      response.addCookie(cookie);
    }
    out.println(output);
   
    out.println("</body>");
     out.println("</html>");
  }
  
}
