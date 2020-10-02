package org.poeiscrumproject.gp2.controller;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;



@RunWith(SpringRunner.class)
@WebMvcTest(value=ConnectionController.class)
public class ConnectionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConnectionController connectionController;


    @Autowired
    private WebApplicationContext applicationContext;

    Model model;


    ConnectionController connection;

    @Before
    public void setUp() throws Exception {
        mockMvc = webAppContextSetup(applicationContext).build();
        connection = new ConnectionController();

    }


    @Test
    public void mockconnect() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/connect")).andExpect(MockMvcResultMatchers.status()
                .isOk());
    }

    @Test
    public void  connectTest() throws Exception {

		connectionController.showConnectionPage(model);

		connectionController.connect("leny12","123456",model);
    }
}