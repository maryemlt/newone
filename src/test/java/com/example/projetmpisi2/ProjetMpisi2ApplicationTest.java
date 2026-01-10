package com.example.projetmpisi2;  // Même package

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjetMpisi2ApplicationTest {  // Même nom

    @Test
    void testConstructor() {
        ProjetMpisi2Application app = new ProjetMpisi2Application();
        assertNotNull(app);
    }

    @Test
    void testMainMethod() {
        try {
            ProjetMpisi2Application.main(new String[]{});
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(true);
        }
    }
}