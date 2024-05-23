package org.repository;

import org.model.Project;

import java.sql.SQLException;
import java.util.List;

public interface ProjectRepository {
    List<Project> getAll() throws SQLException, ClassNotFoundException;
    void add(Project project) throws SQLException, ClassNotFoundException;
    void update(Project Project) throws SQLException, ClassNotFoundException;
    void delete(Long id) throws SQLException, ClassNotFoundException;
    Project getById(Long id) throws SQLException, ClassNotFoundException;
}
