package com.example.newsapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.Article;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    List<Article> articleList = new ArrayList<>();
    NewsRecyclerAdapter adapter;
    LinearProgressIndicator progressIndicator;
    Button btn1, btn2, btn3, btn4, btn5, btn6;
    SearchView searchView;
    String apiKey;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Properties properties = new Properties();
        try (InputStream inputStream = this.getAssets().open("config.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            // Handle exception
        }
        apiKey = properties.getProperty("API_KEY");
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.news_recycler_view);
        progressIndicator = findViewById(R.id.progress_bar);
        searchView = findViewById(R.id.search_view);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);



        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                getNews("GENERAL",query);
                searchView.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        setupRecyclerView();
        getNews("GENERAL",null);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    void updateData(List<Article> data){
        articleList.clear();
        articleList.addAll(data);


    }

    void changeInProgress(boolean inProgress){
        if(inProgress){
            progressIndicator.setVisibility(View.VISIBLE);
        }else{
            progressIndicator.setVisibility(View.GONE);
        }


    }

    void setupRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NewsRecyclerAdapter(articleList,this);
        recyclerView.setAdapter(adapter);


    }

    void getNews(String category, String query){
        changeInProgress(true);
        NewsApiClient newsApiClient = new NewsApiClient(apiKey);
        newsApiClient.getTopHeadlines(
                new TopHeadlinesRequest.Builder()
                        .language("en")
                        .category(category)
                        .q(query)
                        .pageSize(100)
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {

                        runOnUiThread(() ->{
                            changeInProgress(false);
                            articleList = response.getArticles();
                            adapter.updateData(articleList);
                            adapter.notifyDataSetChanged();

                        });



                    }

                    @Override
                    public void onFailure(Throwable throwable) {

                        Log.i("Didn't get articles", throwable.toString());

                    }
                }

        );


    }

    @Override
    public void onClick(View v) {

        Button btn = (Button) v;
        String category = btn.getText().toString();
        getNews(category, null);


    }
}