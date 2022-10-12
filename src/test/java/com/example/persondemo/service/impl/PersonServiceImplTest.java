package com.example.persondemo.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.persondemo.entity.Auto;
import com.example.persondemo.entity.Person;
import com.example.persondemo.entity.dto.AutoDto;
import com.example.persondemo.entity.dto.PersonDto;
import com.example.persondemo.repository.PersonRepository;
import com.example.persondemo.service.AutoService;

@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

    @Mock
    private PersonRepository mockPersonRepository;
    @Mock
    private AutoService mockAutoService;

    private PersonServiceImpl personServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        personServiceImplUnderTest = new PersonServiceImpl(mockPersonRepository, mockAutoService);
    }

    @Test
    void testGetUsers() {
        List<PersonDto> expectedResult = List.of(new PersonDto("name", List.of(new AutoDto("model", 2020))));

        List<Person> people = List.of(new Person(1, "name", List.of(1)));
        when(mockPersonRepository.getUsers()).thenReturn(people);
        when(mockAutoService.getAutos()).thenReturn(List.of(new Auto(1, "model", 2020, 1)));

        List<PersonDto> result = personServiceImplUnderTest.getUsers();
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetUsers_PersonRepositoryReturnsNoItems() {
        List<PersonDto> expectedResult = List.of();
        when(mockPersonRepository.getUsers()).thenReturn(Collections.emptyList());
        when(mockAutoService.getAutos()).thenReturn(List.of(new Auto(1, "model", 2020, 0)));

        List<PersonDto> result = personServiceImplUnderTest.getUsers();
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetUsers_AutoServiceReturnsNoItems() {
        List<PersonDto> expectedResult = List.of(new PersonDto("name", List.of()));

        List<Person> people = List.of(new Person(1, "name", List.of()));
        when(mockPersonRepository.getUsers()).thenReturn(people);
        when(mockAutoService.getAutos()).thenReturn(Collections.emptyList());

        List<PersonDto> result = personServiceImplUnderTest.getUsers();

        assertThat(result).isEqualTo(expectedResult);
    }
}
