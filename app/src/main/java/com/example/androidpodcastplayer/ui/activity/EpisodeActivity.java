package com.example.androidpodcastplayer.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.androidpodcastplayer.R;
import com.example.androidpodcastplayer.common.Constants;
import com.example.androidpodcastplayer.ui.fragment.EpisodeFragment;

public class EpisodeActivity extends AppCompatActivity implements
        EpisodeFragment.Contract{

    // impl of contract method
    @Override
    public void onItemClick(String podcastName) {
        // TODO
    }

    @Override
    public void downloadError(String message) {
        // TODO send message back to PodcastActivity to display snackbar
        finish();
    }

    @Override
    public void onNavigationIconBackPressed() {
        onBackPressed();
    }

    public static void launch(Activity activity, String feedUrl) {
        Intent intent = new Intent(activity, EpisodeActivity.class);
        intent.putExtra(Constants.RSS_FEED_URL, feedUrl);
        activity.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode);

        if (getSupportFragmentManager().findFragmentById(R.id.fragment_container) == null) {
            String feedUrl = getIntent().getStringExtra(Constants.RSS_FEED_URL);
            initFragment(EpisodeFragment.newInstance(feedUrl));
        }
    }

    private void initFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit();
    }



}
