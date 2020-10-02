package org.poeiscrumproject.gp2.controller;

import java.util.List;

import org.poeiscrumproject.gp2.SendEmail;
import org.poeiscrumproject.gp2.model.News;
import org.poeiscrumproject.gp2.model.User;
import org.poeiscrumproject.gp2.service.NewsService;
import org.poeiscrumproject.gp2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RequestMapping(path="/suggest")
@RestController
public class SuggestNewsController {

    @Autowired
    private NewsService service;
    
    @Autowired
    private UserService service2;

    @RequestMapping("/news")
    public ModelAndView showSuggestion(Model model){
        News news = new News();
        model.addAttribute("news", news);
        return new ModelAndView("suggestnews.html");
    }

    @RequestMapping(value="/news",method = RequestMethod.POST)
    public  ModelAndView saveNews(@ModelAttribute("news") News news) {
        service.saveNews(news);
        String emailBody=news.getBody();
        String emailSubject= "Newsletter : " + news.getTitle();
        List<User> users=service2.getAllUsers();
        for(User user : users) {
        	if(user.getSubscriber()!=null && user.getSubscriber().equals("true")) {
        		String emailRecipient=user.getEmail();
        		SendEmail email=new SendEmail(emailRecipient, emailSubject, emailBody);
        	}
        }
        return new ModelAndView("suggestnews.html");
    }
}
