package com.list.itemlist.controller;

import com.list.itemlist.Service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@RestController
public class AddController {

    @Autowired
    ItemService itemService;

    static final Logger logger = LoggerFactory.getLogger(AddController.class);

    @PostMapping("/add/confirm")
    public ModelAndView add(@RequestParam("name") String name,
                            @RequestParam("description") String description,
                            @RequestParam("type") String type,
                            @RequestParam("responsible") String responsible){

        itemService.addItem(0, name, description, type, responsible, "To Do");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("confirm");
        logger.info("Добавление таска");
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addItem");
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
