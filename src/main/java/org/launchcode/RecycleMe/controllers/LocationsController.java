package org.launchcode.RecycleMe.controllers;

import org.launchcode.RecycleMe.models.Location;
import org.launchcode.RecycleMe.models.data.LocationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("location")
public class LocationsController {


    @Autowired
    private LocationDao locationDao;



//===============================THIS CODE ALLOWS USERS TO ENTER NEW LOCATIONS BASED ON CITIES ALREADY ENTERED===========================

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("locations", locationDao.findAll());
        model.addAttribute("title", "Locations");

        return "location/index";
    }

    @RequestMapping(value = "index")
    public String index2(Model model) {

        model.addAttribute("locations", locationDao.findAll());
        model.addAttribute("title", "Locations");

        return "location/index";
    }
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayLocations(Model model) {
        model.addAttribute("title", "Add Location");
        Location location = new Location();
        model.addAttribute("location", location);

        return "location/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processLocations(@ModelAttribute @Valid Location newLocation,
                                   Errors errors, Model model) {

            locationDao.save(newLocation);
            return "redirect:/location/index";

    }
}













