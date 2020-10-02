package org.poeiscrumproject.gp2.controller;


import org.poeiscrumproject.gp2.SendEmail;
import org.poeiscrumproject.gp2.model.User;
import org.poeiscrumproject.gp2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@RequestMapping(path="/account")
@RestController
public class AccountCreationController {

    @Autowired
    private UserService service;
    
    @RequestMapping("/create")
    public ModelAndView showCreateUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return new ModelAndView("accountcreation.html");
    }

    @RequestMapping(value="/create",method = RequestMethod.POST)
    public  RedirectView saveUser(@ModelAttribute("user") User user) {
        service.saveUser(user);
        RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/homepage");
		return redirectView;
    }
    
    @RequestMapping("/delete")
    public ModelAndView showDeleteUser(Model model) {
        return new ModelAndView("accountdeletion.html");
    }
    
    @RequestMapping(value="/delete",method = RequestMethod.POST)
    public  RedirectView deleteUser() {
    	User user = service.getUserById(ConnectionController.userSessionId);
        service.deleteUser(user);
    	RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/connect");
		return redirectView;
}
 
    @RequestMapping("/physician")
    public ModelAndView showCreateUserByPhysician(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return new ModelAndView("accountcreationphysicians.html");
    }

    @RequestMapping(value="/physician",method = RequestMethod.POST)
    public  RedirectView saveUserByPhysician(@ModelAttribute("user") User user) {
        service.saveUser(user);
        String emailBody="Bonjour, \n Vous avez été inscrit par votre médein sur Healthcare App. \n"
        		+ "Voici vos paramètres de connexion: \n"
        		+ "nom d'utilisateur: "+user.getUsername()+"\n"
        		+ "password: "+user.getPassword();
        String emailSubject="Inscription à Healthcare App";
        String emailRecipient=user.getEmail();
        SendEmail email=new SendEmail(emailRecipient, emailSubject, emailBody);
    	RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/connect");
		return redirectView;
    }

}
