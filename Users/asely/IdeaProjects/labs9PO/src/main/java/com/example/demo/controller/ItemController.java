package com.example.demo.controller;

import com.example.demo.dto.ItemDto;
import com.example.demo.service.countryService;
import com.example.demo.service.itemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final itemService itemService;
    private final countryService countryService;

    @GetMapping
    public String itemsPage(Model model) {
        model.addAttribute("items", itemService.getItems());
        return "items";
    }

    @GetMapping("/add")
    public String addItemPage(Model model) {
        model.addAttribute("item", new ItemDto());
        model.addAttribute("countries", countryService.getCountries());
        return "add-item";
    }

    @PostMapping("/add")
    public String addItem(@ModelAttribute("item") ItemDto dto) {
        itemService.addItem(dto);
        return "redirect:/items";
    }

    @GetMapping("/edit/{id}")
    public String editItemPage(@PathVariable Long id, Model model) {
        model.addAttribute("item", itemService.getItem(id));
        model.addAttribute("countries", countryService.getCountries());
        return "edit-item";
    }

    @PostMapping("/edit/{id}")
    public String editItem(@PathVariable Long id, @ModelAttribute ItemDto dto) {
        itemService.updateItem(id, dto);
        return "redirect:/items";
    }

    @PostMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return "redirect:/items";
    }
}
