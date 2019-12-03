package org.launchcode.RecycleMe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class RecycleMeController {

    @RequestMapping(value = "")
    public String index() {
        return "index";
    }




}

