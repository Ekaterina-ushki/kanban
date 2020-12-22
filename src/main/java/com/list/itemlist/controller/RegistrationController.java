package com.list.itemlist.controller;

import com.list.itemlist.Service.UserService;
import com.list.itemlist.model.MyUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    @Autowired
    UserService userService;

    static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @GetMapping("/registration")
    public ModelAndView main(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        logger.info("Page Registration is opened");
        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView addUser(@RequestParam("login") String login,
                             @RequestParam("pass1") String pass1,
                             @RequestParam("pass2") String pass2,
                             @RequestParam("email") String email) {

        //clearErrors();
        userService.insertUser(new MyUser(1,login, pass1, email));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        logger.info("User is created");
        return modelAndView;
    }
}
