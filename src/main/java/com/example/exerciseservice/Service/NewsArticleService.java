package com.example.exerciseservice.Service;
import com.example.exerciseservice.Model.NewsArticle;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class NewsArticleService {

    ArrayList<NewsArticle> Articles = new ArrayList<>();

    public ArrayList<NewsArticle> getArticles() {
        return Articles;
    }

    public void addArticle(NewsArticle article) {
        Articles.add(article);
    }

    public boolean updateArticle(int id , NewsArticle article) {
        for (int i = 0; i < Articles.size(); i++) {
            if (Articles.get(i).getId() == id) {
                Articles.set(i, article);
                return true;
            }
        }
        return false;
    }

    public boolean deleteArticle(int id) {
        for (int i = 0; i < Articles.size(); i++) {
            if (Articles.get(i).getId() == id) {
                Articles.remove(i);
                return true;
            }
        }
        return false;
    }

    public void publish(int id) {
        for (int i = 0; i < Articles.size(); i++) {
            if (Articles.get(i).getId() == id) {
              Articles.get(i).setIsPublished(true);
              Articles.get(i).setPublishDate(LocalDate.now());
            }
        }

    }
    public ArrayList<NewsArticle> getAllPublished(){
        ArrayList<NewsArticle> temp = new ArrayList<>();
        for (int i = 0; i < Articles.size(); i++) {
            if (Articles.get(i).getIsPublished()) {
                temp.add(Articles.get(i));
            }
        }
        return temp;
    }

    public ArrayList<NewsArticle> getCategory(String category){
        ArrayList<NewsArticle> temp = new ArrayList<>();
        for (int i = 0; i < Articles.size(); i++) {
            if (Articles.get(i).getCategory().equalsIgnoreCase(category)) {
                temp.add(Articles.get(i));
            }
        }
        return temp;
    }


}
