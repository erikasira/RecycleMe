package org.launchcode.RecycleMe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class RecycleMeController {

    @RequestMapping(value = "")
    public String index(Model model) {
        return "index";
    }


    @RequestMapping(method = RequestMethod.GET, value = "register")
    public String register(Model model){
        return "register.html";
    }

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

