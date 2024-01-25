package com.kosign.dev.controller;

import com.kosign.dev.payload.article.ArticleRequest;
import com.kosign.dev.service.article.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/article")
@RequiredArgsConstructor
@CrossOrigin
public class ArticleController extends AbstractRestController {
    private final ArticleService articleService;

    @PostMapping("/post")
    public Object postArticle(@RequestBody ArticleRequest articleRequest){
        articleService.createArticle(articleRequest);
        return ok();
    }

    @GetMapping("")
    public Object getArticles(){
        return ok(articleService.getArticle());
    }

    @DeleteMapping("/delete/{id}")
    public Object deleteArticle(@PathVariable("id")UUID id){
        articleService.deleteArticle(id);
        return ok();
    }

    @PutMapping("/update/{id}")
    public Object updateArticle(@RequestBody ArticleRequest articleRequest, @PathVariable("id") UUID id){
        articleService.updateArticle(articleRequest, id);
        return ok();
    }
}
