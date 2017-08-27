package com.chi_square.movierating;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.twotoasters.jazzylistview.JazzyGridView;
import com.twotoasters.jazzylistview.effects.SlideInEffect;

public class GenreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Genres");
        }

        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        JazzyGridView list = (JazzyGridView) findViewById(R.id.genre_list);

        String[] genreArray = {"Horror", "Drama", "Adventure", "Sci-Fi", "Comedy", "Romance", "Thriller", "Fantasy"};
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.genre_grid_item,genreArray);

        list.setAdapter(adapter);
        list.setTransitionEffect(new SlideInEffect());

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent movie_list_activity = new Intent(getBaseContext(), MovieListActivity.class);
                TextView genre = (TextView) view.findViewById(R.id.genre_name);
                movie_list_activity.putExtra("GENRE_NAME", genre.getText().toString());
                startActivity(movie_list_activity);
            }
        });
    }
}
