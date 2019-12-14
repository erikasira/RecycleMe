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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("add-item")
public class LocationsController {


    @Autowired
    private LocationDao locationDao;

    @Autowired
    private CityDao cityDao;




    //================CODE FOR ADDING NEW LOCATIONS TO DATABASE--SUPPOSED TO BE LOCATION FOR EACH CITY============================
//    @RequestMapping(value="add-item/{cityId}", method = RequestMethod.GET)
//    public String addItem(Model model, @PathVariable int cityId) {
//
//        City city = cityDao.findById(cityId);
//        model.addAttribute("cityId", cityId );
//        model.addAttribute(new Location());
//        model.addAttribute("title", "Add a Recycling Location to the City of: " + city.getName());
//
//        return "city/add-item";
//    }
//
//    @RequestMapping(value="add-item", method = RequestMethod.POST)
//    public String addItem(Model model, @ModelAttribute @Valid Location Location, Errors errors, @RequestParam int cityId, @RequestParam int locationId) {
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Add Location");
//            return "city/add-item";
//        }
//
//        City city = cityDao.findById(cityId);
//        city.addItem(Location);
//        locationDao.save(Location);
//        return "redirect:/city/view/" + city.getId();
//
//
//    }

//==============END LOCATION TO CITY DATABASE CODE====================================================================================
}

    // Request path: /LOCATION
//    @RequestMapping(value = "")
//    public String index(Model model) {
//
//        model.addAttribute("locations", locationDao.findAll());
//        model.addAttribute("title", "Locations");
//
//        return "add";
//    }
//
//
//
//    //===========ADDED FROM RECYCLE ME CONTROLLER=======================
//    @RequestMapping(method = RequestMethod.GET, value = "add")
//    public String addLocation(Model model) {
//        model.addAttribute("title", "Add Location");
//        model.addAttribute(new Location());
//        model.addAttribute("users", userDao.findAll());
//
//        return "add";
//    }
//
//    @RequestMapping(value = "add", method = RequestMethod.POST)
//    public String addLocation(@ModelAttribute @Valid Location newLocation, Model model, Errors errors, @RequestParam int locationId) {
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Add Location");
//            return "add";
//        }
//
//        locationDao.save(newLocation);
//
//        return "redirect:";
//    }
////===================================================================================








