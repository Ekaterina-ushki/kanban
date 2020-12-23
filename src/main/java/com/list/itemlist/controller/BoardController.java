package com.list.itemlist.controller;

import com.list.itemlist.Service.BoardService;
import com.list.itemlist.model.Board;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @GetMapping("/board")
    public ModelAndView board(Model model) {
        List<Board> boards = boardService.findAllBoard();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("board");
        modelAndView.addObject("boards", boards);
        logger.info("Page Board is opened");
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView add_board(Model model) {
        List<Board> boards = boardService.findAllBoard();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add_board");
        logger.info("Page Add Board is opened");
        return modelAndView;
    }

    @PostMapping("/add/confirm")
    public ModelAndView add_confirm(@RequestParam("name") String name){
        boardService.addBoard(0, name);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("confirm_board");
        logger.info("Подтверждение создания новой доски");
        return modelAndView;
    }
}
