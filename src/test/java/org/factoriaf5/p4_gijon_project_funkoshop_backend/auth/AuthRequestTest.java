package org.factoriaf5.p4_gijon_project_funkoshop_backend.auth;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AuthRequestTest {

    @Test
    public void testConstructor() {
        AuthRequest authRequest = new AuthRequest();
        assertNotNull(authRequest);
    }

    @Test
    public void testGetEmail() {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setEmail("test@example.com");
        assertEquals("test@example.com", authRequest.getEmail());
    }

    @Test
    public void testSetEmail() {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setEmail("test@example.com");
        assertEquals("test@example.com", authRequest.getEmail());
    }

    @Test
    public void testGetPassword() {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setPassword("password123");
        assertEquals("password123", authRequest.getPassword());
    }

    @Test
    public void testSetPassword() {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setPassword("password123");
        assertEquals("password123", authRequest.getPassword());
    }

    @Test
    public void testEmailNull() {
        AuthRequest authRequest = new AuthRequest();
        assertNull(authRequest.getEmail());
    }

    @Test
    public void testPasswordNull() {
        AuthRequest authRequest = new AuthRequest();
        assertNull(authRequest.getPassword());
    }

    @Test
    public void testEmailEmpty() {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setEmail("");
        assertEquals("", authRequest.getEmail());
    }

    @Test
    public void testPasswordEmpty() {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setPassword("");
        assertEquals("", authRequest.getPassword());
    }

    @Test
    public void testGetEmailReturnsNullWhenEmailIsNotSet() {
        AuthRequest request = new AuthRequest();
        request.setEmail("test@example.com");
        String email = request.getEmail();
        assertEquals("test@example.com", email);
    }

    @Test
    public void testGetEmailReturnsEmptyStringWhenEmailIsEmpty() {
        AuthRequest request = new AuthRequest();
        String email = request.getEmail();
        assertNull(email);
    }

    @Test
    public void testGetEmailReturnsNullWhenEmailIsSetToNull() {
        AuthRequest request = new AuthRequest();
        request.setEmail(null);
        String email = request.getEmail();
        assertNull(email);
    }
}