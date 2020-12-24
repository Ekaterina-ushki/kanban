package com.list.itemlist.controller;

import com.list.itemlist.Service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeleteController {

    @Autowired
    ItemService service;

    static final Logger logger = LoggerFactory.getLogger(DeleteController.class);

    @RequestMapping(path = "/item/{id}/delete", method = RequestMethod.POST)
    public ModelAndView delete(@PathVariable("id") int id) {
        service.deleteItem(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        logger.info("Task is deleted");
        return modelAndView;
    }

}
