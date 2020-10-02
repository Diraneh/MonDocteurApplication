package org.poeiscrumproject.gp2.service;

import org.poeiscrumproject.gp2.model.News;
import org.poeiscrumproject.gp2.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public News saveNews(News news){
        return newsRepository.save(news);
    }

    public News getOneNews(int id){
        return newsRepository.findById(id);
    }

    public List<News> getLastNews(){
        return newsRepository.findTop4ByOrderByIdDesc();
    }
    public List<News> getAllNews(){
        return newsRepository.findAllByOrderByIdDesc();
    }

}
