package com.chi_square.movierating;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.chi_square.movierating.adapter.RateMovieAdapter;

import java.util.ArrayList;
import java.util.List;

public class RateActivity extends AppCompatActivity {
    List<String> movies;
    RateMovieAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Rate 5 Movies");
        }

        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        RecyclerView list = (RecyclerView) findViewById(R.id.movie_list);
        list.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(mLayoutManager);

        movies = new ArrayList<String>();
        adapter = new RateMovieAdapter(this,movies);
        list.setAdapter(adapter);

        prepareMovies(0);

        final int[] clickcount = {0};
        Button loadMore = (Button) findViewById(R.id.button_load_more);
        loadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickcount[0]++;
                prepareMovies(clickcount[0]);
            }
        });

    }

    private void prepareMovies(int i){
//        List<String> a = new ArrayList<String>();
        int j = i*10;
        int k = j+10;
        for(i=j;i<k;i++){
            movies.add("Movie Name "+i);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.rate_movie, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.rate_menu_next:
                Intent i = new Intent(getBaseContext(),GenreActivity.class);
                startActivity(i);
                return true;
            default:
                return true;
        }
    }
}
