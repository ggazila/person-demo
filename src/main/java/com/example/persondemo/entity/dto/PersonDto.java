package com.example.persondemo.entity.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonDto {
    private String name;
    private List<AutoDto> autos;
}
