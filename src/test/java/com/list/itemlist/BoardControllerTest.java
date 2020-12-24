package com.list.itemlist;

import com.list.itemlist.controller.BoardController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithUserDetails("Kate")
public class BoardControllerTest {

    @Autowired
    private BoardController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void openBoardTest () throws Exception{
        this.mockMvc.perform(get("/board"))
                .andDo(print())
                .andExpect(xpath("//*[@id='boards']").string("Доски"));
    }

    @Test
    public void addBoardTest () throws Exception{
        this.mockMvc.perform(get("/add"))
                .andDo(print())
                .andExpect(xpath("//*[@id='add-board']").string("Добавить новую доску"));
    }

}
