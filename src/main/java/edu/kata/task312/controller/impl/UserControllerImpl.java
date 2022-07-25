package edu.kata.task312.controller.impl;

import edu.kata.task312.controller.UserController;
import edu.kata.task312.entity.User;
import edu.kata.task312.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@AllArgsConstructor
@Controller
@RequestMapping("/user")
public class UserControllerImpl implements UserController {

    private final UserService userService;

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public String userPage(Principal principal, ModelMap modelMap) {
        //User user = userService.findOneByLogin(principal.getName());
        User user = userService.findOne(principal.getName());
        modelMap.addAttribute("user", userService.findOne(principal.getName()));
        return "user";
    }
}
