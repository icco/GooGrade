/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



package com.sitepoint;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;

/**
 *
 * @author vgerdin
 */
public class ToDoServlet extends HttpServlet implements ServletContextListener{
    
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ToDoServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ToDoServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /** 
    * Returns a short description of the servlet.
    */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void contextInitialized(ServletContextEvent sce)
    {
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("toDoList", new ToDoList(sc.getInitParameter("jdbcDriver"),sc.getInitParameter("jdbcConnectionString")));
        
    }

    public void contextDestroyed(ServletContextEvent arg0)
    {
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        ToDoList toDoList = (ToDoList)getServletContext().getAttribute("toDoList");
        List toDoItems = toDoList.getToDoItems();
        request.setAttribute("toDoItems", toDoItems);

        RequestDispatcher view = request.getRequestDispatcher("/todo.jsp");
        view.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

}
