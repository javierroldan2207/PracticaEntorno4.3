package test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

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
        assertTrue(usuario.esPasswordSegura());
    }

    @Test
    void testModificarPassword() {
        assertTrue(usuario.modificarPassword("password123", "newpassword123", "newpassword123"));
        
        assertFalse(usuario.modificarPassword("wrongpassword", "newpassword123", "newpassword123"));
        
        assertFalse(usuario.modificarPassword("password123", "newpassword123", "newpassword124"));
        
        assertFalse(usuario.modificarPassword("password123", "password123", "password123"));
    }

    @Test
    void testHacerLogin() {
        assertTrue(usuario.hacerLogin("juanperez", "password123"));
        
        assertFalse(usuario.hacerLogin("juanlopez", "password123"));
        
        assertFalse(usuario.hacerLogin("juanperez", "wrongpassword"));
        
        assertFalse(usuario.hacerLogin("juanperez", "wrongpassword"));
    }

}
