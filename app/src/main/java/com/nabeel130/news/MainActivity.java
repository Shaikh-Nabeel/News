package com.nabeel130.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.nabeel130.news.model.Article;
import com.nabeel130.news.model.NewsResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fetchData();
    }

    private void fetchData() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        NewsApi newsApi = RetrofitSingleton.getInstance().create(NewsApi.class);
        Call<NewsResponse> responseCall = newsApi.getTopHeadlines();

        responseCall.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                Log.d("MainActivity", "response code: "+response.code());

                if (response.body() != null) {
                    ArrayList<Article> articles = response.body().getArticles();
                    newsAdapter = new NewsAdapter(articles);
                    recyclerView.setAdapter(newsAdapter);
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Log.d("MainActivity","Error response : "+t.getMessage());
            }
        });
    }

}