package com.chi_square.movierating.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.chi_square.movierating.MovieActivity;
import com.chi_square.movierating.MovieListActivity;
import com.chi_square.movierating.R;

import java.util.List;

/**
 * Created by Rishank on 26-08-2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private Context mContext;
    private List<String> movieList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public RatingBar ratingBar;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.card_rate_movie_title);
            ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        }
    }

    public MovieAdapter(Context context, List<String> list ){
        this.mContext = context;
        this.movieList = list;
    }

    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rate_movie_card, parent, false);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView title = (TextView) view.findViewById(R.id.card_rate_movie_title);
                RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
                Intent movie_intent = new Intent(view.getContext(),MovieActivity.class);
                movie_intent.putExtra("MOVIE_NAME",title.getText().toString());
                movie_intent.putExtra("RATING", ratingBar.getRating() );
                view.getContext().startActivity(movie_intent);
            }
        });

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MovieAdapter.MyViewHolder holder, int position) {
        String title = movieList.get(position);
        holder.title.setText(title);
        double rating = position*0.5;
        holder.ratingBar.setRating((float)rating);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
