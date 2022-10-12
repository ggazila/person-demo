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
import com.example.persondemo.repository.AutoRepository;

@ExtendWith(MockitoExtension.class)
class AutoServiceImplTest {

    @Mock
    private AutoRepository mockAutoRepository;

    private AutoServiceImpl autoServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        autoServiceImplUnderTest = new AutoServiceImpl(mockAutoRepository);
    }

    @Test
    void testGetAutos() {
        List<Auto> expectedResult = List.of(new Auto(0, "model", 2020, 0));
        when(mockAutoRepository.getAutos()).thenReturn(List.of(new Auto(0, "model", 2020, 0)));

        List<Auto> result = autoServiceImplUnderTest.getAutos();
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetAutos_AutoRepositoryReturnsNoItems() {
        when(mockAutoRepository.getAutos()).thenReturn(Collections.emptyList());
        List<Auto> result = autoServiceImplUnderTest.getAutos();
        assertThat(result).isEqualTo(Collections.emptyList());
    }
}
