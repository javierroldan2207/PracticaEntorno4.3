package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.auth.Credencial;

class TestCredencial {

	Credencial credencial = new Credencial("Juan", "Pérez", "Contraseña123");
	
	
	@Test
    public void testGenerarUsername() {
        String expectedUsername = "juape100";
        assertEquals(expectedUsername, credencial.getUsurname(), "El username generado es incorrecto");
    }

    @Test
    public void testEsPasswordSegura() {
        assertTrue(credencial.esPasswordSegura(), "La contraseña debería ser segura");
    }

    @Test
    public void testEsPasswordNoSegura() {
        Credencial credencialNoSegura = new Credencial("Ana", "Gómez", "contraseña");
        assertFalse(credencialNoSegura.esPasswordSegura(), "La contraseña debería no ser segura");
    }

    @Test
    public void testComprobarPassword() {
        assertTrue(credencial.comprobarPassword("Contraseña123"), "Las contraseñas deberían coincidir");
    }

    @Test
    public void testComprobarPasswordIncorrecta() {
        assertFalse(credencial.comprobarPassword("ContraseñaIncorrecta"), "Las contraseñas no deberían coincidir");
    }

}
