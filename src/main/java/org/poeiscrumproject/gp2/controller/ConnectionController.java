package org.poeiscrumproject.gp2.controller;

import org.poeiscrumproject.gp2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class ConnectionController {
	static int userSessionId;
	
	
    @Autowired
    private UserService service;

    @RequestMapping("/connect")
    public ModelAndView showConnectionPage(Model model){
        return new ModelAndView("index.html");
    }

    @RequestMapping(value = "/connect", method = RequestMethod.POST)
    public RedirectView connect(@RequestParam(name = "username") String username,
                                @RequestParam(name="password") String password,
                                Model model){
        if(service.getUserByUsername(username)!=null && service.getUserByUsername(username).getPassword().equals(password)){
            model.addAttribute("userId",service.getUserByUsername(username).getId());
            userSessionId=service.getUserByUsername(username).getId();
            RedirectView redirectView = new RedirectView();
    		redirectView.setUrl("/homepage");
    		return redirectView;

            
        }

        else {
        	RedirectView redirectView = new RedirectView();
    		redirectView.setUrl("/connect");
    		return redirectView;
        }
    }


}
