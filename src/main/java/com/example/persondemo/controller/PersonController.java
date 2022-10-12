package com.example.persondemo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.persondemo.aop.Traceable;
import com.example.persondemo.entity.dto.PersonDto;
import com.example.persondemo.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Log4j2
public class PersonController {
    private final PersonService personService;

    /**
     * handles GET request for all users
     *
     * @return all users with cars and with status code 200.
     */
    @Traceable
    @GetMapping("/users")
    public ResponseEntity<List<PersonDto>> getUsers() {
        return ResponseEntity.ok(personService.getUsers());
    }

    /**
     * If an exception is thrown, log the error and return a 500-status code with a message
     *
     * @param exception The exception that was thrown.
     * @return ResponseEntity<String>
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception exception) {
        log.error("Problem with an application", exception);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unknown error. We are working on a solution.");
    }
}
