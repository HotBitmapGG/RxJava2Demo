package io.netopen.hotbitmapgg.rxjava2demo;

import android.app.Application;

/**
 * Created by hcc on 2017/2/28 15:21
 * 100332338@qq.com
 * RxJava2Demo
 *
 * @HotBitmapGG
 */

public class RxJava2App extends Application {

  public static RxJava2App mRxJava2App;


  @Override public void onCreate() {
    super.onCreate();
    mRxJava2App = this;
  }


  public static RxJava2App getAppContext() {
    return mRxJava2App;
  }
}
