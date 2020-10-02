package org.poeiscrumproject.gp2.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "news")
@NamedNativeQuery(name = "News.mostRecentNews", query = "SELECT title, abstract, body FROM news ORDER BY ID DESC LIMIT 4")

public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int id;

    @Column(name="title")
    @NotEmpty
    public String title;

    @Column(name="abstract")
    @NotEmpty
    public String abs;

    @Column(name="body")
    @NotEmpty
    public String body;

    @Column(name="priority")

    public int priority;

    public News(String title, String abs, String body, int priority) {
        this.title = title;
        this.abs = abs;
        this.body = body;
        this.priority = priority;
    }

    public News() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbs() {
        return abs;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", abs='" + abs + '\'' +
                ", body='" + body + '\'' +
                ", priority=" + priority +
                '}';
    }
}
