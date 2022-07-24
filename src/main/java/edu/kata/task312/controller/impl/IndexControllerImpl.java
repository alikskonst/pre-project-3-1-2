package edu.kata.task312.controller.impl;

import edu.kata.task312.controller.IndexController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class IndexControllerImpl implements IndexController {

    @Override
    public String index(ModelMap modelMap) {
        return "index";
    }
}
