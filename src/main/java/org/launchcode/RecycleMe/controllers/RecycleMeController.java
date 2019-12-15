package org.launchcode.RecycleMe.controllers;


import org.launchcode.RecycleMe.models.Location;
import org.launchcode.RecycleMe.models.data.LocationDao;
import org.launchcode.RecycleMe.models.User;
import org.launchcode.RecycleMe.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;


@Controller
@RequestMapping("")

public class RecycleMeController {
    @Autowired
    private UserDao userDao;

    @Autowired
    private LocationDao locationDao;


//===========THIS CODE DIRECTS TO HOMEPAGE/SEARCH PAGE===============
    @RequestMapping(value = "")
    public String index(Model model) {
        return "index";
    }


//----------------------------------------------------------------




//============BEGINNING CODE FOR USER REGISTRATION======================
    @RequestMapping(method = RequestMethod.GET, value = "register")
    public String register(Model model) {
        model.addAttribute("title", "Register");
        model.addAttribute(new User());
        return "register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User user,
                      Errors errors, String verifyPassword) {

        model.addAttribute(user);

        if (errors.hasErrors()) {
            return "register";

        }

        userDao.save(user);

        return "login";
    }
//-----------------ENDING CODE FOR USER REGISTRATION-------------------------




//============BEGINNING CODE FOR USER LOGIN======================
@RequestMapping(method = RequestMethod.GET, value = "login")
public String getLoginForm() {
    return "login";
}

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@ModelAttribute(name = "User") User user, Model model, Errors errors) {
        String username = user.getUsername();
        String password = user.getPassword();

        User myFoundUser = userDao.findByUsername(username);
        if ( myFoundUser != null && password.equals(myFoundUser.getPassword())){
            return "redirect:/location";
        }
        if (errors.hasErrors()) {
            return "login";

        }
        model.addAttribute("invalidCredentials", true);
        return "redirect:/location";

    }


//---------------ENDING CODE FOR USER LOGIN----------------------


}
