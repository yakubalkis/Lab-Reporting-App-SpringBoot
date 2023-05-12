package com.report.controller;

import com.report.entity.Laborant;
import com.report.entity.Report;
import com.report.service.LaborantService;
import com.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    private LaborantService laborantService;
    private ReportService reportService;
    @Autowired
    public MainController(LaborantService laborantService, ReportService reportService) {
        this.laborantService = laborantService;
        this.reportService = reportService;
    }

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

    @GetMapping("/")
    public String homePage(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Laborant currentLaborant = laborantService.findLaborantByIdNo(auth.getName());

        List<Report> reports = reportService.findAll();
        model.addAttribute("reports", reports);
        model.addAttribute("username", currentLaborant.getFirstName() +" "+ currentLaborant.getLastName());
        return "index";
    }
    @GetMapping("/reports/add")
    public String showFormForAddReport(Model model){

        // create model to bind data
        Report report = new Report();
        model.addAttribute("report", report);

        return "report-form";
    }

    @PostMapping("/reports/save")
    public String saveEmployee(@ModelAttribute("report") Report report){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Laborant currentLaborant = laborantService.findLaborantByIdNo(auth.getName());
        currentLaborant.addReport(report);

        //laborantService.save(currentLaborant);
        reportService.save(report);

        return "redirect:/";
    }

}
