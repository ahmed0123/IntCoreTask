package com.example.android.task1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by world on 2018/02/08.
 */

public class Followers {

    @SerializedName("users")
    @Expose
    private List<com.example.android.task1.model.User> users;
    @SerializedName("next_cursor")
    @Expose
    private Long nextCursor;
    @SerializedName("next_cursor_str")
    @Expose
    private String nextCursorStr;
    @SerializedName("previous_cursor")
    @Expose
    private Long previousCursor;
    @SerializedName("previous_cursor_str")
    @Expose
    private String previousCursorStr;

    public List<com.example.android.task1.model.User> getUsers() {
        return users;
    }

    public void setUsers(List<com.example.android.task1.model.User> users) {
        this.users = users;
    }

    public Long getNextCursor() {
        return nextCursor;
    }

    public void setNextCursor(Long nextCursor) {
        this.nextCursor = nextCursor;
    }

    public String getNextCursorStr() {
        return nextCursorStr;
    }

    public void setNextCursorStr(String nextCursorStr) {
        this.nextCursorStr = nextCursorStr;
    }

    public Long getPreviousCursor() {
        return previousCursor;
    }

    public void setPreviousCursor(Long previousCursor) {
        this.previousCursor = previousCursor;
    }

    public String getPreviousCursorStr() {
        return previousCursorStr;
    }

    public void setPreviousCursorStr(String previousCursorStr) {
        this.previousCursorStr = previousCursorStr;
    }
}

