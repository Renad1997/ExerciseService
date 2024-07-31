package com.example.exerciseservice.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@AllArgsConstructor
@Data
public class NewsArticle {

   @NotNull(message = "ID should be Not Null!")
    private int id;

@NotEmpty(message = "title should be Not Empty!")
@Size(max = 100 ,message = "title maximum characters 100")
    private String title;

@NotEmpty(message = "author should be Not Empty!")
@Size(min=4,max=20,message = "author minimum characters 4")
private String author;

@NotEmpty(message = "content should be Not Empty!")
@Size(min = 200,message = "content minimum characters 200")
private String content;

@NotEmpty(message = "category should be Not Empty!")
@Pattern(regexp="^(politics|sports|technology)$",message = "Category Not Found!")
private String category;

@NotEmpty(message = "imageUrl should be Not Empty!")
private String imageUrl;

@AssertFalse
private Boolean isPublished;


@NotNull(message = "PublishDate should be Not Null!")
@JsonFormat(pattern ="yyyy-MM-dd")
@PastOrPresent
private LocalDate publishDate;




}
