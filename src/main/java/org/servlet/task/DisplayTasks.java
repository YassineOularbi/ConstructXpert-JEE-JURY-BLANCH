package org.servlet.task;

import org.dto.UserDTO;
import org.enums.Status;
import org.repository.TaskRepository;
import org.repository.TaskRepositoryImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.stream.Collectors;

@WebServlet(name = "DisplayTasks", value = "/DisplayTasks")
public class DisplayTasks extends HttpServlet {
    TaskRepository taskRepository = new TaskRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        request.setAttribute("user", userDTO);
        request.setAttribute("projectName", name);
        request.setAttribute("id", id);
        try {
            request.setAttribute("taskToDo", taskRepository.getAll().stream().filter(task -> task.getStatus().equals(Status.TODO)).collect(Collectors.toList()));
            request.setAttribute("taskInProgress", taskRepository.getAll().stream().filter(task -> task.getStatus().equals(Status.IN_PROGRESS)).collect(Collectors.toList()));
            request.setAttribute("taskCompeted", taskRepository.getAll().stream().filter(task -> task.getStatus().equals(Status.COMPLETED)).collect(Collectors.toList()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.getServletContext().getRequestDispatcher("/Tasks.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}