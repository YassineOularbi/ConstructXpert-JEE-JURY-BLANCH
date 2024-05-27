<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 27/05/2024
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ConstructXpert</title>
    <link rel="shortcut icon" href="assets/logo-head.png" type="image/x-icon">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
    <style><%@include file="css/dashboard.css"%></style>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Barlow:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&amp;family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700;1,800&amp;display=swap">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

</head>
<body>
<nav class="sidebar">
    <div class="menu-bar">
        <div class="menu d-flex flex-column justify-content-between">
            <div class="first-option">
                <div class="menu-links">
                    <a class="nav-link my-2" href="dashboard">
                        <i class='bx bxs-dashboard'></i>
                        <span class="text nav-text">Dashboard</span>
                    </a>
                    <a class="nav-link my-2 active  hovered" href="projects">
                        <i class='bx bxs-building-house'></i>
                        <span class="text nav-text">Project</span>
                    </a>
                    <a class="nav-link my-2" href="teams">
                        <i class="fa-solid fa-users active-i"></i>
                        <span class="text nav-text active-span">Team</span>
                    </a>
                    <a class="nav-link my-2" href="supervisors">
                        <i class="fa-solid fa-user-tie"></i>
                        <span class="text nav-text">Supervisor</span>
                    </a>
                    <a class="nav-link my-2" href="vehicles">
                        <i class="fa-solid fa-truck-front"></i>
                        <span class="text nav-text">Vehicle</span>
                    </a>
                    <a class="nav-link my-2" href="equipments">
                        <i class="fa-solid fa-screwdriver-wrench"></i>
                        <span class="text nav-text">Equipment</span>
                    </a>
                    <a class="nav-link my-2" href="materials">
                        <i class="fa-solid fa-recycle"></i>
                        <span class="text nav-text">Material</span>
                    </a>
                </div>
            </div>
            <div class="last-option">
                <a class="nav-link my-2">
                    <i class="fa-solid fa-circle-info"></i>
                    <span class="text nav-text">Support & help</span>
                </a>
                <a class="nav-link my-2">
                    <i class="fa-solid fa-gear"></i>
                    <span class="text nav-text">Setting</span>
                </a>
                <a class="nav-link my-2">
                    <i class="fa-solid fa-right-from-bracket"></i>
                    <span class="text nav-text">Log out</span>
                </a>
            </div>
        </div>
    </div>
</nav>
<header class="header">
    <div class="topbar">
        <div class="toggle">
            <i class="fa-solid fa-bars"></i>
        </div>
        <div class="logo">
            <img src="assets/logo-white.png" alt="">
        </div>
        <div class="search">
            <label>
                <input type="text" placeholder="Search here">
                <i class="fa-solid fa-magnifying-glass"></i>
            </label>
        </div>
        <div class="icon">
            <i class="fa-regular fa-bell"></i>
            <i class="fa-regular fa-comment"></i>
        </div>
        <div class="info-user d-flex flex-column">
            <span>${user.getName()}</span>
            <span>${user.getRole()}</span>
        </div>
        <div class="user">
            <img src="${user.getPicture()}">
        </div>
</header>
<section class="main">
    <div class="main-header d-flex flex-row justify-content-between">
        <div class="main-section d-flex flex-row justify-content-between" style="width: 100%;">
            <h6>Projects <span>&#x2794; View Task</span> <span>&#x2794; ${projectName}</span></h6>
        </div>
    </div>
    <div class="task-details">
        <h6>Title Task</h6>
        <div class="details">
            <div class="d-flex flex-row justify-content-between">
                <div>
                    <i class="fa-solid fa-signal"></i>
                    <span>Status </span>
                </div>
                <p class="status"> Done</p>
            </div>
            <div class="d-flex flex-row justify-content-between">
                <div>
                    <i class="fa-solid fa-bolt"></i>
                    <span>Priority </span>
                </div>
                <p class="status"> High</p>
            </div>
            <div class="d-flex flex-row justify-content-between">
                <div>
                    <i class="fa-brands fa-square-font-awesome-stroke"></i>
                    <span>Type </span>
                </div>
                <p> Enginnering</p>
            </div>
            <div class="d-flex flex-row justify-content-between">
                <div>
                    <i class="fa-solid fa-calendar-check"></i>
                    <span>Due date </span>
                </div>
                <p> 24 march 2025</p>
            </div>
            <div class="desc d-flex flex-column justify-content-between">
                <div>
                    <i class="fa-solid fa-font"></i>
                    <span>Description </span>
                </div>
                <span>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Beatae, sunt! Pariatur consequuntur debitis deleniti quisquam rerum quae vitae accusantium in dolor non laborum, neque animi fugiat cum, praesentium explicabo! Animi.</span>
            </div>
        </div>
        <a class="update-task" href="">Update</a>
    </div>
    <div class="employee-details">
        <h6>Employee</h6>
        <div class="employee">
            <div class="d-flex flex-row justify-content-between">
                <div>
                    <i class="fa-solid fa-user-tie"></i>
                    <span>Leader </span>
                </div>
                <div class="user d-flex flex-row justify-content-start align-items-center">
                    <img src="assets/logo-head.png" alt="">
                    <p>Mohammed</p>
                </div>

            </div>
            <div class="d-flex flex-row justify-content-between">
                <div>
                    <i class="fa-solid fa-people-group"></i>
                    <span>Team </span>
                </div>
                <div class="user d-flex flex-row justify-content-start align-items-center">
                    <img src="assets/logo-head.png" alt="">
                    <p>Team A</p>
                </div>
            </div>
            <a class="update-employee" href="">Update</a>
        </div>
    </div>
    <div class="resource-details">
        <h6>Resources</h6>
        <div class="overflow">
            <div class="scroll  d-flex flex-row">
                <c:forEach var="material" items="${materials}">
                    <label for="material${material.getId()}">
                        <img src="assets/silicate-brick.png" alt="">
                    </label>
                </c:forEach>
                <a class="update-resource" href="">Update</a>
                <a class="add-resource" href="">Add</a>
            </div>
        </div>
    </div>
    <div class="task-action">
        <a class="save" href="">Save</a>
        <a class="delete" href="">Delete</a>
    </div>
</section>
<script src="https://kit.fontawesome.com/6150be860f.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.7.1/dist/chart.min.js"></script>
<script><%@include file="js/chart.js"%></script>
<script src='https://cdn.jsdelivr.net/npm/@fullcalendar/core@6.1.13/index.global.min.js'></script>
<script src='https://cdn.jsdelivr.net/npm/@fullcalendar/daygrid@6.1.13/index.global.min.js'></script>
<script><%@include file="js/calendar.js"%></script>

</body>
</html>

