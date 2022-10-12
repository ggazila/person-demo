package com.example.persondemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Auto {
    private int id;
    private String model;
    private int year;
    private int userId;
}
