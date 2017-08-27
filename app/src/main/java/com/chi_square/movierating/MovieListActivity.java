package com.chi_square.movierating;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.chi_square.movierating.adapter.MovieAdapter;

import java.util.ArrayList;
import java.util.List;

public class MovieListActivity extends AppCompatActivity {
    List<String> movies;
    MovieAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        Bundle i = getIntent().getExtras();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(i.getString("GENRE_NAME"));
        }

        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        RecyclerView list = (RecyclerView) findViewById(R.id.genre_movie_list);
        list.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(mLayoutManager);

        movies = new ArrayList<String>();
        adapter = new MovieAdapter(this,movies);
        list.setAdapter(adapter);

        prepareMovies(0);


    }

    private void prepareMovies(int i){
        int j = i*10;
        int k = j+10;
        for(i=j;i<k;i++){
            movies.add("Movie Name "+i);
        }
        adapter.notifyDataSetChanged();
    }
}
