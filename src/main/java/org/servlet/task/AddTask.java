package org.servlet.task;

import org.dto.UserDTO;
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
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@WebServlet(name = "AddTask", value = "/AddTask")
public class AddTask extends HttpServlet {
    TaskRepository taskRepository = new TaskRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        request.setAttribute("user", userDTO);
        Long id = Long.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        request.setAttribute("projectName", name);
        request.setAttribute("id", id);
        this.getServletContext().getRequestDispatcher("/CreateTask.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String title = request.getParameter("title");
        String type = request.getParameter("type");
        Date dateEnd = Date.valueOf(request.getParameter("date"));
        String description = request.getParameter("description");
        Priority priority = Priority.valueOf(request.getParameter("priority"));
        Status status = Status.valueOf(request.getParameter("status"));
        LocalDate date = LocalDate.now();
        Date dateStart = Date.valueOf(date);
        Task task = new Task(title, type, dateStart, dateEnd, description, priority, status);
        try {
            taskRepository.add(id, task);
            List<Task> taskList = taskRepository.getAll(id);
            request.setAttribute("taskToDo", taskList.stream().filter(task1 -> task1.getStatus().equals(Status.TODO)).collect(Collectors.toList()));
            request.setAttribute("taskInProgress", taskList.stream().filter(task1 -> task1.getStatus().equals(Status.IN_PROGRESS)).collect(Collectors.toList()));
            request.setAttribute("taskCompleted", taskList.stream().filter(task1-> task1.getStatus().equals(Status.COMPLETED)).collect(Collectors.toList()));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        request.setAttribute("user", userDTO);
        request.setAttribute("id", id);
        request.setAttribute("projectName", name);
        this.getServletContext().getRequestDispatcher("/Tasks.jsp").forward(request, response);
    }
}