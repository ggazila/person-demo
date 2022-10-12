package com.example.persondemo.repository.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.persondemo.db.PersonTable;
import com.example.persondemo.entity.Person;
import com.example.persondemo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonRepositoryImpl implements PersonRepository {
    private final PersonTable personTable;

    @Override
    public List<Person> getUsers() {
        return personTable.selectAllUsers();
    }
}
