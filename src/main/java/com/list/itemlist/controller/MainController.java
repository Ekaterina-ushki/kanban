package com.list.itemlist.controller;

import com.list.itemlist.Service.ItemService;
import com.list.itemlist.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class MainController {

    @Autowired
    ItemService itemService;

    static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/index")
    public ModelAndView index(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        logger.info("Page Index is opened");
        return modelAndView;
    }

    @RequestMapping(path = "/main/{id}", method = RequestMethod.GET)
    public ModelAndView main(Model model, @PathVariable("id") int id) {
        List<Item> items = itemService.findAllInToDo(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        modelAndView.addObject("items", items);
        modelAndView.addObject("id", id);
        logger.info("Page Main is opened");
        return modelAndView;
    }

    @RequestMapping(path = "/inProgress/{id}", method = RequestMethod.GET)
    public ModelAndView inProgress(Model model, @PathVariable("id") int id) {
        List<Item> items = itemService.findAllInProgress(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("inProgress");
        modelAndView.addObject("items", items);
        modelAndView.addObject("id", id);
        logger.info("Page InProgress is opened");
        return modelAndView;
    }

    @RequestMapping(path = "/done/{id}", method = RequestMethod.GET)
    public ModelAndView done(Model model, @PathVariable("id") int id) {
        List<Item> items = itemService.findAllInDone(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("done");
        modelAndView.addObject("items", items);
        modelAndView.addObject("id", id);
        logger.info("Page Done is opened");
        return modelAndView;
    }
}
