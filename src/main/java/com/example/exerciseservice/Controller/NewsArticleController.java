package com.example.exerciseservice.Controller;

import com.example.exerciseservice.Api.ApiResponse;
import com.example.exerciseservice.Model.NewsArticle;
import com.example.exerciseservice.Service.NewsArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/news")
@RequiredArgsConstructor
public class NewsArticleController {

    private final NewsArticleService newsArticleService;

    @GetMapping("/get")
    public ResponseEntity getNewsArticle() {
        ArrayList<NewsArticle> Articles = newsArticleService.getArticles();
        return ResponseEntity.status(200).body(Articles);

    }
   @PostMapping("/add")
    public ResponseEntity addNewsArticle(@Valid @RequestBody NewsArticle newsArticle, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        newsArticleService.addArticle(newsArticle);
        return ResponseEntity.status(200).body(new ApiResponse("News Article Added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateNewsArticle(@PathVariable int id ,@Valid @RequestBody NewsArticle newsArticle, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean isUpdated=newsArticleService.updateArticle(id, newsArticle);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("News Article Updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("newsArticle Not Found"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteNewsArticle(@PathVariable int id) {
        boolean isDeleted=newsArticleService.deleteArticle(id);
        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("News Article Deleted"));
        }

     return ResponseEntity.status(400).body(new ApiResponse("newsArticle Not Found"));
    }

@GetMapping("/publish/{id}")
public ResponseEntity publish(@PathVariable int id){
       newsArticleService.publish(id);
return ResponseEntity.status(200).body(new ApiResponse("News Article Published"));
        }

  @GetMapping("/all/Published")
  public ResponseEntity getAllPublished(){
        return ResponseEntity.status(200).body(newsArticleService.getAllPublished());
 }

@GetMapping("/get/category/{category}")
 public ResponseEntity getNewsArticlesCategory(@PathVariable String category){
        return ResponseEntity.status(200).body(newsArticleService.getCategory(category));

 }

}



