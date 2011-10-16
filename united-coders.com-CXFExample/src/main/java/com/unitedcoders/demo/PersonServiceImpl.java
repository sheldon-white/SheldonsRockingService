package com.sheldon.rocking.service;

import javax.jws.WebService;

@WebService(endpointInterface = "com.sheldon.rocking.service.PersonService")
public class PersonServiceImpl implements PersonService {

    public String greetPerson(String name) {
        Person person = new Person(name);

        return "Hello " + person.getName() + "!";
    }

}
