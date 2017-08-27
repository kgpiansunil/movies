package com.chi_square.movierating;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.adroitandroid.chipcloud.ChipCloud;

import org.w3c.dom.Text;

import static java.lang.Float.parseFloat;

public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        Bundle i = getIntent().getExtras();

        String movie = i.getString("MOVIE_NAME");
//        float rating = parseFloat(i.getString("RATING"));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(movie);
        }

        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        TextView movie_name = (TextView) findViewById(R.id.movie_name);
        movie_name.setText(movie);

    }
}
