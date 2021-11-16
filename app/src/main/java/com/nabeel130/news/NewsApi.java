package com.nabeel130.news;

import com.nabeel130.news.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsApi {
    @GET("v2/top-headlines?country=in&apiKey=abb3e7f8e5e244a9be35220e5de5976b")
    Call<NewsResponse> getTopHeadlines();
}
