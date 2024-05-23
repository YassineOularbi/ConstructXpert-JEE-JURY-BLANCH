package org.servlet.task;

import org.enums.Priority;
import org.enums.Status;
import org.model.Task;
import org.repository.TaskRepository;
import org.repository.TaskRepositoryImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "TaskServlet", value = "/TaskServlet")
public class TaskServlet extends HttpServlet {

    TaskRepository taskRepository = new TaskRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Task> tasks = taskRepository.getAll();
            tasks.forEach(System.out::println);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String type = request.getParameter("type");
        Date startDate = Date.valueOf(request.getParameter("startDate"));
        Date endDate = Date.valueOf(request.getParameter("endDate"));
        String description = request.getParameter("description");
        Priority priority = Priority.valueOf(request.getParameter("priority"));
        Status status = Status.valueOf(request.getParameter("status"));
        Task task = new Task(title, type, startDate, endDate, description, priority, status);
        try {
            taskRepository.add(task);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}