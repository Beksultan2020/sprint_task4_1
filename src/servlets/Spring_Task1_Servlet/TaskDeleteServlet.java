package servlets.Spring_Task1_Servlet;

import Java_EE.Football.db.DBManager;
import Java_EE.Spring_Task1.DBManager_Tasks;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/task-delete")
public class TaskDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id=Long.parseLong(req.getParameter("task_id"));
        DBManager_Tasks.deleteTask(id);
        resp.sendRedirect("/");
    }
}
