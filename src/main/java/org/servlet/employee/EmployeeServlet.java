package org.servlet.employee;

import org.model.Supervisor;
import org.model.Team;
import org.service.SupervisorService;
import org.service.TeamService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EmployeeServlet", value = "/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    SupervisorService supervisorService = new SupervisorService();
    TeamService teamService = new TeamService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Supervisor supervisor = new Supervisor("yassine", "John Doe", "Project Manager", true, null);
        System.out.println(supervisor);

        Team teamMember = new Team(2L,"yassine", "Jane Smith", "Developer", true, null);
        System.out.println(teamMember);

        try {
            supervisorService.add(supervisor);
            teamService.update(teamMember);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}