package com.example.rubafikri.moviesbyvolly;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyMovieAdapter extends BaseAdapter {
    Context context;
    List<movie> movies;


    public  MyMovieAdapter (Context context, List<movie> movies){
        this.context = context;
        this.movies = movies;

    }
    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       if (convertView == null){
           convertView = LayoutInflater.from(context).inflate(R.layout.movie_layout,null);
           viewHolder vh = new viewHolder();
           vh.title = convertView.findViewById(R.id.tv);
           vh.released = convertView.findViewById(R.id.tv1);
           vh.im = convertView.findViewById(R.id.im);
           convertView.setTag(vh);
       }
       viewHolder vh = ( viewHolder ) convertView.getTag();
       vh.title.setText(movies.get(position).getTitle());

       vh.released.setText(movies.get(position).getRating());
        Picasso.get().load(movies.get(position).getImage()).into(vh.im);

        return convertView;
    }

    class viewHolder {
        ImageView im ;
        TextView title;
        TextView released;
    }
}
