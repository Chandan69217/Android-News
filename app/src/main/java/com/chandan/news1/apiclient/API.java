package com.chandan.news1.apiclient;

import com.chandan.news1.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {
    @GET("top-headlines/")
    Call<News> getData(@Query("country") String country,@Query("apiKey") String apiKey);
}
