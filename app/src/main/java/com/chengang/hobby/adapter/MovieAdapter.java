package com.chengang.hobby.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
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
public class MovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context mContext;
    private final List<Subjects> mListData;
    private ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    public MovieAdapter(Context context, List<Subjects> listData){
        mContext = context;
        mListData = listData;
    }

    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount()){
            return TYPE_FOOTER;
        }
        return TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent , false);
            view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
            return new ItemViewHolder(view);
        }else if (viewType == TYPE_FOOTER){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_footer, parent , false);
            view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
            return new FooterViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        if (viewHolder instanceof ItemViewHolder){
            Subjects subjects = mListData.get(position);
            if(subjects != null){
                if (imageLoader == null){
                    imageLoader = AppController.getInstance().getImageLoader();
                }
                ((ItemViewHolder)viewHolder).mImageView.setImageUrl(subjects.getImages().getSmall(),imageLoader);
                ((ItemViewHolder)viewHolder).mTitle.setText(subjects.getTitle());
                RatingEntity rating = subjects.getRating();
                ((ItemViewHolder)viewHolder).mAverage.setText(String.valueOf(rating.getAverage()));
                ((ItemViewHolder)viewHolder).mGenres.setText(subjects.getGenres().toString());
                ((ItemViewHolder)viewHolder).mYear.setText(subjects.getYear());
            }
        }

    }

    @Override
    public int getItemCount() {
        return mListData.size() + 1;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        public NetworkImageView mImageView;
        public TextView mTitle;
        public TextView mAverage;
        public TextView mGenres;
        public TextView mYear;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mImageView = (NetworkImageView) itemView.findViewById(R.id.movie_imageView);
            mTitle = (TextView) itemView.findViewById(R.id.movie_title);
            mAverage = (TextView) itemView.findViewById(R.id.movie_average);
            mGenres = (TextView) itemView.findViewById(R.id.movie_genres);
            mYear = (TextView) itemView.findViewById(R.id.movie_year);

        }
    }

    class FooterViewHolder extends RecyclerView.ViewHolder{

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
