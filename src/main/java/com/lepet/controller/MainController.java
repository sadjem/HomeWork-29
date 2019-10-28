package com.lepet.controller;

import com.lepet.model.Article;
import com.lepet.repos.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@SuppressWarnings("unused")
@Controller
public class MainController {

    @Autowired
    private ArticleRepo articleRepo;

    @PostMapping
    public String addArticle(@RequestParam String title, @RequestParam String text, Map<String,Object> model){
        Article article = new Article(title, text);
        articleRepo.save(article);
        Iterable<Article> articles = articleRepo.findAll();
        model.put("articles", articles);
        return "main";
    }

    @GetMapping
    public String getAll (Map<String, Object> model) {
        Iterable<Article> articles = articleRepo.findAll();
        model.put("articles", articles);
        return "main";
    }

    @GetMapping(value = "/article")
    public String add (@RequestParam (value = "title") String title,
                       @RequestParam (value = "text") String text,
                       Map<String, Object> model){
        Iterable<Article> articles = articleRepo.findByTitleAndText(title,text);
        model.put("articles", articles);
        return "search success";
    }

}
