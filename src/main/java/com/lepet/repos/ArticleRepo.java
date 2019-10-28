package com.lepet.repos;

import com.lepet.model.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepo extends CrudRepository <Article, Long> {
    List<Article> findByTitleAndText (String title, String text);
}
