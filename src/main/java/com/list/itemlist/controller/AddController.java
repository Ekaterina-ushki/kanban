package com.list.itemlist.controller;

import com.list.itemlist.Service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AddController {

    @Autowired
    ItemService itemService;

    static final Logger logger = LoggerFactory.getLogger(AddController.class);

    @RequestMapping(path = "/add/confirm/{id}", method = RequestMethod.GET)
    public ModelAndView add(@RequestParam("name") String name,
                            @RequestParam("description") String description,
                            @RequestParam("type") String type,
                            @RequestParam("responsible") String responsible,
                            @PathVariable("id") int id){

        itemService.addItem(0, name, description, type, responsible, "To Do", id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("confirm");
        modelAndView.addObject("id", id);
        logger.info("Добавление таска");
        return modelAndView;
    }


    @RequestMapping(path = "/add/{id}", method = RequestMethod.GET)
    public ModelAndView add(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addItem");
        modelAndView.addObject("id", id);
        logger.info("Page Add is opened");
        return modelAndView;
    }


    @RequestMapping(path = "/add/{id}/inProgress", method = RequestMethod.POST)
    public void addInProgress(@PathVariable("id") int id) {
        itemService.addItemToInProgress(id);
        logger.info("Таск перенесен в InProgress");
    }

    @RequestMapping(path = "/add/{id}/done", method = RequestMethod.POST)
    public void addInDone(@PathVariable("id") int id) {
        itemService.addItemToDone(id);
        logger.info("Таск перенесен в Done");
    }
}
