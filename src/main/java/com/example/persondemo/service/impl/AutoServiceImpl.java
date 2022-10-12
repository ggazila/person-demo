package com.example.persondemo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.persondemo.entity.Auto;
import com.example.persondemo.repository.AutoRepository;
import com.example.persondemo.service.AutoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutoServiceImpl implements AutoService {
    private final AutoRepository autoRepository;

    @Override
    public List<Auto> getAutos() {
        return autoRepository.getAutos();
    }
}
