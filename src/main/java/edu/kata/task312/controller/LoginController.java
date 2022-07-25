package edu.kata.task312.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

public interface LoginController {

    @GetMapping({"/", "/login"})
    String login(ModelMap modelMap);

    @GetMapping("/loginError")
    String loginError(ModelMap modelMap);
}
