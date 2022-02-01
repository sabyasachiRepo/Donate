package org.donate.entity.other;

import java.util.ArrayList;

public class NewsResponse {
    public String status;
    public int totalResults;
    public ArrayList<Article> articles;
}

 class Source{
    public String id;
    public String name;
}

 class Article{
    public Source source;
    public String author;
    public String title;
    public String description;
    public String url;
    public String urlToImage;
    public String publishedAt;
    public String content;
}
