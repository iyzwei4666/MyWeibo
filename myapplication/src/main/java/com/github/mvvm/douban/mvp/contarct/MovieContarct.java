package com.github.mvvm.douban.mvp.contarct;

import android.app.Activity;

import com.github.mvvm.doudou.mvp.model.entity.Result;
import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;

import io.reactivex.Observable;

public interface MovieContarct {
    interface View extends IView {
        void startLoadMore();
        void endLoadMore();
        Activity getActivity();
    }
    interface Model extends IModel {
        Observable<Result> searchMovieByQ(String q);
        Observable<Result> searchMovieByTag(String tag);

    }
}
