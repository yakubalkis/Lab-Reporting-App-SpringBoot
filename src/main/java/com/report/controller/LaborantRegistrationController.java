package com.report.controller;

import com.report.entity.Laborant;
import com.report.entity.Role;
import com.report.service.LaborantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/registration")
public class LaborantRegistrationController {

    private LaborantService laborantService;
    @Autowired
    public LaborantRegistrationController(LaborantService laborantService) {
        this.laborantService = laborantService;
    }

    @GetMapping
    public String showRegistrationForm(Model model){

        Laborant theLaborant = new Laborant();
        model.addAttribute("laborant", theLaborant);

        return "registration";
    }
    @PostMapping
    public String registerLaborantAccount(@ModelAttribute("laborant") Laborant theLaborant){

        theLaborant.setRoles(Arrays.asList(new Role("ROLE_USER")));
        laborantService.save(theLaborant);

        return "redirect:/registration?success";
    }
}
