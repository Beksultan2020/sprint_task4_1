package servlets.Spring_Task1_Servlet;

import Java_EE.Spring_Task1.DBManager_Tasks;
import Java_EE.Spring_Task1.Tasks;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/task-edit")
public class TaskEditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id=Long.parseLong(req.getParameter("task_id"));
        String name=req.getParameter("task_name");
        String description=req.getParameter("task_description");
        String deadlineDate=req.getParameter("task_deadlineDate");
        String done=req.getParameter("task_done");
        Tasks tasks= DBManager_Tasks.getTask(id);
        if(tasks != null){
            tasks.setName(name);
            tasks.setDescription(description);
            tasks.setDeadlineDate(deadlineDate);
            tasks.setDone(done);
        }
        resp.sendRedirect("/");
    }
}
