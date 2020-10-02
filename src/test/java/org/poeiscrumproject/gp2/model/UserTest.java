package org.poeiscrumproject.gp2.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    User userTest;

    @Before
    public void init(){
        userTest = new User("prenom", "nom", "pseudo", "courriel", "false", "password");
    }

    @Test
    public void testFirstName(){
        userTest.setFirstname("Jules");
        assertEquals("Jules", userTest.getFirstname());
    }

    @Test
    public void testLastName(){
        userTest.setLastname("César");
        assertEquals("César", userTest.getLastname());
    }

    @Test
    public void testUsername(){
        userTest.setUsername("JC");
        assertEquals("JC", userTest.getUsername());
    }

    @Test
    public void testEmail(){
        userTest.setEmail("jules.cesar@rome.spqr");
        assertEquals("jules.cesar@rome.spqr", userTest.getEmail());
    }

    @Test
    public void testSubscriber(){
        userTest.setSubscriber("true");
        assertEquals("true", userTest.getSubscriber());
    }
    
    @Test
    public void testPassword(){
        userTest.setPassword("MMXX");
        assertEquals("MMXX", userTest.getPassword());
    }
}