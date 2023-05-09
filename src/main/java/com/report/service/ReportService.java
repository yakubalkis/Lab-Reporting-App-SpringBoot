package com.report.service;

import com.report.entity.Report;

import java.util.List;

public interface ReportService {

    List<Report> findAll();
    Report findById(Integer id);

    void save(Report report);
    void deleteById(Integer id);
}
