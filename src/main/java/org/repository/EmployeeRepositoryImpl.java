package org.repository;

import org.config.DatabaseConfig;
import org.enums.EmployeeType;
import org.model.Employee;
import org.model.Supervisor;
import org.model.Team;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    DatabaseConfig databaseConfig = new DatabaseConfig();

    @Override
    public List<Supervisor> getAllSupervisor() throws SQLException, ClassNotFoundException {
        List<Supervisor> supervisors = new ArrayList<>();
        Connection connection = databaseConfig.getConnection();
        String query = "SELECT * FROM employee WHERE employee_type = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, EmployeeType.SUPERVISOR.toString());
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Supervisor supervisor = new Supervisor();
            supervisor.setId(resultSet.getLong("id"));
            supervisor.setName(resultSet.getString("name"));
            supervisor.setJobType(resultSet.getString("job_type"));
            supervisor.setPicture(resultSet.getString("picture"));
            supervisor.setAvailability(resultSet.getBoolean("availability"));
            supervisor.setEmployeeType(EmployeeType.valueOf(resultSet.getString("employee_type")));
            supervisors.add(supervisor);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return supervisors;
    }

    @Override
    public List<Team> getAllTeam() throws SQLException, ClassNotFoundException {
        List<Team> teams = new ArrayList<>();
        Connection connection = databaseConfig.getConnection();
        String query = "SELECT * FROM employee WHERE employee_type = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, EmployeeType.TEAM.toString());
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Team teamMember = new Team();
            teamMember.setId(resultSet.getLong("id"));
            teamMember.setName(resultSet.getString("name"));
            teamMember.setJobType(resultSet.getString("job_type"));
            teamMember.setPicture(resultSet.getString("picture"));
            teamMember.setAvailability(resultSet.getBoolean("availability"));
            teamMember.setEmployeeType(EmployeeType.valueOf(resultSet.getString("employee_type")));
            teams.add(teamMember);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return teams;
    }

    @Override
    public void add(Employee employee) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "INSERT INTO employee (name, job_type, picture, availability, employee_type) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, employee.getName());
        statement.setString(2, employee.getJobType());
        statement.setString(3, employee.getPicture());
        statement.setBoolean(4, employee.getAvailability());
        statement.setString(5, employee.getEmployeeType().toString());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    @Override
    public void update(Employee employee) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "UPDATE employee SET name = ?, job_type = ?, picture = ?, availability = ?, employee_type = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, employee.getName());
        statement.setString(2, employee.getJobType());
        statement.setString(3, employee.getPicture());
        statement.setBoolean(4, employee.getAvailability());
        statement.setString(5, employee.getEmployeeType().toString());
        statement.setLong(6, employee.getId());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    @Override
    public void delete(Long id) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "DELETE FROM employee WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    @Override
    public Employee getById(Long id) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "SELECT * FROM employee WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        Employee employee = null;
        if (resultSet.next()) {
            employee = new Employee();
            employee.setId(resultSet.getLong("id"));
            employee.setName(resultSet.getString("name"));
            employee.setJobType(resultSet.getString("job_type"));
            employee.setPicture(resultSet.getString("picture"));
            employee.setAvailability(resultSet.getBoolean("availability"));
            employee.setEmployeeType(EmployeeType.valueOf(resultSet.getString("employee_type")));
        }
        resultSet.close();
        statement.close();
        connection.close();
        return employee;
    }
}
