package org.poeiscrumproject.gp2.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.poeiscrumproject.gp2.service.NewsService;
import org.poeiscrumproject.gp2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
public class PasswordControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	UserService service;
	@MockBean
	NewsService service2;
	

	@Test
	public void testShowForgotPasswordPage() throws Exception{
		mockMvc.perform(get("/password/forgot"))
		.andExpect(status().is2xxSuccessful())
		.andExpect(view().name("forgotpassword.html"));
	}

}
