package io.netopen.hotbitmapgg.rxjava2demo.adapter;

import io.netopen.hotbitmapgg.rxjava2demo.R;
import io.netopen.hotbitmapgg.rxjava2demo.bean.AndroidInfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by hcc on 2017/3/1 13:53
 * 100332338@qq.com
 * RxJava2Demo
 *
 * @HotBitmapGG
 */

public class AndroidRecyclerAdapter extends AbsRecyclerViewAdapter<AndroidInfo.ResultsBean> {

  @Override
  public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    bindContext(parent.getContext());
    return new ItemViewHolder(
        LayoutInflater.from(getContext()).inflate(R.layout.item_android, parent, false));
  }


  @Override
  public void onBindViewHolder(ClickableViewHolder holder, int position) {
    if (holder instanceof ItemViewHolder) {
      ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
      AndroidInfo.ResultsBean resultsBean = mDataSources.get(position);
      itemViewHolder.mTv.setText(resultsBean.getDesc());
    }
    super.onBindViewHolder(holder, position);
  }


  private class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder {

    TextView mTv;


    public ItemViewHolder(View itemView) {
      super(itemView);
      mTv = $(R.id.tv);
    }
  }
}
