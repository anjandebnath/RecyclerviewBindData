package com.aad.recyclerviewbinddata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FeedAdapter.FeedItemClickListener {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<FeedModel> feedModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        feedModelArrayList = new ArrayList<>();



        for(int i=0; i<5; i++){
            FeedModel feedModel = new FeedModel();
            if(i%2 == 0){
                feedModel.setTextFeed(true);
            }else{
                feedModel.setTextFeed(false);
            }
            feedModelArrayList.add(feedModel);
        }

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        // specify an adapter (see also next example)
        mAdapter = new FeedAdapter(feedModelArrayList, this, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(int position, int actionType) {
        Toast.makeText(getApplicationContext(), "Postion: "+position + "ViewType:"+ actionType, Toast.LENGTH_LONG).show();
    }
}
