package com.example.android.task1.activites;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.android.task1.R;
import com.example.android.task1.model.User;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.tweetui.TweetTimelineRecyclerViewAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

import de.hdodenhof.circleimageview.CircleImageView;

public class ScrollingActivity extends AppCompatActivity implements View.OnClickListener {

    CircleImageView profileImage;
    ImageView backGroundImage;
    // serialized object
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        profileImage = findViewById(R.id.profile_image);
        backGroundImage = findViewById(R.id.back_ground_image);

        Intent followeAdapterIntent = getIntent();

        if (followeAdapterIntent.hasExtra("Follower")) {
            user = getIntent().getParcelableExtra("Follower");
        }

        // set background image
        setUpImageView(user.getProfileBannerUrl(), backGroundImage, R.drawable.background);

        // set up profile image
        setUpImageView(user.getProfileImageUrl(), profileImage, R.drawable.profile);


        profileImage.setOnClickListener(this);
        backGroundImage.setOnClickListener(this);

        UserTimeline timeline = new UserTimeline.Builder()
                .userId(user.getId())
                .screenName(user.getScreenName())
                .maxItemsPerRequest(10)
                .build();

        final RecyclerView recyclerView = findViewById(R.id.timline_list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final TweetTimelineRecyclerViewAdapter adapter =
                new TweetTimelineRecyclerViewAdapter.Builder(this)
                        .setTimeline(timeline)
                        .setViewStyle(R.style.tw__TweetLightWithActionsStyle)
                        .build();

        recyclerView.setAdapter(adapter);


    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.profile_image:
                openImageViewBrowser(user.getProfileImageUrl());
                break;
            case R.id.back_ground_image:
                openImageViewBrowser(user.getProfileBannerUrl());
                break;

            default:
                break;
        }

    }

    /**
     * setUpImage method check if the current user has banner or not
     * *  if it has one set it
     * *  if not has one set the default one
     */

    private void setUpImageView(String imagePath, ImageView v, int resTd) {
        if (imagePath != null) {
            Picasso.with(getApplicationContext()).load(imagePath).into(v);
        } else
            v.setImageResource(resTd);
    }

    /**
     * openImageViewBrowser method open broswer to view image
     */

    private void openImageViewBrowser(String imagePath) {

        Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
        intent.setData(Uri.parse(imagePath));
        startActivity(intent);


    }
}
