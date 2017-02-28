package io.netopen.hotbitmapgg.rxjava2demo.network.api;

import io.netopen.hotbitmapgg.rxjava2demo.bean.AndroidInfo;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by hcc on 2017/2/28 15:28
 * 100332338@qq.com
 * RxJava2Demo
 *
 * @HotBitmapGG http://gank.io/api/data/Android/10/1
 */

public interface ApiService {

  @GET("data/Android/{pageSize}/{page}")
  Flowable<AndroidInfo> getAndroidInfos(
      @Path("pageSize") int pageSize, @Path("page") int page);
}
