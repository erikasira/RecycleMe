package org.launchcode.RecycleMe.controllers;

import org.launchcode.RecycleMe.models.City;

import org.launchcode.RecycleMe.models.data.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "city")
public class CityController {

    @Autowired
    private CityDao cityDao;

//===========================THIS CODE ALLOWS USERS TO VIEW AND ENTER NEW CITIES TO THE SITE================================
    @RequestMapping(value="")
    public String index(Model model) {
        model.addAttribute("title", "Florida Cities");
        model.addAttribute("cities", cityDao.findAll());
        return "city/index";
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new City());
        model.addAttribute("title", "Add a New City");
        return "city/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid City city, Errors errors) {
        if (errors.hasErrors()) {
            return "city/add";
        }
        else {
            cityDao.save(city);
            return "redirect:/city";
        }
    }

}