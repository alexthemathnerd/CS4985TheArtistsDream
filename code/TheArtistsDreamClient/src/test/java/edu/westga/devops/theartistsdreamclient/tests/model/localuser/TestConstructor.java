package edu.westga.devops.theartistsdreamclient.tests.model.localuser;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import edu.westga.devops.theartistsdreamclient.model.local.LocalUser;

import org.junit.jupiter.api.Test;

/**
 * Test the constructor for the local user
 * 
 * @author Jamia Echols
 * @version Fall 2021
 */
public class TestConstructor {
    
    @Test
    public void testNegativeId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LocalUser(-1, "test@gmail.com","test","test1");
        });
    }

    @Test
    public void testNullUsername() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LocalUser(0, "test@gmail.com",null,"test1");
        });
    }   
     
    @Test
    public void testEmptyUsername() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LocalUser(0, "test@gmail.com","","test1");
        });
    }    
    
    @Test
    public void testNullEmail() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LocalUser(0, null,"test","test1");
        });
    }    
    
    @Test
    public void testEmptyEmail() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LocalUser(0, "","test","test1");
        });
    }    
    
    @Test
    public void testNullPassword() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LocalUser(0, "test@gmail.com","test",null);
        });
    }    
    
    @Test
    public void testEmptyPassword() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LocalUser(0, "test@gmail.com","test","");
        });
    }

    @Test
    public void testValidUser() {
        LocalUser testUser = new LocalUser(0, "test@gmail.com","test","test1");
        assertAll(() -> {
            assertEquals("test", testUser.getUsername());
            assertEquals(0, testUser.getUserId());
            assertEquals("test@gmail.com", testUser.getEmail());
            assertEquals("test1", testUser.getPassword());
        });
    }
}
