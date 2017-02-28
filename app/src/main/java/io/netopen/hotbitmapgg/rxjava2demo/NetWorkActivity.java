package io.netopen.hotbitmapgg.rxjava2demo;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.netopen.hotbitmapgg.rxjava2demo.bean.AndroidInfo;
import io.netopen.hotbitmapgg.rxjava2demo.network.RetrofitHelper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

/**
 * Created by hcc on 2017/2/28 14:35
 * 100332338@qq.com
 * RxJava2Demo
 *
 * @HotBitmapGG
 */

public class NetWorkActivity extends AppCompatActivity {

  @BindView(R.id.recycler_view) RecyclerView mRecyclerView;
  @BindView(R.id.progress_bar) ProgressBar mProgressBar;


  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_network);
    ButterKnife.bind(this);

    loadData();
  }


  private void loadData() {

    RetrofitHelper.createApiService()
        .getAndroidInfos(10, 1)
        .doOnSubscribe(subscription -> mProgressBar.setVisibility(View.VISIBLE))
        .delay(1000, TimeUnit.MILLISECONDS)
        .map(AndroidInfo::getResults)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(resultsBeen -> Log.e("tag", resultsBeen.get(0).getDesc()),
            throwable -> Log.e("tag", throwable.getMessage()));
  }
}
