package com.example.persondemo.db;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.example.persondemo.entity.Auto;

@Component
public class AutoTable {
    private List<Auto> autos;

    /**
     * Creates a list of autos, and then assigns that list to the autos variable
     */
    @PostConstruct
    private void init() {
        Auto firstToyota = new Auto(1, "Toyota1", 2022, 1);
        Auto secondToyota = new Auto(2, "Toyota2", 2020, 1);
        Auto thirdToyota = new Auto(3, "Toyota3", 2012, 2);
        Auto firstFord = new Auto(4, "Ford1", 2012, 3);
        Auto secondFord = new Auto(5, "Ford2", 2012, 3);

        Auto unknown = new Auto(6, "Unknown", 1993, -1);

        autos = List.of(firstToyota, secondToyota, thirdToyota, firstFord, secondFord, unknown);
    }

    /**
     * This function returns a list of all the autos in the database.
     *
     * @return A list of all the autos in the database.
     */
    public List<Auto> selectAllAutos() {
        return autos;
    }
}
