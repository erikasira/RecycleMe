package org.launchcode.RecycleMe.controllers;

import org.launchcode.RecycleMe.models.LoginModel;
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
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserDao userDao;
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String login(Model model) {

        model.addAttribute("title", "Sign In");
        model.addAttribute(new LoginModel());
        return "login";
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public String login(@ModelAttribute @Valid LoginModel newuser, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Sign In");
            return "login";
        }

        //if valid user return to main page with welcome message
        User userEntity = userDao.findByUsername(newuser.getUsername());
        if(userEntity != null && userEntity.getUsername().equalsIgnoreCase(newuser.getUsername())){
            return "mainpage";}

// if invalid user or wrong password redirect him to login page with invalidcredentials prompt
        model.addAttribute("login", "Invalid Credentials ");
        newuser.setPassword("");
        return "login";
    }

}
