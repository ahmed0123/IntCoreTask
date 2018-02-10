package com.example.android.task1.activites;


import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.android.task1.R;
import com.example.android.task1.adapter.FollowersAdapter;
import com.example.android.task1.managers.MyTwitterClient;
import com.example.android.task1.model.Followers;
import com.example.android.task1.model.User;
import com.example.android.task1.utils.EndlessRecyclerViewScrollListener;
import com.example.android.task1.utils.LoginManager;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;

public class FolowerActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    // httpclient used for customize request and for enable caching
    private static OkHttpClient httpClient;
    // session instance used for authentication thought requests
    TwitterSession session;
    Long sessionId;
    Long nextCursor = null;
    Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {

            Request request = chain.request();
            okhttp3.Response response = chain.proceed(request);

            if (isNetworkAvailable()) {
                int maxAge = 60 * 60 * 24 * 2;// Cache expiration time ， Unit for seconds
                return response.newBuilder()
                        .removeHeader("Pragma")// Clear header information ， Because server if not supported ， Will return some interference information ， Does not clear the following can not be effective
                        .header("Cache-Control", "public ,max-age=" + maxAge)
                        .build();
            }
            return response;
        }
    };
    private RecyclerView recyclerView;
    private List<User> userArrayList;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private CoordinatorLayout coordinatorLayout;
    private FollowersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followers);


        sessionId = LoginManager.getSessionId(getApplicationContext());


        if (sessionId == 1) {
            Intent intent = new Intent(FolowerActivity.this, TwitterLogin.class);
            startActivity(intent);
            finish();
            return;
        }

        session = TwitterCore.getInstance().getSessionManager().getSession(sessionId);

        coordinatorLayout = findViewById(R.id.coordinator);

        mSwipeRefreshLayout = findViewById(R.id.swipeRefresh);

        mSwipeRefreshLayout.setOnRefreshListener(this);

        recyclerView = findViewById(R.id.follwer_list);
        userArrayList = new ArrayList<>();

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, linearLayoutManager.getOrientation());


        if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            recyclerView.setLayoutManager(mLayoutManager);

        } else {
            recyclerView.setLayoutManager(linearLayoutManager);

        }
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new FollowersAdapter(getApplicationContext(), userArrayList);

        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                getFolloweList(nextCursor, session);
                if (nextCursor != 0L) {

                    getFolloweList(nextCursor, session);

                } else {

                    Snackbar snackbar = Snackbar
                            .make(coordinatorLayout, "There is no follower yet", Snackbar.LENGTH_LONG);

                    snackbar.show();

                }
            }
        });

        getFolloweList(nextCursor, session);
    }

    private void getFolloweList(Long cursor, TwitterSession session) {

        getCustomizedCleint();

        Call<Followers> conn = new MyTwitterClient(session, httpClient).getTwitterService().followerList(cursor);
        conn.enqueue(new retrofit2.Callback<Followers>() {
            @Override
            public void onResponse(Call<Followers> call, Response<Followers> response) {

                userArrayList.addAll(response.body().getUsers());
                adapter.notifyItemRangeInserted(adapter.getItemCount(), userArrayList.size() - 1);
                mSwipeRefreshLayout.setRefreshing(false);
                // getting the value og the next cursor coming from response
                nextCursor = response.body().getNextCursor();

            }

            @Override
            public void onFailure(Call<Followers> call, Throwable t) {
                Log.e("ERROR", t.getMessage());
            }

        });

    }

    private OkHttpClient getCustomizedCleint() {
        File httpCacheDirectory = new File(Environment.getExternalStorageDirectory(), "HttpCache");
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(httpCacheDirectory, cacheSize);

        // Logging Interceptor

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        httpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)// Set connection timeout
                .readTimeout(10, TimeUnit.SECONDS)// Read timeout
                .writeTimeout(10, TimeUnit.SECONDS)// Write timeout
                .addInterceptor(interceptor)// Add log interceptor
                .addNetworkInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)// Add cache interceptor
                .cache(cache)// Add cache
                .build();

        return httpClient;

    }

    public Activity getActivity() {
        Context context = this;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onRefresh() {
        getFolloweList(nextCursor, session);
    }

}



