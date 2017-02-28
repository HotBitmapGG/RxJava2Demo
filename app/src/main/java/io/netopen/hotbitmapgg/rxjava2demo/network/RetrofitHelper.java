package io.netopen.hotbitmapgg.rxjava2demo.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import io.netopen.hotbitmapgg.rxjava2demo.RxJava2App;
import io.netopen.hotbitmapgg.rxjava2demo.network.api.ApiService;
import java.io.File;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hcc on 2017/2/28 15:09
 * 100332338@qq.com
 * RxJava2Demo
 *
 * @HotBitmapGG
 */

public class RetrofitHelper {

  public static final String BASE_URL = "http://gank.io/api/";

  public static OkHttpClient mOkHttpClient;


  static {
    initOkHttpClient();
  }


  public static ApiService createApiService() {

    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(mOkHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();

    return retrofit.create(ApiService.class);
  }


  private static void initOkHttpClient() {

    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    if (mOkHttpClient == null) {
      synchronized (RetrofitHelper.class) {
        if (mOkHttpClient == null) {
          Cache cache = new Cache(
              new File(RxJava2App.getAppContext().getCacheDir(), "HttpCache"), 1024 * 1024 * 10);

          mOkHttpClient = new OkHttpClient.Builder()
              .cache(cache)
              .addInterceptor(httpLoggingInterceptor)
              .retryOnConnectionFailure(true)
              .connectTimeout(3, TimeUnit.MINUTES)
              .build();
        }
      }
    }
  }
}
