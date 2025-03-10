package test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import com.auth.Credencial;
import com.auth.Usuario;

class TestUsuario {

	Credencial credencial = new Credencial("juan", "perez", "password123");
    Usuario usuario = new Usuario("Juan", "Pérez", "password123", "juan@example.com");
    
    
    @Test
    void testEsCuentaBloqueada() {
        assertFalse(usuario.esCuentaBloqueada(2), "La cuenta no debería estar bloqueada.");
        assertTrue(usuario.esCuentaBloqueada(3), "La cuenta debería estar bloqueada.");
        assertTrue(usuario.esCuentaBloqueada(5), "La cuenta debería estar bloqueada.");
    }

    @Test
    void testEsPasswordSegura() {
        assertTrue(usuario.esPasswordSegura(), "La contraseña debería ser segura.");
    }

    @Test
    void testModificarPassword() {
        assertTrue(usuario.modificarPassword("password123", "newpassword123", "newpassword123"), 
            "La contraseña debería ser cambiada correctamente.");
        
        assertFalse(usuario.modificarPassword("wrongpassword", "newpassword123", "newpassword123"), 
            "No debería poder cambiar la contraseña con el viejo password incorrecto.");
        
        assertFalse(usuario.modificarPassword("password123", "newpassword123", "newpassword124"), 
            "No debería poder cambiar la contraseña si las nuevas contraseñas no coinciden.");
        
        assertFalse(usuario.modificarPassword("password123", "password123", "password123"), 
            "No debería poder cambiar la contraseña al mismo valor.");
    }

    @Test
    void testHacerLogin() {
        assertTrue(usuario.hacerLogin("juanperez", "password123"), "El login debería ser exitoso con credenciales correctas.");
        
        assertFalse(usuario.hacerLogin("juanlopez", "password123"), "El login debería fallar con un username incorrecto.");
        
        assertFalse(usuario.hacerLogin("juanperez", "wrongpassword"), "El login debería fallar con una contraseña incorrecta.");
        
        assertFalse(usuario.hacerLogin("juanperez", "wrongpassword"), "El login debería fallar con una contraseña incorrecta.");
    }

}
