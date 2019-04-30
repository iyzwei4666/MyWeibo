package com.meiji.toutiao.api;

import com.meiji.toutiao.Constant;
import com.meiji.toutiao.bean.photo.ImageResult;
import com.meiji.toutiao.bean.photo.PhotoArticleBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by Meiji on 2017/5/7.
 */

public interface IPhotoApi {

    /**
     * 获取图片标题等信息
     * http://www.toutiao.com/api/article/feed/?category=类型&as=A115C8457F69B85&cp=585F294B8845EE1&_=时间&count=30
     * http://image.baidu.com/channel/listjson?pn=0&rn=30&tag1=%E6%98%8E%E6%98%9F&tag2=%E5%85%A8%E9%83%A8&ftags=%E5%A5%B3%E6%98%8E%E6%98%9F##%E5%86%85%E5%9C%B0&ie=utf8
     */
    @GET("http://www.toutiao.com/api/pc/feed/?as=A115C8457F69B85&cp=585F294B8845EE1&_signature=l")
    Observable<PhotoArticleBean> getPhotoArticle(
            @Query("category") String category,
            @Query("max_behot_time") String time);
    @GET("http://image.baidu.com/channel/listjson?pn=0&rn=30")
    Observable<ImageResult> getPhotoArticle(
            @Query("tag1") String tag1,
            @Query("tag2") String tag2,
            @Query("ftags") String ftags);

    /**
     * 获取图片内容HTML内容
     * 抓取 url 较复杂
     * 详情查看 {@linkplain com.meiji.toutiao.module.photo.content.PhotoContentPresenter#doLoadData(String...)}
     */
    @GET()
    @Headers("User-Agent:" + Constant.USER_AGENT_PC)
    Call<ResponseBody> getPhotoContentHTML(@Url String url);
}
