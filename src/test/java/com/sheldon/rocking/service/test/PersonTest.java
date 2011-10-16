package com.sheldon.rocking.service.test;


import static org.junit.Assert.*;

import org.junit.Test;

import com.sheldon.rocking.service.Person;

public class PersonTest {

    @Test
    public void testPerson() {
        Person p = new Person("foo");
        assertEquals("foo", p.getName());
        
        p.setName("bar");
        assertEquals("bar", p.getName());
    }

}
