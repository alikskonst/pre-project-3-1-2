package edu.kata.task312.controller;

import edu.kata.task312.entity.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

public interface AdminController {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    String pageUsers(ModelMap modelMap);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/create")
    String pageCreate(ModelMap modelMap);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/update/{id}")
    String pageUpdate(ModelMap modelMap, @PathVariable("id") Long id);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/save")
    String save(@ModelAttribute("user") User user);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/remove/{id}")
    String remove(@PathVariable("id") Long id);
}
