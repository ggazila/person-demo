package com.example.persondemo.service;

import java.util.List;

import com.example.persondemo.entity.Auto;

public interface AutoService {
    /**
     * This function returns a list of Auto objects.
     *
     * @return A list of Auto objects.
     */
    List<Auto> getAutos();
}
