package com.example.persondemo.db;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.example.persondemo.entity.Person;

@Component
public class PersonTable {
    private List<Person> people;

    /**
     * Creates a list of people, and then assigns that list to the people variable
     */
    @PostConstruct
    private void init() {
        Person sergey = new Person(1, "Sergey", List.of(1, 2));
        Person alexander = new Person(2, "Alexander", List.of(3));
        Person stanislav = new Person(3, "Stanislav", List.of(4, 5));

        people = List.of(sergey, alexander, stanislav);
    }

    /**
     * This function returns a list of all the people in the database.
     *
     * @return A list of all the people in the database.
     */
    public List<Person> selectAllUsers() {
        return people;
    }
}
