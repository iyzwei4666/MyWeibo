package com.github.mvvm.douban.mvp.model.api;


import com.github.mvvm.douban.mvp.model.entity.MovieResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface VideoService {

    @GET("/v2/movie/search")
    Observable<MovieResult> searchMovieByQ(@Query("q") String q);

    @GET("/v2/movie/search")
    Observable<MovieResult> searchMovieByTag(@Query("tag") String tag);


}
