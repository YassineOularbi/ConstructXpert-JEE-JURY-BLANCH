package org.servlet.project;

import org.enums.Status;
import org.model.Project;
import org.repository.ProjectRepository;
import org.repository.ProjectRepositoryImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "ProjectServlet", value = "/ProjectServlet")
public class ProjectServlet extends HttpServlet {
    ProjectRepository projectRepository = new ProjectRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            projectRepository.delete(1L);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String geolocation = request.getParameter("geolocation");
        Date dateStart = Date.valueOf(request.getParameter("dateStart"));
        Date dateEnd = Date.valueOf(request.getParameter("dateEnd"));
        Status status = Status.valueOf(request.getParameter("status"));
        String description = request.getParameter("description");
        Integer room = Integer.parseInt(request.getParameter("room"));
        Integer bath = Integer.parseInt(request.getParameter("bath"));
        Integer garage = Integer.parseInt(request.getParameter("garage"));
        Integer terrace = Integer.parseInt(request.getParameter("terrace"));
        String wallMaterial = request.getParameter("wallMaterial");
        String foundationType = request.getParameter("foundationType");
        String roofingType = request.getParameter("roofingType");
        Double areaSize = Double.parseDouble(request.getParameter("areaSize"));
        Double budget = Double.parseDouble(request.getParameter("budget"));
        String planFloor = request.getParameter("planFloor");
        String picture = request.getParameter("picture");

        Project project = new Project(name, geolocation, dateStart, dateEnd, status, description, room, bath, garage, terrace,
                wallMaterial, foundationType, roofingType, areaSize, budget, planFloor, picture);
        try {
            projectRepository.add(project);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}