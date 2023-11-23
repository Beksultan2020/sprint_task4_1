package servlets.Spring_Task1_Servlet;

import Java_EE.Spring_Task1.DBManager_Tasks;
import Java_EE.Spring_Task1.Tasks;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/task-details")
public class TaskDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id=Long.parseLong(req.getParameter("id"));
        Tasks tasks= DBManager_Tasks.getTask(id);
        req.setAttribute("zadacha",tasks);
        req.getRequestDispatcher("WEB-INF/Spring_task1_JSP/taskDetails.jsp").forward(req,resp);
    }
}
