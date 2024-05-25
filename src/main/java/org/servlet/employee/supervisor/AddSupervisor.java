package org.servlet.employee.supervisor;

import org.dto.UserDTO;
import org.model.Supervisor;
import org.service.SupervisorService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "AddSupervisor", value = "/AddSupervisor")
public class AddSupervisor extends HttpServlet {
    SupervisorService supervisorService = new SupervisorService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        request.setAttribute("user", userDTO);
        this.getServletContext().getRequestDispatcher("/CreateSupervisor.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String picture = request.getParameter("picture");
        Supervisor supervisor = new Supervisor(name, type, picture, true);
        try {
            request.setAttribute("supervisors", supervisorService.getAllSupervisors());
            supervisorService.add(supervisor);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        HttpSession session = request.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        request.setAttribute("user", userDTO);
        this.getServletContext().getRequestDispatcher("/Supervisors.jsp").forward(request, response);
    }
}