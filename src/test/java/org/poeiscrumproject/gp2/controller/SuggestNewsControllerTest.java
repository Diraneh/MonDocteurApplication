package org.poeiscrumproject.gp2.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.poeiscrumproject.gp2.service.NewsService;
import org.poeiscrumproject.gp2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SuggestNewsControllerTest {




    @Autowired
    MockMvc mockMvc;

    @MockBean
    NewsService service;

    @MockBean
    UserService user;




    @Test
    public void testSaveNews() throws Exception{
        mockMvc.perform(post("/suggest/news"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("suggestnews.html"))
                .andExpect(model().size(1));
    }


    @Test
    public void testShowSuggestion() throws Exception{
        mockMvc.perform(get("/suggest/news"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("suggestnews.html"));
    }





}
