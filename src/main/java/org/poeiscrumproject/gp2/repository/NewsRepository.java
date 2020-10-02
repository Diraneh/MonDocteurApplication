package org.poeiscrumproject.gp2.repository;

import org.poeiscrumproject.gp2.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Integer> {
    News findById(int id);

    List<News> findTop4ByOrderByIdDesc();

    List<News> findAllByOrderByIdDesc();
}
