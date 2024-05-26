package org.repository;

import org.model.*;

import java.sql.SQLException;
import java.util.List;

public interface ResourceRepository {
    List<Equipment> getAllEquipment() throws SQLException, ClassNotFoundException;
    List<Material> getAllMaterial() throws SQLException, ClassNotFoundException;
    List<Vehicle> getAllVehicle() throws SQLException, ClassNotFoundException;

    List<Resource> getAllAvailable() throws SQLException, ClassNotFoundException;
    void add(Resource resource) throws SQLException, ClassNotFoundException;
    void update(Resource resource) throws SQLException, ClassNotFoundException;
    void delete(Long id) throws SQLException, ClassNotFoundException;
    Resource getById(Long id) throws SQLException, ClassNotFoundException;
}
