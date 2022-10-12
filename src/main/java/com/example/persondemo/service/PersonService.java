package com.example.persondemo.service;

import java.util.List;

import com.example.persondemo.entity.dto.PersonDto;

public interface PersonService {

    /**
     * Get a list of users with autos.
     *
     * @return A list of PersonDto objects.
     */
    List<PersonDto> getUsers();
}
