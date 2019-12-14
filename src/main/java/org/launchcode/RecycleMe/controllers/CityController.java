package org.launchcode.RecycleMe.controllers;

import org.launchcode.RecycleMe.forms.AddCityItemForm;
import org.launchcode.RecycleMe.models.City;
import org.launchcode.RecycleMe.models.Location;
import org.launchcode.RecycleMe.models.data.CityDao;
import org.launchcode.RecycleMe.models.data.LocationDao;
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

    @Autowired
    private LocationDao locationDao;


    //=================INDEX PAGE FOR CITIES - DISPLAYS AND LINKS TO ALL CITIES THAT HAVE BEEN ADDED TO DATABASE===========
    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Cities");
        model.addAttribute("cities", cityDao.findAll());

        return "city/index";
    }
//==========================END OF DISPLAY OF CITIES THAT HAVE BEEN ENTERED=====================================


    //==================THIS IS TO ADD A NEW CITY=============================================================
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new City());
        model.addAttribute("title", "Add City");
        return "city/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid City city, Errors errors) {
        if (errors.hasErrors()) {
            return "city/add";
        }
        cityDao.save(city);
        return "redirect:/city/view/" + city.getId();
    }

    @RequestMapping(value = "view/{cityId}", method = RequestMethod.GET)
    public String viewCity(Model model, @PathVariable int cityId) {
        City city = cityDao.findById(cityId);
        model.addAttribute("city", city);
        model.addAttribute("title", city.getName());
        return "city/view";
    }
//==================END OF ADDING A NEW CITY========================================================






//================CODE FOR ADDING NEW LOCATIONS TO DATABASE--SUPPOSED TO BE LOCATION FOR EACH CITY============================
    @RequestMapping(value="add-item/{cityId}", method = RequestMethod.GET)
    public String addItem(Model model, @PathVariable int cityId) {

        City city = cityDao.findById(cityId);
        model.addAttribute("cityId", cityId );
        model.addAttribute(new Location());
        model.addAttribute("title", "Add a Recycling Location to the City of: " + city.getName());

        return "city/add-item";
    }

    @RequestMapping(value="add-item", method = RequestMethod.POST)
    public String addItem(Model model, @ModelAttribute @Valid Location Location, Errors errors, @RequestParam int cityId, @RequestParam int locationId) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Location");
            return "city/add-item";
        }

        City city = cityDao.findById(cityId);
        city.addItem(Location);
        locationDao.save(Location);
        return "redirect:/city/view/" + city.getId();


    }

//==============END LOCATION TO CITY DATABASE CODE====================================================================================
}