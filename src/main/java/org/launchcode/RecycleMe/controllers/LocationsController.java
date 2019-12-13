package org.launchcode.RecycleMe.controllers;

import org.launchcode.RecycleMe.models.City;
import org.launchcode.RecycleMe.models.Location;
import org.launchcode.RecycleMe.models.data.CityDao;
import org.launchcode.RecycleMe.models.data.LocationDao;
import org.launchcode.RecycleMe.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("add")
public class LocationsController {


    @Autowired
    private LocationDao locationDao;

    @Autowired
    private UserDao userDao;

    // Request path: /LOCATION
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("locations", locationDao.findAll());
        model.addAttribute("title", "Locations");

        return "add";
    }



    //===========ADDED FROM RECYCLE ME CONTROLLER=======================
    @RequestMapping(method = RequestMethod.GET, value = "add")
    public String addLocation(Model model) {
        model.addAttribute("title", "Add Location");
        model.addAttribute(new Location());
        model.addAttribute("users", userDao.findAll());

        return "add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addLocation(@ModelAttribute @Valid Location newLocation, Model model, Errors errors, @RequestParam int locationId) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Location");
            return "add";
        }

        locationDao.save(newLocation);

        return "redirect:";
    }
//===================================================================================







}
