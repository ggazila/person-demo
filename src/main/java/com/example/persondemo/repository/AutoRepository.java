package com.example.persondemo.repository;

import java.util.List;

import com.example.persondemo.entity.Auto;

/**
 * The interface Auto repository.
 */
public interface AutoRepository {
    /**
     * Gets autos.
     *
     * @return the autos
     */
    List<Auto> getAutos();
}
