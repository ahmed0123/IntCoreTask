package com.example.android.task1.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.android.task1.R;
import com.example.android.task1.utils.LoginManager;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

public class TwitterLogin extends AppCompatActivity {

    // Button for authenticate user
    TwitterLoginButton loginButton;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter_login);

        loginButton = findViewById(R.id.login_button);

        toolbar = findViewById(R.id.login_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.login_activity);
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {

                TwitterSession session = result.data;
                // set the session
                TwitterCore.getInstance().getSessionManager().setSession(session.getId(), session);
                // save user session id in shared preferences to manage session and to use id later for retrieving session
                LoginManager.setSessionId(getApplicationContext(), session.getId());

                // Start FollowerActivity
                Intent intent = new Intent(getApplicationContext(), FolowerActivity.class);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(intent);

                finish();

            }

            @Override
            public void failure(TwitterException exception) {
                Log.e("ERROR", exception.getMessage());
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result to the login button.
        loginButton.onActivityResult(requestCode, resultCode, data);
    }
}
