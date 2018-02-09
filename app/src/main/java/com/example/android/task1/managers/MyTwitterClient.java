package com.example.android.task1.managers;

import com.example.android.task1.model.Followers;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterSession;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by world on 2018/02/09.
 */

public class MyTwitterClient extends TwitterApiClient {

    public MyTwitterClient(TwitterSession session, OkHttpClient client) {
        super(session, client);

    }

    public TwitterService getTwitterService() {
        return getService(TwitterService.class);
    }

    public interface TwitterService {
        @GET("/1.1/followers/list.json")
        Call<Followers> followerList(@Query("cursor") Long nextCursor);
    }
}
