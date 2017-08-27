package com.chi_square.movierating;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chi_square.movierating.adapter.RateMovieAdapter;
import com.chi_square.movierating.data.MovieList;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class RateActivity extends AppCompatActivity {
    List<MovieList> movies;
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

        movies = new ArrayList<MovieList>();
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
            MovieList a = new MovieList(i,"Movie Name "+i,0,1996,12234,R.drawable.icon_movie_thumbnail);
            movies.add(a);
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
                int count = 0;
                for(ListIterator<MovieList> movieIterator = movies.listIterator(); movieIterator.hasNext();){
                    MovieList element = movieIterator.next();
                    if(element.getRating() > 0){
                        count++;
                    }
                }
                Log.i("COUNT_RATING",""+count);
                if(count >= 5){
                    Intent i = new Intent(getBaseContext(),GenreActivity.class);
                    startActivity(i);
                }else{
                    TextView error = (TextView) findViewById(R.id.error_rate);
                    error.setText("Rate atleast 5 movies");
                }
                return true;
            default:
                return true;
        }
    }
}
