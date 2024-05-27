# Système de Gestion de Projets de Construction avec Java EE et Frontend Web
Ce repository contient un projet de gestion de projets de construction développé pour l’entreprise « ConstructionXpert Services ». L'application offre des fonctionnalités complètes pour gérer les projets, les tâches et les ressources, avec une interface utilisateur conviviale et des fonctionnalités CRUD complètes.
<div align="center" style="display: flex; flex-direction: row; align-items: flex-start;" >
  <img src="https://i.ibb.co/4TmB4Hk/logo-white.png" alt="Enaa Logo" height="130" width="300"/>
</div>

## Table des Matières

- [Fonctionnalités](#fonctionnalités)
- [Technologies Utilisées](#technologies-utilisées)
- [Prérequis](#prérequis)
- [Installation et Configuration](#installation-et-configuration)
- [Usage](#usage)
- [Auteurs](#auteurs)

### Gestion des Projets
- **Créer un nouveau projet** : spécifiez le nom, la description, la date de début, la date de fin et le budget.
- **Afficher la liste des projets** : avec leurs détails.
- **Mettre à jour un projet** : modifiez les détails d'un projet existant.
- **Supprimer un projet** : retirez un projet du système.

### Gestion des Tâches
- **Créer une nouvelle tâche** : spécifiez la description, la date de début, la date de fin, le statut (à faire, en cours, terminé) et les ressources nécessaires.
- **Afficher la liste des tâches** : associées à un projet avec leurs détails.
- **Mettre à jour une tâche** : modifiez les détails d'une tâche existante.
- **Supprimer une tâche** : retirez une tâche du système.

### Gestion des Ressources
- **Ajouter de nouvelles ressources** : spécifiez le nom, le type, la quantité et les informations du fournisseur.
- **Afficher la liste des ressources** : disponibles avec leurs détails.
- **Mettre à jour une ressource** : modifiez les détails d'une ressource existante.
- **Supprimer une ressource** : retirez une ressource du système.

### Bonus
- **Authentification** : Authentification des utilisateurs pour l'accès aux fonctionnalités protégées à l'aide de filtres JEE.

- **Gestion des sessions** : Maintenez l'état de l'utilisateur.

- **Exportation** : Exportez les ressources en format PDF.

- **Graphiques Dynamiques avec Chart.js :** Utilisation de la bibliothèque Chart.js pour créer des graphiques dynamiques et interactifs pour visualiser les données liées aux projets de construction, aux tâches, etc.

- **Gestion des Événements avec FullCalendar.io :** Intégration de FullCalendar.io pour gérer et afficher les événements liés aux projets.

- **Fonctionnalité de Drag-and-Drop :** Implémentation de la fonctionnalité de drag-and-drop pour permettre aux utilisateurs de déplacer facilement les tâches l'interface graphique du projet.


## Technologies Utilisées

![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white) ![Java EE](https://img.shields.io/badge/Java%20EE-007396?style=for-the-badge&logo=java&logoColor=white) ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white) ![Apache Tomcat](https://img.shields.io/badge/Apache%20Tomcat-F8DC75?style=for-the-badge&logo=apache-tomcat&logoColor=black) ![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white) ![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white) ![HTML](https://img.shields.io/badge/HTML-E34F26?style=for-the-badge&logo=html5&logoColor=white) ![CSS](https://img.shields.io/badge/CSS-1572B6?style=for-the-badge&logo=css3&logoColor=white) ![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black) ![Bootstrap](https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white)

## Prérequis

Avant de commencer, assurez-vous d'avoir installé les éléments suivants :

- Java JDK 1.8
- MySQL Server 8.0.28
- Apache Tomcat 8.5
- Maven 3.3.2

## Installation et Configuration

### Backend (Java EE)

1. Clonez ce dépôt sur votre machine locale.
   ```sh
   git clone https://github.com/YassineOularbi/ConstructXpert-JEE-JURY-BLANCH.git
2. Importez le projet dans votre IDE (Eclipse, IntelliJ IDEA).
3. Configurez votre base de données MySQL en créant une nouvelle base de données nommée construction_db.
4. Ouvrez le fichier `DatabaseConfig.java` situé dans le répertoire `org/config`.
5. Modifiez les champs `url`, `username` et `password` selon votre base de données.

Exemple pour MySQL :
```java
private static final String url = "jdbc:mysql://localhost:3306/construction_db";
private static final String username = "votre_nom_utilisateur_mysql";
private static final String password = "votre_mot_de_passe_mysql";
```
### Création des Tables dans la Base de Données

Voici la requête SQL pour créer les tables nécessaires dans la base de données :

```sql
CREATE TABLE user_table (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name_user VARCHAR(255) NOT NULL,
    user_name VARCHAR(255) NOT NULL UNIQUE,
    user_email VARCHAR(255) NOT NULL UNIQUE,
    user_password VARCHAR(255) NOT NULL,
    picture VARCHAR(255),
    user_role ENUM('ADMIN', 'CLIENT', 'SUPERVISOR') NOT NULL
);

CREATE TABLE project (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    geolocation VARCHAR(255),
    date_start DATE,
    date_end DATE,
    status ENUM('TODO', 'IN_PROGRESS', 'COMPLETED') NOT NULL,
    description TEXT,
    room INT,
    bath INT,
    garage INT,
    terrace INT,
    wall_material VARCHAR(255),
    foundation_type VARCHAR(255),
    roofing_type VARCHAR(255),
    area_size DOUBLE,
    budget DOUBLE,
    plan_floor VARCHAR(255),
    picture VARCHAR(255)
);

CREATE TABLE task (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    start_date DATE,
    end_date DATE,
    description TEXT,
    priority ENUM('LOW', 'MEDIUM', 'HIGH') NOT NULL,
    status ENUM('TODO', 'IN_PROGRESS', 'COMPLETED') NOT NULL,
    id_project BIGINT NOT NULL,
    FOREIGN KEY (id_project) REFERENCES project (id)
);

CREATE TABLE employee (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    job_type VARCHAR(255) NOT NULL,
    picture VARCHAR(255),
    availability BOOLEAN NOT NULL,
    employee_type ENUM('SUPERVISOR', 'TEAM') NOT NULL
);

CREATE TABLE resource (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    provider VARCHAR(255),
    acquisition_date DATE,
    picture VARCHAR(255),
    quantity VARCHAR(255),
    availability BOOLEAN NOT NULL,
    resource_type ENUM('EQUIPMENT', 'VEHICLE', 'MATERIAL') NOT NULL
);

CREATE TABLE task_resource (
    id_task BIGINT NOT NULL,
    id_resource BIGINT NOT NULL,
    quantity VARCHAR(255) NOT NULL,
    FOREIGN KEY (id_task) REFERENCES task(id),
    FOREIGN KEY (id_resource) REFERENCES resource(id)
);

CREATE TABLE task_employee (
    id_task BIGINT NOT NULL,
    id_employee BIGINT NOT NULL,
    FOREIGN KEY (id_task) REFERENCES task(id),
    FOREIGN KEY (id_employee) REFERENCES employee(id)
);
```

## Usage

Pour utiliser ce projet, suivez les étapes ci-dessous :

### 1. Installation de Apache Tomcat 8.5

1. Téléchargez Apache Tomcat 8.5 depuis le site officiel : [Téléchargement Apache Tomcat](https://tomcat.apache.org/download-80.cgi).

2. Suivez les instructions d'installation fournies dans la documentation de Tomcat pour votre système d'exploitation.

### 2. Configuration dans IntelliJ IDEA

1. Ouvrez IntelliJ IDEA (ou votre IDE de choix).

2. Importez le projet en utilisant l'option de clonage depuis Git ou en important le fichier pom.xml pour Maven.

3. Assurez-vous d'avoir configuré votre JDK dans IntelliJ IDEA.

4. Configurez Tomcat comme serveur d'application dans IntelliJ IDEA :
   - Allez dans les préférences ou les paramètres de l'IDE.
   - Recherchez la section "Serveurs" ou "Application Servers".
   - Cliquez sur le bouton d'ajout (+) pour ajouter un nouveau serveur.
   - Sélectionnez Apache Tomcat 8.5 et spécifiez le chemin d'installation de Tomcat.

5. Ajoutez l'artefact pour exécuter le projet :
   - Allez dans les paramètres de l'application ou de la configuration de l'exécution.
   - Sélectionnez "Artifacts" ou "Build Artifacts".
   - Cliquez sur le bouton d'ajout (+) pour créer un nouvel artefact.
   - Choisissez l'option correspondant à votre projet (WAR, JAR, etc.).
   - Configurez les détails de l'artefact comme le nom, le chemin de sortie, etc.

### 3. Exécution du Projet

1. Démarrez Apache Tomcat 8.5 en exécutant le script de démarrage approprié pour votre système d'exploitation.

2. Dans IntelliJ IDEA, assurez-vous que Tomcat est sélectionné comme serveur de déploiement pour votre artefact.

3. Exécutez votre application en utilisant l'option de déploiement ou de démarrage de l'artefact dans IntelliJ IDEA.

4. Ouvrez votre navigateur et accédez à l'URL de votre application (généralement http://localhost:8080/ConstructXpert_JEE_JURY_BLANCH_war_exploded/).

Vous devriez maintenant voir votre projet en cours d'exécution dans Apache Tomcat via IntelliJ IDEA.

## Auteurs

Ce projet a été développé par [Yassine OULARBI]. Pour toute question, veuillez contacter [yassineoularbi4@gmail.com].
