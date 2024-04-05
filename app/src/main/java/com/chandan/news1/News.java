package com.chandan.news1;
import android.os.Parcel;
import java.util.ArrayList;
public class News{
    private int totalResults;
    private ArrayList<Article> articles;
    private String status;

    public News(int totalResults, ArrayList<Article> articles, String status) {
        this.totalResults = totalResults;
        this.articles = articles;
        this.status = status;
    }

    public int getTotalResults() { return totalResults; }
    public void setTotalResults(int value) { this.totalResults = value; }

    public ArrayList<Article> getArticles() { return articles; }
    public void setArticles(ArrayList<Article> value) { this.articles = value; }

    public String getStatus() { return status; }
    public void setStatus(String value) { this.status = value; }



    public class Source {
        private String name;
        private String id;

        public Source(String name, String id) {
            this.name = name;
            this.id = id;
        }

        public String getName() { return name; }
        public void setName(String value) { this.name = value; }

        public String getid() { return id; }
        public void setid(String value) { this.id = value; }
    }


    public class Article {
        private String publishedAt;
        private String author;
        private String urlToImage;
        private String description;
        private Source source;
        private String title;
        private String url;
        private String content;

        public Article(String publishedAt, String author, String urlToImage, String description, Source source, String title, String url, String content) {
            this.publishedAt = publishedAt;
            this.author = author;
            this.urlToImage = urlToImage;
            this.description = description;
            this.source = source;
            this.title = title;
            this.url = url;
            this.content = content;
        }

        public String getPublishedAt() { return publishedAt; }
        public void setPublishedAt(String value) { this.publishedAt = value; }

        public String getAuthor() { return author; }
        public void setAuthor(String value) { this.author = value; }

        public String geturlToImage() { return urlToImage; }
        public void seturlToImage(String value) { this.urlToImage = value; }

        public String getDescription() { return description; }
        public void setDescription(String value) { this.description = value; }

        public Source getSource() { return source; }
        public void setSource(Source value) { this.source = value; }

        public String getTitle() { return title; }
        public void setTitle(String value) { this.title = value; }

        public String geturl() { return url; }
        public void seturl(String value) { this.url = value; }

        public String getContent() { return content; }
        public void setContent(String value) { this.content = value; }
    }
}




