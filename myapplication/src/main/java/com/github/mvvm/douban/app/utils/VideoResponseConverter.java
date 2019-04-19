package com.github.mvvm.douban.app.utils;

import com.github.mvvm.douban.mvp.model.entity.MovieResult;
import com.google.gson.Gson;

import me.jessyan.armscomponent.commonsdk.utils.BaseResponseConverter;

public class VideoResponseConverter extends BaseResponseConverter<MovieResult> {
    @Override
    public MovieResult parserHtml(String json) {
        return  new Gson().fromJson(json, MovieResult.class);
    }
}