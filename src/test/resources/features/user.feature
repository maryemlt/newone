Feature: Gestion des utilisateurs

  Scenario: Ajouter un nouvel utilisateur
    Given un nouvel utilisateur avec le nom "Ali" et l'email "ali@example.com"
    When je sauvegarde cet utilisateur
    Then l'utilisateur doit être sauvegardé avec succès
