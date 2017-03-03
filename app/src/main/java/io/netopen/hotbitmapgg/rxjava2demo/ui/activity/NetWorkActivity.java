package io.netopen.hotbitmapgg.rxjava2demo.ui.activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.netopen.hotbitmapgg.rxjava2demo.R;
import io.netopen.hotbitmapgg.rxjava2demo.ui.adapter.AndroidRecyclerAdapter;
import io.netopen.hotbitmapgg.rxjava2demo.bean.AndroidInfo;
import io.netopen.hotbitmapgg.rxjava2demo.network.RetrofitHelper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
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
  private AndroidRecyclerAdapter mAdapter;
  private List<AndroidInfo.ResultsBean> datas = new ArrayList<>();


  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_network);
    ButterKnife.bind(this);

    initView();
    loadData();
  }


  private void initView() {

    mRecyclerView.setHasFixedSize(true);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    mAdapter = new AndroidRecyclerAdapter();
    mAdapter.setDataSources(datas);
    mRecyclerView.setAdapter(mAdapter);
  }


  private void loadData() {

    RetrofitHelper.createApiService()
        .getAndroidInfos(30, 1)
        .doOnSubscribe(subscription -> mProgressBar.setVisibility(View.VISIBLE))
        .delay(1000, TimeUnit.MILLISECONDS)
        .filter(androidInfo -> !androidInfo.isError())
        .map(AndroidInfo::getResults)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(resultsBeen -> {
          datas.addAll(resultsBeen);
          mProgressBar.setVisibility(View.GONE);
          mAdapter.notifyDataSetChanged();
        }, throwable -> Log.e("tag", throwable.getMessage()));
  }
}
