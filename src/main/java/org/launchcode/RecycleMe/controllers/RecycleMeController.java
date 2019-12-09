package org.launchcode.RecycleMe.controllers;


import org.launchcode.RecycleMe.models.forms.User;
import org.launchcode.RecycleMe.models.data.UserDao;
import org.launchcode.RecycleMe.models.forms.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
@RequestMapping("")

public class RecycleMeController {
    @Autowired
    private UserDao userDao;



//===========THIS CODE DIRECTS TO HOMEPAGE===============
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
                      Errors errors, String verifypassword) {

        model.addAttribute(user);

        if (errors.hasErrors()) {
            return "register";

        }

        userDao.save(user);

        return "add";
    }
//-----------------ENDING CODE FOR USER REGISTRATION-------------------------




//============BEGINNING CODE FOR USER LOGIN======================
    @RequestMapping(method = RequestMethod.GET, value = "login")
    public String login(Model model) {
        model.addAttribute("title", "Log In");
        model.addAttribute(new Login());
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@ModelAttribute @Valid Login form, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Log In");
            return "login";
        }

        User user = userDao.findByUsername(form.getUsername());
        String password = form.getPassword();

        if (user != null && user.getUsername().equalsIgnoreCase(user.getUsername())) {

            return "add";
        }

        model.addAttribute("login", "Errors");
        user.setPassword("");

        return "login";
    }

//---------------ENDING CODE FOR USER LOGIN----------------------






//=================BEGINNING CODE FOR ADDING LOCATIONS TO THE DATABASE=============
    @RequestMapping(method = RequestMethod.GET, value = "add")
    public String add(Model model) {
        return "add.html";
    }
//-----------END CODE FOR ADDING LOCATIONS TO DATABASE-----------------------------





//================BEGINNING CODE FOR GETTING LOCATION RESULTS FROM DATABASE=======================
    @RequestMapping(method = RequestMethod.GET, value = "results")
    public String results(Model model) {
        return "results.html";
    }
//------------------- ENDING CODE FOR RESULT -----------------------------------------------
}
