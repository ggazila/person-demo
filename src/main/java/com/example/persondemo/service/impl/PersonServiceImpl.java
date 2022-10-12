package com.example.persondemo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.persondemo.entity.Auto;
import com.example.persondemo.entity.Person;
import com.example.persondemo.entity.dto.AutoDto;
import com.example.persondemo.entity.dto.PersonDto;
import com.example.persondemo.repository.PersonRepository;
import com.example.persondemo.service.AutoService;
import com.example.persondemo.service.PersonService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final AutoService autoService;

    @Override
    public List<PersonDto> getUsers() {
        List<Person> people = personRepository.getUsers();
        List<Auto> autos = autoService.getAutos();

        return people.stream()
                .map(person -> new PersonDto(person.getName(), getAutoDtos(autos, person.getId())))
                .toList();
    }

    /**
     * "Get a list of AutoDtos from a list of Autos, where the Auto's userId matches the given personId."
     * <p>
     *
     * @param autos    a list of Auto objects
     * @param personId The id of the person whose autos we want to retrieve.
     * @return A list of AutoDtos
     */
    private List<AutoDto> getAutoDtos(List<Auto> autos, int personId) {
        return autos.stream()
                .filter(auto -> auto.getUserId() == personId)
                .map(auto -> new AutoDto(auto.getModel(), auto.getYear()))
                .toList();
    }
}
