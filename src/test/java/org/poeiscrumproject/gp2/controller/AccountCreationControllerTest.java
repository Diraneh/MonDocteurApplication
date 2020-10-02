package org.poeiscrumproject.gp2.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.poeiscrumproject.gp2.SendEmail;
import org.poeiscrumproject.gp2.model.User;
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

import javax.mail.Transport;

@RunWith(SpringRunner.class)
@WebMvcTest
public class AccountCreationControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	UserService service;
	
	@MockBean
	NewsService service2;
	
	@MockBean
	SendEmail mail;
	
	@MockBean
	Transport transport;
	
	
	@Test
	public void testShowCreateUser() throws Exception{
		mockMvc.perform(get("/account/create"))
		.andExpect(status().is2xxSuccessful())
		.andExpect(view().name("accountcreation.html"))
		.andExpect(model().size(1));
	}
	
	@Test
	public void testSaveUser() throws Exception{
		mockMvc.perform(post("/account/create"))
		.andExpect(status().is3xxRedirection())
		.andExpect(redirectedUrl("/homepage"));;
	}
	
	@Test
	public void testShowDeleteUser() throws Exception{
		mockMvc.perform(get("/account/delete"))
		.andExpect(status().is2xxSuccessful())
		.andExpect(view().name("accountdeletion.html"));
	}
	
	@Test
	public void testDeleteUser() throws Exception{
		mockMvc.perform(post("/account/delete"))
		.andExpect(status().is3xxRedirection())
		.andExpect(redirectedUrl("/connect"));
	}
	
	@Test
	public void testShowCreateUserByPhysician() throws Exception{
		mockMvc.perform(get("/account/physician"))
		.andExpect(status().is2xxSuccessful())
		.andExpect(view().name("accountcreationphysicians.html"));
	}
	
	 @Test
	public void testSaveUserByPhysician() throws Exception{
		mockMvc.perform(post("/account/physician"))
		.andExpect(status().is3xxRedirection())
		.andExpect(redirectedUrl("/connect"));
	} 

}
