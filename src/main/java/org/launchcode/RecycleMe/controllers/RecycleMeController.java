package org.launchcode.RecycleMe.controllers;

import org.launchcode.RecycleMe.models.User;
import org.launchcode.RecycleMe.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller

public class RecycleMeController {
    @Autowired
    private UserDao UserDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        return "index";
    }




    @RequestMapping(method = RequestMethod.GET, value = "register")
    public String register(Model model){
        //====== ADDED THIS TO TRY AND ACTUALLY REGISTER USERS, MAY NOT WORK=====
        // IN CASE OF FAILURE, DELETE EVERYTHING BEFORE RETURN REGISTER LINE
        model.addAttribute(new User());
        model.addAttribute("title", "Register");
        return "register";
    }

    //====== ADDED THIS TO TRY AND ACTUALLY REGISTER USERS, MAY NOT WORK=====
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User user,
                      Errors errors, String verify) {

        model.addAttribute(user);
        boolean passwordsMatch = true;
        if (user.getPassword() == null || verify == null
                || !user.getPassword().equals(verify)) {
            passwordsMatch = false;
            user.setPassword("");
            model.addAttribute("verifyError", "Passwords must match");
        }

        if (!errors.hasErrors() && passwordsMatch) {
            return "index";
        }

        return "redirect:/add";
    }
  //===========THIS IS THE END OF WHERE YOU WOULD WANT TO DELETE IF FAILS==========





    @RequestMapping(method = RequestMethod.GET, value = "login")
    public String login(Model model){
        return "login.html";
    }

    @RequestMapping(method = RequestMethod.GET, value = "add")
    public String add(Model model){
        return "add.html";
    }

    @RequestMapping(method = RequestMethod.GET, value = "results")
    public String results(Model model){
        return "results.html";
    }

}

