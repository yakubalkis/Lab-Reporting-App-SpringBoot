package com.report.repository;

import com.report.entity.Laborant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LaborantRepository extends JpaRepository<Laborant, Integer> {
        Laborant findByIdNo(String idNo);

        @Query("SELECT lab FROM Laborant lab WHERE lab.idNo = ?1")
        Laborant findLaborantByIdNo(String idNo);
}
