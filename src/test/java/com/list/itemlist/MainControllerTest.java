package com.list.itemlist;

import com.list.itemlist.controller.MainController;
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
public class MainControllerTest {

    @Autowired
    private MainController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void ToDoListTaskTest() throws Exception {
        this.mockMvc.perform(get("/main/1"))
                .andDo(print())
                .andExpect(xpath("//div[@id='task-list']/div").nodeCount(1)); //*[@id="Написать 10 авторам-item"]/div
    }

    @Test
    public void InProgressListTaskTest() throws Exception {
        this.mockMvc.perform(get("/inProgress/1"))
                .andDo(print())
                .andExpect(xpath("//div[@id='task-list']/div").nodeCount(1));
    }

    @Test
    public void DoneListTaskTest() throws Exception {
        this.mockMvc.perform(get("/done/1"))
                .andDo(print())
                .andExpect(xpath("//div[@id='task-list']/div").nodeCount(0));
    }
}
