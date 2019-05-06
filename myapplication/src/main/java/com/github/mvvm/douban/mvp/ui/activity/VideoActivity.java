package com.github.mvvm.douban.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.github.mvvm.douban.R;
import com.github.mvvm.douban.app.EventBusTags;
import com.github.mvvm.douban.mvp.model.entity.MovieResult;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.github.mvvm.douban.di.component.DaggerVideoComponent;
import com.github.mvvm.douban.mvp.contract.VideoContract;
import com.github.mvvm.douban.mvp.presenter.VideoPresenter;


import org.simple.eventbus.EventBus;

import me.jessyan.armscomponent.commonsdk.core.RouterHub;

import static com.jess.arms.utils.Preconditions.checkNotNull;


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
@Route(path = RouterHub.DOUBAN_SEARCH)
public class VideoActivity extends BaseActivity<VideoPresenter> implements VideoContract.View {
    GISLoadingDlg loadingDlg ;
    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerVideoComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.video_main; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }
    TextView data;
    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        TextView get = findViewById(R.id.get);
        data = findViewById(R.id.data);
        loadingDlg = new GISLoadingDlg(VideoActivity.this);
        loadingDlg.setTitle("数据加载");
        loadingDlg.setLoadingMessage("正在获取服务数据...");
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mPresenter.searchMovieByQ("周星驰");
                mPresenter.searchMovieByTag("喜剧");
            }
        });
    }

    @Override
    public void showLoading() {
    }
    @Override
    public void showLoading(String netKey) {
        loadingDlg.show(netKey);
    }
    @Override
    public void hideLoading() {
        loadingDlg.hide();
    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {

        Toast.makeText(this , "收到退出的消息",Toast.LENGTH_LONG).show();
//        finish();
    }

    @Override
    public boolean isCancel(String key) {
        return loadingDlg.isCancel(key);
    }



    @Override
    public void showMovie(MovieResult result) {
        data.setText(result.toString());
        EventBus.getDefault().post("发送退出窗口" ,  EventBusTags.EXIT );
    }
}
