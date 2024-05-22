<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ajouter un utilisateur</title>
  <!-- Bootstrap CSS -->
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
  <h1 class="mb-4">Ajouter un utilisateur</h1>
  <form action="UserServlet" method="post">
    <div class="form-group">
      <label for="name">Nom</label>
      <input type="text" class="form-control" id="name" name="name" required>
    </div>
    <div class="form-group">
      <label for="userName">Nom d'utilisateur</label>
      <input type="text" class="form-control" id="userName" name="userName" required>
    </div>
    <div class="form-group">
      <label for="userEmail">Email</label>
      <input type="email" class="form-control" id="userEmail" name="userEmail" required>
    </div>
    <div class="form-group">
      <label for="password">Mot de passe</label>
      <input type="password" class="form-control" id="password" name="password" required>
    </div>
    <div class="form-group">
      <label for="picture">Mot de passe</label>
      <input type="url" class="form-control" id="picture" name="picture" required>
    </div>
    <div class="form-group">
      <label for="role">Rôle</label>
      <select class="form-control" id="role" name="role" required>
        <option value="ADMIN">Admin</option>
        <option value="CLIENT">Client</option>
        <option value="SUPERVISOR">Supervisor</option>
      </select>
    </div>
    <button type="submit" class="btn btn-primary">Ajouter</button>
  </form>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
