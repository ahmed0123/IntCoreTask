package com.example.android.task1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * Created by world on 2018/02/04.
 */

public class LoginManager {

    public static final String KEY_USER_NAME = "username";
    public static final String KEY_USER_ID = "id";
    private static final String SHARED_PREFERENCES_NAME = "UserSessionManagement";
    private static final String IS_USER_LOGIN = "IsUserLoggedIn";
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Context context;
    int PRIVATE_MODE = 0;


    public LoginManager(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, PRIVATE_MODE);
        editor = preferences.edit();
    }

    public void createSessionForUSer(String username, long userid) {

        editor.putBoolean(IS_USER_LOGIN, true);
        editor.putString(KEY_USER_NAME, username);
        editor.putLong(KEY_USER_ID, userid);
        editor.commit();
    }

    public boolean isUserLoggedIn() {
        return preferences.getBoolean(IS_USER_LOGIN, false);
    }

    public boolean checkLogin() {
        if (!this.isUserLoggedIn()) {

            Intent intent = new Intent(context, TwitterLogin.class);

            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(intent);
        }

        return false;
    }
}
