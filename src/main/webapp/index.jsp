<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ajouter un projet</title>
  <!-- Bootstrap CSS -->
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
  <h1>Ajouter un projet</h1>
  <form action="ProjectServlet" method="POST">
    <div class="form-group">
      <label for="name">Nom :</label>
      <input type="text" class="form-control" id="name" name="name" required>
    </div>
    <div class="form-group">
      <label for="geolocation">Géolocalisation :</label>
      <input type="text" class="form-control" id="geolocation" name="geolocation">
    </div>
    <div class="form-group">
      <label for="dateStart">Date de début :</label>
      <input type="date" class="form-control" id="dateStart" name="dateStart">
    </div>
    <div class="form-group">
      <label for="dateEnd">Date de fin :</label>
      <input type="date" class="form-control" id="dateEnd" name="dateEnd">
    </div>
    <div class="form-group">
      <label for="status">Statut :</label>
      <select class="form-control" id="status" name="status" required>
        <option value="TODO">À faire</option>
        <option value="IN_PROGRESS">En cours</option>
        <option value="COMPLETED">Terminé</option>
      </select>
    </div>
    <div class="form-group">
      <label for="description">Description :</label>
      <textarea class="form-control" id="description" name="description" rows="3"></textarea>
    </div>
    <div class="form-group">
      <label for="room">Nombre de pièces :</label>
      <input type="number" class="form-control" id="room" name="room">
    </div>
    <div class="form-group">
      <label for="bath">Nombre de salles de bains :</label>
      <input type="number" class="form-control" id="bath" name="bath">
    </div>
    <div class="form-group">
      <label for="garage">Nombre de garages :</label>
      <input type="number" class="form-control" id="garage" name="garage">
    </div>
    <div class="form-group">
      <label for="terrace">Nombre de terrasses :</label>
      <input type="number" class="form-control" id="terrace" name="terrace">
    </div>
    <div class="form-group">
      <label for="wallMaterial">Matériau de mur :</label>
      <input type="text" class="form-control" id="wallMaterial" name="wallMaterial">
    </div>
    <div class="form-group">
      <label for="foundationType">Type de fondation :</label>
      <input type="text" class="form-control" id="foundationType" name="foundationType">
    </div>
    <div class="form-group">
      <label for="roofingType">Type de toiture :</label>
      <input type="text" class="form-control" id="roofingType" name="roofingType">
    </div>
    <div class="form-group">
      <label for="areaSize">Superficie :</label>
      <input type="number" step="0.01" class="form-control" id="areaSize" name="areaSize">
    </div>
    <div class="form-group">
      <label for="budget">Budget :</label>
      <input type="number" step="0.01" class="form-control" id="budget" name="budget">
    </div>
    <div class="form-group">
      <label for="planFloor">Plan de l'étage :</label>
      <input type="text" class="form-control" id="planFloor" name="planFloor">
    </div>
    <div class="form-group">
      <label for="picture">Image :</label>
      <input type="file" class="form-control-file" id="picture" name="picture">
    </div>
    <button type="submit" class="btn btn-primary">Ajouter</button>
  </form>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
