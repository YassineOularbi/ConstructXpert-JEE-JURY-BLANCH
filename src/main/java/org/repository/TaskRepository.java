package org.repository;

import org.model.Task;

import java.sql.SQLException;
import java.util.List;

public interface TaskRepository {
    List<Task> getAll() throws SQLException, ClassNotFoundException;
    void add(Task task) throws SQLException, ClassNotFoundException;
    void update(Task task) throws SQLException, ClassNotFoundException;
    void delete(Long id) throws SQLException, ClassNotFoundException;
    Task getById(Long id) throws SQLException, ClassNotFoundException;
}
