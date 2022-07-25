package edu.kata.task312.controller.impl;

import edu.kata.task312.controller.UserController;
import edu.kata.task312.entity.User;
import edu.kata.task312.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/user")
public class UserControllerImpl implements UserController {

    private final UserService userService;

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public String userPage(ModelMap modelMap) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        modelMap.addAttribute("user", userService.findOne(user.getLogin()));
        return "user";
    }
}
