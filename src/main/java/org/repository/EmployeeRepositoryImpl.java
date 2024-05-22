package org.repository;

import org.config.DatabaseConfig;
import org.model.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository{

    DatabaseConfig databaseConfig = new DatabaseConfig();
    @Override
    public List<Employee> getAll() throws SQLException {
        return null;
    }

    @Override
    public void add(Employee employee) {

    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Employee getById(Long id) {
        return null;
    }
}
