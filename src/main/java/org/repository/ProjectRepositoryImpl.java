package org.repository;

import org.config.DatabaseConfig;
import org.enums.Status;
import org.model.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepositoryImpl implements ProjectRepository {

    DatabaseConfig databaseConfig = new DatabaseConfig();

    @Override
    public List<Project> getAll() throws SQLException, ClassNotFoundException {
        List<Project> projects = new ArrayList<>();
        Connection connection = databaseConfig.getConnection();
        String query = "SELECT * FROM project";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Project project = new Project();
            project.setId(resultSet.getLong("id"));
            project.setName(resultSet.getString("name"));
            project.setGeolocation(resultSet.getString("geolocation"));
            project.setDateStart(resultSet.getDate("date_start"));
            project.setDateEnd(resultSet.getDate("date_end"));
            project.setStatus(Status.valueOf(resultSet.getString("status")));
            project.setDescription(resultSet.getString("description"));
            project.setRoom(resultSet.getInt("room"));
            project.setBath(resultSet.getInt("bath"));
            project.setGarage(resultSet.getInt("garage"));
            project.setTerrace(resultSet.getInt("terrace"));
            project.setWallMaterial(resultSet.getString("wall_material"));
            project.setFoundationType(resultSet.getString("foundation_type"));
            project.setRoofingType(resultSet.getString("roofing_type"));
            project.setAreaSize(resultSet.getDouble("area_size"));
            project.setBudget(resultSet.getDouble("budget"));
            project.setPlanFloor(resultSet.getString("plan_floor"));
            project.setPicture(resultSet.getString("picture"));
            projects.add(project);
        }
        resultSet.close();
        statement.close();
        return projects;
    }

    @Override
    public void add(Project project) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "INSERT INTO project (name, geolocation, date_start, date_end, status, description, room, " +
                "bath, garage, terrace, wall_material, foundation_type, roofing_type, area_size, budget, " +
                "plan_floor, picture) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, project.getName());
        statement.setString(2, project.getGeolocation());
        statement.setDate(3, project.getDateStart());
        statement.setDate(4, project.getDateEnd());
        statement.setString(5, project.getStatus().toString());
        statement.setString(6, project.getDescription());
        statement.setInt(7, project.getRoom());
        statement.setInt(8, project.getBath());
        statement.setInt(9, project.getGarage());
        statement.setInt(10, project.getTerrace());
        statement.setString(11, project.getWallMaterial());
        statement.setString(12, project.getFoundationType());
        statement.setString(13, project.getRoofingType());
        statement.setDouble(14, project.getAreaSize());
        statement.setDouble(15, project.getBudget());
        statement.setString(16, project.getPlanFloor());
        statement.setString(17, project.getPicture());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    @Override
    public void update(Project project) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "UPDATE project SET name = ?, geolocation = ?, date_start = ?, date_end = ?, status = ?, " +
                "description = ?, room = ?, bath = ?, garage = ?, terrace = ?, wall_material = ?, " +
                "foundation_type = ?, roofing_type = ?, area_size = ?, budget = ?, plan_floor = ?, picture = ? " +
                "WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, project.getName());
        statement.setString(2, project.getGeolocation());
        statement.setDate(3, project.getDateStart());
        statement.setDate(4, project.getDateEnd());
        statement.setString(5, project.getStatus().getStatusName());
        statement.setString(6, project.getDescription());
        statement.setInt(7, project.getRoom());
        statement.setInt(8, project.getBath());
        statement.setInt(9, project.getGarage());
        statement.setInt(10, project.getTerrace());
        statement.setString(11, project.getWallMaterial());
        statement.setString(12, project.getFoundationType());
        statement.setString(13, project.getRoofingType());
        statement.setDouble(14, project.getAreaSize());
        statement.setDouble(15, project.getBudget());
        statement.setString(16, project.getPlanFloor());
        statement.setString(17, project.getPicture());
        statement.setLong(18, project.getId());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    @Override
    public void delete(Long id) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "DELETE FROM project WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    @Override
    public Project getById(Long id) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "SELECT * FROM project WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();

        Project project = null;
        if (resultSet.next()) {
            project = new Project();
            project.setId(resultSet.getLong("id"));
            project.setName(resultSet.getString("name"));
            project.setGeolocation(resultSet.getString("geolocation"));
            project.setDateStart(resultSet.getDate("date_start"));
            project.setDateEnd(resultSet.getDate("date_end"));
            project.setStatus(Status.valueOf(resultSet.getString("status")));
            project.setDescription(resultSet.getString("description"));
            project.setRoom(resultSet.getInt("room"));
            project.setBath(resultSet.getInt("bath"));
            project.setGarage(resultSet.getInt("garage"));
            project.setTerrace(resultSet.getInt("terrace"));
            project.setWallMaterial(resultSet.getString("wall_material"));
            project.setFoundationType(resultSet.getString("foundation_type"));
            project.setRoofingType(resultSet.getString("roofing_type"));
            project.setAreaSize(resultSet.getDouble("area_size"));
            project.setBudget(resultSet.getDouble("budget"));
            project.setPlanFloor(resultSet.getString("plan_floor"));
            project.setPicture(resultSet.getString("picture"));
        }

        resultSet.close();
        statement.close();
        connection.close();
        return project;
    }

}
