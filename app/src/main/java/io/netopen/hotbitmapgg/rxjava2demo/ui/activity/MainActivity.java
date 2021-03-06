package io.netopen.hotbitmapgg.rxjava2demo.ui.activity;

import io.netopen.hotbitmapgg.rxjava2demo.R;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import org.reactivestreams.Publisher;

public class MainActivity extends AppCompatActivity {

  public static final String TAG = MainActivity.class.getName();


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button mButton = (Button) findViewById(R.id.btn);
    mButton.setOnClickListener(
        view -> startActivity(new Intent(MainActivity.this, NetWorkActivity.class)));

    Flowable.create(new FlowableOnSubscribe<String>() {

      @Override public void subscribe(FlowableEmitter<String> e) throws Exception {
        e.onNext("发射数据");
      }
    }, BackpressureStrategy.BUFFER)
        .doOnSubscribe(subscription -> Log.e(TAG, "doOnSubscribe"))
        .filter(s -> s.contains("数据"))
        .map(s -> s + "map转换的数据")
        .flatMap(new Function<String, Publisher<String>>() {
          @Override public Publisher<String> apply(String s) throws Exception {
            return Flowable.just(s + "flatMap添加的数据");
          }
        })
        .delay(1000, TimeUnit.MILLISECONDS)
        .doOnError(throwable -> Log.e(TAG, "doOnError"))
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(s -> Log.e(TAG, "subscribe  = " + s),
            throwable -> Log.e(TAG, "subscribe  error  = " + throwable.getMessage()));

    // Flowable.create(new FlowableOnSubscribe<String>() {
    //   @Override public void subscribe(FlowableEmitter<String> e) throws Exception {
    //     e.onNext("rxjava2");
    //   }
    // }, BackpressureStrategy.BUFFER)
    //     .subscribe(new Subscriber<String>() {
    //       @Override public void onSubscribe(Subscription s) {
    //         s.request(Long.MAX_VALUE);
    //       }
    //
    //
    //       @Override public void onNext(String s) {
    //         Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
    //       }
    //
    //
    //       @Override public void onError(Throwable t) {
    //
    //       }
    //
    //
    //       @Override public void onComplete() {
    //
    //       }
    //     });

    // Flowable.just("rxjava2demo")
    //     .map(s -> s)
    //     .flatMap(new Function<String, Publisher<String>>() {
    //       @Override public Publisher<String> apply(String s) throws Exception {
    //         return Flowable.just("sssss");
    //       }
    //     })
    //     .subscribe(s -> Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show(),
    //         throwable -> {
    //
    //         });

    // Flowable.fromArray("Hellow,hcc")
    //     .subscribe(s -> {
    //       Log.e("tag", s);
    //     });

    // Flowable.fromCallable(() -> "fsafsaf").subscribe(s -> {
    //   Log.e("tag", s);
    // });

    // Flowable.fromArray(1, 33, 55, -1, 4, 6, 7)
    //     .filter(integer -> integer > 5)
    //     .subscribe(integer -> {
    //
    //     });

    // Flowable.fromArray(1, 2, 3, 4, 5, 6)
    //     .filter(integer -> integer > 3)
    //     .take(2)
    //     .map(integer -> String.valueOf(integer.intValue()))
    //     .delay(1000, TimeUnit.MILLISECONDS)
    //     .subscribeOn(Schedulers.io())
    //     .observeOn(AndroidSchedulers.mainThread())
    //     .subscribe(s -> Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show(),
    //         throwable -> Toast.makeText(MainActivity.this, throwable.getMessage(),
    //             Toast.LENGTH_SHORT).show());

    // Flowable.just("hcc")
    //     .take(1)
    //     .filter(s -> s.contains("c")).subscribeOn(Schedulers.io())
    //     .observeOn(AndroidSchedulers.mainThread())
    //     .subscribe(s -> Log.d("tag", s), throwable -> Log.d("tag", throwable.getMessage()));
  }
}
