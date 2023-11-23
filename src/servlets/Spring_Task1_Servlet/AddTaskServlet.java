package servlets.Spring_Task1_Servlet;

import Java_EE.Spring_Task1.DBManager_Tasks;
import Java_EE.Spring_Task1.Tasks;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/add-task-servlet")
public class AddTaskServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("task_name");
        String description=req.getParameter("task_description");
        String deadlineDate=req.getParameter("task_deadlineDate");
        Tasks tasks=new Tasks();
        tasks.setName(name);
        tasks.setDescription(description);
        tasks.setDeadlineDate(deadlineDate);
        DBManager_Tasks.addTask(tasks);
        resp.sendRedirect("/");
    }
}
