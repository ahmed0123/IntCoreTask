package com.example.android.task1.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by world on 2018/02/08.
 */

public class User implements Parcelable {
    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("id_str")
    @Expose
    private String idStr;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("screen_name")
    @Expose
    private String screenName;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("profile_location")
    @Expose
    private String profileLocation;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("protected")
    @Expose
    private Boolean _protected;
    @SerializedName("followers_count")
    @Expose
    private int followersCount;
    @SerializedName("friends_count")
    @Expose
    private int friendsCount;
    @SerializedName("listed_count")
    @Expose
    private int listedCount;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("favourites_count")
    @Expose
    private Long favouritesCount;
    @SerializedName("utc_offset")
    @Expose
    private int utcOffset;
    @SerializedName("time_zone")
    @Expose
    private String timeZone;
    @SerializedName("geo_enabled")
    @Expose
    private Boolean geoEnabled;
    @SerializedName("verified")
    @Expose
    private Boolean verified;
    @SerializedName("statuses_count")
    @Expose
    private int statusesCount;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("contributors_enabled")
    @Expose
    private Boolean contributorsEnabled;
    @SerializedName("is_translator")
    @Expose
    private Boolean isTranslator;
    @SerializedName("is_translation_enabled")
    @Expose
    private Boolean isTranslationEnabled;
    @SerializedName("profile_background_color")
    @Expose
    private String profileBackgroundColor;
    @SerializedName("profile_background_image_url")
    @Expose
    private String profileBackgroundImageUrl;
    @SerializedName("profile_background_image_url_https")
    @Expose
    private String profileBackgroundImageUrlHttps;
    @SerializedName("profile_background_tile")
    @Expose
    private Boolean profileBackgroundTile;
    @SerializedName("profile_image_url")
    @Expose
    private String profileImageUrl;
    @SerializedName("profile_image_url_https")
    @Expose
    private String profileImageUrlHttps;
    @SerializedName("profile_link_color")
    @Expose
    private String profileLinkColor;
    @SerializedName("profile_sidebar_border_color")
    @Expose
    private String profileSidebarBorderColor;
    @SerializedName("profile_sidebar_fill_color")
    @Expose
    private String profileSidebarFillColor;
    @SerializedName("profile_text_color")
    @Expose
    private String profileTextColor;
    @SerializedName("profile_use_background_image")
    @Expose
    private Boolean profileUseBackgroundImage;
    @SerializedName("default_profile")
    @Expose
    private Boolean defaultProfile;
    @SerializedName("default_profile_image")
    @Expose
    private Boolean defaultProfileImage;
    @SerializedName("following")
    @Expose
    private Boolean following;
    @SerializedName("follow_request_sent")
    @Expose
    private Boolean followRequestSent;
    @SerializedName("notifications")
    @Expose
    private Boolean notifications;
    @SerializedName("muting")
    @Expose
    private Boolean muting;
    @SerializedName("profile_banner_url")
    @Expose
    private String profileBannerUrl;

