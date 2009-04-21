package com.sitepoint;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AddToDoServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String newToDo = request.getParameter("newtodo");
        if (newToDo != null) {
            ToDoList toDoList = (ToDoList)getServletContext().getAttribute("toDoList");
            toDoList.addItem(newToDo);
        }
        response.sendRedirect("index.html");
    }
}