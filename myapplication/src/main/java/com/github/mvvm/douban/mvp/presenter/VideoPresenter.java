package com.github.mvvm.douban.mvp.presenter;

import android.app.Application;

import com.github.mvvm.douban.mvp.model.entity.MovieResult;
import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.http.imageloader.ImageLoader;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import me.jessyan.rxerrorhandler.handler.RetryWithDelay;

import javax.inject.Inject;

import com.github.mvvm.douban.mvp.contract.VideoContract;
import com.jess.arms.utils.RxLifecycleUtils;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

import java.util.Date;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 04/19/2019 17:08
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
public class VideoPresenter extends BasePresenter<VideoContract.Model, VideoContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    VideoContract.View view;

    @Inject
    public VideoPresenter(VideoContract.Model model, VideoContract.View rootView) {
        super(model, rootView);
        view = rootView;
        EventBus.getDefault().register(this);
    }

    public void searchMovieByQ(String q) {
        final String netkey = new Date().toString();
        view.showLoading(netkey);
        mModel.searchMovieByQ(q)
                .subscribeOn(Schedulers.io())
                .retryWhen(new RetryWithDelay(3, 2))
                .doOnSubscribe(disposable -> {
                    mRootView.showLoading();
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .subscribe(new ErrorHandleSubscriber<MovieResult>(mErrorHandler) {
                    @Override
                    public void onNext(MovieResult result) {
                        if (!view.isCancel(netkey)) {
                            view.hideLoading();
                            view.showMovie(result);
                        } else {
                            view.showMessage("请求被取消");
                        }
                    }

                });
    }

    public void searchMovieByTag(String tag) {
        final String netkey = new Date().toString();
        view.showLoading(netkey);
        mModel.searchMovieByTag(tag)
                .subscribeOn(Schedulers.io())
                .retryWhen(new RetryWithDelay(3, 2))
                .doOnSubscribe(disposable -> {
                    mRootView.showLoading();
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .subscribe(new ErrorHandleSubscriber<MovieResult>(mErrorHandler) {
                    @Override
                    public void onNext(MovieResult result) {
                        if (!view.isCancel(netkey)) {
                            view.hideLoading();
                            view.showMovie(result);
                        } else {
                            view.showMessage("请求被取消");
                        }
                    }

                });
    }

    @Subscriber(tag = "exit")
    public void exit(String msg) {
            view.killMyself();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
        EventBus.getDefault().unregister(this);
    }


}
