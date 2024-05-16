package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConexionBDTest {

    @Test
    void testEndConnection() {
        ConexionBD conexionBD = new ConexionBD();

        // Llama al método que estamos probando
        conexionBD.endConnection();

        // Verifica que el EntityManager está cerrado
        assertFalse(conexionBD.entityManager.isOpen());
    }
}