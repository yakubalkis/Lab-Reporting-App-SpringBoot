package com.report.service;

import com.report.entity.Laborant;

import java.util.List;

public interface LaborantService {
    List<Laborant> findAll();

    Laborant findById(Integer id);
    void save(Laborant laborant);
    void deleteById(Integer id);
}
