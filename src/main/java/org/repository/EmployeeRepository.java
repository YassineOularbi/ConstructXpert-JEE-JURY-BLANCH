package org.repository;

import org.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeRepository {
    List<Employee> getAll() throws SQLException;
    void add(Employee employee);
    void update(Employee employee);
    void delete(Long id);
    Employee getById(Long id);
}
