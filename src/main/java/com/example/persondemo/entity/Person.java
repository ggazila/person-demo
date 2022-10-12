package com.example.persondemo.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private int id;
    private String name;
    private List<Integer> autoIds;
}
