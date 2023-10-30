# MarjaneV1
## Système de Gestion des Promotions Marjane Maroc


### Contexte du Projet
L’hypermarché Marjane Maroc souhaite simplifier la gestion des promotions de ses produits au niveau de tous les centres du royaume. Ce projet vise à créer une application basée sur une API REST en Java (Spring Core) et Hibernate pour gérer efficacement les promotions des produits dans l'ensemble de ses centres.


### Fonctionnalités Clés
. Gestion des administrateurs de chaque centre et de leurs promotions.
. Création et gestion de promotions par catégorie de produits.
. Approbation ou refus des promotions par les responsables de rayon.
. Contrôle d'accès restreint aux promotions entre 8h et 12h.
. Respect des règles générales de réduction et de fidélité.
. Journalisation des opérations dans la base de données.
. Consultation des statistiques des promotions par l'administrateur général.
. Durée de validité modifiable pour chaque promotion.

### Technologies Utilisées
. Java (version  : Java 20)
. Spring Core
. Spring MVC
. Spring Data (Hibernate)
. PostgreSQL (base de données)
. Maven (outil de gestion de dépendances)
. JUnit (pour les tests unitaires)

### Installation
1. Clonez ce référentiel sur votre machine locale.
2. Assurez-vous d'avoir Java et Maven installés.
3. Exécutez `mvn clean install` pour installer les dépendances.

### Utilisation
1. Démarrez l'application en utilisant `mvn spring-boot:run`.
2. Accédez à l'API via http://localhost:8080.

### Tests
Exécutez les tests unitaires en utilisant `mvn test`.

### Base de Données
L'application utilise une base de données PostgreSQL. Assurez-vous qu'elle est configurée correctement
