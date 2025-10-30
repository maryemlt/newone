package com.example.projetmpisi2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class ProjetMpisi2ApplicationTest {

    @Test
    void main() {
        // Vérifie que l'application démarre sans lever d'exception
        assertDoesNotThrow(() -> ProjetMpisi2Application.main(new String[]{}));
    }
}
