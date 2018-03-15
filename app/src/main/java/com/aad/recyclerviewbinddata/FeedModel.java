package com.aad.recyclerviewbinddata;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Anjan Debnath on 3/15/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */

public class FeedModel {

    public boolean isTextFeed() {
        return isTextFeed;
    }

    public void setTextFeed(boolean textFeed) {
        isTextFeed = textFeed;
    }

    public String getFeedName() {
        return feedName;
    }

    public void setFeedName(String feedName) {
        this.feedName = feedName;
    }

    boolean isTextFeed;
    String feedName;


}
