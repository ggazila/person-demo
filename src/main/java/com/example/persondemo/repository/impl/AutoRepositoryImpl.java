package com.example.persondemo.repository.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.persondemo.db.AutoTable;
import com.example.persondemo.entity.Auto;
import com.example.persondemo.repository.AutoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutoRepositoryImpl implements AutoRepository {
    private final AutoTable autoTable;

    @Override
    public List<Auto> getAutos() {
        return autoTable.selectAllAutos();
    }
}
