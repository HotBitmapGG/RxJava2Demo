package io.netopen.hotbitmapgg.rxjava2demo;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Java8DemoActivity extends AppCompatActivity {

  private List<BookInfo> books = new ArrayList<>();


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_java8_demo);

    initData();

    books.stream()
        .filter(bookInfo -> bookInfo.getBookName().equals("Java"))
        .findFirst();
  }


  private void initData() {
    books.add(new BookInfo("Java", 1, "it"));
    books.add(new BookInfo("Android", 2, "it"));
    books.add(new BookInfo("iOS", 3, "it"));
    books.add(new BookInfo("Js", 4, "it"));
    books.add(new BookInfo("Python", 5, "it"));
  }
}
