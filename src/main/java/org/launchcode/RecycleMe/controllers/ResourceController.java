package org.launchcode.RecycleMe.controllers;

import org.launchcode.RecycleMe.models.Resource;

import org.launchcode.RecycleMe.models.data.ResourceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "resource")
public class ResourceController {

    @Autowired
    private ResourceDao resourceDao;

//===========================THIS CODE ALLOWS USERS TO VIEW AND ENTER NEW CITIES TO THE SITE================================
    @RequestMapping(value="")
    public String index(Model model) {
        model.addAttribute("title", "Recycling Resources");
        model.addAttribute("resources", resourceDao.findAll());
        return "resource/index";
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new Resource());
        model.addAttribute("title", "Add a Resource");
        return "resource/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Resource resource, Errors errors) {
        if (errors.hasErrors()) {
            return "resource/add";
        }
        else {
            resourceDao.save(resource);
            return "redirect:/resource";
        }
    }

}