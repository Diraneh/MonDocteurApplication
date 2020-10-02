package org.poeiscrumproject.gp2.controller;

import org.poeiscrumproject.gp2.model.News;
import org.poeiscrumproject.gp2.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private NewsService newsService;
    List<News> mostRecentNewsList = new ArrayList<>();

    @GetMapping(path="/homepage")
    public ModelAndView showHomePage(){
        Map<String, Object> model = new HashMap<>();

        mostRecentNewsList = newsService.getLastNews();
        System.out.println(mostRecentNewsList.size());

        model.put("mostRecentNewsList", mostRecentNewsList);
        return new ModelAndView("homepage.html", model);
    }
}
