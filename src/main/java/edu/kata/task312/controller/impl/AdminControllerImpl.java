package edu.kata.task312.controller.impl;

import edu.kata.task312.controller.AdminController;
import edu.kata.task312.entity.User;
import edu.kata.task312.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/admin")
public class AdminControllerImpl implements AdminController {

    private final UserService userService;

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public String pageUsers(ModelMap modelMap) {
        modelMap.addAttribute("userList", userService.findAll());
        return "user_list";
    }

    @Override
    public String pageCreate(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "user_manage";
    }

    @Override
    public String pageUpdate(ModelMap modelMap, Long id) {
        modelMap.addAttribute("user", userService.findOne(id));
        return "user_manage";
    }

    @Override
    public String save(User user) {
        userService.save(user);
        return "redirect:/admin";
    }

    @Override
    public String remove(Long id) {
        userService.remove(id);
        return "redirect:/admin";
    }
}
