package com.github.mvvm.douban.app.utils;

import com.github.mvvm.douban.mvp.model.api.VideoService;
import com.github.mvvm.douban.mvp.model.entity.MovieResult;


import me.jessyan.armscomponent.commonsdk.utils.BaseConverterFactory;
import me.jessyan.armscomponent.commonsdk.utils.BaseResponseConverter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


public class RetrofitFactory {
    private  static VideoService videoService;
    public static VideoService getVideoService(){
                if(videoService ==null){
            videoService =new Retrofit.Builder()
                    .baseUrl("https://api.douban.com")
                    .addConverterFactory(new BaseConverterFactory<MovieResult>() {
                        @Override
                        public BaseResponseConverter responseConverter() {
                            return new VideoResponseConverter();
                        }
                    })
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
                    .create(VideoService.class);
        }
        return videoService;
    }


}
