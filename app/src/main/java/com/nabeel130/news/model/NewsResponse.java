package com.nabeel130.news.model;

import java.util.ArrayList;

public class NewsResponse {
    private ArrayList<Article> articles;
    private String status;
    private int totalResults;

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }
}
