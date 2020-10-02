package org.poeiscrumproject.gp2.controller;

import org.poeiscrumproject.gp2.model.News;
import org.poeiscrumproject.gp2.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;
    News news = new News();
    List<News> allNewsList = new ArrayList<>();

    @GetMapping(path="/news")
    public ModelAndView showOneNews(@RequestParam int id){
        Map<String, Object> model = new HashMap<>();

        news = newsService.getOneNews(id);

        model.put("news", news);
        return new ModelAndView("news.html", model);
    }

    @GetMapping(path="/allnews")
    public ModelAndView showAllNewsPage(){
        Map<String, Object> model = new HashMap<>();

        allNewsList = newsService.getAllNews();
        System.out.println(allNewsList.size());

        model.put("allNewsList", allNewsList);
        return new ModelAndView("allnews.html", model);
    }
}
