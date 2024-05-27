package org.repository;

import org.config.DatabaseConfig;
import org.enums.Priority;
import org.enums.Status;
import org.model.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {

    DatabaseConfig databaseConfig = new DatabaseConfig();

    @Override
    public List<Task> getAll(Long id) throws SQLException, ClassNotFoundException {
        List<Task> tasks = new ArrayList<>();
        Connection connection = databaseConfig.getConnection();
        String query = "SELECT * FROM task WHERE id_project = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Task task = new Task();
            task.setId(resultSet.getLong("id"));
            task.setTitle(resultSet.getString("title"));
            task.setType(resultSet.getString("type"));
            task.setStartDate(resultSet.getDate("start_date"));
            task.setEndDate(resultSet.getDate("end_date"));
            task.setDescription(resultSet.getString("description")); // Ajout de la description
            task.setPriority(Priority.valueOf(resultSet.getString("priority")));
            task.setStatus(Status.valueOf(resultSet.getString("status")));
            tasks.add(task);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return tasks;
    }

    @Override
    public Long add(Long id, Task task) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "INSERT INTO task (title, type, start_date, end_date, description, priority, status, id_project) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, task.getTitle());
        statement.setString(2, task.getType());
        statement.setDate(3, task.getStartDate());
        statement.setDate(4, task.getEndDate());
        statement.setString(5, task.getDescription());
        statement.setString(6, task.getPriority().name());
        statement.setString(7, task.getStatus().name());
        statement.setLong(8, id);
        statement.executeUpdate();
        String getIdQuery = "SELECT id FROM task WHERE id_project = ? AND title = ?";
        PreparedStatement getIdStatement = connection.prepareStatement(getIdQuery);
        getIdStatement.setLong(1, id);
        getIdStatement.setString(2, task.getTitle());
        ResultSet resultSet = getIdStatement.executeQuery();
        Long idTask = null;
        if (resultSet.next()) {
           idTask = resultSet.getLong("id");
        }
        getIdStatement.close();
        statement.close();
        connection.close();
        return idTask;
    }

    @Override
    public void update(Task task) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "UPDATE task SET title=?, type=?, start_date=?, end_date=?, description=?, priority=?, status=? WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, task.getTitle());
        statement.setString(2, task.getType());
        statement.setDate(3, task.getStartDate());
        statement.setDate(4, task.getEndDate());
        statement.setString(5, task.getDescription());
        statement.setString(6, task.getPriority().name());
        statement.setString(7, task.getStatus().name());
        statement.setLong(8, task.getId());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    @Override
    public void delete(Long id) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "DELETE FROM task WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    @Override
    public Task getById(Long id) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "SELECT * FROM task WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        Task task = null;
        if (resultSet.next()) {
            task = new Task();
            task.setId(resultSet.getLong("id"));
            task.setTitle(resultSet.getString("title"));
            task.setType(resultSet.getString("type"));
            task.setStartDate(resultSet.getDate("start_date"));
            task.setEndDate(resultSet.getDate("end_date"));
            task.setDescription(resultSet.getString("description"));
            task.setPriority(Priority.valueOf(resultSet.getString("priority")));
            task.setStatus(Status.valueOf(resultSet.getString("status")));
        }
        resultSet.close();
        statement.close();
        connection.close();
        return task;
    }

    @Override
    public void updateTaskStatus(Long id, Status status) throws SQLException, ClassNotFoundException {
        Connection connection = databaseConfig.getConnection();
        String query = "UPDATE task SET status = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, String.valueOf(status));
        statement.setLong(2, id);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }
}
