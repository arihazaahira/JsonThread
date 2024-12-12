# Gestion Automatisée des Fichiers JSON de Commandes

Ce projet Java a pour objectif de traiter automatiquement des fichiers JSON contenant des ordres (commandes). Il vérifie si les commandes sont associées à des clients existants dans une base de données, stocke les données valides, et gère les erreurs de manière efficace.

## Fonctionnalités

1. **Lecture et Vérification des Fichiers JSON** :
   - Analyse périodique (toutes les 60 minutes) des fichiers JSON d'entrée.
   - Validation des champs : `id`, `date`, `amount` et `customer_id`.

2. **Validation des Données** :
   - Vérification de l'existence du `customer_id` dans la table `customer` de la base de données.
   - Si le `customer_id` existe, la commande est insérée dans la table `order`.

3. **Gestion des Données** :
   - Les commandes valides sont :
     - Stockées dans la table `order`.
     - Supprimées du fichier JSON d'entrée.
     - Enregistrées dans un fichier de sortie (`outpfiles/orders.txt`).
   - Les commandes invalides ou en erreur sont enregistrées dans un fichier d'erreurs (`errors/ordres_errors.txt`).

4. **Traitement Différé** :
   - Exécution du traitement toutes les 60 minutes pour les nouveaux fichiers JSON disponibles.

5. **Logs des Opérations** :
   - Journalisation des commandes traitées, des erreurs et des statuts d'exécution dans des fichiers texte.

## Technologies Utilisées

- **Java** : Langage principal pour le développement.
- **Gson** : Bibliothèque utilisée pour le parsing et la manipulation des fichiers JSON.
- **JDBC** : Gestion des connexions et des opérations avec une base de données SQL.
- **IntelliJ IDEA** : Environnement de développement intégré (IDE).

## Schéma de la Base de Données

### Table `customer`
| Champ         | Type       | Description                  |
|---------------|------------|------------------------------|
| `customer_id` | INT        | Identifiant unique du client |
| `name`        | VARCHAR    | Nom du client               |
| `email`       | VARCHAR    | Adresse e-mail du client    |
| `phone`       | VARCHAR    | Numéro de téléphone         |

### Table `order`
| Champ         | Type       | Description                  |
|---------------|------------|------------------------------|
| `id`          | INT        | Identifiant unique de l'ordre |
| `date`        | DATE       | Date de l'ordre             |
| `amount`      | DECIMAL    | Montant de l'ordre          |
| `customer_id` | INT        | Référence au client associé |


