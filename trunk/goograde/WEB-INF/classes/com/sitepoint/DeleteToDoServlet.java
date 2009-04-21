package com.sitepoint;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class DeleteToDoServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String deleteid = request.getParameter("deleteid");
        if (deleteid != null) {
            try {
                ToDoList toDoList = (ToDoList)getServletContext().getAttribute("toDoList");
                toDoList.deleteItem(Integer.parseInt(deleteid));
            }
            catch (NumberFormatException e) {
                throw new ServletException("Bad deleteid value submitted.", e);
            }
        }
        response.sendRedirect("index.html");
    }
}