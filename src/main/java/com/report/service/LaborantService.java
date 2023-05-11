package com.report.service;

import com.report.entity.Laborant;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface LaborantService extends UserDetailsService {
    List<Laborant> findAll();

    Laborant findById(Integer id);

    Laborant save(Laborant laborant);

    void deleteById(Integer id);
}
