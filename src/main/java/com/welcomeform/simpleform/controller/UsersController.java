package com.welcomeform.simpleform.controller;

import com.welcomeform.simpleform.model.usersModel;
import com.welcomeform.simpleform.service.UsersService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping("/register")
    public String getRegisterPage(Model model) {
         model.addAttribute("registerRequest", new usersModel());
        return "register_page";
    }

    @RequestMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new usersModel());
        return "login_page";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute usersModel UsersModel) {
        System.out.println("register request" + UsersModel);
        usersModel registeredUser=usersService.registerUser(UsersModel.getLogin(), UsersModel.getPassword(), UsersModel.getEmail());
        return registeredUser == null ? "error_page" : "redirect:/login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute usersModel UsersModel ,Model model) {
        System.out.println("login request" + UsersModel);
        usersModel authenticated=usersService.authenticate(UsersModel.getLogin(), UsersModel.getPassword());
        if(authenticated != null){
            model.addAttribute("userLogin",authenticated.getLogin());
            return "personal_page";
        }else{
            return "error_page";
        }
    }
}


