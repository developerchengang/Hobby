package com.chengang.hobby.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.chengang.hobby.AppController;
import com.chengang.hobby.R;
import com.chengang.hobby.bean.RatingEntity;
import com.chengang.hobby.bean.Subjects;

import java.util.List;

/**
 * ȫ电影适配器
 *
 * @author chengang (https://github.com/developerchengang)
 * @version 1.0
 * @created 2015-07-11
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private final Context mContext;
    private final List<Subjects> mListData;
    private ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public MovieAdapter(Context context, List<Subjects> listData){
        mContext = context;
        mListData = listData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Subjects subjects = mListData.get(position);
        if(subjects != null){
            if (imageLoader == null){
                imageLoader = AppController.getInstance().getImageLoader();
            }
            viewHolder.mImageView.setImageUrl(subjects.getImages().getSmall(),imageLoader);
            viewHolder.mTitle.setText(subjects.getTitle());
            RatingEntity rating = subjects.getRating();
            viewHolder.mAverage.setText(String.valueOf(rating.getAverage()));
            viewHolder.mGenres.setText(subjects.getGenres().toString());
            viewHolder.mYear.setText(subjects.getYear());


        }
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public NetworkImageView mImageView;
        public TextView mTitle;
        public TextView mAverage;
        public TextView mGenres;
        public TextView mYear;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (NetworkImageView) itemView.findViewById(R.id.movie_imageView);
            mTitle = (TextView) itemView.findViewById(R.id.movie_title);
            mAverage = (TextView) itemView.findViewById(R.id.movie_average);
            mGenres = (TextView) itemView.findViewById(R.id.movie_genres);
            mYear = (TextView) itemView.findViewById(R.id.movie_year);

        }
    }
}
