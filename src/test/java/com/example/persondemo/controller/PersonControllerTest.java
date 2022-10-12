package com.example.persondemo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.persondemo.entity.dto.AutoDto;
import com.example.persondemo.entity.dto.PersonDto;
import com.example.persondemo.service.PersonService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PersonController.class)
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService mockPersonService;

    @Test
    void testGetUsers() throws Exception {

        List<PersonDto> personDtos = List.of(new PersonDto("name", List.of(new AutoDto("model", 2020))));
        when(mockPersonService.getUsers()).thenReturn(personDtos);

        MockHttpServletResponse response = getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[{\"name\":\"name\",\"autos\":[{\"model\":\"model\",\"year\":2020}]}]");
    }

    @Test
    void testGetUsers_PersonServiceReturnsNoItems() throws Exception {
        when(mockPersonService.getUsers()).thenReturn(Collections.emptyList());

        MockHttpServletResponse response = getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }

    @Test
    void testGetUsers_PersonServiceThrowException() throws Exception {
        when(mockPersonService.getUsers()).thenThrow(RuntimeException.class);

        MockHttpServletResponse response = getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
        assertThat(response.getContentAsString()).isEqualTo("Unknown error. We are working on a solution.");
    }

    private MockHttpServletResponse getResponse() throws Exception {
        return mockMvc.perform(get("/api/users").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
    }
}
