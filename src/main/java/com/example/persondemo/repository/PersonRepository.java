package com.example.persondemo.repository;

import java.util.List;

import com.example.persondemo.entity.Person;

/**
 * The interface Person repository.
 */
public interface PersonRepository {
    /**
     * Gets users.
     *
     * @return the users
     */
    List<Person> getUsers();
}
