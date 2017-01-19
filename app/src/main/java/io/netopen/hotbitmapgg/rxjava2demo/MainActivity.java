package io.netopen.hotbitmapgg.rxjava2demo;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.functions.Function;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button mButton = (Button) findViewById(R.id.btn);
    mButton.setOnClickListener(
        view -> startActivity(new Intent(MainActivity.this, Java8DemoActivity.class)));

    Flowable.create(new FlowableOnSubscribe<String>() {
      @Override public void subscribe(FlowableEmitter<String> e) throws Exception {
        e.onNext("rxjava2");
      }
    }, BackpressureStrategy.BUFFER)
        .subscribe(new Subscriber<String>() {
          @Override public void onSubscribe(Subscription s) {
            s.request(Long.MAX_VALUE);
          }


          @Override public void onNext(String s) {
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
          }


          @Override public void onError(Throwable t) {

          }


          @Override public void onComplete() {

          }
        });

    Flowable.just("rxjava2demo")
        .map(s -> s)
        .flatMap(new Function<String, Publisher<String>>() {
          @Override public Publisher<String> apply(String s) throws Exception {
            return Flowable.just("sssss");
          }
        })
        .subscribe(s -> Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show(),
            throwable -> {

            });

    Flowable.fromArray("Hellow,hcc")
        .subscribe(s -> {
          Log.e("tag", s);
        });

    Flowable.fromCallable(() -> "fsafsaf").subscribe(s -> {
      Log.e("tag", s);
    });
  }
}
