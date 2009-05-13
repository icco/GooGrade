/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package goograde;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nwelch
 */
public class AboutController extends HttpServlet
{
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        Scanner sc = null;
        String contents = new String(" ");
        RequestDispatcher view = request.getRequestDispatcher("/about.jsp");
        File readme = null;
        
        try
        {
            /* I really want to parse the readme, but not gonna happen I guess
            readme = new File("/tmp/README.md");
            sc = new Scanner(readme);
            while(sc.hasNext())
            {
                String temp = sc.next();
                contents += temp + "\n";
            }
         
            request.setAttribute("README", Utils.getHTML(contents));
             */ 
            view.forward(request, response);
        }
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(AboutController.class.getName()).log(
                    Level.SEVERE, "No Such File.", ex);
        }
        catch (ServletException ex)
        {
            Logger.getLogger(AboutController.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(AboutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
