package com.list.itemlist.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/registration").setViewName("registration");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/inProgress").setViewName("inProgress");
        registry.addViewController("/confirm_board").setViewName("confirm_board");
        registry.addViewController("/confirm").setViewName("confirm");
        registry.addViewController("/board").setViewName("board");
        registry.addViewController("/addItem").setViewName("addItem");
        registry.addViewController("/add_board").setViewName("add_board");
        registry.addViewController("/done").setViewName("done");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/board").setViewName("board");
    }
}