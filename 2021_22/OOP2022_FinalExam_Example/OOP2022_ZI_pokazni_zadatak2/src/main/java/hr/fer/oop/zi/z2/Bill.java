package hr.fer.oop.zi.z2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bill {
  public String id;
  public List<Article> articles;

  public Bill(String id) {
    this.id = id;
    this.articles = new ArrayList<>();
  }

  public void addArticle(Article article) {
    articles.add(article);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<Article> getArticles() {
    return articles;
  }

  public void setArticles(List<Article> articles) {
    this.articles = articles;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Bill {\n");
    sb.append("  id='" + id + "',\n");
    sb.append("  articles=[\n");
    sb.append(articles.stream()
        .map((a -> a.toString()))
        .collect(Collectors.joining(",\n", "", "\n"))
        .indent(4));
    sb.append("  ]\n");
    sb.append("}");

    return sb.toString();
  }
}
