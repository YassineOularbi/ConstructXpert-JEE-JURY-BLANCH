<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ajouter une tâche</title>
  <!-- Bootstrap CSS -->
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
  <h1>Ajouter une tâche</h1>
  <form action="TaskServlet" method="POST">
    <div class="form-group">
      <label for="title">Titre :</label>
      <input type="text" class="form-control" id="title" name="title" required>
    </div>
    <div class="form-group">
      <label for="type">Type :</label>
      <input type="text" class="form-control" id="type" name="type" required>
    </div>
    <div class="form-group">
      <label for="startDate">Date de début :</label>
      <input type="date" class="form-control" id="startDate" name="startDate">
    </div>
    <div class="form-group">
      <label for="endDate">Date de fin :</label>
      <input type="date" class="form-control" id="endDate" name="endDate">
    </div>
    <div class="form-group">
      <label for="description">Description :</label>
      <textarea class="form-control" id="description" name="description" rows="3"></textarea>
    </div>
    <div class="form-group">
      <label for="priority">Priorité :</label>
      <select class="form-control" id="priority" name="priority" required>
        <option value="LOW">Faible</option>
        <option value="MEDIUM">Moyenne</option>
        <option value="HIGH">Élevée</option>
      </select>
    </div>
    <div class="form-group">
      <label for="status">Statut :</label>
      <select class="form-control" id="status" name="status" required>
        <option value="TODO">À faire</option>
        <option value="IN_PROGRESS">En cours</option>
        <option value="COMPLETED">Terminé</option>
      </select>
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