    protected User(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        idStr = in.readString();
        name = in.readString();
        screenName = in.readString();
        location = in.readString();
        profileLocation = in.readString();
        url = in.readString();
        description = in.readString();
        byte tmp_protected = in.readByte();
        _protected = tmp_protected == 0 ? null : tmp_protected == 1;
        followersCount = in.readInt();
        friendsCount = in.readInt();
        listedCount = in.readInt();
        createdAt = in.readString();
        if (in.readByte() == 0) {
            favouritesCount = null;
        } else {
            favouritesCount = in.readLong();
        }
        utcOffset = in.readInt();
        timeZone = in.readString();
        byte tmpGeoEnabled = in.readByte();
        geoEnabled = tmpGeoEnabled == 0 ? null : tmpGeoEnabled == 1;
        byte tmpVerified = in.readByte();
        verified = tmpVerified == 0 ? null : tmpVerified == 1;
        statusesCount = in.readInt();
        lang = in.readString();
        byte tmpContributorsEnabled = in.readByte();
        contributorsEnabled = tmpContributorsEnabled == 0 ? null : tmpContributorsEnabled == 1;
        byte tmpIsTranslator = in.readByte();
        isTranslator = tmpIsTranslator == 0 ? null : tmpIsTranslator == 1;
        byte tmpIsTranslationEnabled = in.readByte();
        isTranslationEnabled = tmpIsTranslationEnabled == 0 ? null : tmpIsTranslationEnabled == 1;
        profileBackgroundColor = in.readString();
        profileBackgroundImageUrl = in.readString();
        profileBackgroundImageUrlHttps = in.readString();
        byte tmpProfileBackgroundTile = in.readByte();
        profileBackgroundTile = tmpProfileBackgroundTile == 0 ? null : tmpProfileBackgroundTile == 1;
        profileImageUrl = in.readString();
        profileImageUrlHttps = in.readString();
        profileLinkColor = in.readString();
        profileSidebarBorderColor = in.readString();
        profileSidebarFillColor = in.readString();
        profileTextColor = in.readString();
        byte tmpProfileUseBackgroundImage = in.readByte();
        profileUseBackgroundImage = tmpProfileUseBackgroundImage == 0 ? null : tmpProfileUseBackgroundImage == 1;
        byte tmpDefaultProfile = in.readByte();
        defaultProfile = tmpDefaultProfile == 0 ? null : tmpDefaultProfile == 1;
        byte tmpDefaultProfileImage = in.readByte();
        defaultProfileImage = tmpDefaultProfileImage == 0 ? null : tmpDefaultProfileImage == 1;
        byte tmpFollowing = in.readByte();
        following = tmpFollowing == 0 ? null : tmpFollowing == 1;
        byte tmpFollowRequestSent = in.readByte();
        followRequestSent = tmpFollowRequestSent == 0 ? null : tmpFollowRequestSent == 1;
        byte tmpNotifications = in.readByte();
        notifications = tmpNotifications == 0 ? null : tmpNotifications == 1;
        byte tmpMuting = in.readByte();
        muting = tmpMuting == 0 ? null : tmpMuting == 1;
        profileBannerUrl = in.readString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProfileLocation() {
        return profileLocation;
    }

    public void setProfileLocation(String profileLocation) {
        this.profileLocation = profileLocation;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean get_protected() {
        return _protected;
    }

    public void set_protected(Boolean _protected) {
        this._protected = _protected;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public int getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(int friendsCount) {
        this.friendsCount = friendsCount;
    }

    public int getListedCount() {
        return listedCount;
    }

    public void setListedCount(int listedCount) {
        this.listedCount = listedCount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Long getFavouritesCount() {
        return favouritesCount;
    }

    public void setFavouritesCount(Long favouritesCount) {
        this.favouritesCount = favouritesCount;
    }

    public int getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(int utcOffset) {
        this.utcOffset = utcOffset;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public Boolean getGeoEnabled() {
        return geoEnabled;
    }

    public void setGeoEnabled(Boolean geoEnabled) {
        this.geoEnabled = geoEnabled;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public int getStatusesCount() {
        return statusesCount;
    }

    public void setStatusesCount(int statusesCount) {
        this.statusesCount = statusesCount;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Boolean getContributorsEnabled() {
        return contributorsEnabled;
    }

    public void setContributorsEnabled(Boolean contributorsEnabled) {
        this.contributorsEnabled = contributorsEnabled;
    }

    public Boolean getTranslator() {
        return isTranslator;
    }

    public void setTranslator(Boolean translator) {
        isTranslator = translator;
    }

    public Boolean getTranslationEnabled() {
        return isTranslationEnabled;
    }

    public void setTranslationEnabled(Boolean translationEnabled) {
        isTranslationEnabled = translationEnabled;
    }

    public String getProfileBackgroundColor() {
        return profileBackgroundColor;
    }

    public void setProfileBackgroundColor(String profileBackgroundColor) {
        this.profileBackgroundColor = profileBackgroundColor;
    }

    public String getProfileBackgroundImageUrl() {
        return profileBackgroundImageUrl;
    }

    public void setProfileBackgroundImageUrl(String profileBackgroundImageUrl) {
        this.profileBackgroundImageUrl = profileBackgroundImageUrl;
    }

    public String getProfileBackgroundImageUrlHttps() {
        return profileBackgroundImageUrlHttps;
    }

    public void setProfileBackgroundImageUrlHttps(String profileBackgroundImageUrlHttps) {
        this.profileBackgroundImageUrlHttps = profileBackgroundImageUrlHttps;
    }

    public Boolean getProfileBackgroundTile() {
        return profileBackgroundTile;
    }

    public void setProfileBackgroundTile(Boolean profileBackgroundTile) {
        this.profileBackgroundTile = profileBackgroundTile;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getProfileImageUrlHttps() {
        return profileImageUrlHttps;
    }

    public void setProfileImageUrlHttps(String profileImageUrlHttps) {
        this.profileImageUrlHttps = profileImageUrlHttps;
    }

    public String getProfileLinkColor() {
        return profileLinkColor;
    }

    public void setProfileLinkColor(String profileLinkColor) {
        this.profileLinkColor = profileLinkColor;
    }

    public String getProfileSidebarBorderColor() {
        return profileSidebarBorderColor;
    }

    public void setProfileSidebarBorderColor(String profileSidebarBorderColor) {
        this.profileSidebarBorderColor = profileSidebarBorderColor;
    }

    public String getProfileSidebarFillColor() {
        return profileSidebarFillColor;
    }

    public void setProfileSidebarFillColor(String profileSidebarFillColor) {
        this.profileSidebarFillColor = profileSidebarFillColor;
    }

    public String getProfileTextColor() {
        return profileTextColor;
    }

    public void setProfileTextColor(String profileTextColor) {
        this.profileTextColor = profileTextColor;
    }

    public Boolean getProfileUseBackgroundImage() {
        return profileUseBackgroundImage;
    }

    public void setProfileUseBackgroundImage(Boolean profileUseBackgroundImage) {
        this.profileUseBackgroundImage = profileUseBackgroundImage;
    }

    public Boolean getDefaultProfile() {
        return defaultProfile;
    }

    public void setDefaultProfile(Boolean defaultProfile) {
        this.defaultProfile = defaultProfile;
    }

    public Boolean getDefaultProfileImage() {
        return defaultProfileImage;
    }

    public void setDefaultProfileImage(Boolean defaultProfileImage) {
        this.defaultProfileImage = defaultProfileImage;
    }

    public Boolean getFollowing() {
        return following;
    }

    public void setFollowing(Boolean following) {
        this.following = following;
    }

    public Boolean getFollowRequestSent() {
        return followRequestSent;
    }

    public void setFollowRequestSent(Boolean followRequestSent) {
        this.followRequestSent = followRequestSent;
    }

    public Boolean getNotifications() {
        return notifications;
    }

    public void setNotifications(Boolean notifications) {
        this.notifications = notifications;
    }

    public Boolean getMuting() {
        return muting;
    }

    public void setMuting(Boolean muting) {
        this.muting = muting;
    }

    public String getProfileBannerUrl() {
        return profileBannerUrl;
    }

    public void setProfileBannerUrl(String profileBannerUrl) {
        this.profileBannerUrl = profileBannerUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
        dest.writeString(idStr);
        dest.writeString(name);
        dest.writeString(screenName);
        dest.writeString(location);
        dest.writeString(profileLocation);
        dest.writeString(url);
        dest.writeString(description);
        dest.writeByte((byte) (_protected == null ? 0 : _protected ? 1 : 2));
        dest.writeInt(followersCount);
        dest.writeInt(friendsCount);
        dest.writeInt(listedCount);
        dest.writeString(createdAt);
        if (favouritesCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(favouritesCount);
        }
        dest.writeInt(utcOffset);
        dest.writeString(timeZone);
        dest.writeByte((byte) (geoEnabled == null ? 0 : geoEnabled ? 1 : 2));
        dest.writeByte((byte) (verified == null ? 0 : verified ? 1 : 2));
        dest.writeInt(statusesCount);
        dest.writeString(lang);
        dest.writeByte((byte) (contributorsEnabled == null ? 0 : contributorsEnabled ? 1 : 2));
        dest.writeByte((byte) (isTranslator == null ? 0 : isTranslator ? 1 : 2));
        dest.writeByte((byte) (isTranslationEnabled == null ? 0 : isTranslationEnabled ? 1 : 2));
        dest.writeString(profileBackgroundColor);
        dest.writeString(profileBackgroundImageUrl);
        dest.writeString(profileBackgroundImageUrlHttps);
        dest.writeByte((byte) (profileBackgroundTile == null ? 0 : profileBackgroundTile ? 1 : 2));
        dest.writeString(profileImageUrl);
        dest.writeString(profileImageUrlHttps);
        dest.writeString(profileLinkColor);
        dest.writeString(profileSidebarBorderColor);
        dest.writeString(profileSidebarFillColor);
        dest.writeString(profileTextColor);
        dest.writeByte((byte) (profileUseBackgroundImage == null ? 0 : profileUseBackgroundImage ? 1 : 2));
        dest.writeByte((byte) (defaultProfile == null ? 0 : defaultProfile ? 1 : 2));
        dest.writeByte((byte) (defaultProfileImage == null ? 0 : defaultProfileImage ? 1 : 2));
        dest.writeByte((byte) (following == null ? 0 : following ? 1 : 2));
        dest.writeByte((byte) (followRequestSent == null ? 0 : followRequestSent ? 1 : 2));
        dest.writeByte((byte) (notifications == null ? 0 : notifications ? 1 : 2));
        dest.writeByte((byte) (muting == null ? 0 : muting ? 1 : 2));
        dest.writeString(profileBannerUrl);
    }
}
