package com.github.mvvm.douban.app.utils;

import com.github.mvvm.doudou.mvp.model.entity.Result;
import com.google.gson.Gson;

import me.jessyan.armscomponent.commonsdk.utils.BaseResponseConverter;

public class VideoResponseConverter extends BaseResponseConverter<Result> {
    @Override
    public Result parserHtml(String json) {
        return  new Gson().fromJson(json, Result.class);
    }
}