package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.auth.Credencial;

class TestCredencial {

	Credencial credencial = new Credencial("user123", "pass123", "0");

    @Test
    void testConstructor() {
        assertEquals("user123", credencial.getUsurname(), "El username no se asignó correctamente.");
    }

    @Test
    void testSetPassword() {
        credencial.setPassword("newPass456");
    }

    @Test
    void testGenerarUsername() {
        String username1 = credencial.generarUsername("Carlos", "Gomez");
        String username2 = credencial.generarUsername("Luis", "Fernandez");

        assertEquals("cargom0", username1, "Error en el username generado.");
        assertEquals("luifer1", username2, "Error en el username generado.");
    }

}
