package com.nabeel130.news;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nabeel130.news.model.Article;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private ArrayList<Article> articles;

    NewsAdapter(ArrayList<Article> articles){
        this.articles = articles;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        Article article = articles.get(position);
        holder.title.setText(article.getTitle());
        holder.author.setText(article.getAuthor());
        Glide.with(holder.imageOfNewsItem.getContext()).load(article.getUrlToImage()).placeholder(R.drawable.news).into(holder.imageOfNewsItem);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    static class NewsViewHolder extends RecyclerView.ViewHolder{

        NewsViewHolder(View view){
            super(view);
            imageOfNewsItem = view.findViewById(R.id.imageViewOfNewsItem);
            title = view.findViewById(R.id.titleOfNewsItem);
            author = view.findViewById(R.id.authorOfNewsItem);
        }
        ImageView imageOfNewsItem;
        TextView title;
        TextView author;
    }
}
