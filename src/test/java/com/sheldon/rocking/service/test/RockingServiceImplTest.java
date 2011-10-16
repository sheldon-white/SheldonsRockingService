package com.sheldon.rocking.service.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sheldon.rocking.service.RockingService;
import com.sheldon.rocking.service.RockingServiceImpl;


public class RockingServiceImplTest {

    private RockingService service;
    
    @Before
    public void setUp() {
        service = new RockingServiceImpl();
    }
    
    @Test
    public void testGreetPerson() {
        String expected = "Hello World!";
        
        String actual = service.greetPerson("World");
        
        assertEquals(expected, actual);
    }
    
}
