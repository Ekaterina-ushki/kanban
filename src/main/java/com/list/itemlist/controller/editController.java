package com.list.itemlist.controller;

import com.list.itemlist.Service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class editController {
    @Autowired
    ItemService itemService;

    static final Logger logger = LoggerFactory.getLogger(DeleteController.class);

    @RequestMapping(path = "/main/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editOpen(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit-task");
        modelAndView.addObject("id", id);
        logger.info("Page Edit is opened");
        return modelAndView;
    }

    @RequestMapping(path = "/main/edit-p/{id}", method = RequestMethod.POST)
    public ModelAndView edit(@RequestParam("description") String description,
                            @PathVariable("id") int id){
        itemService.editTask(id, description);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("board");
        modelAndView.addObject("id", id);
        logger.info("Изменение таска");
        return modelAndView;
    }



}
