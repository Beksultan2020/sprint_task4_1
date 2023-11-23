package servlets.Spring_Task1_Servlet;

import Java_EE.Spring_Task1.DBManager_Tasks;
import Java_EE.Spring_Task1.Tasks;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/")
public class Servlet_SpringT1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Tasks>tasks= DBManager_Tasks.getAllTasks();
        req.setAttribute("zadachi",tasks);
        req.getRequestDispatcher("WEB-INF/Spring_task1_JSP/SPT1_home.jsp").forward(req,resp);
    }
}

