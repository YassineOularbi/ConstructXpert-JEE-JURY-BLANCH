package org.servlet.task;

import org.enums.Status;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "UpdateTaskStatus", value = "/UpdateTaskStatus")
public class UpdateTaskStatus extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputStream inputStream = request.getInputStream();
        JsonReader jsonReader = Json.createReader(inputStream);
        JsonObject jsonObject = jsonReader.readObject();
        jsonReader.close();
        Long id = Long.valueOf(String.valueOf(jsonObject.getJsonNumber("id")));
        String status = jsonObject.getString("status");
        System.out.println("id: " + id);
        System.out.println("status: " + status);
    }
}