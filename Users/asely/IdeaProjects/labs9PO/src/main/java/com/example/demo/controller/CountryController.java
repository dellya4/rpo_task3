package com.example.demo.controller;

import com.example.demo.dto.CountryDto;
import com.example.demo.service.countryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/countries")
public class CountryController {

    private final countryService countryService;

    @GetMapping
    public String countriesPage(Model model) {
        model.addAttribute("countries", countryService.getCountries());
        return "countries";
    }

    @GetMapping("/add")
    public String addCountryPage(Model model) {
        model.addAttribute("country", new CountryDto());
        return "add-country";
    }

    @PostMapping("/add")
    public String addCountry(@ModelAttribute("country") CountryDto dto) {
        countryService.addCountry(dto);
        return "redirect:/countries";
    }

    @GetMapping("/edit/{id}")
    public String editCountryPage(@PathVariable Long id, Model model) {
        CountryDto dto = countryService.getCountry(id);
        model.addAttribute("country", dto);
        return "edit-country";
    }

    @PostMapping("/edit/{id}")
    public String editCountry(@PathVariable Long id, @ModelAttribute CountryDto dto) {
        countryService.updateCountry(id, dto);
        return "redirect:/countries";
    }

    @PostMapping("/delete/{id}")
    public String deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
        return "redirect:/countries";
    }
}
