package com.chi_square.movierating.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.chi_square.movierating.R;
import com.chi_square.movierating.data.MovieList;

import java.util.List;

/**
 * Created by Rishank on 26-08-2017.
 */

public class RateMovieAdapter extends RecyclerView.Adapter<RateMovieAdapter.MyViewHolder> {

    private Context mContext;
    private List<MovieList> movieList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public RatingBar ratingBar;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.card_rate_movie_title);
            ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
            ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                    movieList.get(getPosition()).setRating(ratingBar.getRating());
                }
            });
        }
    }

    public RateMovieAdapter(Context context, List<MovieList> list ){
        this.mContext = context;
        this.movieList = list;
    }

    @Override
    public RateMovieAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rate_movie_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RateMovieAdapter.MyViewHolder holder, int position) {
        String title = movieList.get(position).getName();
        holder.title.setText(title);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
