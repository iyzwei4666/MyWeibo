package com.github.mvvm.doudou.mvp.model.api;


import com.github.mvvm.doudou.mvp.model.entity.Result;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;


public interface VideoService {

    @GET("/v2/movie/search")
    Observable<Result> searchMovieByQ(@Query("q") String q);

    @GET("/v2/movie/search")
    Observable<Result> searchMovieByTag(@Query("tag") String tag);


}
