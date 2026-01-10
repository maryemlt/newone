package com.example.projetmpisi2.bdd.stepdefs;

import com.example.projetmpisi2.entity.User;
import com.example.projetmpisi2.service.UserService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@CucumberContextConfiguration
@SpringBootTest
public class UserStepDefinitions {

    @Autowired
    private UserService userService;

    private User user;
    private User savedUser;

    @Given("un nouvel utilisateur avec le nom {string} et l'email {string}")
    public void unNouvelUtilisateurAvecLeNomEtLEmail(String username, String email) {
        user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword("password123");
    }

    @When("je sauvegarde cet utilisateur")
    public void jeSauvegardeCetUtilisateur() {
        savedUser = userService.saveUser(user);
    }

    @Then("l'utilisateur doit être sauvegardé avec succès")
    public void lUtilisateurDoitÊtreSauvegardéAvecSuccès() {
        assertNotNull(savedUser);
        assertNotNull(savedUser.getId());
        assertEquals(user.getUsername(), savedUser.getUsername());
        assertEquals(user.getEmail(), savedUser.getEmail());
    }
}
