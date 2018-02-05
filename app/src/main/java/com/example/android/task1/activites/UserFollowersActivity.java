package com.example.android.task1.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.android.task1.R;
import com.example.android.task1.managers.LoginManager;

public class UserFollowersActivity extends AppCompatActivity {


    LoginManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followers);

        // instantiated LoginManager class to provide access for it's methods
        manager = new LoginManager(getApplicationContext());

        Toast.makeText(getApplicationContext(),
                "User Login Status: " + manager.isUserLoggedIn(),
                Toast.LENGTH_LONG).show();

        /* LoginManager check if the user
                - is not logged-in redirect the user to TwitterLogin class
                -  is logged-in Continuing showing followers list
        */
        if (manager.checkLogin())
            finish();
    }
}
