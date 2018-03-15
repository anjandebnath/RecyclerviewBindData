package com.aad.recyclerviewbinddata;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import butterknife.ButterKnife;


/**
 * Created by Anjan Debnath on 12/4/2017.
 * Purpose :
 * Copyright (c) 2017, W3 Engineers Ltd. All rights reserved.
 */
public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.GenericViewHolder> {

    private ArrayList<FeedModel> feedModelList;
    private Context mContext;


    //custom click listener for recyclerview
    private FeedItemClickListener itemClickListener;

    // this will differentiate view type
    private final int ITEM_TEXT_FEED_VIEW = 0;
    private final int ITEM_IMAGE_FEED_VIEW = 1;

    //clickListener for item
    public interface FeedItemClickListener {
        void onItemClick(int position, int actionType);
    }

    FeedAdapter(ArrayList<FeedModel> list, Context context, FeedItemClickListener onItemClick) {
        this.feedModelList = list;
        this.mContext = context;
        this.itemClickListener = onItemClick;
    }

    @Override
    public int getItemViewType(int position) {
        FeedModel playerModel = feedModelList.get(position);
        if (playerModel.isTextFeed()) {
            return ITEM_TEXT_FEED_VIEW;
        }else{
            return ITEM_IMAGE_FEED_VIEW;
        }
    }

    //This view holder is generic
    public abstract class GenericViewHolder extends RecyclerView.ViewHolder
    {
        public GenericViewHolder(View itemView) {
            super(itemView);
        }

        public abstract  void setDataOnView(int position);
    }

    @Override
    public GenericViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        switch(viewType){
            case ITEM_TEXT_FEED_VIEW:
                itemView = inflater.inflate(R.layout.layout_text_feed, parent, false);
                return new TextFeedViewHolder(itemView);

            case ITEM_IMAGE_FEED_VIEW:
                itemView = inflater.inflate(R.layout.layout_image_feed, parent, false);
                return new ImageFeedViewHolder(itemView);

            default:
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final GenericViewHolder holder, final int position) {

        holder.setDataOnView(position);

    }

    @Override
    public int getItemCount() {
        return feedModelList.size();
    }

    public class ImageFeedViewHolder extends GenericViewHolder {



        public ImageFeedViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }

        @Override
        public void setDataOnView(final int position) {

            final FeedModel feedModel = feedModelList.get(position);

        }
    }

    public class TextFeedViewHolder extends GenericViewHolder {

        ConstraintLayout headerFeedLayout;
        ImageView imageView;

        public TextFeedViewHolder(View v) {
            super(v);
            View headerViewLayout = v.findViewById(R.id.header_part);
            //headerFeedLayout = headerViewLayout.findViewById(R.id.feed_header_layout);
            imageView = headerViewLayout.findViewById(R.id.profile_picture);

        }

        @Override
        public void setDataOnView(final int position) {

            final FeedModel feedModel = feedModelList.get(position);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClick(position, 1);
                }
            });

        }
    }


    public void dataChanged(int flag) {
        notifyDataSetChanged();
    }


}
