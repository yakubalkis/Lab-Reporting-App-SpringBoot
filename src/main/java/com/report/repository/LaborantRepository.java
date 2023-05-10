package com.report.repository;

import com.report.entity.Laborant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaborantRepository extends JpaRepository<Laborant, Integer> {
        Laborant findByIdNo(String idNo);
}
