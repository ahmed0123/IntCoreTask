package com.example.android.task1.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by world on 2018/02/04.
 */

public class LoginManager {

    public static final String KEY_SESSION_KEY = "SessionId";


    static SharedPreferences getSharedPreferences(Context context) {

        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setSessionId(Context context, Long sessionID) {

        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putLong(KEY_SESSION_KEY, sessionID);
        editor.commit();

    }

    public static Long getSessionId(Context context) {

        return getSharedPreferences(context).getLong(KEY_SESSION_KEY, 1);

    }
}