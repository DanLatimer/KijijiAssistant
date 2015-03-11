package com.danlatimer.android.kijiji.web;


import com.danlatimer.android.kijiji.models.Ad;
import retrofit.http.GET;
import retrofit.http.Query;

import java.util.List;

public interface KijijiRestApi {

    @GET("/ads")
    public List<Ad> getAds(
            @Query("latitude") String latitude,
            @Query("longitude") String longitude,
            @Query("distance") String distance,
            @Query("distanceUnit") String distanceUnit,
            @Query("q") String searchQuery,
            @Query("pictureRequired") String pictureRequired);

}
