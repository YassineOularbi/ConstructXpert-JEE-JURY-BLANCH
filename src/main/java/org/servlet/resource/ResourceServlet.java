package org.servlet.resource;

import org.model.Equipment;
import org.model.Material;
import org.model.Vehicle;
import org.service.EquipmentService;
import org.service.MaterialService;
import org.service.VehicleService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ResourceServlet", value = "/ResourceServlet")
public class ResourceServlet extends HttpServlet {
    VehicleService vehicleService = new VehicleService();
    EquipmentService equipmentService = new EquipmentService();
    MaterialService materialService = new MaterialService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Vehicle vehicle = new Vehicle("Voiture de service", "Car", "Fournisseur A", null, "image.jpg", "2", true);
        Equipment equipment = new Equipment("Outil de travail", "Tool", "Fournisseur B", null, "outil.jpg", "5", true);
        Material material = new Material("Matériau de construction", "Construction Material", "Fournisseur C", null, "materiau.jpg", "10", true);
        try {
            vehicleService.add(vehicle);
            equipmentService.add(equipment);
            materialService.add(material);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}