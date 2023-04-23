# Projet API de Baux Ruraux

Ce projet est une API qui récupère les requêtes d'un script Python envoyant
des coordonnées présente dans un fichier geojson représentant une délimitation
de bail rural. Le projet python correspondant est disponible ici :
<https://github.com/EWEN14/projetSmartContrat>

L'API reçoit les coordonnées et les enregistre dans une base de données H2.

Les baux ruraux peuvent être consultés via un endpoint (voir Swagger).

Voici les principaux endpoints :

- POST : <http://localhost:8080/bailrural> : vérifie que les coordonnées reçues représente
un polygone et enregistre le bail rural dans la base H2.
- GET : <http://localhost:8080/bailrural> :  récupère la liste des baux ruraux
- GET : <http://localhost:8080/bailrural/{id}> : récupère le bail rural avec l'id spécifiée

## Lancer l'application

Avec Maven : **mvn :spring-boot:run**

Avec Intellij : attendre qu'Intellij télécharge les dépendances à l'ouverture du projet, puis cliquer
sur le bouton de lancement de l'application.

## Swagger (API)

Swagger permet de consulter les différents endpoints de l'application.

- Accès à Swagger : <http://localhost:8080/swagger-ui.html> (interface graphique)
- ou <http://localhost:8080/v3/api-docs> (JSON de l'API)

## Console BDD H2

- Accès à la base de données en mémoire (H2) bailrural_db : <http://localhost:8080/h2-console>
- id : sa
- password : aucun (none)
