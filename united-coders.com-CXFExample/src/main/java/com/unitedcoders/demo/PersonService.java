package com.sheldon.rocking.service;

import javax.jws.WebService;

@WebService
public interface PersonService {

    public String greetPerson(String name);

}
